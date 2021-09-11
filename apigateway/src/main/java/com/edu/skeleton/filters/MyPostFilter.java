package com.edu.skeleton.filters;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


public class MyPostFilter extends ZuulFilter{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyPostFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		LOGGER.info("#################");
		LOGGER.info("Exiting post filter");
		RequestContext currentContext = RequestContext.getCurrentContext();
		Instant startTime = (Instant)currentContext.get("startTime");
		long totalRequestTime = ChronoUnit.MILLIS.between(startTime, Instant.now());
		
		LOGGER.info("totalRequestTime: {}", totalRequestTime);
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
