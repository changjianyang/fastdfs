package com.weiyun.fastdfs.domain.proto.storage;

import com.weiyun.fastdfs.domain.fdfs.StorePath;
import com.weiyun.fastdfs.domain.proto.StorageCommandTestBase;
import org.junit.Test;

public class StorageDeleteFileCommandTest extends StorageCommandTestBase {

    /**
     * 文件删除测试
     */
    @Test
    public void testStorageDeleteFileCommand() {

        // 上传文件
        StorePath path = uploadDefaultFile();

        // 删除文件
        StorageDeleteFileCommand command = new StorageDeleteFileCommand(path.getGroup(), path.getPath());
        executeStoreCmd(command);
        LOGGER.debug("----文件删除成功-----");
    }

}
