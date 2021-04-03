package cc.zy.base.generator.service.impl;

import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.SortUtil;
import cc.zy.base.generator.entity.Column;
import cc.zy.base.generator.entity.Table;
import cc.zy.base.generator.mapper.GeneratorMapper;
import cc.zy.base.generator.service.IGeneratorService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MrBird
 */
@Service
@RequiredArgsConstructor
public class GeneratorServiceImpl implements IGeneratorService {

    private final GeneratorMapper generatorMapper;

    @Override
    public List<String> getDatabases(String databaseType) {
        return generatorMapper.getDatabases(databaseType);
    }

    @Override
    public IPage<Table> getTables(String tableName, QueryRequest request, String databaseType, String schemaName) {
        Page<Table> page = new Page<>(request.getPageNum(), request.getPageSize());
        SortUtil.handlePageSort(request, page, "createTime", FebsConstant.ORDER_ASC, false);
        return generatorMapper.getTables(page, tableName, databaseType, schemaName);
    }

    @Override
    public List<Column> getColumns(String databaseType, String schemaName, String tableName) {
        return generatorMapper.getColumns(databaseType, schemaName, tableName);
    }
}
