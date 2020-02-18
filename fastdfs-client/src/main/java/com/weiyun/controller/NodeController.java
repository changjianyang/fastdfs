package com.weiyun.controller;

import com.weiyun.fastdfs.domain.fdfs.StorageNode;
import com.weiyun.fastdfs.domain.fdfs.StorageState;
import com.weiyun.fastdfs.service.DefaultTrackerClient;
import com.weiyun.entity.ResponseFul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author YcJ
 * @Description
 * @Date 2020/2/18 17:46
 */
@RestController
@RequestMapping(value = "node")
public class NodeController {

    @Autowired
    private DefaultTrackerClient trackerClient;

    /**
     * 获取存储节点
     * @return
     */
    @RequestMapping(value = "getAll")
    public String getNode(){
        try {
            StorageNode storeStorage = trackerClient.getStoreStorage();
            return ResponseFul.success(storeStorage,"获取存储节点成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseFul.fail(500,"获取存储节点失败",null);
        }
    }

    /**
     * 按組查詢存儲節點
     * @param groupName 组名 group1
     * @return
     */
    @GetMapping(value = "getByGroup")
    public String getNodeByGroup(@RequestParam(value = "groupName") String groupName){
        try {
            StorageNode storeStorage = trackerClient.getStoreStorage(groupName);
            return ResponseFul.success(storeStorage,"按組查詢成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseFul.fail(500,"按组查询节点失败",null);
        }
    }

    /**
     * 获取存储状态
     * @param groupName 組名 group1
     * @return
     */
    @RequestMapping(value = "listStorages")
    public String getListStorages(@RequestParam(value = "groupName")String groupName){
        try {
            List<StorageState> storageStates = trackerClient.listStorages(groupName);
            return ResponseFul.success(storageStates,"查询存储状态成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseFul.fail(500,"查詢存儲狀態失敗",null);
        }
    }
}
