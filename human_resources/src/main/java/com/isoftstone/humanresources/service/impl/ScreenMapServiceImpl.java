package com.isoftstone.humanresources.service.impl;

import com.isoftstone.humanresources.dao.ScreenMapDao;
import com.isoftstone.humanresources.dao.WarnDao;
import com.isoftstone.humanresources.domain.EmployeeInformation;
import com.isoftstone.humanresources.domain.OrganizationInformation;
import com.isoftstone.humanresources.domain.screen.*;
import com.isoftstone.humanresources.service.EmployeeService;
import com.isoftstone.humanresources.service.OrganizationService;
import com.isoftstone.humanresources.service.ScreenMapService;
import com.isoftstone.humanresources.util.CommonConstant;
import com.isoftstone.humanresources.util.DateUtil;
import com.isoftstone.humanresources.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service(value = "ScreenMapService")
public class ScreenMapServiceImpl implements ScreenMapService {

    private final static Logger logger = LoggerFactory.getLogger(ScreenMapService.class);

    @Autowired
    private ScreenMapDao screenMapDao;

    @Autowired
    private WarnDao warnDao;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private EmployeeService employeeService;

    public List<ScreenMapEntity> queryUserMapEntity(String organizationID,String organizationType){
        return screenMapDao.queryScreenMapEntity(organizationType,organizationID);
    }

    /**
     * 获取项目组或部门的性别分布信息
     * @param organizationID
     * @param organizationType
     * @return
     */
    public List<ScreenMapEntity> getSexDistribution(String organizationID,String organizationType){

        List<ScreenMapEntity> screenMapEntityList = null;

        if(StringUtil.checkOrganizationType(organizationType)){
            screenMapEntityList =  screenMapDao.getSexDistribution(organizationType,organizationID);
        }else {
            logger.error("organizationType is error!");
        }
        return screenMapEntityList;
    }


    /**
     * 获取项目组或部门的年龄分布信息
     * @param organizationID
     * @param organizationType
     * @return
     */
    public List<ScreenMapEntity> getAgeDistribution(String organizationID,String organizationType){

        List<ScreenMapEntity> screenMapEntityList = null;
        //按组织查询出员工信息
        List<EmployeeInformation>  employeeInformationList = null;
        if(StringUtil.checkOrganizationType(organizationType)){
            employeeInformationList =  employeeService.queryByOrganizationID(organizationID,organizationType);
        }else {
            logger.error("organizationType is error!");
        }
        if(CollectionUtils.isEmpty(employeeInformationList)){
            return screenMapEntityList;
        }
        //根据生日对员工进行分类
        screenMapEntityList = ageGroupToScreenMapList(employeeInformationList);
        return screenMapEntityList;
    }

    /**
     * 获取项目组或部门的司龄分布信息
     * @param organizationID
     * @param organizationType
     * @return
     */
    public List<ScreenMapEntity> getEntryAgeDistribution(String organizationID, String organizationType){

        List<ScreenMapEntity> screenMapEntityList = null;
        //按组织查询出员工信息
        List<EmployeeInformation>  employeeInformationList = null;
        if(StringUtil.checkOrganizationType(organizationType)){
            employeeInformationList =  employeeService.queryByOrganizationID(organizationID,organizationType);
        }else {
            logger.error("organizationType is error!");
        }
        if(CollectionUtils.isEmpty(employeeInformationList)){
            return screenMapEntityList;
        }
        //根据入职时间对员工进行分类
        screenMapEntityList = entryAgeGroupToScreenMapList(employeeInformationList);
        return screenMapEntityList;
    }



