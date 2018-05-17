package com.nihal.client;

import org.junit.Test;

import com.nihal.model.Activity;

import junit.framework.TestCase;
import static org.junit.Assert.*;

public class ActivityClientTest extends TestCase {

	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();
		
		Activity activity= client.get("1234");
		
		System.out.println(activity);
		
		assertNotNull(activity);
	}

}
