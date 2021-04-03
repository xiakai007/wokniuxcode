package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.AbsenteeCost;
import cc.zy.base.businesses.entity.CostExport;
import cc.zy.base.businesses.entity.CostExportExcel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;


/**
 *  Mapper
 *
 * @author gzd
 * @date 2021-02-03 16:29:47
 */
public interface AbsenteeCostMapper extends BaseMapper<AbsenteeCost> {

    String getSequence();
    String getAllSequence();

    List<CostExportExcel> selectCostExportExcel(@Param("costExport")CostExport costExport);

    long countCostExportExcelDetail(@Param("costExport") CostExport costExport);
}
