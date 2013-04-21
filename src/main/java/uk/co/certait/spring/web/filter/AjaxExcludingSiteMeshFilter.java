package uk.co.certait.spring.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

public class AjaxExcludingSiteMeshFilter extends SiteMeshFilter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		if(! isAjaxRequest((HttpServletRequest)request)){
			super.doFilter(request, response, chain);
		}
		else{
			chain.doFilter(request, response);
		}
	}

	protected boolean isAjaxRequest(HttpServletRequest request) {
		return request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equals("XMLHttpRequest");
	}
}
