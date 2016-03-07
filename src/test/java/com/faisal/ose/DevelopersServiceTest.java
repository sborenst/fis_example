package com.faisal.ose;

import org.apache.camel.*;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Test;

/**
 * Created by faisalmasood on 5/03/2016.
 * A paxexam placeholder
 */
public class DevelopersServiceTest extends CamelBlueprintTestSupport {


    @EndpointInject(uri = "mock:testOutputMock")
    protected MockEndpoint testOutputMock;


    @Produce(
            uri = "direct:get-all-developers"
    )
    protected ProducerTemplate mockRequestHandler;

    /**
     * Test developers service.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDevelopersService() throws Exception {
        this.context.getRouteDefinition("get-all-developers-route").adviceWith(this.context, new AdviceWithRouteBuilder() {
            public void configure() throws Exception {

                this.weaveAddLast().to(testOutputMock);
            }
        });
        this.context.setTracing(Boolean.valueOf(true));
        this.context.start();


        mockRequestHandler.sendBody(null);

        testOutputMock.expectedMessageCount(1);


    }



    @Override
    public boolean isUseAdviceWith() {
        return true;
    }


    @Override
    protected String getBlueprintDescriptor() {

        return "test-camel-context.xml";
    }

    public boolean isUseDebugger() {
        return true;
    }

    protected void debugBefore(Exchange exchange, Processor processor, ProcessorDefinition<?> definition, String id, String label) {
        System.out.println("Before " + definition + " with body " + exchange.getIn().getBody());
    }

    protected void debugAfter(Exchange exchange, Processor processor, ProcessorDefinition<?> definition, String id, String label, long timeTaken) {
        System.out.println("After " + definition + " with body " + exchange.getIn().getBody());
    }


}
