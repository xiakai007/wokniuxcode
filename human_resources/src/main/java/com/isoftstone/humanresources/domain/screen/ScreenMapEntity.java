package com.isoftstone.humanresources.domain.screen;

import java.io.Serializable;
import java.util.List;

public class ScreenMapEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;

    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
