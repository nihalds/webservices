package com.nihal.repository;

import java.util.ArrayList;
import java.util.List;

import com.nihal.model.Activity;
import com.nihal.model.User;


public class ActivityRepositoryStub implements ActivityRepository {
	
	/* (non-Javadoc)
	 * @see com.nihal.repository.ActivityRepository#findAllActivities()
	 */
	public List<Activity> findAllActivities()
	{
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity activity1= new Activity();
		activity1.setDescription("running");
		activity1.setDuration(45);
		activity1.setId("1234");
		
		activities.add(activity1);
		
		Activity activity2=new Activity();
		activity2.setDescription("swimming");
		activity2.setDuration(30);
		activity2.setId("4321");
		
		activities.add(activity2);
		
		return activities;
	}
	@Override
	public Activity findActivity(String activityId) {
		if(activityId.equals("7777"))
		{
			return null;
		}
		
		Activity activity1= new Activity();
		activity1.setDescription("running");
		activity1.setDuration(45);
		activity1.setId("1234");
		
		User user=new User();
		user.setId("1");
		user.setName("Bryan");
		
		activity1.setUser(user);
		
		return activity1;
		
	}
	
	@Override
	public void create(Activity activity) {
		// we write insert into db here
		System.out.println("received : "+activity);
	}
}
