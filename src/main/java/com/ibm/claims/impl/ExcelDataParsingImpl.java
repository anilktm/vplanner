package com.ibm.claims.impl;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import com.ibm.claims.models.ILCData;

@Service
public class ExcelDataParsingImpl {
	
	@Autowired
	private Database db;
	
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	
	public void parseExcelData( MultipartFile multipartFile) {
		try
        {
            //FileInputStream file = new FileInputStream(new File(multipartFile.getInputStream()));
			String SHEET = "ILC";
			InputStream file = multipartFile.getInputStream();
            //Create Workbook instance holding reference to .xlsx file
            Workbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            Sheet sheet = workbook.getSheet("ILC");

            ArrayList<ILCData> ilcDataList = new ArrayList<>();
            boolean isFinished=false;
            for(int i=sheet.getFirstRowNum()+1;i<=sheet.getLastRowNum();i++){
            	System.out.println(i+" Rows.");
                ILCData ilcdata= new ILCData();
                ilcdata.setEntityType("claimdetails");
                String id="";
                Row ro=sheet.getRow(i);        
                if(ro.getFirstCellNum()!=0)break;
                for(int j=ro.getFirstCellNum();j<=ro.getLastCellNum();j++){
                   Cell ce = ro.getCell(j);
                   int cellType=(ce!=null ?ce.getCellType():3);
                   if(j==0){ // month
                	  String cellVal=(ce!=null && ce.getStringCellValue().length()>0 ?ce.getStringCellValue():"");
                	  if((ce!=null && ce.getStringCellValue().length()>0 ?ce.getStringCellValue():"").isEmpty()) {
                		  isFinished=true;
                		  break;
                	  }
                	   id=ce.getStringCellValue();
                	   ilcdata.setMonth((ce!=null && ce.getStringCellValue().length()>0 ?ce.getStringCellValue():""));  
                  }else if(j==1){//monthBeginDate
                	  ilcdata.setMonthBeginDate((ce!=null && ce.getStringCellValue().length()>0 ?ce.getStringCellValue():""));
                  }else if(j==2){//monthEndDate
                	  ilcdata.setMonthEndDate((ce!=null && ce.getStringCellValue().length()>0 ?ce.getStringCellValue():""));
                  } else if(j==3) {//year
                	  int year=(int) ce.getNumericCellValue();
                	  ilcdata.setYear(Integer.valueOf(year));
                	  id=id+"_"+year;
                  }else if(j==4) {//weekEndingDate
                	  ilcdata.setWeekEndingDate((ce!=null && ce.getStringCellValue().length()>0 ?ce.getStringCellValue():""));
                  }else if(j==5) {//senttoDPAMDate
                	  ilcdata.setSenttoDPAMDate((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==6) {//sentToCLRDate
                	  ilcdata.setSentToCLRDate((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==7) {//employeeLastName
                	  ilcdata.setEmployeeLastName((ce!=null && ce.getStringCellValue().length()>0 ?ce.getStringCellValue():""));
                	  id=id+"_"+ce.getStringCellValue();
                  }else if(j==8) {//employeeIntials
                	  ilcdata.setEmployeeIntials((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==9) {//employeeSerialNumber
                	  ilcdata.setEmployeeSerialNumber((cellType==1?ce.getStringCellValue():String.valueOf(ce.getNumericCellValue())));
                	  if(cellType==1)
                		  id=id+"_"+ce.getStringCellValue();
                	  else
                		  id=id+"_"+ce.getNumericCellValue();
                	  
                  }else if(j==10) {//ledgerProjectId
                	  ilcdata.setLedgerProjectId((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==11) {//cFTSWorkNumber
                	  ilcdata.setCFTSWorkNumber((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==12) {//accountGroupId
                	  ilcdata.setAccountGroupId((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==13) {//accountName
                	  ilcdata.setAccountName((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==14) {//accountId
                	  ilcdata.setAccountId((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==15) {//accountDesc
                	  ilcdata.setAccountDesc((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==16) {//workItemId
                	  ilcdata.setWorkItemId((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==17) {//workItemTitle
                	  ilcdata.setWorkItemTitle((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==18) {//activity
                	  ilcdata.setActivity((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==19) {//activityUserDesc
                	  ilcdata.setActivityUserDesc((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==20) {//acitivityDesc
                	  ilcdata.setAcitivityDesc((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==21) {//countryCode
                	  ilcdata.setCountryCode(Integer.valueOf((int) ce.getNumericCellValue()));
                  }else if(j==22) {//divisionCode             
                	  ilcdata.setDivisionCode((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==23) {//fACode
                	  ilcdata.setFACode((cellType==1?ce.getStringCellValue():String.valueOf(ce.getNumericCellValue())));
                  }else if(j==24) {//department
                	  ilcdata.setDepartment((cellType==1?ce.getStringCellValue():String.valueOf(ce.getNumericCellValue())));
                  }else if(j==25) {//overtimeIndicator
                	  ilcdata.setOvertimeIndicator((cellType==1?ce.getStringCellValue():String.valueOf(ce.getNumericCellValue())));
                  }else if(j==26) {//billingCode
                	  ilcdata.setBillingCode((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==27) {//hours
                	  ilcdata.setHours(Integer.valueOf((int) ce.getNumericCellValue()));
                  }else if(j==28) {//oTHours
                	  ilcdata.setOTHours(Integer.valueOf((int) ce.getNumericCellValue()));
                  }else if(j==29) {//satHours
                	  ilcdata.setSatHours(Integer.valueOf((int) ce.getNumericCellValue()));
                  }else if(j==30) {//sunHours
                	  ilcdata.setSunHours(Integer.valueOf((int) ce.getNumericCellValue()));
                  }else if(j==31) {//monHours
                	  ilcdata.setMonHours(Integer.valueOf((int) ce.getNumericCellValue()));
                  }else if(j==32) {//tueHours
                	  ilcdata.setTueHours(Integer.valueOf((int) ce.getNumericCellValue()));
                  }else if(j==33) {//wedHours
                	  ilcdata.setWedHours(Integer.valueOf((int) ce.getNumericCellValue()));
                  }else if(j==34) {//thuHours
                	  ilcdata.setThuHours(Integer.valueOf((int) ce.getNumericCellValue()));
                  }else if(j==35) {//friHours
                	  ilcdata.setFriHours((cellType==0?Integer.valueOf((int) ce.getNumericCellValue()):0));
                  }else if(j==36) {//orgSplit
                	  ilcdata.setOrgSplit((ce!=null && ce.getStringCellValue().length()>0 ?ce.getStringCellValue():""));
                  }else if(j==37) {//employeeStatus
                	  ilcdata.setEmployeeStatus((ce!=null && ce.getStringCellValue().length()>0 ?ce.getStringCellValue():""));
                  }else if(j==38) {//longevityCode
                	  ilcdata.setLongevityCode((ce!=null && ce.getStringCellValue().length()>0 ?ce.getStringCellValue():""));
                  }else if(j==39) {//bandGroup
                	  ilcdata.setBandGroup((cellType==1?ce.getStringCellValue():String.valueOf(ce.getNumericCellValue())));
                  }else if(j==40) {//upcomingWeekending
                	  ilcdata.setUpcomingWeekending((ce!=null && ce.getStringCellValue().length()>0 ?ce.getStringCellValue():""));
                  }else if(j==41) {//yearBeginDate
                	  ilcdata.setYearBeginDate((ce!=null && ce.getStringCellValue().length()>0 ?ce.getStringCellValue():""));
                  }else if(j==42) {//currentYTDWeeks
                	  ilcdata.setCurrentYTDWeeks((cellType==0?Integer.valueOf((int) ce.getNumericCellValue()):0));
                  }else if(j==43) {//monthlyWeeks
                	  ilcdata.setMonthlyWeeks((cellType==0?Integer.valueOf((int) ce.getNumericCellValue()):0));
                  }else if(j==44) {//utilizationTarget
                	  ilcdata.setUtilizationTarget((cellType==0?Integer.valueOf((int) ce.getNumericCellValue()):0));
                  }else if(j==45) {//yTDFTEFactor
                	  ilcdata.setYTDFTEFactor((ce!=null?String.valueOf(ce.getNumericCellValue()):"0"));
                  }else if(j==46) {//monthlyFTEFactor
                	  ilcdata.setMonthlyFTEFactor((cellType==0?Integer.valueOf((int) ce.getNumericCellValue()):0));
                  }else if(j==47) {//yTDFTE
                	  ilcdata.setYTDFTE((cellType==0?Integer.valueOf((int) ce.getNumericCellValue()):0));
                  }else if(j==48) {//fTE
                	  ilcdata.setFTE(Double.parseDouble((ce!=null?String.valueOf(ce.getNumericCellValue()):"0")));
                  }else if(j==49) {//limits
                	  ilcdata.setLimits((ce!=null && ce.getStringCellValue().length()>0 ?ce.getStringCellValue():""));
                  }else if(j==50) {//companyCode
                	  ilcdata.setCompanyCode((ce!=null && ce.getStringCellValue().length()>0 ?ce.getStringCellValue():""));
                  }else if(j==51) {//createdTimestamp
                	  ilcdata.setCreatedTimestamp((ce!=null && ce.getStringCellValue().length()>0 ?ce.getStringCellValue():""));
                	  id=id+"_"+ce.getStringCellValue();
                  }else if(j==52) {//submitterUserId
                	  ilcdata.setSubmitterUserId((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==53) {//submitterSerialNumber
                	  ilcdata.setSubmitterSerialNumber((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==54) {//submitterCountryCode
                	  ilcdata.setSubmitterCountryCode((cellType==0?Integer.valueOf((int) ce.getNumericCellValue()):0));
                  }else if(j==55) {//submitterCompanyCode
                	  ilcdata.setSubmitterCompanyCode((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }else if(j==56) {//regularHours
                	  ilcdata.setRegularHours((cellType==0?Integer.valueOf((int) ce.getNumericCellValue()):0));
                  }else if(j==57) {//standbyHours
                	  ilcdata.setStandbyHours((cellType==0?Integer.valueOf((int) ce.getNumericCellValue()):0));
                  }else if(j==58) {//typeofhours
                	  ilcdata.setTypeofhours((cellType==0?String.valueOf(ce.getNumericCellValue()):(cellType==1?ce.getStringCellValue():"")));
                  }
               }
                if(isFinished)break;
                ilcdata.set_id(id);
               // ilcdata.set_rev(id);
                ilcDataList.add(ilcdata);
                if(db.contains(id)) {
                	ILCData response = db.find(ILCData.class, id);
                	ilcdata.set_rev(response.get_rev());
                	db.update(ilcdata);
                }else {
                	db.save(ilcdata);
                }
            }
            //db.bulk(ilcDataList);
        }catch(Exception ex) {
        	System.out.println(ex.getMessage());
        	ex.printStackTrace();
	}
}
	
	public boolean hasExcelFormat(MultipartFile file) {
	
	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }
	
	    return true;
	  }

}
