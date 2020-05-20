package com.mooc.mooc.service;

import com.mooc.mooc.model.DiscussRecord;
import com.mooc.mooc.model.DiscussionDetail;

public interface DiscussRecordService {

    DiscussionDetail addRecord(DiscussRecord discussRecord);

    DiscussionDetail updateRecord(DiscussRecord discussRecord);

    DiscussionDetail deleteRecord(DiscussRecord discussRecord);
}
