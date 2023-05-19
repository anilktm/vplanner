package com.ibm.claims.service;

import com.ibm.claims.models.VacationDetails;
import com.ibm.claims.request.AddTeamAndResourceRequest;
import com.ibm.claims.request.SearchRequest;

public interface ClaimService {

	public Object getAllClaims(SearchRequest searchRequest);
	
	public Object getAllWorkItemId();
	
	public Object getAllWeekEndingDate();

	public Object getAuthenticated();
	
	public Object getResourceVacation();

	Object addTeamAndResource(AddTeamAndResourceRequest addTeamAndResourceRequest);

	Object updateResourceVacation(VacationDetails vacationDetails);
}
