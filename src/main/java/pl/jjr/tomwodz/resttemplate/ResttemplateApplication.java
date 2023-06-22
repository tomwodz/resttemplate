package pl.jjr.tomwodz.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ResttemplateApplication {

    @Autowired
    ShawnMendesProxy shawnMendenClient;

    public static void main(String[] args) {
        SpringApplication.run(ResttemplateApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void makeRequestToShawnMendesEndpoint(){
        String response = shawnMendenClient.makeShawnMendesRequest("shawnmendes", 10);
        System.out.println(response);
    }

}
