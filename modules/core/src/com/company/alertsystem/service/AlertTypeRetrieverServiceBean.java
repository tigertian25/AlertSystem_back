package com.company.alertsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service(AlertTypeRetrieverService.NAME)
public class AlertTypeRetrieverServiceBean implements AlertTypeRetrieverService {


	@Override
	public List<Map<String, Object>> retrieveList(List<Map<String, Object>> sampleOrderList) {
		List<Map<String, Object>> alertList=new ArrayList<>();
		for (Map<String, Object> sampleOrder : sampleOrderList) {
			//TODO 判断该sampleOrder的每个工序是否完成，
			
			Map<String, Object> alert=sampleOrder;
			alert.put("fromProcess", "画花发出");
			alert.put("fromTimestamp", "2017-11-12 15:12:22");
			alert.put("toProcess", "画花收回");
			alert.put("alertTypeId", 3);
			alert.put("allowedDuration", 60*30);
			alertList.add(alert);
		}
		return alertList;
	}

	// 获取所有AlertType
	/*private List<AlertType> getAllAlertType() {
		// TODO 获取所有AlertType
		return null;

	}*/

}