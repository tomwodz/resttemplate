package pl.jjr.tomwodz.resttemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import pl.jjr.tomwodz.resttemplate.itunes.service.ItunesService;
import pl.jjr.tomwodz.resttemplate.sampleshawnmendes.service.ShawnMendesService;

@SpringBootApplication
public class ResttemplateApplication {

    @Autowired
    ItunesService itunesService;

    @Autowired
    ShawnMendesService shawnMendesService;

    public static void main(String[] args) {
        SpringApplication.run(ResttemplateApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() throws JsonProcessingException {
        itunesService.fetchShawnMendesSongs();
        shawnMendesService.testClient();
    }

}
