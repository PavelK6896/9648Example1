package camel1;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class Starter6 {
    public static void main(String[] args) throws Exception {
        CamelContext camel = new DefaultCamelContext();

        DataSource dataSource = new DriverManagerDataSource(
                "jdbc:postgresql://localhost:5432/mouth1?user=postgres&password=0"
        );
        camel.getRegistry().bind("mouth1", dataSource);

        camel.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("timer:base?period=60000")
                        .routeId("JDBC route")
                        .setBody(simple("select id, text from message"))
                        .to("jdbc:mouth1")
                        .log(">>> ${body}");
            }
        });

        camel.start();
        Thread.sleep(4_000);
        camel.stop();
    }


}
