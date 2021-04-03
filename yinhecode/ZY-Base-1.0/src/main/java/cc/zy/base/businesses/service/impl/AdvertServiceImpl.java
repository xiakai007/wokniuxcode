package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.Advert;
import cc.zy.base.businesses.entity.AdvertLoop;
import cc.zy.base.businesses.mapper.AdvertMapper;
import cc.zy.base.businesses.service.IAdvertService;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.SortUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * 广告Service实现
 *
 * @author lijian
 * @date 2021/01/25
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdvertServiceImpl extends ServiceImpl<AdvertMapper, Advert> implements IAdvertService {

    private final AdvertMapper advertMapper;

    @Override
    public IPage<Advert> findAdverts(QueryRequest request, Advert advert) {
        if (advert != null && advert.getTitle() != null) {
            advert.setTitle(advert.getTitle().trim());
        }
        Page<Advert> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countAdvertDetail(advert));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, true);
        return this.baseMapper.findAdvertDetailPage(page, advert);
    }

    @Override
    public List<Advert> findAdverts(Advert advert) {
        if (advert != null && advert.getTitle() != null) {
            advert.setTitle(advert.getTitle().trim());
        }
        LambdaQueryWrapper<Advert> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public Advert findAdvertDetailById(Integer id) {
        return this.baseMapper.findById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createAdvert(Advert advert) {
        this.save(advert);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAdvert(Advert advert) {
        Advert byId = advertMapper.findById(advert.getId());
        if (byId.getStatusId().equals(advert.getStatusId())) {
            this.saveOrUpdate(advert);
        } else if (advert.getStatusId() == 1) {
            Integer advertLoopId = advertMapper.getAdvertLoopId();
            advertMapper.addAdvertToAdvertLoop(advert.getId(), advertLoopId);
            this.saveOrUpdate(advert);
        } else if (advert.getStatusId() == 2 && byId.getStatusId() == 1) {
            advertMapper.updateAdvertLoopById(advert.getId());
            this.saveOrUpdate(advert);
        } else if (advert.getStatusId() == 2 && byId.getStatusId() == 3) {
            this.saveOrUpdate(advert);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAdvertStatus(Advert advertDetail) {
        this.saveOrUpdate(advertDetail);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAdvert(Integer advertId) {
        this.baseMapper.deleteById(advertId);
    }

    @Override
    public Integer findAdvertLoopId() {
        return advertMapper.getAdvertLoopId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delAdvrertToAdvertLoop(Integer advertId) {
        Integer[] adArray = advertMapper.getAdvertLoopIntegerArray(advertId);
        if (adArray.length > 0) {
            Integer delId = advertMapper.getDelAdvertLoopId(advertId);
            advertMapper.delAndChangeAdvertToAdvertLoop(delId);
            for (Integer integer : adArray) {
                advertMapper.addAdvertToAdvertLoop(integer, delId);
                delId++;
            }
        } else {
            this.advertMapper.updateAdvertLoopById(advertId);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addAdvertToAdvertLoop(Integer advertId, Integer loopId) {
        advertMapper.addAdvertToAdvertLoop(advertId, loopId);
    }

    @Override
    public IPage<AdvertLoop> findAdvertLoops(QueryRequest request) {
        Page<AdvertLoop> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countAdvertLoop());
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.findAdvertLoopList(page);
    }

    @Override
    public long findUseLoopCount() {
        return advertMapper.countAdvertLoop();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAdvertLoopOrder(AdvertLoop advertLoop) {
        advertMapper.moveSiteForOrder(advertLoop.getId(), advertLoop.getAdvertId());
        advertMapper.addAdvertToAdvertLoop(advertLoop.getAdvertId(), advertLoop.getId());
    }
}
