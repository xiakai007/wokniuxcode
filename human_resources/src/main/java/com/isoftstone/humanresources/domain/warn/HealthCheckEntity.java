package com.isoftstone.humanresources.domain.warn;

import com.isoftstone.humanresources.domain.screen.ScreenMapEntity;

import java.io.Serializable;
import java.util.List;

public class HealthCheckEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String organizationID;

    private String organizationName;
    //健康检查的结果：Health/UnHealth
    private String healthResult;
    //健康的数据结果
    private List<ScreenMapEntity> healthList;
    //查询出的结果
    private List<ScreenMapEntity> realList;

    public String getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(String organizationID) {
        this.organizationID = organizationID;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getHealthResult() {
        return healthResult;
    }

    public void setHealthResult(String healthResult) {
        this.healthResult = healthResult;
    }

    public List<ScreenMapEntity> getHealthList() {
        return healthList;
    }

    public void setHealthList(List<ScreenMapEntity> healthList) {
        this.healthList = healthList;
    }

    public List<ScreenMapEntity> getRealList() {
        return realList;
    }

    public void setRealList(List<ScreenMapEntity> realList) {
        this.realList = realList;
    }
}
