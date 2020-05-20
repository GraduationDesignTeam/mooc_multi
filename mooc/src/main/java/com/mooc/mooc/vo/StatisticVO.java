package com.mooc.mooc.vo;

import com.mooc.mooc.model.UserStatistic;
import lombok.Data;

import java.util.List;

/**
 * @author 朱翔鹏
 * 封装了用户增长数据对象表的展示层
 */
@Data
public class StatisticVO {

    private List<UserStatistic> list;

    //平均月度增长率
    private Double increaseRate;

    public List<UserStatistic> getList() {
        return list;
    }

    public void setList(List<UserStatistic> list) {
        this.list = list;
    }

    public Double getIncreaseRate() {
        return increaseRate;
    }

    public void setIncreaseRate(Double increaseRate) {
        this.increaseRate = increaseRate;
    }
}
