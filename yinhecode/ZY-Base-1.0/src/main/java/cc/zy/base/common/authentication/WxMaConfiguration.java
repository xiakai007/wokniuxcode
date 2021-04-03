package cc.zy.base.common.authentication;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.message.WxMaMessageRouter;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import cn.binarywang.wx.miniapp.message.WxMaMessageRouter;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: zh
 * @Date: 2020/9/08 10:45
 */
@Configuration
@EnableConfigurationProperties(WxMaProperties.class)
public class WxMaConfiguration {

    private WxMaProperties properties;

    private static Map<String, WxMaMessageRouter> routers = Maps.newHashMap();
    private static Map<String, WxMaService> maServices = Maps.newHashMap();

    @Autowired
    public WxMaConfiguration(WxMaProperties properties) {
        this.properties = properties;
    }

    public static Map<String, WxMaMessageRouter> getRouters() {
        return routers;
    }

    public static WxMaService getMaService(String appid) {
        WxMaService wxService = maServices.get(appid);
        if (wxService == null) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appid));
        }

        return wxService;
    }

    public static WxMaService getMaService() {
        if (maServices.size() == 1){
            Set<String> keySet = maServices.keySet();
            return maServices.get(keySet.iterator().next());
        }

        throw new RuntimeException("存在多个maService, 无法决策");
    }

    @PostConstruct
    public void init() {
        List<WxMaProperties.Config> configs = this.properties.getConfigs();
        if (configs == null) {
            throw new RuntimeException("相关配置错误！");
        }

        maServices = configs.stream()
                .map(a -> {
                    WxMaDefaultConfigImpl config = new WxMaDefaultConfigImpl();
                    config.setAppid(a.getAppid());
                    config.setSecret(a.getSecret());
                    config.setToken(a.getToken());
                    config.setAesKey(a.getAesKey());
                    config.setMsgDataFormat(a.getMsgDataFormat());

                    WxMaService service = new WxMaServiceImpl();
                    service.setWxMaConfig(config);
//					routers.put(a.getAppid(), this.newRouter(service));
                    return service;
                }).collect(Collectors.toMap(s -> s.getWxMaConfig().getAppid(), a -> a));
    }



}
