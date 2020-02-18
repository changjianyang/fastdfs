package com.weiyun.fastdfs.domain.proto.storage;

import com.weiyun.fastdfs.TestConstants;
import org.junit.Test;

import com.weiyun.fastdfs.domain.proto.StorageCommandTestBase;

/**
 * 文件上传命令测试
 * 
 * @author tobato
 *
 */
public class StorageUploadFileCommandTest extends StorageCommandTestBase {

    /**
     * 文件上传测试
     */
    @Test
    public void testStorageUploadFileCommand() {
        // 非append模式
        execStorageUploadFileCommand(TestConstants.CAT_IMAGE_FILE, false);
    }

    @Test
    public void testStorageUploadFileCommandByAppend() {
        // append模式
        execStorageUploadFileCommand(TestConstants.CAT_IMAGE_FILE, true);
    }

}
