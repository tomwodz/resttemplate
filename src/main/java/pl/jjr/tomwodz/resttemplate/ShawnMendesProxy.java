package pl.jjr.tomwodz.resttemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class ShawnMendesProxy {

    @Autowired
    RestTemplate restTemplate;

    @Value("${addresswww.service.url}")
    String url;

    public String makeShawnMendesRequest(String term, Integer limit) throws JsonProcessingException {
        String uri = url + "/search?term=" + term + "&limit=" + limit;
        return makeRequest(uri);
    }

    private String makeRequest(String uri) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host("itunes.apple.com")
                .path("/search")
                .queryParam("term", "shawnMendes")
                .queryParam("limit", 1);
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.GET,
                    null,
                    String.class);
            return response.getBody();
        } catch (RestClientResponseException exception) {
            System.out.println(exception.getStatusText() + " " + exception.getStatusCode().value());
        } catch (RestClientException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }


}
