package com.example.shuhistory.entity;

import lombok.Data;

@Data
public class MemorabiliaFiguresWithBLOBs extends SchoolHistoryFigures {

    private String event;

    private String year;

    private String month;

    private String picture;

    private String pic_detail;

    private String school;

}