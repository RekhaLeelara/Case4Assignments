package com.edu.skeleton.filters;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


public class MyPreFilter extends ZuulFilter{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyPreFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		LOGGER.info("****************");
		LOGGER.info("Inside pre filter");
		RequestContext currentContext = RequestContext.getCurrentContext();
		currentContext.set("startTime", Instant.now());
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
