package com.company.alertsystem.service;

import java.util.List;
import java.util.Map;

public interface AlertTypeRetrieverService {
    String NAME = "AlertTypeRetriever";
    //筛选出工序超时的版单
    public List retrieveList(List<Map<String,Object>> alertList) ;
}