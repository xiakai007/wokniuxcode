package cc.zy.base.businesses.mapper;



import cc.zy.base.businesses.entity.Notice;
import cc.zy.base.businesses.entity.NoticeUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * 通知表 Mapper
 * @author 杨东豪
 * @date 2021-01-26
 */
public interface NoticeMapper extends BaseMapper<Notice> {
    /**
     * 查找用户详细信息
     *@author 赵佳伟
	 * @date 2021-01-26
     * @param page 分页对象
     * @param notice 用户对象，用于传递查询条件
     * @return Ipage
     */
    <T> IPage<Notice> findNoticeDetailPage(Page<T> page, @Param("notice") Notice notice);

    /**
	 *@author 赵佳伟
     * @date 2021-01-26
     * 查询通知总数
     * @param notice
     * @return
     */
    long countNoticeDetail(@Param("notice") Notice notice);


    /**
     * 创建人查学生
     */
    List<Notice> findCreatIdByUserId(Integer noticeId);

    List<Integer> findUserIdsByUserId(Integer noticeId);
    /**
     * 插入noticeUser
     * @param page 分页对象
     * @param noticeUser 用户对象，用于传递查询条件
     * @return Ipage
     */
    int insertNoticeUser(@Param("noticeUser")NoticeUser noticeUser);


    /**
     * 通过id查询通知信息
     * @param noticeId 通知id
     */
    Notice findNoticeById(Integer noticeId);

    /**
     * 修改通知
     * @param noticeUser 用户对象，用于传递查询条件
     */
    int UpdateNoticeByidy(Notice notice);
}
