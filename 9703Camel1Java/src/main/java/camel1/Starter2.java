package camel1;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Starter2 {
    public static void main(String[] args) throws Exception {
        CamelContext camel = new DefaultCamelContext();
        //просто в записи
        ProducerTemplate template = camel.createProducerTemplate();

        camel.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("timer:foo?period=500")
                        .log("HHH");
            }
        });

        camel.start();
        template.sendBody(
                "file:///D:/D.BackEnd/java/9648Example1/files?filename=event-${date:now:yyyyMMdd-HH-mm}.html",
                "<hello>world!!!</hello>"
        );
        Thread.sleep(4_000);
        camel.stop();
    }
}
