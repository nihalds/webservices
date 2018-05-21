package com.nihal.client;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.nihal.model.Activity;

public class ActivityClientTest extends TestCase {

	@Test
	public void testCreate(){
		ActivityClient client = new ActivityClient();
		
		Activity activity= new Activity();
		activity.setDescription("swimming");
		activity.setDuration(60);
		
		activity= client.create(activity);
		
		assertNotNull(activity);
	}
	
	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();
		
		Activity activity= client.get("1234");
		
		System.out.println(activity);
		
		assertNotNull(activity);
	}
	
	@Test
	public void testGetList() {
		ActivityClient client = new ActivityClient();
		
		List<Activity> activities= client.get();
		
		System.out.println(activities);
		
		assertNotNull(activities);
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetWithBadRequest(){
		ActivityClient client = new ActivityClient();
		client.get("123");
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetWithNotFound(){
		ActivityClient client = new ActivityClient();
		client.get("7777");
	}

}
