package com.company.alertsystem.service;

import org.springframework.stereotype.Service;

import com.company.alertsystem.entity.AlertSnooze;

@Service(SnoozeAccessorService.NAME)
public class SnoozeAccessorServiceBean implements SnoozeAccessorService {

	@Override
	public AlertSnooze getDuration(int sampleOrderId, int alertTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(int sampleOrderId, int alertTypeId, int duration) {
		// TODO Auto-generated method stub
		return null;
	}

}