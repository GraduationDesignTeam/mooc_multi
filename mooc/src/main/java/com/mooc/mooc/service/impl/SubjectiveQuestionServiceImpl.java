package com.mooc.mooc.service.impl;

import com.mooc.mooc.mapper.SubjectiveOfQuestionMapper;
import com.mooc.mooc.model.SubjectiveOfQuestion;
import com.mooc.mooc.service.SubjectiveQuestionService;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectiveQuestionServiceImpl implements SubjectiveQuestionService {

    @Autowired
    private SubjectiveOfQuestionMapper subjectiveOfQuestionMapper;
    @Override
    public List<SubjectiveOfQuestion> list(SubjectiveOfQuestion subjectiveOfQuestion) {
        return null;
    }

    @Override
    public ResultVO update(SubjectiveOfQuestion subjectiveOfQuestion) {
        return null;
    }

    @Override
    public ResultVO delete(Integer taskId) {
        subjectiveOfQuestionMapper.deleteByPrimaryKey(taskId);
        return null;
    }

    @Override
    public ResultVO add(SubjectiveOfQuestion subjectiveOfQuestion) {
        ResultVO resultVO=new ResultVO(0, "");
        subjectiveOfQuestion.setType(0);
        subjectiveOfQuestionMapper.insert(subjectiveOfQuestion);
        return resultVO;
    }

    @Override
    public ResultVO cancel(Integer choiceId) {
        return null;
    }

    @Override
    public SubjectiveOfQuestion sel(Integer choiceId) {
        return null;
    }

    @Override
    public List<SubjectiveOfQuestion> listdraft() {
        return subjectiveOfQuestionMapper.selectAllByType(0);
    }

    @Override
    public List<SubjectiveOfQuestion> listtask(Integer taskId) {
        return subjectiveOfQuestionMapper.selectAllByTask(taskId);
    }
}
