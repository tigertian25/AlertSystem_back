package com.company.alertsystem.service;

import java.util.List;

import com.company.alertsystem.service.AlertCalculatorService.Alert;
import com.company.alertsystem.service.AlertCalculatorService.SampleOrder;

public interface AlertTypeRetrieverService {
    String NAME = "AlertTypeRetriever";
    //筛选出工序超时的版单
    public List<Alert> retrieveList(List<SampleOrder> SampleOrderList) ;
}