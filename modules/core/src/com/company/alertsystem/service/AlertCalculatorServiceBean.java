package com.company.alertsystem.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.company.alertsystem.entity.AlertSnooze;
import com.company.alertsystem.entity.AlertType;

@Service(AlertCalculatorService.NAME)
public class AlertCalculatorServiceBean implements AlertCalculatorService {

	@Inject
	AlertTypeRetrieverService alertTypeRetriever;
	@Inject
	SnoozeAccessorService snoozeAccessor;

	@Override
	public List<Map<String, Object>> calculateAlertList() {
		List<Map<String, Object>> returnAlertList = new ArrayList<>();
		List<Map<String, Object>> sampleOrderList = getAllSampleOrder();// 获取未完成的订单列表
		if (sampleOrderList.size() > 0) {
			List<Map<String, Object>> alertList = alertTypeRetriever.retrieveList(sampleOrderList);// 筛选出有工序未完成的列表
			for (Map<String, Object> alert : alertList) {// 循环计算超时的数据
				try {
					String timeDifference = "";// 此字段用于显示超时多少时间
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date now = df.parse(df.format(new Date()));// 当前时间
					// 超出规定时间
					int allowedDuration = Integer.parseInt(alert.get("allowedDuration").toString());// 规定时限
					Date fromTimestamp = df.parse(alert.get("fromTimestamp").toString());// 当前工序完成时间
					Calendar calendar1 = Calendar.getInstance();
					calendar1.setTime(fromTimestamp);
					System.out.println("当前工序完成时间：" + df.format(calendar1.getTime()));
					calendar1.add(Calendar.SECOND, allowedDuration);
					System.out.println("规定时间：" + df.format(calendar1.getTime()));
					if (now.getTime() > calendar1.getTime().getTime()) {// 当前时间大于规定时间表示超时
						AlertSnooze duration = snoozeAccessor.getDuration(
								Integer.parseInt(alert.get("sampleOrderId").toString()),
								Integer.parseInt(alert.get("alertTypeId").toString()));

						if (!duration.equals(null) && duration != null) {// 设置了睡眠

							Date durationDate = duration.getCreateTime();
							Calendar calendar = Calendar.getInstance();
							calendar.setTime(durationDate);
							System.out.println("duration创建时间：" + df.format(calendar.getTime()));
							calendar.add(Calendar.SECOND, duration.getDuration());
							System.out.println("睡眠后时间：" + df.format(calendar.getTime()));
							if (now.getTime() > calendar.getTime().getTime()) {// 当前时间大于睡眠后的时间
								timeDifference = dateUtil(df.format(now), df.format(calendar.getTime()));
								alert.put("timeDifference", timeDifference);
								returnAlertList.add(alert);
							}

						} else {
							timeDifference = dateUtil(df.format(now), df.format(calendar1.getTime()));
							alert.put("timeDifference", timeDifference);
							returnAlertList.add(alert);
						}

					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return returnAlertList;
	}

	// 计算时间差工具
	public String dateUtil(String date1, String date2) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeDifference = "0";
		try {
			Date d1 = df.parse(date1);
			Date d2 = df.parse(date2);
			long l = d2.getTime() - d1.getTime();
			long day = l / (24 * 60 * 60 * 1000);
			long hour = (l / (60 * 60 * 1000) - day * 24);
			long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
			if (day > 0) {
				timeDifference += day + "天";
			}
			if (hour > 0) {
				timeDifference += hour + "小时";
			}
			if (min > 0) {
				timeDifference += min + "分";
			}
			if (s > 0) {
				timeDifference += s + "秒";
			}
			System.out.println("" + day + "天" + hour + "小时" + min + "分" + s + "秒");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return timeDifference;
	}

	// 获取所有未完成的版单
	private List<Map<String, Object>> getAllSampleOrder() {
		// TODO 获取所有未完成的版单
		List<Map<String, Object>> SampleOrderList = new ArrayList<>();
		Map<String, Object> SampleOrder = new HashMap<>();
		SampleOrder.put("sampleOrderId", 123456);
		SampleOrder.put("styleNumber", 123456);
		SampleOrderList.add(SampleOrder);
		return SampleOrderList;

	}

}