package com.company.alertsystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.company.alertsystem.service.AlertCalculatorService.Alert;
import com.company.alertsystem.service.AlertCalculatorService.SampleOrder;


@Service(AlertTypeRetrieverService.NAME)
public class AlertTypeRetrieverServiceBean implements AlertTypeRetrieverService {


	@Override
	public List<Alert> retrieveList(List<SampleOrder> sampleOrderList) {
		List<Alert> alertList=new ArrayList<>();
		for (int i = 0; i < sampleOrderList.size(); i++) {
			
		}
		System.out.println(alertList.size());
		return alertList;
	}

	

	// 获取所有AlertType
	/*private List<AlertType> getAllAlertType() {
		// TODO 获取所有AlertType
		return null;

	}*/

}