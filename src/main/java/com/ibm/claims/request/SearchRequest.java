package com.ibm.claims.request;

import java.util.List;


public class SearchRequest {

	private List<String> workId = null;
	private List<String> overtimeIndicator = null;
	private List<String> month = null;
	private List<String> weekEndingDate = null;

	public List<String> getWorkId() {
	return workId;
	}

	public void setWorkId(List<String> workId) {
	this.workId = workId;
	}

	public List<String> getOvertimeIndicator() {
	return overtimeIndicator;
	}

	public void setOvertimeIndicator(List<String> overtimeIndicator) {
	this.overtimeIndicator = overtimeIndicator;
	}

	public List<String> getMonth() {
	return month;
	}

	public void setMonth(List<String> month) {
	this.month = month;
	}

	public List<String> getWeekEndingDate() {
	return weekEndingDate;
	}

	public void setWeekEndingDate(List<String> weekEndingDate) {
	this.weekEndingDate = weekEndingDate;
	}


}
