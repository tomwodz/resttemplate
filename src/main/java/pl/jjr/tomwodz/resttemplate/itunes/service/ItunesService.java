package pl.jjr.tomwodz.resttemplate.itunes.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jjr.tomwodz.resttemplate.itunes.proxy.ItunesProxy;
import pl.jjr.tomwodz.resttemplate.itunes.proxy.ItunesResponse;

@Service
public class ItunesService {
    
    @Autowired
    ItunesProxy ItunesClient;

    @Autowired
    ItunesMapper itunesMapper;

    public void fetchShawnMendesSongs() throws JsonProcessingException {
    String json = ItunesClient.makeRequest("shawnmendes", 4);
        if(json != null){
        ItunesResponse shawnMendesResponse = itunesMapper.mapJsonToItunesResponse(json);
        System.out.println(shawnMendesResponse);
    }
    }

}
