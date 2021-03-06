package com.weiyun.fastdfs.domain.proto.storage;

import com.weiyun.fastdfs.domain.fdfs.FileInfo;
import com.weiyun.fastdfs.domain.fdfs.StorePath;
import com.weiyun.fastdfs.domain.proto.StorageCommandTestBase;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * 文件查询处理
 *
 * @author tobato
 */
public class StorageQueryFileInfoCommandTest extends StorageCommandTestBase {

    @Test
    public void testStorageQueryFileInfoCommand() {
        // 上传文件
        StorePath path = uploadDefaultFile();

        // 查询文件
        StorageQueryFileInfoCommand command = new StorageQueryFileInfoCommand(path.getGroup(), path.getPath());
        FileInfo fileInfo = executeStoreCmd(command);
        assertNotNull(fileInfo);
        LOGGER.debug("----文件查询处理结果-----");
        LOGGER.debug(fileInfo.toString());
    }

}
