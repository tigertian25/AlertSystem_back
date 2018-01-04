package com.company.alertsystem.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.alertsystem.AlertsystemTestContainer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;

public class AlertCalculatorServiceBeanTest {
	@ClassRule
	public static AlertsystemTestContainer cont = AlertsystemTestContainer.Common.INSTANCE;

	private Metadata metadata;
	private Persistence persistence;
	private DataManager dataManager;

	AlertCalculatorServiceBean alertCalculatorServiceBean;
	AlertTypeRetrieverService alertTypeRetriever;
	SnoozeAccessorService snoozeAccessor;

	@Before
	public void setUp() throws Exception {
		alertCalculatorServiceBean = new AlertCalculatorServiceBean();
		alertTypeRetriever = new AlertTypeRetrieverServiceBean();
		snoozeAccessor = new SnoozeAccessorServiceBean();
		persistence = cont.persistence();

	}

	@Test
	public void testDateUtil() {
		String date = alertCalculatorServiceBean.dateUtil("2017-10-12 11:11:11", "2018-01-03 15:32:11");
		System.out.println(date);
	}

	@Test
	public void testcalculateAlertList() {
		alertCalculatorServiceBean.alertTypeRetriever = alertTypeRetriever;
		alertCalculatorServiceBean.snoozeAccessor = snoozeAccessor;
		List<Map<String, Object>> calculateAlertList = alertCalculatorServiceBean.calculateAlertList();

		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
		String formData = gson.toJson(calculateAlertList);
		System.out.println(formData);
	}
}
