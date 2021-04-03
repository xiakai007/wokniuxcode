package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.SystemConfigInformation;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SystemConfigDao {
    List<SystemConfigInformation> queryConfigByType(@Param("configType") String configType);
    
    SystemConfigInformation queryConfigByValue(@Param("configType") String configType,@Param("configValue") String configValue);
}
