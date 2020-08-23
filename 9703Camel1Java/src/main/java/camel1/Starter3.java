package camel1;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Starter3 {
    public static void main(String[] args) throws Exception {
        CamelContext camel = new DefaultCamelContext();

        camel.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:///D:/D.BackEnd/java/9648Example1/files/from")
                        .routeId("one dddd")
                        .log(">>>>> ${body}")
                        .convertBodyTo(String.class)
                        .to("log:?showBody=true&showHeaders=true")
                        .to("file:///D:/D.BackEnd/java/9648Example1/files/toB");
            }
        });

        camel.start();
        Thread.sleep(4_000);
        camel.stop();
    }
}
