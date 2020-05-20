package com.mooc.mooc.service.impl;

import com.mooc.mooc.mapper.ChoiceOfQuestionMapper;
import com.mooc.mooc.model.ChoiceOfQuestion;
import com.mooc.mooc.service.ChoiceQuestionService;
import com.mooc.mooc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceQuestionServiceImpl implements ChoiceQuestionService {

    @Autowired
    private ChoiceOfQuestionMapper choiceOfQuestionMapper;
    @Override
    public List<ChoiceOfQuestion> list(ChoiceOfQuestion choiceOfQuestion) {
        return null;
    }

    @Override
    public ResultVO update(ChoiceOfQuestion choiceOfQuestion) {
        return null;
    }

    @Override
    public ResultVO delete(Integer taskId) {
        choiceOfQuestionMapper.deleteByPrimaryKey(taskId);
        return null;
    }

    @Override
    public ResultVO add(ChoiceOfQuestion choiceOfQuestion) {
        ResultVO resultVO=new ResultVO(0, "");
        choiceOfQuestion.setType(0);
        if(choiceOfQuestion.getAnswer()==1){
            choiceOfQuestion.setResolution("A");
        }
        else if(choiceOfQuestion.getAnswer()==2){
            choiceOfQuestion.setResolution("B");
        }
        else if(choiceOfQuestion.getAnswer()==3){
            choiceOfQuestion.setResolution("C");
        }
        else if(choiceOfQuestion.getAnswer()==4){
            choiceOfQuestion.setResolution("D");
        }
        choiceOfQuestionMapper.insert(choiceOfQuestion);
        return resultVO;
    }

    @Override
    public ResultVO cancel(Integer choiceId) {
        return null;
    }

    @Override
    public ChoiceOfQuestion sel(Integer choiceId) {
        return null;
    }

    @Override
    public List<ChoiceOfQuestion> listdraft() {
        return choiceOfQuestionMapper.selectAllByType(0);
    }

    @Override
    public List<ChoiceOfQuestion> listtask(Integer taskId) {
        List<ChoiceOfQuestion> list=choiceOfQuestionMapper.selectAllByTask(taskId);
        return list;
    }
}
