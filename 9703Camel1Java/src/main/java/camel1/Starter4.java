package camel1;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Starter4 {
    public static void main(String[] args) throws Exception {

        CamelContext camel = new DefaultCamelContext();

        //настройки
        camel.getPropertiesComponent().setLocation("classpath:application.properties");

        camel.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:{{from}}")
                        .routeId("one dddd")
                        .log(">>>>> ${body}")
                        .convertBodyTo(String.class)
                        .to("log:?showBody=true&showHeaders=true")
                        .to("file:{{toB}}");
            }
        });

        camel.start();
        Thread.sleep(4_000);
        camel.stop();

    }
}
