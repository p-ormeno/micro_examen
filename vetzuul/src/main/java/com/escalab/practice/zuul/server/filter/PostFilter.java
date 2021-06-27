package com.escalab.practice.zuul.server.filter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.CharStreams;
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

		try (final InputStream responseDataStream = ctx.getResponseDataStream()) {
			final String responseData = CharStreams.toString(new InputStreamReader(responseDataStream, StandardCharsets.UTF_8));
			ctx.setResponseBody(responseData);
			log.info("Respuesta:  {} ", responseData);
		} catch (IOException e) {
			log.warn("Error leyendo la respuesta", e);
		}
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
