package com.ibm.claims.models;

import java.util.List;

public class VacationDetails  {

   private String _id;
   private String _rev;
   private String teamname;
   private String quarter;
   private String year;
   private String resourcename;
   private String resourceid;
   private List<String> vacation;
   
    public VacationDetails(String id,String teamname,String quarter,String year,String resourcename,String resourceid,List<String> vacation) {
    	super();
    	this._id=id;
    	this.teamname=teamname;
    	this.quarter=quarter;
    	this.year=year;
    	this.resourcename=resourcename;
    	this.resourceid=resourceid;
    	this.vacation=vacation;
    
    }

    public String getId() {
        return _id;
    }

    public void set_id(String id) {
        this._id = id;
    }

    public String get_rev() {
        return _rev;
    }

    public void set_rev(String rev) {
        this._rev = rev;
    }

    public String getTeamname() {
        return teamname;
    }

   public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getResourcename() {
        return resourcename;
    }

   public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public String getResourceid() {
        return resourceid;
    }

     public void setResourceid(String resourceid) {
        this.resourceid = resourceid;
    }

    public List<String> getVacation() {
        return vacation;
    }

     public void setVacation(List<String> vacation) {
        this.vacation = vacation;
    }

}