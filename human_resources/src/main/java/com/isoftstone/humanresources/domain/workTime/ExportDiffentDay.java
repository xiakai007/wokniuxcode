package com.isoftstone.humanresources.domain.workTime;

import java.io.Serializable;

/**
 * 日期差异数据excel导出
 */
public class ExportDiffentDay implements Serializable {

    private static final long serialVersionUID = -1L;

    private int ipsaemployeeID        ;
    private String ipsaemployeeName      ;
    private String ipsaworkArea          ;
    private String ipsaworkStatus        ;
    private String ipsapersonalStatus    ;
    private String ipsadayCount          ;
    private String ipsaworkDay           ;
    private String ipsadayCatagray       ;
    private String ipsafirstRecordPlace  ;
    private String ipsafirstRecordTime   ;
    private String ipsalastRecordPlace   ;
    private String ipsalastRecordTime    ;
    private String ipsaactualTimes       ;
    private String ipsaholidayTimes      ;
    private String ipsabusinessTimes     ;
    private String ipsaoutWorkTimes      ;
    private String ipsaabsenteeismTimes  ;
    private String ipsaworkBadTimes      ;
    private String ipsapenalizeTimes     ;
    private String ipsalateTimes         ;
    private String ipsaovertimes         ;
    private String ipsaextendTimes       ;
    private String ipsacopCatagray       ;
    private String ipsacopModel          ;
    private String ipsamonthInShore      ;

    private String omppo                 ;
    private String omppersonStatus       ;
    private String ompactualTimes        ;
    private String ompholidayTimes       ;
    private String ompabsenteeismTimes   ;
    private String omppenalizeTimes      ;
    private String ompovertimes          ;
    private String ompextendTimes        ;
    private String ompcopCatagray        ;
    private String ompcopModel           ;
    private String ompmonthInShore       ;

    private String signMsg ;
    private String shoreMsg ;

    private String difworkTimes  ;   //   出勤工时差异
    private String difholidayTimes ;   //  请假工时差异
    private String diflateLeaveTimes ;   // 迟到&早退工时差异
    private String difabsenteeismTimes ;   // 旷工工时差异
    private String difoverTimes  ;   // 加班工时差异
    private String difextendTimes  ;   // 延长工时差异

    public String getSignMsg() {
        return signMsg;
    }

    public void setSignMsg(String signMsg) {
        this.signMsg = signMsg;
    }

    public String getShoreMsg() {
        return shoreMsg;
    }

    public void setShoreMsg(String shoreMsg) {
        this.shoreMsg = shoreMsg;
    }

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

    public int getIpsaemployeeID() {
        return ipsaemployeeID;
    }

    public void setIpsaemployeeID(int ipsaemployeeID) {
        this.ipsaemployeeID = ipsaemployeeID;
    }

    public String getIpsaemployeeName() {
        return ipsaemployeeName;
    }

    public void setIpsaemployeeName(String ipsaemployeeName) {
        this.ipsaemployeeName = ipsaemployeeName;
    }

    public String getIpsaworkArea() {
        return ipsaworkArea;
    }

    public void setIpsaworkArea(String ipsaworkArea) {
        this.ipsaworkArea = ipsaworkArea;
    }

    public String getIpsaworkStatus() {
        return ipsaworkStatus;
    }

    public void setIpsaworkStatus(String ipsaworkStatus) {
        this.ipsaworkStatus = ipsaworkStatus;
    }

    public String getIpsapersonalStatus() {
        return ipsapersonalStatus;
    }

    public void setIpsapersonalStatus(String ipsapersonalStatus) {
        this.ipsapersonalStatus = ipsapersonalStatus;
    }

    public String getIpsadayCount() {
        return ipsadayCount;
    }

    public void setIpsadayCount(String ipsadayCount) {
        this.ipsadayCount = ipsadayCount;
    }

    public String getIpsaworkDay() {
        return ipsaworkDay;
    }

    public void setIpsaworkDay(String ipsaworkDay) {
        this.ipsaworkDay = ipsaworkDay;
    }

    public String getIpsadayCatagray() {
        return ipsadayCatagray;
    }

    public void setIpsadayCatagray(String ipsadayCatagray) {
        this.ipsadayCatagray = ipsadayCatagray;
    }

    public String getIpsafirstRecordPlace() {
        return ipsafirstRecordPlace;
    }

    public void setIpsafirstRecordPlace(String ipsafirstRecordPlace) {
        this.ipsafirstRecordPlace = ipsafirstRecordPlace;
    }

    public String getIpsafirstRecordTime() {
        return ipsafirstRecordTime;
    }

