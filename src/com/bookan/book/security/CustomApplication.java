package com.bookan.book.security;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class CustomApplication extends ResourceConfig 
{
	public CustomApplication() 
	{
		packages("com.bookan.book");
		register(LoggingFilter.class);
		register(GsonMessageBodyHandler.class);
		register(AuthenticationFilter.class);
	}
}
