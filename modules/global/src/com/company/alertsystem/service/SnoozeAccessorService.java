package com.company.alertsystem.service;


public interface SnoozeAccessorService {
    String NAME = "SnoozeAccessor";
    //返回睡眠时间，没有的返回0
    public int getDuration(int sampleOrderId,int alertTypeId);
    
    public String update(int sampleOrderId,int alertTypeId,int duration);
}