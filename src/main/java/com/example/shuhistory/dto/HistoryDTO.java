package com.example.shuhistory.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDTO {
    private Integer id;
    private String title;
    private String content;
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    private Date date;
}
