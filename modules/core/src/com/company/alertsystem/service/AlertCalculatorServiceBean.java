package com.company.alertsystem.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.company.alertsystem.entity.AlertType;

@Service(AlertCalculatorService.NAME)
public class AlertCalculatorServiceBean implements AlertCalculatorService {

	@Override
	public List calculateAlertList() {
		// TODO Auto-generated method stub
		return null;
	}
	//获取所有AlertType
	public List<AlertType> getAllAlertType(){
		// TODO 获取所有AlertType
		return null;
		
	}
	//获取所有未完成的版单
	public List<Map<String, Object>> getAllSampleOrder(){
		// TODO 获取所有未完成的版单
		return null;
		
	}

}