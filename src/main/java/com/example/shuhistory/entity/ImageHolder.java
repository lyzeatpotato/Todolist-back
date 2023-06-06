package com.example.shuhistory.entity;

import com.example.shuhistory.enums.FileStateEnums;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: lyz
 * @date: 2023-06-2023/6/3
 * @description: 图片实体类
 */
@Data
public class ImageHolder {

    private FileStateEnums StateEnum;
    private String fileName;
    private MultipartFile multipartFile;
    private List<MultipartFile> list;

    //成功的构造器
    public ImageHolder(FileStateEnums stateEnum, MultipartFile multipartFile) {
        StateEnum = stateEnum;
        this.multipartFile = multipartFile;
    }
    public ImageHolder(FileStateEnums stateEnum, String fileName) {
        StateEnum = stateEnum;
        this.fileName = fileName;
    }

    //失败的构造器
    public ImageHolder(FileStateEnums stateEnum) {
        StateEnum = stateEnum;
    }
}
