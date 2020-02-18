package com.weiyun.controller;

import com.weiyun.tobato.fastdfs.domain.fdfs.MetaData;
import com.weiyun.tobato.fastdfs.domain.fdfs.StorePath;
import com.weiyun.tobato.fastdfs.service.FastFileStorageClient;
import com.weiyun.entity.ResponseFul;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author YcJ
 * @Description
 * @Date 2020/2/16 22:40
 */
@RestController
@RequestMapping(value = "file")
public class FileController {

    @Value("${wx.domain}")
    private String url;
    @Autowired
    protected FastFileStorageClient storageClient;

    @PostMapping(value = "upload")
    public String uploadFile1(MultipartFile file) throws Exception{
      return   this.testUploadFileAndMetaData(file);
    }

    /**
     * 刪除文件
     * @param group 组
     * @param path 路径
     * @return
     */
    @GetMapping(value = "del")
    public String deleteFile(@RequestParam(value = "group") String group,@RequestParam(value = "path") String path){
        try {
            storageClient.deleteFile(group, path);
            return ResponseFul.success(null,"刪除成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseFul.fail(500,"刪除失敗",null);
        }
    }

    /**
     * 日志
     */
    protected static Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    /**
     * 上传文件，并且设置MetaData
     */
    public String  testUploadFileAndMetaData(MultipartFile file) throws Exception{
        LOGGER.debug("##上传文件..##");
        // Metadata
        Set<MetaData> metaDataSet = createMetaData();
        String originalFilename = file.getOriginalFilename();
        //获取文件扩展名
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).replace(".","");
        // 上传文件和Metadata
        StorePath path = storageClient.uploadFile(file.getInputStream(), file.getBytes().length, suffix,
                metaDataSet);
        //StorePath [group=group1, path=M00/61/02/rBsSEV5Lg_CAQViwAALo8_2yJiM940.png]
        String fullPath = path.getFullPath()+"?attname="+originalFilename;
        return this.url+"/"+fullPath;
    }



    private Set<MetaData> createMetaData() {
        Set<MetaData> metaDataSet = new HashSet<>();
        metaDataSet.add(new MetaData("Author", "yangchangjian"));
        metaDataSet.add(new MetaData("CreateDate", "2020-02-18"));
        metaDataSet.add(new MetaData("company","微掌文"));
        return metaDataSet;
    }

}
