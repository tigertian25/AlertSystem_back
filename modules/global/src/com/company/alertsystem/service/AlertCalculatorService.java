package com.company.alertsystem.service;

import java.util.List;

public interface AlertCalculatorService {
    String NAME = "AlertCalculator";
    
    public List calculateAlertList();
}