    /**
     * 年龄分组转换成需要的信息
     * @param employeeInformationList
     * @return
     */
    public List<ScreenMapEntity> ageGroupToScreenMapList(List<EmployeeInformation>  employeeInformationList){
        List<ScreenMapEntity> screenMapEntityList = new ArrayList<ScreenMapEntity>();
        int ages = 0;
        int agem = 0;
        int ageb = 0;
        //先定义分类，25以下，26-30,30以上，3个级别
        for(EmployeeInformation information:employeeInformationList){
            if(StringUtil.isEmpty(information.getBirthday())){
                continue;
            }
            if(StringUtil.isEmpty(information.getIssStatus())||!"在职".equals(information.getIssStatus())){
                continue;
            }
            int age = DateUtil.getAgeByBirthday(DateUtil.parseDateByAuto(information.getBirthday()));
            if(age<=25){
                ages = ages +1 ;
            }
            if(age>25&&age<=30){
                agem = agem +1 ;
            }
            if(age>30){
                ageb = ageb +1 ;
            }
        }
        ScreenMapEntity entitys = new ScreenMapEntity();
        entitys.setName("25岁以下");
        entitys.setValue(ages);
        screenMapEntityList.add(entitys);
        ScreenMapEntity entitym = new ScreenMapEntity();
        entitym.setName("26岁-30岁");
        entitym.setValue(agem);
        screenMapEntityList.add(entitym);
        ScreenMapEntity entityb = new ScreenMapEntity();
        entityb.setName("30岁以上");
        entityb.setValue(ageb);
        screenMapEntityList.add(entityb);
        return screenMapEntityList;
    }
    /**
     * 司龄分组转换成需要的信息
     * @param employeeInformationList
     * @return
     */
    public List<ScreenMapEntity> entryAgeGroupToScreenMapList(List<EmployeeInformation>  employeeInformationList){
        List<ScreenMapEntity> screenMapEntityList = new ArrayList<ScreenMapEntity>();
        int ages = 0;
        int agem = 0;
        int ageb = 0;
        //先定义分类，1以下，1-3年，3年以上，3个级别
        for(EmployeeInformation information:employeeInformationList) {
            if(StringUtil.isEmpty(information.getIssStatus())||!"在职".equals(information.getIssStatus())){
                continue;
            }
            int age = DateUtil.getAgeByBirthday(DateUtil.parseDateByAuto(information.getEntryDate()));
            if (age <= 1) {
                ages = ages + 1;
            }
            if (age > 1 && age <= 3) {
                agem = agem + 1;
            }
            if (age > 3) {
                ageb = ageb + 1;
            }
        }
        ScreenMapEntity entitys = new ScreenMapEntity();
        entitys.setName("1年以下");
        entitys.setValue(ages);
        screenMapEntityList.add(entitys);
        ScreenMapEntity entitym = new ScreenMapEntity();
        entitym.setName("1年-3年");
        entitym.setValue(agem);
        screenMapEntityList.add(entitym);
        ScreenMapEntity entityb = new ScreenMapEntity();
        entityb.setName("3年以上");
        entityb.setValue(ageb);
        screenMapEntityList.add(entityb);
        return screenMapEntityList;
    }
    /**
     * 获取项目组或部门的技能分布信息
     * @param organizationID
     * @param organizationType
     * @return
     */
    public List<ScreenMapEntity> getSkillDistribution(String organizationID,String organizationType){
        List<ScreenMapEntity> screenMapEntityList = null;
        if(StringUtil.checkOrganizationType(organizationType)){
            screenMapEntityList =  screenMapDao.getSkillDistribution(organizationType,organizationID);
        }else {
            logger.error("organizationType is error!");
        }
        return screenMapEntityList;
    }

    /**
     * 获取华为级别分布信息
     * @param organizationID
     * @param organizationType
     * @return
     */
    public List<ScreenMapEntity> getHuaweiLevelDistribution(String organizationID,String organizationType){

        List<ScreenMapEntity> screenMapEntityList = null;

        if(StringUtil.checkOrganizationType(organizationType)){
            screenMapEntityList =  screenMapDao.getHuaweiLevelDistribution(organizationType,organizationID);
        }else {
            logger.error("organizationType is error!");
        }
        return screenMapEntityList;
    }

