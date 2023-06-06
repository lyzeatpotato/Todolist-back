package com.example.shuhistory.service;

import com.example.shuhistory.entity.ImageHolder;
import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    ImageHolder addHeadImage(MultipartFile file);

    ImageHolder addHeadImageToOss(MultipartFile file, String filePath);
}

