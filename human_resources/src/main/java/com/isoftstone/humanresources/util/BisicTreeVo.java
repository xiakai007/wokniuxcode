package com.isoftstone.humanresources.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.*;
import jdk.nashorn.internal.ir.annotations.Ignore;


public class BisicTreeVo<OrganizationTreeVO> {

    private String id ;

    private String title ;


    private String parentId ;

    private String parentName ;

    private List<OrganizationTreeVO> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonAlias
    public List<OrganizationTreeVO> getChildren() {
        return children;
    }

    public void setChildren(List<OrganizationTreeVO> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        @SuppressWarnings("unchecked")
		BisicTreeVo<OrganizationTreeVO> that = (BisicTreeVo<OrganizationTreeVO>) o;
        return Objects.equals( id, that.id );
    }

    @Override
    public int hashCode() {

        return Objects.hash( id );
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }


    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
