package com.woniu.baidumap.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shop implements Serializable{
    private String name;
    private String address;
    private String province;
    private String city;
    private String area;
    private String street_id;
    private String telephone;
    private Location location;
}