    /**
     * 获取入职分布信息
     * @param organizationID
     * @param organizationType
     * @return
     */
    public List<EntryLeaveEntity> getEntryDistribution(String organizationID,String organizationType,String dateType) {
        List<ScreenMapEntity> entryList = null;
        List<EntryLeaveEntity> retList = null;
        //分别获取对应的list信息
        if (StringUtil.checkOrganizationType(organizationType)) {
            if (CommonConstant.DATE_TYPE_MONTH.equals(dateType)) {
                entryList = screenMapDao.getEntryDistributionByMonth(organizationType, organizationID);
            } else if (CommonConstant.DATE_TYPE_WEEK.equals(dateType)) {
                entryList = screenMapDao.getEntryDistributionByWeek(organizationType, organizationID);
            }
        } else {
            logger.error("organizationType is error!");
        }
        //对非空的处理
        if (CollectionUtils.isEmpty(entryList)) {
            return retList;
        }
        //入职和离职的月份信息集合
        List<String> diffMonth = new ArrayList<String>();
        if (!CollectionUtils.isEmpty(entryList)) {
            entryList.forEach(entity -> {
                if (!StringUtil.checkInList(diffMonth, entity.getName())) {
                    diffMonth.add(entity.getName());
                }
            });
        }
        //按日期顺序排序
        Collections.sort(diffMonth);
        //list转Map，为了方便下边的获取。
        Map<String, Integer> entryMap = entryList.stream().collect(Collectors.toMap(ScreenMapEntity::getName, ScreenMapEntity::getValue));
        retList = new ArrayList<EntryLeaveEntity>();
        String childOrgType = StringUtil.getChildOrganizationType(organizationType);
        for (String str : diffMonth) {
            EntryLeaveEntity entity = new EntryLeaveEntity();
            entity.setDate(str);
            if (null == entryMap.get(str)) {
                entity.setNum(0);
            } else {
                entity.setNum(entryMap.get(str));
            }
            //对入离职的Top信息进行获取

            if (!StringUtil.isEmpty(childOrgType)) {
                //入职Top添加
                if (CommonConstant.DATE_TYPE_MONTH.equals(dateType)) {
                    entity.setTopList(screenMapDao.getEntryTopByMonth(str + CommonConstant.STR_PERCENT, CommonConstant.STR_ENTRY, organizationType, organizationID, childOrgType));
                } else if (CommonConstant.DATE_TYPE_WEEK.equals(dateType)) {
                    entity.setTopList(screenMapDao.getEntryTopByWeek(str, CommonConstant.STR_ENTRY, organizationType, organizationID, childOrgType));
                }

            }
            retList.add(entity);
        }
        return retList;
    }
    /**
     * 获取离职分布信息
     * @param organizationID
     * @param organizationType
     * @return
     */
    public List<EntryLeaveEntity> getLeaveDistribution(String organizationID,String organizationType,String dateType){
        List<ScreenMapEntity> leaveList = null;
        List<EntryLeaveEntity> retList = null;
        //分别获取对应的list信息
        if(StringUtil.checkOrganizationType(organizationType)){
            if(CommonConstant.DATE_TYPE_MONTH.equals(dateType)) {
                leaveList = screenMapDao.getLeaveDistributionByMonth(organizationType, organizationID);
            }else  if(CommonConstant.DATE_TYPE_WEEK.equals(dateType)) {
                leaveList = screenMapDao.getLeaveDistributionByWeek(organizationType, organizationID);
            }
        }else {
            logger.error("organizationType is error!");
        }
        //对非空的处理
        if(CollectionUtils.isEmpty(leaveList)){
            return retList;
        }
        //入职和离职的月份信息集合
        List<String> diffMonth = new ArrayList<String>();
        if (!CollectionUtils.isEmpty(leaveList)) {
            leaveList.forEach(entity -> {
                if(!StringUtil.checkInList(diffMonth,entity.getName())) {
                    diffMonth.add(entity.getName());
                }
            });
        }
        //按日期顺序排序
        Collections.sort(diffMonth);
        //list转Map，为了方便下边的获取。
        Map<String , Integer> leaveMap = leaveList.stream().collect(Collectors.toMap(ScreenMapEntity::getName , ScreenMapEntity::getValue ));
        retList = new ArrayList<EntryLeaveEntity>();
        String childOrgType = StringUtil.getChildOrganizationType(organizationType) ;

        List<EntryLeaveTopEntity>  topEntityList = new ArrayList<EntryLeaveTopEntity>();
        List<EntryLeaveTopEntity>  preEntityList = new ArrayList<EntryLeaveTopEntity>();

        for(int i=0;i<diffMonth.size();i++) {
            String str = diffMonth.get(i);
            EntryLeaveEntity entity = new EntryLeaveEntity();
            entity.setDate(str);
            if(null == leaveMap.get(str)){
                entity.setNum(0);
            }else {
                entity.setNum(leaveMap.get(str));
            }
            //对入离职的Top信息进行获取
            if(!StringUtil.isEmpty(childOrgType)){
                //离职Top添加，在这里需要做叠加操作
                if(CommonConstant.DATE_TYPE_MONTH.equals(dateType)) {
                    topEntityList =  screenMapDao.getLeaveTopByMonth(str + CommonConstant.STR_PERCENT, CommonConstant.STR_LEAVE, organizationType, organizationID, childOrgType) ;
                }else  if(CommonConstant.DATE_TYPE_WEEK.equals(dateType)) {
                    topEntityList = screenMapDao.getLeaveTopByWeek(str,CommonConstant.STR_LEAVE,organizationType,organizationID,childOrgType);
                }
                if(i==0) {
                    entity.setTopList(changeList(topEntityList));
                }else{
                    //获取前一个实体的列表信息
                    preEntityList = retList.get(i-1).getTopList();
                    entity.setTopList(changeList(splicingList(topEntityList,preEntityList,"Leave")));
                }
            }
            retList.add(entity);
        }

        //获取所有的organizationID和organizationName不同的数据
        Map<String,String> diffOrg = new HashMap<String,String>();
        retList.forEach(entity -> {
        	if(null!=entity.getTopList()){
	            entity.getTopList().forEach(topEntity -> {
	                if (!StringUtil.checkInMap(diffOrg, topEntity.getOrganizationID())) {
	                    diffOrg.put(topEntity.getOrganizationID(),topEntity.getOrganizationName());
	                }
	            });
        	}
        });

        //组装新的返回实体
        List<EntryLeaveEntity> otherList = new ArrayList<EntryLeaveEntity>();
        //
        for(EntryLeaveEntity entryLeaveEntity : retList){
            topEntityList =  entryLeaveEntity.getTopList();

            for(String key : diffOrg.keySet()){
                boolean isInToplist = false ;
                for(EntryLeaveTopEntity leaveTopEntity: topEntityList ){
                    if(key.equals(leaveTopEntity.getOrganizationID())){
                        isInToplist = true ;
                        break;
                    }
                }
                if(!isInToplist){
                    EntryLeaveTopEntity topEntity = new EntryLeaveTopEntity();
                    topEntity.setOrganizationID(key);
                    topEntity.setOrganizationName(diffOrg.get(key));
                    topEntity.setLeaveNum(0);
                    topEntity.setAddLeaveNum(0);
                    topEntity.setAddLeaveOrEntryRate("0");
                    topEntityList.add(topEntity);
                }

            }
            entryLeaveEntity.setTopList(topEntityList);
            //根据organizationID进行倒序
            if(!CollectionUtils.isEmpty(topEntityList)){
	            Collections.sort(topEntityList, new Comparator<EntryLeaveTopEntity>() {
	                public int compare(EntryLeaveTopEntity o1, EntryLeaveTopEntity o2) {
	                    if (o1.getOrganizationID().compareTo(o2.getOrganizationID()) > 0) {
	                        return -1;
	                    }
	                    return 1;
	                }
	            });
            }
            otherList.add(entryLeaveEntity);

        }

        return otherList;
    }

