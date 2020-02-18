package com.weiyun.fastdfs.domain.proto.tracker;

import com.weiyun.fastdfs.domain.fdfs.StorageNodeInfo;
import com.weiyun.fastdfs.domain.proto.AbstractFdfsCommand;
import com.weiyun.fastdfs.domain.proto.FdfsResponse;
import com.weiyun.fastdfs.domain.proto.tracker.internal.TrackerGetFetchStorageRequest;

/**
 * 获取源服务器
 *
 * @author tobato
 */
public class TrackerGetFetchStorageCommand extends AbstractFdfsCommand<StorageNodeInfo> {

    public TrackerGetFetchStorageCommand(String groupName, String path, boolean toUpdate) {
        super.request = new TrackerGetFetchStorageRequest(groupName, path, toUpdate);
        super.response = new FdfsResponse<StorageNodeInfo>() {
            // default response
        };
    }

}
