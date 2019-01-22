package com.redhat.usecase;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateInboundTest extends CamelSpringTestSupport {

    @EndpointInject(uri = "mock:inbound-test-output") private MockEndpoint resultEndpoint;

    @Produce(uri = "direct:inbound-test-input") private ProducerTemplate startEndpoint;

    @Test public void validateInboudRoute() throws Exception {
        // EXCLUDE-BEGIN
        // setup expectations
        //resultEndpoint.expectedMessageCount(1);
        // set expected body as the unpretty print version of the json
        // (flattened)
        //resultEndpoint.expectedBodiesReceived(readFile("src/test/data/PatientDemographics.xml"));

        // run test
        //startEndpoint.sendBody(readFile("src/test/data/PatientDemographics.xml"));

        // verify results
        //resultEndpoint.assertIsSatisfied();
    // EXCLUDE-END
    }

    @Override protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            public void configure() throws Exception {
             // EXCLUDE-BEGIN
                from("direct:inbound-test-input")
                   .to("direct:deim_internal")
                   .log("${body}")
                   .to("mock:inbound-test-output");
        // EXCLUDE-END
            }
        };
    }

    @Override protected AbstractXmlApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("spring/camel-context.xml");
    }

    private String readFile(String filePath) throws Exception {
        String content;
        FileInputStream fis = new FileInputStream(filePath);
        try {
            content = createCamelContext().getTypeConverter().convertTo(String.class, fis);
        } finally {
            fis.close();
        }
        return content;
    }

}
