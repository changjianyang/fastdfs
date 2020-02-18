package com.weiyun.fastdfs.domain.proto.tracker;

import com.weiyun.fastdfs.domain.fdfs.GroupState;
import com.weiyun.fastdfs.domain.proto.AbstractFdfsCommand;
import com.weiyun.fastdfs.domain.proto.tracker.internal.TrackerListGroupsRequest;
import com.weiyun.fastdfs.domain.proto.tracker.internal.TrackerListGroupsResponse;

import java.util.List;

/**
 * 列出组命令
 *
 * @author tobato
 */
public class TrackerListGroupsCommand extends AbstractFdfsCommand<List<GroupState>> {

    public TrackerListGroupsCommand() {
        super.request = new TrackerListGroupsRequest();
        super.response = new TrackerListGroupsResponse();
    }

}
