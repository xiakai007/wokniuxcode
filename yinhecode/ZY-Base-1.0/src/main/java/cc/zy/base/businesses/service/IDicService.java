package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.Dic;


import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 字典表 Service接口
 *
 * @author LiPeng
 * @date 2021-01-27 19:34:24
 */
public interface IDicService extends IService<Dic> {



    /**
     * 根据id查字典详情
     */
    Dic findDicBid(Integer id);

	/**
     * 查找院校详细信息
     *
     * @param type 院校对象，用于传递查询条件
     * @return List<Dic>
     */
    List<Dic> findDicByType( String type);
	
	/**
     * 查询字典表id
     *
     * @param type String
     * @param sid int
     * @return int
     */
    Integer findDicId(String type, int sid);

	List<Dic> findAllTransferType();
    Integer findCorrespondingTransferStatus(Integer id);


}
