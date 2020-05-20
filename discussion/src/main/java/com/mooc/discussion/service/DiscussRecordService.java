package com.mooc.discussion.service;


import com.mooc.discussion.model.DiscussRecord;
import com.mooc.discussion.model.DiscussionDetail;

public interface DiscussRecordService {

    DiscussionDetail addRecord(DiscussRecord discussRecord);

    DiscussionDetail updateRecord(DiscussRecord discussRecord);

    DiscussionDetail deleteRecord(DiscussRecord discussRecord);
}
