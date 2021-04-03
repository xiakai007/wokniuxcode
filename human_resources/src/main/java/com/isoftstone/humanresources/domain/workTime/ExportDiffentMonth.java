package com.isoftstone.humanresources.domain.workTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * 月份差异数据excel导出
 */
public class ExportDiffentMonth implements Serializable {

    private static final long serialVersionUID = -1L;
    private Integer ipsaemployeeID;

    private String ipsaemployeeName       ;
    private String ipsaarea               ;
    private String omppdu                 ;
    private String ipsamonth              ;
    private String ipsashouldDays         ;
    private String ipsaactualDays         ;
    private String ipsashouldTimes        ;
    private String ipsaactualTimes        ;
    private String ipsaholidayTimes       ;
    private String ipsabusinessTimes      ;
    private String ipsabusinessTripTimes  ;
    private String ipsalateTimes          ;
    private String ipsaLeaveEarlyTimes    ;
    private String ipsaabsenteeismTimes   ;
    private String ipsaoweTimes           ;
    private String ipsaovertimeNum        ;
    private String ipsaovertimes          ;
    private String ipsaextendTimes        ;
    private String ompshouldTimes         ;
    private String ompholidayTimes        ;
    private String omplateTimes           ;
    private String ompLeaveEarlyTimes     ;
    private String ompbusinessTimes       ;
    private String ompabsenteeismTimes    ;
    private String ompoweTimes            ;
    private String ompsupplySignInNum     ;
    private String ompserverTimes         ;
    private String omprealTimes           ;
    private String omppayTimes            ;
    private String ompoverTimes           ;
    private String ompmonthInShore        ;

    private String difworkTimes         ;
    private String difholidayTimes           ;
    private String diflateLeaveTimes            ;
    private String difabsenteeismTimes           ;
    private String difoverTimes        ;
    private String difextendTimes        ;
    private String ompoutTimes        ;

    public String getDifworkTimes() {
        return difworkTimes;
    }

    public void setDifworkTimes(String difworkTimes) {
        this.difworkTimes = difworkTimes;
    }

    public String getDifholidayTimes() {
        return difholidayTimes;
    }

    public void setDifholidayTimes(String difholidayTimes) {
        this.difholidayTimes = difholidayTimes;
    }

    public String getDiflateLeaveTimes() {
        return diflateLeaveTimes;
    }

    public void setDiflateLeaveTimes(String diflateLeaveTimes) {
        this.diflateLeaveTimes = diflateLeaveTimes;
    }

    public String getDifabsenteeismTimes() {
        return difabsenteeismTimes;
    }

    public void setDifabsenteeismTimes(String difabsenteeismTimes) {
        this.difabsenteeismTimes = difabsenteeismTimes;
    }

    public String getDifoverTimes() {
        return difoverTimes;
    }

    public void setDifoverTimes(String difoverTimes) {
        this.difoverTimes = difoverTimes;
    }

    public String getDifextendTimes() {
        return difextendTimes;
    }

    public void setDifextendTimes(String difextendTimes) {
        this.difextendTimes = difextendTimes;
    }

    public String getOmpoutTimes() {
        return ompoutTimes;
    }

    public void setOmpoutTimes(String ompoutTimes) {
        this.ompoutTimes = ompoutTimes;
    }

    public Integer getIpsaemployeeID() {
        return ipsaemployeeID;
    }

    public void setIpsaemployeeID(Integer ipsaemployeeID) {
        this.ipsaemployeeID = ipsaemployeeID;
    }

    public String getIpsaemployeeName() {
        return ipsaemployeeName;
    }

    public void setIpsaemployeeName(String ipsaemployeeName) {
        this.ipsaemployeeName = ipsaemployeeName;
    }

    public String getIpsaarea() {
        return ipsaarea;
    }

    public void setIpsaarea(String ipsaarea) {
        this.ipsaarea = ipsaarea;
    }

    public String getOmppdu() {
        return omppdu;
    }

    public void setOmppdu(String omppdu) {
        this.omppdu = omppdu;
    }

    public String getIpsamonth() {
        return ipsamonth;
    }

    public void setIpsamonth(String ipsamonth) {
        this.ipsamonth = ipsamonth;
    }

    public String getIpsashouldDays() {
        return ipsashouldDays;
    }

    public void setIpsashouldDays(String ipsashouldDays) {
        this.ipsashouldDays = ipsashouldDays;
    }

    public String getIpsaactualDays() {
        return ipsaactualDays;
    }

    public void setIpsaactualDays(String ipsaactualDays) {
        this.ipsaactualDays = ipsaactualDays;
    }

    public String getIpsashouldTimes() {
        return ipsashouldTimes;
    }

    public void setIpsashouldTimes(String ipsashouldTimes) {
        this.ipsashouldTimes = ipsashouldTimes;
    }

    public String getIpsaactualTimes() {
        return ipsaactualTimes;
    }

    public void setIpsaactualTimes(String ipsaactualTimes) {
        this.ipsaactualTimes = ipsaactualTimes;
    }

