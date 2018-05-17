package com.nihal.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import com.nihal.model.Activity;

public class ActivityClient {
	
	private Client client;
	
	public ActivityClient(){
		client = ClientBuilder.newClient();
		
	}
	
	public Activity get(String id){
		WebTarget target = client.target("http://localhost:8080/webservices/webapi/");
		
		Activity response = target.path("activities/" +id).request().get(Activity.class);
		
		return response;
	}

}
