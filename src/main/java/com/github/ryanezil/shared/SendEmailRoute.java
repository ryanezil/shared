package com.github.ryanezil.shared;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class SendEmailRoute extends RouteBuilder {

  @Override
  public void configure() {

    from("direct:sendEmail")
       .routeId("sendEmailRoute")
       .log(LoggingLevel.INFO,"Sending email with body: ${body}");

  }
}
