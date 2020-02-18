package com.weiyun.fastdfs.domain.proto.storage;

import com.weiyun.fastdfs.domain.fdfs.StorePath;
import com.weiyun.fastdfs.domain.proto.AbstractFdfsCommand;
import com.weiyun.fastdfs.domain.proto.FdfsResponse;
import com.weiyun.fastdfs.domain.proto.storage.internal.StorageUploadFileRequest;

import java.io.InputStream;

/**
 * 文件上传命令
 *
 * @author tobato
 */
public class StorageUploadFileCommand extends AbstractFdfsCommand<StorePath> {


    /**
     * 文件上传命令
     *
     * @param storeIndex
     * @param inputStream
     * @param fileExtName
     * @param fileSize
     * @param isAppenderFile
     */
    public StorageUploadFileCommand(byte storeIndex, InputStream inputStream, String fileExtName, long fileSize,
                                    boolean isAppenderFile) {
        super();
        this.request = new StorageUploadFileRequest(storeIndex, inputStream, fileExtName, fileSize, isAppenderFile);
        // 输出响应
        this.response = new FdfsResponse<StorePath>() {
            // default response
        };
    }

}
