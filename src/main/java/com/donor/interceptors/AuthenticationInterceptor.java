package com.donor.interceptors;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;

import com.donor.actions.LoginAction;
import com.donor.beans.Donor;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * The Class AuthenticationInterceptor.
 * 
 * @author Ruchita Bhamare
 */
public class AuthenticationInterceptor implements Interceptor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8526967800972160896L;

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(AuthenticationInterceptor.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
	 */
	
	public void destroy() {

	}

	/**
	 * Prints Version Information to logs.
	 * 
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
	 */
	
	public void init() {
		logger.info("init[] IR21 Application version 1.11. Created: 28-04-2012 15:15. Time Deployed: " + new Date(System.currentTimeMillis()).toString());
	}

	/**
	 * Checks Whether User is Logged in before every Request.
	 *
	 * @param invocation the invocation
	 * @return the string
	 * @throws Exception the exception
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony
	 * .xwork2.ActionInvocation)
	 */
	
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("login Interceptor Start");
		Donor donor = (Donor) invocation.getInvocationContext().getSession().get("loggedinuser");
		if (donor != null) {
			System.out.println("login Interceptor invoking action");
			return invocation.invoke();
		} else {
			System.out.println("In Interceptor Action is ::"+invocation.getProxy().getMethod());
			if (invocation.getProxy().getMethod().equals("signIn")  || invocation.getProxy().getMethod().equals("register") ||
					invocation.getProxy().getMethod().equals("registerDonor"))
			{
				return invocation.invoke();
			}else {
				invocation.getInvocationContext().getSession().remove("loggedinuser");
				((SessionMap<String, Object>)invocation.getInvocationContext().getSession()).invalidate();
				logger.error("User Not Logged In");
				System.out.println("login Interceptor user not loggedIn");
				return "login";
			}
			
		}
		
	}

}
