package camel1;

import org.apache.camel.CamelContext;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.DefaultMessage;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class Starter7 {

    public static void main(String[] args) throws Exception {
        CamelContext camel = new DefaultCamelContext();

        DataSource dataSource = new DriverManagerDataSource(
                "jdbc:postgresql://localhost:5432/mouth1?user=postgres&password=0"
        );
        //зарегистрировать источьник данных
        camel.getRegistry().bind("mouth1", dataSource);

        camel.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("timer:base?period=60000")
                        .routeId("JDBC route")
                        .setHeader("key", constant(300))
                        .setBody(simple("select id, text from message where id > :?key"))
                        .to("jdbc:mouth1?useHeadersAsParameters=true")
                        .log(">>> ${body}")

                        .process(exchange -> {
                            Message in = exchange.getIn(); // получили запись
                            Object body = in.getBody();

                            DefaultMessage message = new DefaultMessage(exchange);// чтобы изменить
                            message.setHeaders(in.getHeaders());//все тоже
                            message.setHeader("rnd", "kek");
                            message.setBody(body.toString() + "\n" + in.getHeaders().toString());

                            exchange.setMessage(message);
                        })
                        //записывает в файл с динамически созданым именем
                        .toD("file:///D:/D.BackEnd/java/9648Example1/files/toB?fileName=done-${date:now:yyyyMMdd}-${headers.rnd}.txt");
            }
        });

        camel.start();
        Thread.sleep(4_000);
        camel.stop();
    }
}
