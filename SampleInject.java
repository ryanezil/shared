// camel-k: language=java
// camel-k: dependency=camel-quarkus-direct
// camel-k: dependency=mvn:com.github.ryanezil:shared:main-SNAPSHOT

package com.github.ryanezil;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.LoggingLevel;

import javax.enterprise.context.ApplicationScoped;

import com.github.ryanezil.shared.UpperCaseProcessor;

import javax.inject.Inject;

@ApplicationScoped
public class SampleInject extends RouteBuilder {

    @Inject
    private UpperCaseProcessor upperCaseProcessor;

    @Override
    public void configure() throws Exception {

    System.out.println("Injected object: " + upperCaseProcessor);

        from("timer:tick?period=5s")
          .routeId("timerTick-demo-route")
          .setBody(constant("Hello world!"))
//          .process(upperCaseProcessor)
          .process(new UpperCaseProcessor())
          .to("direct:sendEmail")
          .log(LoggingLevel.INFO,"e-mail sent!");
    }
}
