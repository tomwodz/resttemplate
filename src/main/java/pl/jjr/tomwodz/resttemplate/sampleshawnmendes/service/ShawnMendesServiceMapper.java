package pl.jjr.tomwodz.resttemplate.sampleshawnmendes.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.jjr.tomwodz.resttemplate.sampleshawnmendes.proxy.SampleServerShawnMendesResponse;

@Service
class ShawnMendesServiceMapper {
    SampleServerShawnMendesResponse mapJsonToSampleShanMendesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, SampleServerShawnMendesResponse.class);
    }
}
