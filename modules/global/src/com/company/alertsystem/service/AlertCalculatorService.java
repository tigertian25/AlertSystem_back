package com.company.alertsystem.service;

import java.util.List;
import java.util.Map;

public interface AlertCalculatorService {
    String NAME = "AlertCalculator";
    
    public List<Map<String,Object>> calculateAlertList();
}