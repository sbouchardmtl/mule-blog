package org.mule.modules.assertequals;

import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * This Connector tests for equality of two json Strings according to rfc7159
 */
@Connector(name="assert-equals", friendlyName="AssertEquals")
public class AssertEqualsConnector {


    /**
     * Custom processor
     *
     * @param expectedValue The expected result of the test
     * @param actualValue The actual value returned by the tests
     * @throws An exception if the two values are not considered equal according to rfc7159
     */
    @Processor
    public void json(String expectedValue, String actualValue) throws Exception{
    	 JsonParser parser = new JsonParser();
    	 JsonElement expectedJson = parser.parse(expectedValue);
    	 JsonElement actualJson = parser.parse(actualValue);
    	
        if  (!expectedJson.equals(actualJson))
        	throw new Exception("Expected " + expectedValue + " but actual value was "+ actualValue);
    }
}