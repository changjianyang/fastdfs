package com.weiyun.fastdfs.domain.proto.tracker;

import com.weiyun.fastdfs.domain.fdfs.StorageNode;
import com.weiyun.fastdfs.domain.proto.AbstractFdfsCommand;
import com.weiyun.fastdfs.domain.proto.FdfsResponse;
import com.weiyun.fastdfs.domain.proto.tracker.internal.TrackerGetStoreStorageWithGroupRequest;
import com.weiyun.fastdfs.domain.proto.tracker.internal.TrackerGetStoreStorageRequest;

/**
 * 获取存储节点命令
 *
 * @author tobato
 */
public class TrackerGetStoreStorageCommand extends AbstractFdfsCommand<StorageNode> {

    public TrackerGetStoreStorageCommand(String groupName) {
        super.request = new TrackerGetStoreStorageWithGroupRequest(groupName);
        super.response = new FdfsResponse<StorageNode>() {
            // default response
        };
    }

    public TrackerGetStoreStorageCommand() {
        super.request = new TrackerGetStoreStorageRequest();
        super.response = new FdfsResponse<StorageNode>() {
            // default response
        };
    }

}
