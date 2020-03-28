package org.mycompany;


import java.util.HashSet;
import java.util.Set;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class SetAggregationStrategy implements AggregationStrategy{
    
   @Override
   public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

	   System.out.println("inside Aggregation");
	   Set<String> set = new HashSet<String>();
	   
	        if (oldExchange == null) {
	        	     	
	        	System.out.println("oldExchange is null!!");
	            return newExchange;
	        }
	        String body =   oldExchange.getIn().getBody(String.class) + "|" 
	             +  newExchange.getIn().getBody(String.class);
	        System.out.println("this is body inside Aggregation" +body);
	        oldExchange.getIn().setBody(body);
	        set.add(body);
	     //   if (body.length() >= 5) {
	      //      oldExchange.setProperty(Exchange.AGGREGATION_COMPLETE_CURRENT_GROUP, true);
	      //  }
	        return oldExchange;
	    }
	}