package com.company.alertsystem.service;

import com.company.alertsystem.entity.AlertSnooze;

public interface SnoozeAccessorService {
    String NAME = "SnoozeAccessor";
    //查询有没有设置睡眠，（根据时间倒序排列取第一条数据）
    public AlertSnooze getDuration(int sampleOrderId,int alertTypeId);
    
    public String update(int sampleOrderId,int alertTypeId,int duration);
}