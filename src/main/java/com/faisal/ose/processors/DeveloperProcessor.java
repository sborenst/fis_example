package com.faisal.ose.processors;

import com.faisal.ose.model.Developer;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by faisalmasood on 5/03/2016.
 */
public class DeveloperProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        List<Developer> allDevelopers = new ArrayList<>();

        allDevelopers.add(new Developer(1L, "Faisal"));
        allDevelopers.add(new Developer(2L, "Masood"));

        exchange.getIn().setBody(allDevelopers);
    }
}
