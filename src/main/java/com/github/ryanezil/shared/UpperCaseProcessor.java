package io.ryanezil.shared;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class UpperCaseProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

                String body = exchange.getIn().getBody(String.class);
                body = body.toUpperCase().concat("-github");
                exchange.getOut().setBody(body);
	}

}
