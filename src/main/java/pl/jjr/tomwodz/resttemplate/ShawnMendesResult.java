package pl.jjr.tomwodz.resttemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShawnMendesResult(String trackName, String artistName) {
}
