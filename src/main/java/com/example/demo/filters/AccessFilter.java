package com.example.demo.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class AccessFilter extends ZuulFilter {

  @Override
  public String filterType() {
    return "pre";
    // return "routing";
    // return "post";
    // return "error";
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();

    Object accessToken = request.getParameter("accessToekn");
    if(accessToken == null) {
      ctx.setSendZuulResponse(false);
      ctx.setResponseStatusCode(401);
      return null;
    }

    return null;
  }

}
