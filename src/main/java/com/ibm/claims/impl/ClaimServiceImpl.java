package com.ibm.claims.impl;

import static com.cloudant.client.api.query.Expression.eq;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.query.QueryBuilder;
import com.cloudant.client.api.query.QueryResult;
import com.cloudant.client.api.query.Selector;
import com.cloudant.client.org.lightcouch.NoDocumentException;
import com.ibm.claims.models.ILCData;
import com.ibm.claims.models.VacationDetails;
import com.ibm.claims.request.AddTeamAndResourceRequest;
import com.ibm.claims.request.SearchRequest;
import com.ibm.claims.service.ClaimService;


@Service
public class ClaimServiceImpl implements ClaimService {

	private final Logger log = LoggerFactory.getLogger(ClaimServiceImpl.class);
	
	@Autowired
	private Database db;

	@Override
	public Object getAllClaims(SearchRequest searchRequest) {
		
		log.info("Request to find All the claims from cloudant ");
		List <String>workItemArray=new ArrayList<>();
		List <String>overtimeArray=new ArrayList<>();
		List <String>monthArray=new ArrayList<>();
		List <String>weekEndingDateArray=new ArrayList<>();
		
		Collection<ILCData> ilcdataList =null;
		Object claimListByWeekEndingId=null;
		try {		
			/*Selector operationSelector = and(eq("entityType", "claimdetails"),
        			in("workItemId", workItemArray.toArray()),
        			in("overtimeIndicator", overtimeArray.toArray()),
        			in("month", monthArray..toArray()),
        			in("weekEndingDate", weekEndingDateArray));
			*/
			Selector operationSelector = eq("entityType", "claimdetails");
			System.out.println((db==null?"db object is null":"db object is not null"));
			QueryResult<ILCData> queryResult = db.query(new QueryBuilder(operationSelector).build(), ILCData.class);
			ilcdataList = queryResult.getDocs();
			claimListByWeekEndingId=getSearchResultsByFields(ilcdataList,searchRequest);
			
		} catch (NoDocumentException e) {
			log.debug("No document found for All Claims ",e);
			return claimListByWeekEndingId;
		}
		return claimListByWeekEndingId;
	}

	@Override
	public Object getAllWorkItemId() {
		Selector operationSelector = eq("entityType", "claimdetails");
		QueryResult<ILCData> queryResult = db.query(new QueryBuilder(operationSelector).build(), ILCData.class);
		Collection<ILCData> ilcdataList = queryResult.getDocs();
		Set<String> ilcWorkItemIds = ilcdataList.stream().map(ILCData::getWorkItemId).collect(Collectors.toSet());
        return ilcWorkItemIds;		
	}
	
	@Override
	public Object getAllWeekEndingDate() {
		Selector operationSelector = eq("entityType", "claimdetails");
		QueryResult<ILCData> queryResult = db.query(new QueryBuilder(operationSelector).build(), ILCData.class);
		Collection<ILCData> ilcdataList = queryResult.getDocs();
		Set<String> ilcWorkItemIds = ilcdataList.stream().map(ILCData::getWeekEndingDate).collect(Collectors.toSet());
        return ilcWorkItemIds;
	}
	
	@Override
	public Object getAuthenticated() {
		List<Boolean> arrayList = new ArrayList<Boolean>();
		arrayList.add(true);
        return arrayList;
	}
	
	@Override
	public Object getResourceVacation() {
		Selector operationSelector = eq("_id", "010504_aTAF_Q1");
		QueryResult<VacationDetails> queryResult = db.query(new QueryBuilder(operationSelector).build(), VacationDetails.class);
		Collection<VacationDetails> vacationdataList = queryResult.getDocs();
		//Set<String> ilcWorkItemIds = ilcdataList.stream().map(ILCData::getWeekEndingDate).collect(Collectors.toSet());
        return vacationdataList;
	}
	
	@Override
	public Object addTeamAndResource(AddTeamAndResourceRequest addTeamAndResourceRequest) {
		
		log.info("Request to add the team and resource details to cloudant ");
		String resourceId=addTeamAndResourceRequest.getResourceid();
		String teamname=addTeamAndResourceRequest.getTeamname();
		Calendar calendar=new GregorianCalendar();
		int year=calendar.get(Calendar.YEAR);
		String id=resourceId+"_"+year;
		VacationDetails vDetails=new VacationDetails(id,teamname,"","Q2","2023",resourceId,new ArrayList<String> ());
		
		if(db.contains(id)) {
			VacationDetails response = db.find(VacationDetails.class, id);
			vDetails.set_rev(response.get_rev());
        	db.update(vDetails);
        }else {
        	db.save(vDetails);
        }
		
		return "Successfully Added The Data.";
	}
	@Override
	public Object updateResourceVacation(VacationDetails vacationDetails) {
		
		log.info("Request to add the team and resource details to cloudant ");
		String resourceId=vacationDetails.getResourceid();
		Calendar calendar=new GregorianCalendar();
		int year=calendar.get(Calendar.YEAR);
		String id=resourceId+"_"+year;
		vacationDetails.set_id(id);
		if(db.contains(id)) {
			VacationDetails response = db.find(VacationDetails.class, id);
			vacationDetails.set_rev(response.get_rev());
        	db.update(vacationDetails);
        }else {
        	db.save(vacationDetails);
        }
		return "Successfully Added The Data.";
	}

