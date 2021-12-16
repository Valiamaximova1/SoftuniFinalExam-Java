package com.example.examfinal.config;


import com.example.examfinal.service.CityService;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public class OwnerSecurityExpressionRoot extends SecurityExpressionRoot implements
    MethodSecurityExpressionOperations {

  private CityService cityService;
  private Object filterObject;
  private Object returnObject;

  public OwnerSecurityExpressionRoot(Authentication authentication) {
    super(authentication);
  }


  public void setCityService(CityService cityService) {
    this.cityService = cityService;
  }

  public boolean isOwner(Long id) {
    String userName = currentUserName();
    if (userName != null) {
      return cityService.isOwner(userName, id);
    }
    return false;
  }


  public String currentUserName() {
    Authentication auth = getAuthentication();
    if (auth.getPrincipal() instanceof UserDetails) {
      return ((UserDetails)auth.getPrincipal()).getUsername();
    }
    return null;
  }

  @Override
  public void setFilterObject(Object filterObject) {
    this.filterObject = filterObject;
  }

  @Override
  public Object getFilterObject() {
    return filterObject;
  }

  @Override
  public void setReturnObject(Object returnObject) {
    this.returnObject = returnObject;
  }

  @Override
  public Object getReturnObject() {
    return returnObject;
  }

  @Override
  public Object getThis() {
    return this;
  }
}
