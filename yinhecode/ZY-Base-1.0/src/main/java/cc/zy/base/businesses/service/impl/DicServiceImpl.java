package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.Dic;
import cc.zy.base.businesses.mapper.DicMapper;
import cc.zy.base.businesses.service.IDicService;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典表 Service实现
 *
 * @author LiPeng
 * @date 2021-01-27 19:34:24
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DicServiceImpl extends ServiceImpl<DicMapper, Dic> implements IDicService {

	@Resource
    private final DicMapper dicMapper;

    @Override
    public Dic findDicBid(Integer id) {
        return dicMapper.findDicByid(id);
    }

    @Override
    public List<Dic> findDicByType(String type) {
        return dicMapper.findDicByType(type);
    }
	
	@Override
    public Integer findDicId(String type, int sid) {

        Map<String,Object> map = new HashMap();
        map.put("type",type);
        map.put("sid",sid);
        List<Dic> dics = baseMapper.selectByMap(map);
        if (dics != null) {
            int dicId = dics.get(0).getId();
            return dicId;
        }
        return null;
    }

	@Override
    public List<Dic> findAllTransferType() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("type","change_type");
        return dicMapper.selectList(queryWrapper);
    }

    /**
     * 获取异动类型对应异动状态id
     * @param id
     * @return
     */
    @Override
    public Integer findCorrespondingTransferStatus(Integer id) {
        Dic dic = dicMapper.selectById(id);
        QueryWrapper<Dic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","change_status");
        queryWrapper.eq("detail",dic.getDetail());
        List<Dic> dics = dicMapper.selectList(queryWrapper);
        if (dics!=null){
            return dics.get(0).getId();
        }
        return null;
    }
}
