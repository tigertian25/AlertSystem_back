package com.company.alertsystem.service;


import org.junit.Test;

public class AlertCalculatorServiceBeanTest {
	 
	AlertCalculatorServiceBean alertCalculatorServiceBean;
	@Test
	public void testDateUtil() {
		String date=alertCalculatorServiceBean.dateUtil("2017-10-12 11:11:11", "2018-01-03 15:32:11");
		System.out.println(date);
	}

}
