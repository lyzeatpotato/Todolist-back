package com.example.shuhistory.entity;

import lombok.Data;

@Data
public class CloudBlessWithBLOBs extends CloudBless {

    private String status;

    private String content;

    private String distance;

    private String city;

    private String show_distance;

}