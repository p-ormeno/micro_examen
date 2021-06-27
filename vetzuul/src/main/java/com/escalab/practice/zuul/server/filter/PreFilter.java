package com.escalab.practice.zuul.server.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * The Class PreFilter.
 */
public class PreFilter extends ZuulFilter {
	
	/** The Constant FILTERTYPE. */
	private static final String FILTERTYPE = "pre";
    
    /** The Constant FILTERORDER. */
    private static final Integer FILTERORDER = 1;
    
    private static Logger log = LoggerFactory.getLogger(PreFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		log.info("Petición {} a {}", request.getMethod(), request.getRequestURL().toString());
		
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
