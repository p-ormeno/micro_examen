package com.escalab.practice.zuul.server.filter;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * The Class PostFilter.
 */
public class PostFilter extends ZuulFilter {
	
	/** The Constant FILTERTYPE. */
	private static final String FILTERTYPE = "post";
    
    /** The Constant FILTERORDER. */
    private static final Integer FILTERORDER = 200;
    
    /** The log. */
    private static Logger log = LoggerFactory.getLogger(PostFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();

		HttpServletRequest request = ctx.getRequest();
		long startTime = (Long) ctx.get("startTime");

		log.info("Request URL: {} :: Tiempo Utilizado: {} ", request.getRequestURL().toString(), (Instant.now().toEpochMilli() - startTime));
		return null;
	}

	@Override
	public String filterType() {
		return FILTERTYPE;
	}

	@Override
	public int filterOrder() {
		return FILTERORDER;
	}

}
