package com.nihal.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import com.nihal.model.Activity;

public class ActivityClient {
	
	private Client client;
	
	public ActivityClient(){
		client = ClientBuilder.newClient();
		
	}
	//GET client
	public Activity get(String id){
		WebTarget target = client.target("http://localhost:8080/webservices/webapi/");
		
		Response response = target.path("activities/" +id).request().get(Response.class);
		
		if(response.getStatus() != 200)
		{
			throw new RuntimeException(response.getStatus()+": There was an error at the server.");
		}
		return response.readEntity(Activity.class);
	}
	//GET Client
	public List<Activity> get(){
		WebTarget target = client.target("http://localhost:8080/webservices/webapi/");
		
		List<Activity> response = target.path("activities").request().get(new GenericType<List<Activity>>(){});
		
		return response;
	}
	
	//POST client
	public Activity create(Activity activity) {
		// TODO Auto-generated method stub
		WebTarget target = client.target("http://localhost:8080/webservices/webapi/");
		
         Response response = target.path("activities/activity").request().post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200)
		{
			throw new RuntimeException(response.getStatus()+": There was an error at the server.");
		}
		return response.readEntity(Activity.class);
		
	}

}
