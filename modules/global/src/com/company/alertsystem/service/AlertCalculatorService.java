package com.company.alertsystem.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.company.alertsystem.entity.AlertType;

public interface AlertCalculatorService {
	String NAME = "AlertCalculator";

	public List<Alert> calculateAlertList();

	public class SampleOrder implements Serializable {
		private static final long serialVersionUID = 1L;

		private int styleID;
		private String styleNumber;

		public int getStyleID() {
			return styleID;
		}

		public void setStyleID(int styleID) {
			this.styleID = styleID;
		}

		public String getStyleNumber() {
			return styleNumber;
		}

		public void setStyleNumber(String styleNumber) {
			this.styleNumber = styleNumber;
		}

		public SampleOrder(int styleID, String styleNumber) {
			this.styleID = styleID;
			this.styleNumber = styleNumber;
		}

		@Override
		public String toString() {
			return "SampleOrder{" + "styleID='" + styleID + '\'' + ", styleNumber=" + styleNumber + '}';
		}

	}

	public class Alert implements Serializable {
		private static final long serialVersionUID = 2L;

		private AlertType alertType;
		private Date fromTimestamp;
		private Date lastTimestamp;
		private SampleOrder sampleOrder;
		private String timeDifference;

		public String getTimeDifference() {
			return timeDifference;
		}

		public void setTimeDifference(String timeDifference) {
			this.timeDifference = timeDifference;
		}

		public AlertType getAlertType() {
			return alertType;
		}

		public void setAlertType(AlertType alerttype) {
			this.alertType = alerttype;
		}

		public Date getFromTimestamp() {
			return fromTimestamp;
		}

		public void setFromTimestamp(Date fromTimestamp) {
			this.fromTimestamp = fromTimestamp;
		}

		public Date getLastTimestamp() {
			return lastTimestamp;
		}

		public void setLastTimestamp(Date lastTimestamp) {
			this.lastTimestamp = lastTimestamp;
		}

		public SampleOrder getSampleOrder() {
			return sampleOrder;
		}

		public void setSampleOrder(SampleOrder sampleOrder) {
			this.sampleOrder = sampleOrder;
		}

	}
}