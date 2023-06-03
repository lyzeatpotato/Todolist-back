package com.example.shuhistory.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CreateHistoryForm {
    private String title;

    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