	public Object getSearchResultsByFields(Collection<ILCData> ilcData,SearchRequest searchRequest) {
		
		 List<String> workIdList=searchRequest.getWorkId();
		 List<String> overtimeList=searchRequest.getOvertimeIndicator();
		 List<String> monthList=searchRequest.getMonth();
		 List<String> wkEndingDateList=searchRequest.getWeekEndingDate();
		 Map<String, List<ILCData>> ilcDataFiltered =null;
		 
		 if(workIdList!=null && workIdList.size()>0 &&
		    overtimeList!=null && overtimeList.size()>0 &&
		    monthList!=null && monthList.size()>0 &&
		    wkEndingDateList!=null && wkEndingDateList.size()>0) {
			ilcDataFiltered =ilcData.stream().filter((workid)->workIdList.contains(workid.getWorkItemId()))
		 				 .filter((overtime)->overtimeList.contains(overtime.getOvertimeIndicator()))
		 				 .filter((month)->monthList.contains(month.getMonth()))
		 				 .filter((wkEdDt)->wkEndingDateList.contains(wkEdDt.getWeekEndingDate())).collect(Collectors.groupingBy(ILCData::getWeekEndingDate));
		 }else if(workIdList!=null && workIdList.size()>0 &&
		    overtimeList!=null && overtimeList.size()>0 &&
		    monthList!=null && monthList.size()>0 ) {
			ilcDataFiltered =ilcData.stream().filter((workid)->workIdList.contains(workid.getWorkItemId()))
		 				 .filter((overtime)->overtimeList.contains(overtime.getOvertimeIndicator()))
		 				 .filter((month)->monthList.contains(month.getMonth())).collect(Collectors.groupingBy(ILCData::getWeekEndingDate));	 				 
		 }else if(workIdList!=null && workIdList.size()>0 &&
		    overtimeList!=null && overtimeList.size()>0) {	
			ilcDataFiltered =ilcData.stream().filter((workid)->workIdList.contains(workid.getWorkItemId()))
		 				 .filter((overtime)->overtimeList.contains(overtime.getOvertimeIndicator())).collect(Collectors.groupingBy(ILCData::getWeekEndingDate));
		 				 
		 }else if(workIdList!=null && workIdList.size()>0 &&
		    overtimeList!=null && overtimeList.size()>0 &&
		    wkEndingDateList!=null && wkEndingDateList.size()>0) {	
			ilcDataFiltered =ilcData.stream().filter((workid)->workIdList.contains(workid.getWorkItemId()))
		 				 .filter((overtime)->overtimeList.contains(overtime.getOvertimeIndicator()))
		 				 .filter((wkEdDt)->wkEndingDateList.contains(wkEdDt.getWeekEndingDate())).collect(Collectors.groupingBy(ILCData::getWeekEndingDate));
		 }else if(workIdList!=null && workIdList.size()>0 &&
		    monthList!=null && monthList.size()>0 &&
		    wkEndingDateList!=null && wkEndingDateList.size()>0) {
			 ilcDataFiltered =ilcData.stream().filter((workid)->workIdList.contains(workid.getWorkItemId()))
		 				 .filter((month)->monthList.contains(month.getMonth()))
		 				 .filter((wkEdDt)->wkEndingDateList.contains(wkEdDt.getWeekEndingDate())).collect(Collectors.groupingBy(ILCData::getWeekEndingDate));
		 }else if(workIdList!=null && workIdList.size()>0 &&			    
		    wkEndingDateList!=null && wkEndingDateList.size()>0) {	
			 ilcDataFiltered =ilcData.stream().filter((workid)->workIdList.contains(workid.getWorkItemId()))
		 				.filter((wkEdDt)->wkEndingDateList.contains(wkEdDt.getWeekEndingDate())).collect(Collectors.groupingBy(ILCData::getWeekEndingDate));
		 }else if(workIdList!=null && workIdList.size()>0 &&
		    monthList!=null && monthList.size()>0 ) {
			 System.out.println("workIdList+monthList");
			 ilcDataFiltered =ilcData.stream().filter((workid)->workIdList.contains(workid.getWorkItemId()))
	 				 .filter((month)->monthList.contains(month.getMonth())).collect(Collectors.groupingBy(ILCData::getWeekEndingDate));
		 }else if(workIdList!=null && workIdList.size()>0) {
			 ilcDataFiltered =ilcData.stream().filter((workid)->workIdList.contains(workid.getWorkItemId()))
					 						  .collect(Collectors.groupingBy(ILCData::getWeekEndingDate));
		 }
		 
		 Set<String> keys=ilcDataFiltered.keySet();
		 JSONArray searchResultArray=new JSONArray();		 
		 for(String key:keys) {	
			 JSONObject searchResult=new JSONObject();
			 Collection<ILCData> ilcDataCollection=ilcDataFiltered.get(key);
			 Integer totalHoursByWeekEndingDate=ilcDataCollection.stream().filter(o -> o.getHours()!=null).mapToInt(ILCData::getHours).sum(); 			 
			 Set<String> ilcWorkItemIds = ilcDataCollection.stream().map(ILCData::getWorkItemId).collect(Collectors.toSet());
			 for(String workIds:ilcWorkItemIds) {				 
				 searchResult.put(workIds, ilcDataCollection
						    .stream()
						    .filter(p -> p.getWorkItemId().equals(workIds))
						    .mapToInt(ILCData::getHours)
						    .sum());
				
			 }
			 searchResult.put("resultArray", ilcDataFiltered.get(key));
			 searchResult.put("weekEndingDate", key);
			 searchResult.put("totalHoursByWeekEndingDate", totalHoursByWeekEndingDate);			 
			 searchResultArray.add(searchResult);
		 }
		
		return searchResultArray;
	}

	
}
