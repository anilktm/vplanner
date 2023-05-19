package com.ibm.claims.models;

public class Users {

private String id;
private String userId;
private String firstName;
private String lastName;
private Boolean isActive;
private Boolean isAdmin;
private String accessGroup;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getUserId() {
return userId;
}

public void setUserId(String userId) {
this.userId = userId;
}

public String getFirstName() {
return firstName;
}

public void setFirstName(String firstName) {
this.firstName = firstName;
}

public String getLastName() {
return lastName;
}

public void setLastName(String lastName) {
this.lastName = lastName;
}

public Boolean getIsActive() {
return isActive;
}

public void setIsActive(Boolean isActive) {
this.isActive = isActive;
}

public Boolean getIsAdmin() {
return isAdmin;
}

public void setIsAdmin(Boolean isAdmin) {
this.isAdmin = isAdmin;
}

public String getAccessGroup() {
return accessGroup;
}

public void setAccessGroup(String accessGroup) {
this.accessGroup = accessGroup;
}

}
