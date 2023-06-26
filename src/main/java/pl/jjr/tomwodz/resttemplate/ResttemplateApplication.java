package pl.jjr.tomwodz.resttemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ResttemplateApplication {

    @Autowired
    ItunesProxy shawnMendesClient;

    @Autowired
    SampleShawnMendesServerProxy sampleShawnMendesServerProxy;

    public static void main(String[] args) {
        SpringApplication.run(ResttemplateApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() throws JsonProcessingException {
//        String json = shawnMendesClient.makeRequest("shawnmendes", 4);
//        if(json != null){
//            ShawnMendesResponse shawnMendesResponse = mapJsonToShawnMendesResponse(json);
//            System.out.println(shawnMendesResponse);
//        }

        String postJsonSampleShawnMendesServer = sampleShawnMendesServerProxy.makePostRequest();
        if(postJsonSampleShawnMendesServer != null) {
            SampleServerShawnMendesResponse sampleServerShawnMendesResponse = mapJsonToSampleShanMendesResponse(postJsonSampleShawnMendesServer);
            System.out.println(sampleServerShawnMendesResponse);
        }
        String getJsonSampleShawnMendesServer = sampleShawnMendesServerProxy.makeGetRequest();
        if(getJsonSampleShawnMendesServer != null) {
            SampleServerShawnMendesResponse sampleServerShawnMendesResponse = mapJsonToSampleShanMendesResponse(getJsonSampleShawnMendesServer);
            System.out.println(sampleServerShawnMendesResponse);
        }
    }

    private ShawnMendesResponse mapJsonToShawnMendesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ShawnMendesResponse.class);
    }

    private SampleServerShawnMendesResponse mapJsonToSampleShanMendesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, SampleServerShawnMendesResponse.class);
    }


}
