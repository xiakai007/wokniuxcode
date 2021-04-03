package cc.zy.base.businesses.utils;

import com.ec.v2.config.Config;
import com.ec.v2.entity.config.*;
import com.ec.v2.entity.customer.CrmIdslDto;
import com.ec.v2.entity.customer.QueryLabelResp;
import com.ec.v2.service.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 裴昊东
 * @Date 2021/1/29 19:21
 * @Version 1.0
 * EC数据获取类
 */


public class ECUtil {
    private static long corpId = 15274436;
    private static String appId = "705715394396028928";
    private static String secret = "QBNKUtgRznRmTU6iEFC";

    private static ECUtil ecUtil = new ECUtil();

    //私有化构造
    private ECUtil(){

    }

    //静态获取单例
    public static ECUtil getInstance(){
        return ecUtil;
    }

    //加载时进行初始化配置
    static {
        // 初始化配置信息
        Config.initConfig(corpId, appId, secret);
//        System.out.println("初始化配置");
//        System.out.println(corpId);
//        System.out.println(appId);
//        System.out.println(secret);
    }

    public static void setCorpId(long corpId) {
        ECUtil.corpId = corpId;
        // 初始化配置信息
        Config.initConfig(corpId, appId, secret);
    }

    public static void setAppId(String appId) {
        ECUtil.appId = appId;
        // 初始化配置信息
        Config.initConfig(corpId, appId, secret);
    }

    public static void setSecret(String secret) {
        ECUtil.secret = secret;
        // 初始化配置信息
        Config.initConfig(corpId, appId, secret);
    }

    public static long getCorpId() {
        return corpId;
    }

    public static String getAppId() {
        return appId;
    }

    public static String getSecret() {
        return secret;
    }


    /*
    *从EC系统获取所有标签信息
    *
    * */
    public Map<Long,Map<String,String>> getLableMap(){

        //执行查询
        ConfigResponse<ConfigCrmGroupTagResp> res = null;
        try {
            res = com.ec.v2.service.Config.getLabelInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 4。 处理结果
//        System.out.println(JSONObject.toJSONString(res));

        Map<Long,Map<String,String>> labelMap = new HashMap<Long,Map<String,String>>();

        List<ConfigCrmGroupTagResp> list = res.getData();
        for (ConfigCrmGroupTagResp labelGroupList : list) {
            String labelGroupName = labelGroupList.getLabelGroupName();
            List<ConfigCrmTagResp> labelList = labelGroupList.getLabelList();
            for (ConfigCrmTagResp label : labelList) {
                Long labelId = label.getLabelId();
                String labelName = label.getLabelName();
                Map<String,String> map = new HashMap<String,String>();
                map.put(labelGroupName,labelName);
                labelMap.put(labelId,map);
            }
        }

        /*for (Map.Entry<Long, Map<String, String>> entry : labelMap.entrySet()) {
            Long key = entry.getKey();
            entry.getValue();
            System.out.print(entry.getKey() + " --> ");
            for (Map.Entry<String, String> entry1 : entry.getValue().entrySet()) {
                System.out.println(entry1.getKey() + "  " + entry1.getValue());
            }
        }*/
        return  labelMap;
    }


    /*
    * 根据客户id  crmId  获取标签id集合
    *
    * */

    public List<Integer> getLabelIds(Long crmId){
        String crmIdStr = crmId.toString();


        // 2. 构建请求参数
        CrmIdslDto dto = new CrmIdslDto();
        dto.setCrmIds(crmIdStr);
        // 3. 请求服务器 获取数据
        QueryLabelResp res = null;
        try {
            // 4。 处理结果
            res = Customer.queryLabel(dto);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String labelIdsStr = res.getData().get(0).getLabelIds();
        String[] strArray = labelIdsStr.split(",");
        List<Integer> labelIds = new ArrayList<Integer>();
        for (String s : strArray) {
            int i = Integer.parseInt(s);
            labelIds.add(i);
        }

        return labelIds;
    }

    /*
    *从EC系统获取所有自定义字段信息
    *
    * */
    public Map<Integer,Map<String,String>> getFieldInfoMap(){
        ConfigResponse<ConfigCustomFieldResp> res = null;
        try {
            res = com.ec.v2.service.Config.getFieldMapping();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<Integer,Map<String,String>> fieldInfoMap = new HashMap<Integer,Map<String,String>>();
        for (ConfigCustomFieldResp configCustomFieldResp : res.getData()) {
            String fieldName = configCustomFieldResp.getFieldName();
            List<ConfigCustomFieldParamResp> fieldParam = configCustomFieldResp.getFieldParam();
            Map<String,String> map = new HashMap<String,String>();
            if (fieldParam != null) {
                for (ConfigCustomFieldParamResp configCustomFieldParamResp : fieldParam) {
                    Integer paramId = configCustomFieldParamResp.getParamId();
                    String paramName = configCustomFieldParamResp.getParamName();
                    map.put(fieldName,paramName);
                    fieldInfoMap.put(paramId,map);
                }
            }else{
                map.put(fieldName,"");
                fieldInfoMap.put(null,map);
            }

        }

        for (Map.Entry<Integer, Map<String, String>> integerMapEntry : fieldInfoMap.entrySet()) {
            System.out.print(integerMapEntry.getKey()+"  ");
            for (Map.Entry<String, String> stringStringEntry : integerMapEntry.getValue().entrySet()) {
                System.out.println(stringStringEntry.getKey()+":"+stringStringEntry.getValue());
            }
        }

        return fieldInfoMap;
    }
    /**
     *
     */
}
