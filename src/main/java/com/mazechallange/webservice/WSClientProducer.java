package com.mazechallange.webservice;

import javax.enterprise.inject.Produces;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;


public class WSClientProducer {

	@Produces
	public MazeWSClient getMazeWebServiceClient() {
		return new ResteasyClientBuilder().build().target("http://www.epdeveloperchallenge.com/api/").proxy(MazeWSClient.class);
	}
}