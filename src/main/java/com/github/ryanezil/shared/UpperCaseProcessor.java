package com.github.ryanezil.shared;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UpperCaseProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

                String body = exchange.getIn().getBody(String.class);
                body = body.toUpperCase().concat("-mytext");
                exchange.getOut().setBody(body);
	}

}
