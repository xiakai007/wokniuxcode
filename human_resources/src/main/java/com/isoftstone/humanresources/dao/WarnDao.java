package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.OrganizationInformation;
import com.isoftstone.humanresources.domain.screen.ScreenWarnEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarnDao {
    List<ScreenWarnEntity> queryWarnByOrganizationID(@Param("list") List<OrganizationInformation> list);
}
