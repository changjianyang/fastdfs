package com.weiyun.fastdfs.domain.proto.storage;

import com.weiyun.fastdfs.domain.proto.AbstractFdfsCommand;
import com.weiyun.fastdfs.domain.proto.FdfsResponse;
import com.weiyun.fastdfs.domain.proto.storage.internal.StorageTruncateRequest;

/**
 * 文件Truncate命令
 *
 * @author tobato
 */
public class StorageTruncateCommand extends AbstractFdfsCommand<Void> {


    /**
     * StorageTruncateCommand
     *
     * @param path
     * @param fileSize
     */
    public StorageTruncateCommand(String path, long fileSize) {
        super();
        this.request = new StorageTruncateRequest(path, fileSize);
        // 输出响应
        this.response = new FdfsResponse<Void>() {
            // default response
        };
    }

}