    public void setIpsafirstRecordTime(String ipsafirstRecordTime) {
        this.ipsafirstRecordTime = ipsafirstRecordTime;
    }

    public String getIpsalastRecordPlace() {
        return ipsalastRecordPlace;
    }

    public void setIpsalastRecordPlace(String ipsalastRecordPlace) {
        this.ipsalastRecordPlace = ipsalastRecordPlace;
    }

    public String getIpsalastRecordTime() {
        return ipsalastRecordTime;
    }

    public void setIpsalastRecordTime(String ipsalastRecordTime) {
        this.ipsalastRecordTime = ipsalastRecordTime;
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

    public String getIpsaoutWorkTimes() {
        return ipsaoutWorkTimes;
    }

    public void setIpsaoutWorkTimes(String ipsaoutWorkTimes) {
        this.ipsaoutWorkTimes = ipsaoutWorkTimes;
    }

    public String getIpsaabsenteeismTimes() {
        return ipsaabsenteeismTimes;
    }

    public void setIpsaabsenteeismTimes(String ipsaabsenteeismTimes) {
        this.ipsaabsenteeismTimes = ipsaabsenteeismTimes;
    }

    public String getIpsaworkBadTimes() {
        return ipsaworkBadTimes;
    }

    public void setIpsaworkBadTimes(String ipsaworkBadTimes) {
        this.ipsaworkBadTimes = ipsaworkBadTimes;
    }

    public String getIpsapenalizeTimes() {
        return ipsapenalizeTimes;
    }

    public void setIpsapenalizeTimes(String ipsapenalizeTimes) {
        this.ipsapenalizeTimes = ipsapenalizeTimes;
    }

    public String getIpsalateTimes() {
        return ipsalateTimes;
    }

    public void setIpsalateTimes(String ipsalateTimes) {
        this.ipsalateTimes = ipsalateTimes;
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

    public String getIpsacopCatagray() {
        return ipsacopCatagray;
    }

    public void setIpsacopCatagray(String ipsacopCatagray) {
        this.ipsacopCatagray = ipsacopCatagray;
    }

    public String getIpsacopModel() {
        return ipsacopModel;
    }

    public void setIpsacopModel(String ipsacopModel) {
        this.ipsacopModel = ipsacopModel;
    }

    public String getIpsamonthInShore() {
        return ipsamonthInShore;
    }

    public void setIpsamonthInShore(String ipsamonthInShore) {
        this.ipsamonthInShore = ipsamonthInShore;
    }

    public String getOmppo() {
        return omppo;
    }

    public void setOmppo(String omppo) {
        this.omppo = omppo;
    }

    public String getOmppersonStatus() {
        return omppersonStatus;
    }

    public void setOmppersonStatus(String omppersonStatus) {
        this.omppersonStatus = omppersonStatus;
    }

    public String getOmpactualTimes() {
        return ompactualTimes;
    }

    public void setOmpactualTimes(String ompactualTimes) {
        this.ompactualTimes = ompactualTimes;
    }

    public String getOmpholidayTimes() {
        return ompholidayTimes;
    }

    public void setOmpholidayTimes(String ompholidayTimes) {
        this.ompholidayTimes = ompholidayTimes;
    }

    public String getOmpabsenteeismTimes() {
        return ompabsenteeismTimes;
    }

    public void setOmpabsenteeismTimes(String ompabsenteeismTimes) {
        this.ompabsenteeismTimes = ompabsenteeismTimes;
    }

    public String getOmppenalizeTimes() {
        return omppenalizeTimes;
    }

    public void setOmppenalizeTimes(String omppenalizeTimes) {
        this.omppenalizeTimes = omppenalizeTimes;
    }

    public String getOmpovertimes() {
        return ompovertimes;
    }

    public void setOmpovertimes(String ompovertimes) {
        this.ompovertimes = ompovertimes;
    }

    public String getOmpextendTimes() {
        return ompextendTimes;
    }

    public void setOmpextendTimes(String ompextendTimes) {
        this.ompextendTimes = ompextendTimes;
    }

    public String getOmpcopCatagray() {
        return ompcopCatagray;
    }

    public void setOmpcopCatagray(String ompcopCatagray) {
        this.ompcopCatagray = ompcopCatagray;
    }

    public String getOmpcopModel() {
        return ompcopModel;
    }

    public void setOmpcopModel(String ompcopModel) {
        this.ompcopModel = ompcopModel;
    }

    public String getOmpmonthInShore() {
        return ompmonthInShore;
    }

    public void setOmpmonthInShore(String ompmonthInShore) {
        this.ompmonthInShore = ompmonthInShore;
    }
}
