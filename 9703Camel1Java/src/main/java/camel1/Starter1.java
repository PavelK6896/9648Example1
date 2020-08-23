package camel1;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Starter1 {
    public static void main(String[] args) throws Exception {
        CamelContext camel = new DefaultCamelContext();

        camel.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("timer:foo?period=500") //адрес ресурса
                        .log("HHH");
            }
        });

        camel.start();
        Thread.sleep(4_000);
        camel.stop();
    }
}
