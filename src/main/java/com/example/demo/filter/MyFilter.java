package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.CustomerRepository;

public class MyFilter implements Filter {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setHeader("Baeldung-Example-Filter-Header", "Value-Filter");
		System.out.println("Welcome " + request.getParameter("name"));
		filterChain.doFilter(request, response);

	}

}
