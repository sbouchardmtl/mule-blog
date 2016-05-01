package org.mule.modules.assertequals.automation.functional;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.modules.assertequals.AssertEqualsConnector;

public class JsonTestCases extends TestCase {

	public JsonTestCases() {
		super();
	}

	@Before
	public void setup() {
		// TODO
	}

	@After
	public void tearDown() {
		// TODO
	}

	@Test
	public void testVerify() {
		java.lang.String expectedValue = "{\"artist\":\"radiohead\",\"album\":{\"title\":\"the bends\",\"songs\":[\"The bends\",\"Fake plastic trees\"]}}";
		java.lang.String actualValue = "{\"album\":{\"title\"	:    \"the bends\",\"songs\":[\"The bends\",\"Fake plastic trees\"]},\"artist\":\"radiohead\"}";
		
		AssertEqualsConnector connector = new AssertEqualsConnector();
		try {
			connector.json(expectedValue, actualValue);
		} catch (Exception e) {
			fail("expectedValue and actualValue are equal, but were not considered as such");
		}
	}
	
	public void testVerify2() {
		java.lang.String expectedValue = "{\"artist\":\"radiohead\",\"album\":{\"title\":\"the bends\",\"songs\":[\"The bends\",\"Fake plastic trees\"]}}";
		java.lang.String actualValue = "{\"album\":{\"title\":\"the bends\",\"songs\":[\"Fake plastic trees\",\"The bends\"]},\"artist\":\"radiohead\"}";
		
		AssertEqualsConnector connector = new AssertEqualsConnector();
		try {
			connector.json(expectedValue, actualValue);
			fail("expectedValue and actualValue are not equal, an exception should have been thrown");
		} catch (Exception e) {
			// do nothing, we're expecting an exception
		}
	}

}