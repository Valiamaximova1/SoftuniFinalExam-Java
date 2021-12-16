package com.example.examfinal.config;


import com.example.examfinal.service.CityService;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

public class ProjectMethodSecurityExpressionHandler extends
        DefaultMethodSecurityExpressionHandler {

  private final CityService cityService;

  public ProjectMethodSecurityExpressionHandler(CityService cityService) {
    this.cityService = cityService;
  }

  @Override
  protected MethodSecurityExpressionOperations createSecurityExpressionRoot(
          Authentication authentication, MethodInvocation invocation) {
    OwnerSecurityExpressionRoot root = new OwnerSecurityExpressionRoot(authentication);

    root.setCityService(cityService);
    root.setPermissionEvaluator(getPermissionEvaluator());
    root.setTrustResolver(new AuthenticationTrustResolverImpl());
    root.setRoleHierarchy(getRoleHierarchy());

    return root;

  }
}