    /**
     * 把list里面的entity的leaveNum赋值给AddLeaveNum
     * @param topEntityList
     * @return
     */
    private List<EntryLeaveTopEntity> changeList(List<EntryLeaveTopEntity>  topEntityList){
        List<EntryLeaveTopEntity> retList = new ArrayList<EntryLeaveTopEntity>();
        for(EntryLeaveTopEntity entity:topEntityList){
            if(null == entity.getAddLeaveNum()||0==entity.getAddLeaveNum()){
                entity.setAddLeaveNum(entity.getLeaveNum());
            }
            double df =  entity.getAddLeaveNum()*100/(entity.getAllNum()+entity.getAddLeaveNum());
            entity.setAddLeaveOrEntryRate(String.format("%.2f", df));
            retList.add(entity);
        }
        return retList;
    }

    /**
     * 相同ID的进行叠加
     * @param topEntityList
     * @param preEntityList
     * @param leaveOrEntryType
     * @return
     */
    private List<EntryLeaveTopEntity> splicingList(List<EntryLeaveTopEntity>  topEntityList,List<EntryLeaveTopEntity>  preEntityList,String leaveOrEntryType){
        List<EntryLeaveTopEntity> retList = new ArrayList<EntryLeaveTopEntity>();
        for(EntryLeaveTopEntity entity:topEntityList){
            for(EntryLeaveTopEntity preEntity:preEntityList){
                if(entity.getOrganizationID().equals(preEntity.getOrganizationID()) ){
                    if("Leave".equals(leaveOrEntryType)) {

                        entity.setAddLeaveNum(entity.getLeaveNum()+preEntity.getAddLeaveNum());
                        // entity.setLeaveNum(entity.getLeaveNum()+preEntity.getLeaveNum());
                    }
                    if("Entry".equals(leaveOrEntryType)) {
                        entity.setEntryNum(entity.getEntryNum()+preEntity.getEntryNum());
                    }
                }
            }
            retList.add(entity);
        }
        //对于中间空一个月没有
        boolean isInList = false;
        for(EntryLeaveTopEntity preEntity:preEntityList){
            for(EntryLeaveTopEntity entity:topEntityList){
                if(entity.getOrganizationID().equals(preEntity.getOrganizationID()) ){
                    isInList = true;
                }
            }
            if(!isInList) {
                retList.add(preEntity);
            }
            isInList = false;
        }
        //根据organizationID进行倒序
        Collections.sort(retList, new Comparator<EntryLeaveTopEntity>() {
            public int compare(EntryLeaveTopEntity o1, EntryLeaveTopEntity o2) {
                if (o1.getOrganizationID().compareTo(o2.getOrganizationID()) > 0) {
                    return -1;
                }
                return 1;
            }
        });


        return retList;
    }
    /**
     * 获取备份信息
     * @param organizationID
     * @param organizationType
     * @return
     */
    public List<EmployeeBackUpEntity> getBackUpDistribution(String organizationID, String organizationType){

        List<EmployeeBackUpEntity> employeeBackUpEntityList = null;

        if(!StringUtil.checkOrganizationType(organizationType)){
            return employeeBackUpEntityList;
        }

        //人员备份信息是按项目组进行统计的，如果是部门的，需要进行叠加。
        List<OrganizationInformation> list = new ArrayList<OrganizationInformation>();
        if(CommonConstant.ORGANZATION_TYPE_PROJECTTEAM.equals(organizationType)){
            OrganizationInformation information = new OrganizationInformation();
            information.setOrganizationID(organizationID);
            list.add(information);
            employeeBackUpEntityList =  screenMapDao.getBackUpDistribution(list);
        }else {
            employeeBackUpEntityList =  screenMapDao.getBackUpDistribution( organizationService.getChildOrgInfo(organizationID));
        }
        return employeeBackUpEntityList;
    }

