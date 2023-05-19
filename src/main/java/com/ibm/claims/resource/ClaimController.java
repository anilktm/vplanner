package com.ibm.claims.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.claims.impl.ExcelDataParsingImpl;
import com.ibm.claims.message.ResponseMessage;
import com.ibm.claims.models.VacationDetails;
import com.ibm.claims.request.AddTeamAndResourceRequest;
import com.ibm.claims.request.SearchRequest;
import com.ibm.claims.service.ClaimService;
@CrossOrigin(origins = "*")
@RestController
public class ClaimController {

	@Autowired
	private ClaimService claimService;
	
	@Autowired
	private ExcelDataParsingImpl excelDataParsingService;

	@PostMapping("/searchByILCFields")
	public Object getAllClaims(@RequestBody SearchRequest searchRequest) {
		return claimService.getAllClaims(searchRequest);
	}
	
	@GetMapping("/getAllWorkItemId")
	public Object getAllWorkItemId() {
		return claimService.getAllWorkItemId();
	}
	
	@GetMapping("/getAllWeekEndingDate")
	public Object getAllWeekEndingdate() {
		return claimService.getAllWeekEndingDate();
	}
	

	@GetMapping("/getAuthenticated")
	public Object getAuthenticated() {
		return claimService.getAuthenticated();
	}
	
	@GetMapping("/getResourceVacation")
	public Object getResourceVacation() {
		return claimService.getResourceVacation();
	}
	@PostMapping("/addTeamAndResource")
	public Object addTeamAndResource(@RequestBody AddTeamAndResourceRequest addTeamAndResourceRequest) {
		return claimService.addTeamAndResource(addTeamAndResourceRequest);
	}
	
	@PostMapping("/updateResourceVacation")
	public Object updateResourceVacation(@RequestBody VacationDetails vacationDetails) {
		return claimService.updateResourceVacation(vacationDetails);
	}
	
	@PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    //ExcelDataParsingImpl excelDataParsingImpl=new ExcelDataParsingImpl();
	    if (excelDataParsingService.hasExcelFormat(file)) {
	      try {
	    	  excelDataParsingService.parseExcelData(file);
	
	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	      }
	    }
	
	    message = "Please upload an excel file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	  }
	
	
}
