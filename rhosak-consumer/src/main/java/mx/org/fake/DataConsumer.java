package mx.org.fake;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.Map;

public class DataConsumer extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("kafka:{{kafka.topic}}")
            .unmarshal().json(JsonLibrary.Gson)
        .to("log:info:showBody=true");
    }
}