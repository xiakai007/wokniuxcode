package com.isoftstone.humanresources.domain;
import java.io.Serializable;

/**
 * AOP日志实体
 */
public class SysLog implements Serializable {

    private static final long serialVersionUID = -4229021481982570944L;
    private Integer operationID;
    private String operationObject;   //操作对象
    private String operationType;     //操作类型
    private String employeeID;         //   操作人
    private String changeTime;          //操作时间
    private String operationResult;    //是否成功
    private String changeRecord;        //操作记录
    private String operationIP;         //IP
    private String operationModule;   //操作模块
    private String loginName;          //登陆名

    public String getOperationObject() {
        return operationObject;
    }

    public void setOperationObject(String operationObject) {
        this.operationObject = operationObject;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }

    public String getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
    }

    public String getChangeRecord() {
        return changeRecord;
    }

    public void setChangeRecord(String changeRecord) {
        this.changeRecord = changeRecord;
    }

    public String getOperationIP() {
        return operationIP;
    }

    public void setOperationIP(String operationIP) {
        this.operationIP = operationIP;
    }

    public String getOperationModule() {
        return operationModule;
    }

    public void setOperationModule(String operationModule) {
        this.operationModule = operationModule;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
