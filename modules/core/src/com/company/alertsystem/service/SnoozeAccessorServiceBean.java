package com.company.alertsystem.service;

import org.springframework.stereotype.Service;

@Service(SnoozeAccessorService.NAME)
public class SnoozeAccessorServiceBean implements SnoozeAccessorService {

	@Override
	public int getDuration(int sampleOrderId, int alertTypeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String update(int sampleOrderId, int alertTypeId, int duration) {
		// TODO Auto-generated method stub
		return null;
	}

}