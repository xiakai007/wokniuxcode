package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.CType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

/**
 *  Mapper
 *
 * @author quxiaolong
 * @date 2021-01-25 10:44:35
 */
public interface CTypeMapper extends BaseMapper<CType> {
    /**
     * 查找类别详细信息
     *
     * @param CType 类别对象，用于传递查询条件
     * @return List<College>
     */
    <T> IPage<CType> findCTypeDetail(Page<T> page, @Param("cType") CType cType);
    /**
     * 查找类别条数
     *
     * @param CType 类别对象，用于传递查询条件
     * @return long
     */
    long countCTypeDetail(@Param("cType") CType cType);
    /**
     * 修该类别状态
     *
     * @param id 主键id，Data 修改时间 ，updateUserId 修改人
     * @return int
     */
    int updateByIdStatus(@Param("id") int id,@Param("updateTime") Date updateTime,@Param("updateUserId")int updateUserId);
    /**
     * 修该类别状态
     *
     * @param id 主键id，Data 修改时间 ，updateUserId 修改人
     * @return int
     */
    int updateByIdStatusSon(@Param("id") int id,@Param("updateTime") Date updateTime,@Param("updateUserId")int updateUserId);
    /**
     * 修该类别状态
     *
     * @param id 主键id，Data 修改时间 ，updateUserId 修改人
     * @return int
     */
    int updateByIdStatusUp(@Param("id") int id,@Param("updateTime") Date updateTime,@Param("updateUserId")int updateUserId);
    /**
     * 查询二级pid
     *
     * @param id 主键id
     * @return int
     */
    int findPid(@Param("id" )int id);
    /**
     * 修该类别状态
     *
     * @param id 主键id，Data 修改时间 ，updateUserId 修改人
     * @return int
     */
    int updateByIdStatusSonDown(@Param("id") int id,@Param("updateTime") Date updateTime,@Param("updateUserId")int updateUserId);
    /**
     * 修该类别状态
     *
     * @param sort1 排序id1，sort1 排序id2
     * @return Integer
     */
    Integer selectByIdPid(@Param("sort1") int sort1,@Param("sort2") int sort2);
    /**
     * 排序
     *
     * @param id 主键id，排序值
     * @return int
     */
    int  updateByIdSort(@Param("id") int id,@Param("sort2") int sort2 );
    /**
     * 查找一条类别信息
     *
     * @param id 主键id，排序值
     * @return CType
     */
    CType findById(@Param("id") int id);
    /**
     * 查找一条状态值
     *
     * @param id 主键id，排序值
     * @return int
     */
    int  findStatus(@Param("id") int id);
    /**
     * 查找sort1类别的最大值
     *
     * @return List<College>
     */
    Integer findCTypeSORT1MAX();
    /**
     * 查找sort1类别的当前值
     *
     * @return List<College>
     */
    int  findCTypeSort1Now(@Param("ctypeId") int ctypeId);

    /**
     * 查找sort2类别的最大值
     *
     * @return List<College>
     */
    int findCTypeSORT2MAX(@Param("ctypeSort1Id") int ctypeSort1Id);

    /**
     * 通过ID查找类别
     *
     * @param id id
     * @return 院校
     */
    CType findById(@Param("cTypeId") Integer cTypeId);
    /**
     *查找所有一级分类
     * @return
     */
    List<CType> selectCTypeList1();
    /**
     * 查找type_id
     */
    int selectByVideoId(@Param("id") int id);
    List<Integer> selectByPid(@Param("id") int id);
    /**
     * 查找sort2
     */
    List<Integer> selectSort2BySort1(@Param("sort1") int sort1);

    /**
     * 查找sort1
     * @param pid
     * @return
     */
    int selectSort1ByPid(@Param("pid") int pid);

    /**
     * 查找pid
     * @param id
     * @return
     */
    int selectPidById(@Param("id") int id);
    List<String> selectRootNameLastInsert();
}
