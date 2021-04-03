package com.isoftstone.humanresources.util;

import java.util.ArrayList;
import java.util.List;


public class TreeUtils {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <OrganizationTreeVO extends BisicTreeVo> List<OrganizationTreeVO> getTree(List<OrganizationTreeVO> sources){
		List<OrganizationTreeVO> rootList =  getTreeRoot(sources);
        int len = rootList.size();
        for(int i=0;i<len;i++){
            rootList.get( i ).setChildren(getChild(rootList.get( i ).getId(),sources));
        }
        return rootList;
    }

    /**
     * 分离出根节点
     * @return
     */
    private  static <OrganizationTreeVO extends BisicTreeVo<OrganizationTreeVO>> List<OrganizationTreeVO> getTreeRoot(List<OrganizationTreeVO> sources){
        List<OrganizationTreeVO> rootList = new ArrayList<>(  );
        for(int i=sources.size()-1;i>=0;i--){
            if(sources.get( i ).getParentId() == null){
                rootList.add( sources.remove( i ) );
            }
        }
        return rootList;
    }


    private static <OrganizationTreeVO extends BisicTreeVo> List<OrganizationTreeVO> getChild(String parentId, List<OrganizationTreeVO> orgList)
    {
        List<OrganizationTreeVO> list = new ArrayList<>();
        for(OrganizationTreeVO org: orgList){
                if (org.getParentId().equals(parentId)){
                    list.add(org);

                }
        }
            for(OrganizationTreeVO orgVo : list){
                List<OrganizationTreeVO> retlist = getChild(orgVo.getId(), orgList);
                orgVo.setChildren(retlist);
            }


        return list;
    }
}
