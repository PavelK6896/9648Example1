package camel1;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Starter5 {
    public static void main(String[] args) throws Exception {
        CamelContext camel = new DefaultCamelContext();

        //настройки
        camel.getPropertiesComponent().setLocation("classpath:application.properties");

        camel.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:{{from}}")
                        .routeId("one dddd")
                        .convertBodyTo(String.class)
                        .to("log:?showBody=true&showHeaders=true")
                        .choice()//выбор
                        .when(exchange -> ((String) exchange.getIn().getBody()).contains("=a"))
                        .to("file:{{toA}}")
                        .when(exchange -> ((String) exchange.getIn().getBody()).contains("=b"))
                        .to("file:{{toB}}")
                        .otherwise()
                        .to("file:{{toC}}")//создаст пакет если нету
                        .end()
                        .log("HHH");
            }
        });

        camel.start();
        Thread.sleep(4_000);
        camel.stop();
    }
}
