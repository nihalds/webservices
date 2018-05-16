package com.nihal;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.nihal.model.Activity;
import com.nihal.model.User;
import com.nihal.repository.ActivityRepository;
import com.nihal.repository.ActivityRepositoryStub;


@Path("activities")
public class ActivityResource {
	
	private ActivityRepository activityRepository = new ActivityRepositoryStub();
	
@POST
@Path("activity")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public Activity createActivity(Activity activity){
	System.out.println(activity.getDescription());
	System.out.println(activity.getDuration());
	
	activityRepository.create(activity);
	return activity;
}
	
@POST
@Path("activity")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public Activity createActivityParams(MultivaluedMap<String, String> formParams){
	System.out.println(formParams.getFirst("description"));
	System.out.println(formParams.getFirst("duration"));
	
	Activity activity = new Activity();
	activity.setDescription(formParams.getFirst("description"));
	activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));
	
	activityRepository.create(activity);
	
	return activity;
}
	
@GET
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public List<Activity> getAllActivities(){
	return activityRepository.findAllActivities();
}
	

@GET
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Path("{actiityId}")
public Activity getActivity(@PathParam ("activityId") String activityId){
	return activityRepository.findActivity(activityId);
}

@GET
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Path("{actiityId}/user")
public User getActivityUser(@PathParam ("activityId") String activityId){
	return activityRepository.findActivity(activityId).getUser();
}

}