    public String getIpsaholidayTimes() {
        return ipsaholidayTimes;
    }

    public void setIpsaholidayTimes(String ipsaholidayTimes) {
        this.ipsaholidayTimes = ipsaholidayTimes;
    }

    public String getIpsabusinessTimes() {
        return ipsabusinessTimes;
    }

    public void setIpsabusinessTimes(String ipsabusinessTimes) {
        this.ipsabusinessTimes = ipsabusinessTimes;
    }

    public String getIpsabusinessTripTimes() {
        return ipsabusinessTripTimes;
    }

    public void setIpsabusinessTripTimes(String ipsabusinessTripTimes) {
        this.ipsabusinessTripTimes = ipsabusinessTripTimes;
    }

    public String getIpsalateTimes() {
        return ipsalateTimes;
    }

    public void setIpsalateTimes(String ipsalateTimes) {
        this.ipsalateTimes = ipsalateTimes;
    }

    public String getIpsaLeaveEarlyTimes() {
        return ipsaLeaveEarlyTimes;
    }

    public void setIpsaLeaveEarlyTimes(String ipsaLeaveEarlyTimes) {
        this.ipsaLeaveEarlyTimes = ipsaLeaveEarlyTimes;
    }

    public String getIpsaabsenteeismTimes() {
        return ipsaabsenteeismTimes;
    }

    public void setIpsaabsenteeismTimes(String ipsaabsenteeismTimes) {
        this.ipsaabsenteeismTimes = ipsaabsenteeismTimes;
    }

    public String getIpsaoweTimes() {
        return ipsaoweTimes;
    }

    public void setIpsaoweTimes(String ipsaoweTimes) {
        this.ipsaoweTimes = ipsaoweTimes;
    }

    public String getIpsaovertimeNum() {
        return ipsaovertimeNum;
    }

    public void setIpsaovertimeNum(String ipsaovertimeNum) {
        this.ipsaovertimeNum = ipsaovertimeNum;
    }

    public String getIpsaovertimes() {
        return ipsaovertimes;
    }

    public void setIpsaovertimes(String ipsaovertimes) {
        this.ipsaovertimes = ipsaovertimes;
    }

    public String getIpsaextendTimes() {
        return ipsaextendTimes;
    }

    public void setIpsaextendTimes(String ipsaextendTimes) {
        this.ipsaextendTimes = ipsaextendTimes;
    }

    public String getOmpshouldTimes() {
        return ompshouldTimes;
    }

    public void setOmpshouldTimes(String ompshouldTimes) {
        this.ompshouldTimes = ompshouldTimes;
    }

    public String getOmpholidayTimes() {
        return ompholidayTimes;
    }

    public void setOmpholidayTimes(String ompholidayTimes) {
        this.ompholidayTimes = ompholidayTimes;
    }

    public String getOmplateTimes() {
        return omplateTimes;
    }

    public void setOmplateTimes(String omplateTimes) {
        this.omplateTimes = omplateTimes;
    }

    public String getOmpLeaveEarlyTimes() {
        return ompLeaveEarlyTimes;
    }

    public void setOmpLeaveEarlyTimes(String ompLeaveEarlyTimes) {
        this.ompLeaveEarlyTimes = ompLeaveEarlyTimes;
    }

    public String getOmpbusinessTimes() {
        return ompbusinessTimes;
    }

    public void setOmpbusinessTimes(String ompbusinessTimes) {
        this.ompbusinessTimes = ompbusinessTimes;
    }

    public String getOmpabsenteeismTimes() {
        return ompabsenteeismTimes;
    }

    public void setOmpabsenteeismTimes(String ompabsenteeismTimes) {
        this.ompabsenteeismTimes = ompabsenteeismTimes;
    }

    public String getOmpoweTimes() {
        return ompoweTimes;
    }

    public void setOmpoweTimes(String ompoweTimes) {
        this.ompoweTimes = ompoweTimes;
    }

    public String getOmpsupplySignInNum() {
        return ompsupplySignInNum;
    }

    public void setOmpsupplySignInNum(String ompsupplySignInNum) {
        this.ompsupplySignInNum = ompsupplySignInNum;
    }

    public String getOmpserverTimes() {
        return ompserverTimes;
    }

    public void setOmpserverTimes(String ompserverTimes) {
        this.ompserverTimes = ompserverTimes;
    }

    public String getOmprealTimes() {
        return omprealTimes;
    }

    public void setOmprealTimes(String omprealTimes) {
        this.omprealTimes = omprealTimes;
    }

    public String getOmppayTimes() {
        return omppayTimes;
    }

    public void setOmppayTimes(String omppayTimes) {
        this.omppayTimes = omppayTimes;
    }

    public String getOmpoverTimes() {
        return ompoverTimes;
    }

    public void setOmpoverTimes(String ompoverTimes) {
        this.ompoverTimes = ompoverTimes;
    }

    public String getOmpmonthInShore() {
        return ompmonthInShore;
    }

    public void setOmpmonthInShore(String ompmonthInShore) {
        this.ompmonthInShore = ompmonthInShore;
    }
}