    /**
     * 获取该组织下的告警信息
     * @param organizationID
     * @param organizationType
     * @return
     */
    public List<ScreenWarnEntity> getScreenWarn(String organizationID , String organizationType){
        List<ScreenWarnEntity> screenWarnEntityList = null;
        if(!StringUtil.checkOrganizationType(organizationType)){
            return screenWarnEntityList;
        }
        List<OrganizationInformation> list = new ArrayList<OrganizationInformation>();

        if(CommonConstant.ORGANZATION_TYPE_PROJECTTEAM.equals(organizationType)){
            OrganizationInformation information = new OrganizationInformation();
            information.setOrganizationID(organizationID);
            list.add(information);
            screenWarnEntityList =  warnDao.queryWarnByOrganizationID(list);
        }else {
            screenWarnEntityList =  warnDao.queryWarnByOrganizationID(organizationService.getChildOrgInfo(organizationID));
        }
        return  screenWarnEntityList;
    }
    /**
     * 获取项目组或部门的绩效分布信息
     * @param organizationID
     * @param organizationType
     * @return
     */
    public List<EmployeePerformanceEntity> getPerformanceDistribution(String organizationID, String organizationType){
        List<EmployeePerformanceEntity> employeeBackUpEntityList = null;
        if(!StringUtil.checkOrganizationType(organizationType)){
            return employeeBackUpEntityList;
        }
        List<OrganizationInformation> list = new ArrayList<OrganizationInformation>();
        if(CommonConstant.ORGANZATION_TYPE_PROJECTTEAM.equals(organizationType)){
            OrganizationInformation information = new OrganizationInformation();
            information.setOrganizationID(organizationID);
            list.add(information);
            employeeBackUpEntityList =  employeeService.getPerformanceDistribution(list);
        }else {
            employeeBackUpEntityList =  employeeService.getPerformanceDistribution( organizationService.getChildOrgInfo(organizationID));
        }
        return employeeBackUpEntityList;
    }

	@Override
	public List<OrganizationInformation> getCuInfoList(String employeeId) {
		return screenMapDao.getCuInfoList(employeeId);
	}

}
