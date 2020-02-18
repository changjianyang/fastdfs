package com.weiyun.controller;

import com.weiyun.entity.ResponseFul;
import com.weiyun.fastdfs.domain.fdfs.MetaData;
import com.weiyun.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @Author YcJ
 * @Description
 * @Date 2020/2/18 15:17
 */
@RestController
@RequestMapping(value = "metaData")
public class MetaDataController {

    @Autowired
    protected FastFileStorageClient storageClient;

    /**
     * 查询元数据
     *
     * @param groupName 組 group1
     * @param path  路徑 M00/61/02/rBsSEV5LjyWAPbwWAEp7JSsFfko668.zip
     * @return
     */
    @GetMapping(value = "get")
    public String getMetaData(@RequestParam("groupName") String groupName, @RequestParam(value = "path") String path) {
        try {
            Set<MetaData> fetchMetaData = storageClient.getMetadata(groupName, path);
            return ResponseFul.success(fetchMetaData, "查询元数据");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseFul.fail(500, "找不到节点或文件", null);
        }
    }
}
