package com.weiyun.fastdfs.domain.proto.tracker;

import com.weiyun.fastdfs.domain.proto.AbstractFdfsCommand;
import com.weiyun.fastdfs.domain.proto.FdfsResponse;
import com.weiyun.fastdfs.domain.proto.tracker.internal.TrackerDeleteStorageRequest;

/**
 * 移除存储服务器命令
 *
 * @author tobato
 */
public class TrackerDeleteStorageCommand extends AbstractFdfsCommand<Void> {

    public TrackerDeleteStorageCommand(String groupName, String storageIpAddr) {
        super.request = new TrackerDeleteStorageRequest(groupName, storageIpAddr);
        super.response = new FdfsResponse<Void>() {
            // default response
        };
    }

}
