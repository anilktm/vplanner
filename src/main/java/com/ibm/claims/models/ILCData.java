package com.ibm.claims.models;

public class ILCData {
private String _id;
public String get_rev() {
	return _rev;
}


public void set_rev(String _rev) {
	this._rev = _rev;
}


private String _rev;
private String month;
private String monthBeginDate;
private String monthEndDate;
private Integer year;
private String weekEndingDate;
private String senttoDPAMDate;
private String sentToCLRDate;
private String employeeLastName;
private String employeeIntials;
private String employeeSerialNumber;
private String ledgerProjectId;
private String cFTSWorkNumber;
private String accountGroupId;
private String accountName;
private String accountId;
private String accountDesc;
private String workItemId;
private String workItemTitle;
private String activity;
private String activityUserDesc;
private String acitivityDesc;
private Integer countryCode;
private String divisionCode;
private String fACode;
private String department;
private String overtimeIndicator;
private String billingCode;
private Integer hours;
private Integer oTHours;
private Integer satHours;
private Integer sunHours;
private Integer monHours;
private Integer tueHours;
private Integer wedHours;
private Integer thuHours;
private Integer friHours;
private String orgSplit;
private String employeeStatus;
private String longevityCode;
private String bandGroup;
private String upcomingWeekending;
private String yearBeginDate;
private Integer currentYTDWeeks;
private Integer monthlyWeeks;
private Integer utilizationTarget;
private String yTDFTEFactor;
private Integer monthlyFTEFactor;
private Integer yTDFTE;
private Double fTE;
private String limits;
private String companyCode;
private String createdTimestamp;
private String submitterUserId;
private String submitterSerialNumber;
private Integer submitterCountryCode;
private String submitterCompanyCode;
private Integer regularHours;
private Integer standbyHours;
private String typeofhours;
private String entityType;
public ILCData() {}


public ILCData(String _id,String _rev,String month, String monthBeginDate, String monthEndDate, Integer year, String weekEndingDate,
		String senttoDPAMDate, String sentToCLRDate, String employeeLastName, String employeeIntials,
		String employeeSerialNumber, String ledgerProjectId, String cFTSWorkNumber, String accountGroupId,
		String accountName, String accountId, String accountDesc, String workItemId, String workItemTitle,
		String activity, String activityUserDesc, String acitivityDesc, Integer countryCode, String divisionCode,
		String fACode, String department, String overtimeIndicator, String billingCode, Integer hours, Integer oTHours,
		Integer satHours, Integer sunHours, Integer monHours, Integer tueHours, Integer wedHours, Integer thuHours,
		Integer friHours, String orgSplit, String employeeStatus, String longevityCode, String bandGroup,
		String upcomingWeekending, String yearBeginDate, Integer currentYTDWeeks, Integer monthlyWeeks,
		Integer utilizationTarget, String yTDFTEFactor, Integer monthlyFTEFactor, Integer yTDFTE, Double fTE,
		String limits, String companyCode, String createdTimestamp, String submitterUserId,
		String submitterSerialNumber, Integer submitterCountryCode, String submitterCompanyCode, Integer regularHours,
		Integer standbyHours, String typeofhours,String entityType) {
	super();
	this._id=_id;
	this._rev=_rev;
	this.month = month;
	this.monthBeginDate = monthBeginDate;
	this.monthEndDate = monthEndDate;
	this.year = year;
	this.weekEndingDate = weekEndingDate;
	this.senttoDPAMDate = senttoDPAMDate;
	this.sentToCLRDate = sentToCLRDate;
	this.employeeLastName = employeeLastName;
	this.employeeIntials = employeeIntials;
	this.employeeSerialNumber = employeeSerialNumber;
	this.ledgerProjectId = ledgerProjectId;
	this.cFTSWorkNumber = cFTSWorkNumber;
	this.accountGroupId = accountGroupId;
	this.accountName = accountName;
	this.accountId = accountId;
	this.accountDesc = accountDesc;
	this.workItemId = workItemId;
	this.workItemTitle = workItemTitle;
	this.activity = activity;
	this.activityUserDesc = activityUserDesc;
	this.acitivityDesc = acitivityDesc;
	this.countryCode = countryCode;
	this.divisionCode = divisionCode;
	this.fACode = fACode;
	this.department = department;
	this.overtimeIndicator = overtimeIndicator;
	this.billingCode = billingCode;
	this.hours = hours;
	this.oTHours = oTHours;
	this.satHours = satHours;
	this.sunHours = sunHours;
	this.monHours = monHours;
	this.tueHours = tueHours;
	this.wedHours = wedHours;
	this.thuHours = thuHours;
	this.friHours = friHours;
	this.orgSplit = orgSplit;
	this.employeeStatus = employeeStatus;
	this.longevityCode = longevityCode;
	this.bandGroup = bandGroup;
	this.upcomingWeekending = upcomingWeekending;
	this.yearBeginDate = yearBeginDate;
	this.currentYTDWeeks = currentYTDWeeks;
	this.monthlyWeeks = monthlyWeeks;
	this.utilizationTarget = utilizationTarget;
	this.yTDFTEFactor = yTDFTEFactor;
	this.monthlyFTEFactor = monthlyFTEFactor;
	this.yTDFTE = yTDFTE;
	this.fTE = fTE;
	this.limits = limits;
	this.companyCode = companyCode;
	this.createdTimestamp = createdTimestamp;
	this.submitterUserId = submitterUserId;
	this.submitterSerialNumber = submitterSerialNumber;
	this.submitterCountryCode = submitterCountryCode;
	this.submitterCompanyCode = submitterCompanyCode;
	this.regularHours = regularHours;
	this.standbyHours = standbyHours;
	this.typeofhours = typeofhours;
	this.entityType=entityType;
}
public String get_id() {
	return _id;
}


public void set_id(String _id) {
	this._id = _id;
}

public String getMonth() {
return month;
}


public void setMonth(String month) {
this.month = month;
}


public String getMonthBeginDate() {
return monthBeginDate;
}


public void setMonthBeginDate(String monthBeginDate) {
this.monthBeginDate = monthBeginDate;
}


public String getMonthEndDate() {
return monthEndDate;
}


public void setMonthEndDate(String monthEndDate) {
this.monthEndDate = monthEndDate;
}


public Integer getYear() {
return year;
}


public void setYear(Integer year) {
this.year = year;
}


public String getWeekEndingDate() {
return weekEndingDate;
}


public void setWeekEndingDate(String weekEndingDate) {
this.weekEndingDate = weekEndingDate;
}


public String getSenttoDPAMDate() {
return senttoDPAMDate;
}


public void setSenttoDPAMDate(String senttoDPAMDate) {
this.senttoDPAMDate = senttoDPAMDate;
}


public String getSentToCLRDate() {
return sentToCLRDate;
}


public void setSentToCLRDate(String sentToCLRDate) {
this.sentToCLRDate = sentToCLRDate;
}


public String getEmployeeLastName() {
return employeeLastName;
}

public void setEmployeeLastName(String employeeLastName) {
this.employeeLastName = employeeLastName;
}

public String getEmployeeIntials() {
return employeeIntials;
}

public void setEmployeeIntials(String employeeIntials) {
this.employeeIntials = employeeIntials;
}

public String getEmployeeSerialNumber() {
return employeeSerialNumber;
}

public void setEmployeeSerialNumber(String employeeSerialNumber) {
this.employeeSerialNumber = employeeSerialNumber;
}

public String getLedgerProjectId() {
return ledgerProjectId;
}

public void setLedgerProjectId(String ledgerProjectId) {
this.ledgerProjectId = ledgerProjectId;
}

public String getCFTSWorkNumber() {
return cFTSWorkNumber;
}

public void setCFTSWorkNumber(String cFTSWorkNumber) {
this.cFTSWorkNumber = cFTSWorkNumber;
}

public String getAccountGroupId() {
return accountGroupId;
}

public void setAccountGroupId(String accountGroupId) {
this.accountGroupId = accountGroupId;
}

public String getAccountName() {
return accountName;
}

public void setAccountName(String accountName) {
this.accountName = accountName;
}

public String getAccountId() {
return accountId;
}

public void setAccountId(String accountId) {
this.accountId = accountId;
}

public String getAccountDesc() {
return accountDesc;
}

public void setAccountDesc(String accountDesc) {
this.accountDesc = accountDesc;
}

public String getWorkItemId() {
return workItemId;
}

public void setWorkItemId(String workItemId) {
this.workItemId = workItemId;
}

public String getWorkItemTitle() {
return workItemTitle;
}

public void setWorkItemTitle(String workItemTitle) {
this.workItemTitle = workItemTitle;
}

public String getActivity() {
return activity;
}

public void setActivity(String activity) {
this.activity = activity;
}

public String getActivityUserDesc() {
return activityUserDesc;
}

public void setActivityUserDesc(String activityUserDesc) {
this.activityUserDesc = activityUserDesc;
}

public String getAcitivityDesc() {
return acitivityDesc;
}

public void setAcitivityDesc(String acitivityDesc) {
this.acitivityDesc = acitivityDesc;
}

public Integer getCountryCode() {
return countryCode;
}

public void setCountryCode(Integer countryCode) {
this.countryCode = countryCode;
}

public String getDivisionCode() {
return divisionCode;
}

public void setDivisionCode(String divisionCode) {
this.divisionCode = divisionCode;
}

public String getFACode() {
return fACode;
}

public void setFACode(String fACode) {
this.fACode = fACode;
}

public String getDepartment() {
return department;
}

public void setDepartment(String department) {
this.department = department;
}

public String getOvertimeIndicator() {
return overtimeIndicator;
}

public void setOvertimeIndicator(String overtimeIndicator) {
this.overtimeIndicator = overtimeIndicator;
}

public String getBillingCode() {
return billingCode;
}

public void setBillingCode(String billingCode) {
this.billingCode = billingCode;
}

public Integer getHours() {
return hours;
}

public void setHours(Integer hours) {
this.hours = hours;
}

public Integer getOTHours() {
return oTHours;
}

public void setOTHours(Integer oTHours) {
this.oTHours = oTHours;
}

public Integer getSatHours() {
return satHours;
}

public void setSatHours(Integer satHours) {
this.satHours = satHours;
}

public Integer getSunHours() {
return sunHours;
}

public void setSunHours(Integer sunHours) {
this.sunHours = sunHours;
}

public Integer getMonHours() {
return monHours;
}

public void setMonHours(Integer monHours) {
this.monHours = monHours;
}

public Integer getTueHours() {
return tueHours;
}

public void setTueHours(Integer tueHours) {
this.tueHours = tueHours;
}

public Integer getWedHours() {
return wedHours;
}

public void setWedHours(Integer wedHours) {
this.wedHours = wedHours;
}

public Integer getThuHours() {
return thuHours;
}

public void setThuHours(Integer thuHours) {
this.thuHours = thuHours;
}

public Integer getFriHours() {
return friHours;
}

public void setFriHours(Integer friHours) {
this.friHours = friHours;
}

public String getOrgSplit() {
return orgSplit;
}

public void setOrgSplit(String orgSplit) {
this.orgSplit = orgSplit;
}

public String getEmployeeStatus() {
return employeeStatus;
}

public void setEmployeeStatus(String employeeStatus) {
this.employeeStatus = employeeStatus;
}

public String getLongevityCode() {
return longevityCode;
}

public void setLongevityCode(String longevityCode) {
this.longevityCode = longevityCode;
}

public String getBandGroup() {
return bandGroup;
}

public void setBandGroup(String bandGroup) {
this.bandGroup = bandGroup;
}

public String getUpcomingWeekending() {
return upcomingWeekending;
}

public void setUpcomingWeekending(String upcomingWeekending) {
this.upcomingWeekending = upcomingWeekending;
}

public String getYearBeginDate() {
return yearBeginDate;
}

public void setYearBeginDate(String yearBeginDate) {
this.yearBeginDate = yearBeginDate;
}

public Integer getCurrentYTDWeeks() {
return currentYTDWeeks;
}

public void setCurrentYTDWeeks(Integer currentYTDWeeks) {
this.currentYTDWeeks = currentYTDWeeks;
}

public Integer getMonthlyWeeks() {
return monthlyWeeks;
}

public void setMonthlyWeeks(Integer monthlyWeeks) {
this.monthlyWeeks = monthlyWeeks;
}

public Integer getUtilizationTarget() {
return utilizationTarget;
}

public void setUtilizationTarget(Integer utilizationTarget) {
this.utilizationTarget = utilizationTarget;
}

public String getYTDFTEFactor() {
return yTDFTEFactor;
}

public void setYTDFTEFactor(String yTDFTEFactor) {
this.yTDFTEFactor = yTDFTEFactor;
}

public Integer getMonthlyFTEFactor() {
return monthlyFTEFactor;
}

public void setMonthlyFTEFactor(Integer monthlyFTEFactor) {
this.monthlyFTEFactor = monthlyFTEFactor;
}

public Integer getYTDFTE() {
return yTDFTE;
}

public void setYTDFTE(Integer yTDFTE) {
this.yTDFTE = yTDFTE;
}

public Double getFTE() {
return fTE;
}

public void setFTE(Double fTE) {
this.fTE = fTE;
}

public String getLimits() {
return limits;
}

public void setLimits(String limits) {
this.limits = limits;
}

public String getCompanyCode() {
return companyCode;
}

public void setCompanyCode(String companyCode) {
this.companyCode = companyCode;
}

public String getCreatedTimestamp() {
return createdTimestamp;
}

public void setCreatedTimestamp(String createdTimestamp) {
this.createdTimestamp = createdTimestamp;
}

public String getSubmitterUserId() {
return submitterUserId;
}

public void setSubmitterUserId(String submitterUserId) {
this.submitterUserId = submitterUserId;
}

public String getSubmitterSerialNumber() {
return submitterSerialNumber;
}

public void setSubmitterSerialNumber(String submitterSerialNumber) {
this.submitterSerialNumber = submitterSerialNumber;
}

public Integer getSubmitterCountryCode() {
return submitterCountryCode;
}

public void setSubmitterCountryCode(Integer submitterCountryCode) {
this.submitterCountryCode = submitterCountryCode;
}

public String getSubmitterCompanyCode() {
return submitterCompanyCode;
}

public void setSubmitterCompanyCode(String submitterCompanyCode) {
this.submitterCompanyCode = submitterCompanyCode;
}

public Integer getRegularHours() {
return regularHours;
}

public void setRegularHours(Integer regularHours) {
this.regularHours = regularHours;
}

public Integer getStandbyHours() {
return standbyHours;
}

public void setStandbyHours(Integer standbyHours) {
this.standbyHours = standbyHours;
}

public String getTypeofhours() {
return typeofhours;
}

public void setTypeofhours(String typeofhours) {
this.typeofhours = typeofhours;
}


public String getEntityType() {
	return entityType;
}


public void setEntityType(String entityType) {
	this.entityType = entityType;
}

}
