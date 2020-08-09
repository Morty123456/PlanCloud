package org.hg.hystrix.controller;

import org.hg.hystrix.service.OnLoadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: wzh
 * @time: 2020/8/9 9:05
 * @description:
 */
@RestController
public class OnLoadFile {
    @Autowired
    OnLoadFileService onLoadFileService;

    @PostMapping("/file")
    public String addFile(MultipartFile file, String fileType){
        System.out.println("文件上传");
        boolean flage = false;
        String fileName =file.getOriginalFilename();
        System.out.println(fileName);
        try {
            onLoadFileService.batchImport(fileName, file, fileType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
