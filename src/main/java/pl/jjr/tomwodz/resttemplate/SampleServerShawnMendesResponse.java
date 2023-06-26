package pl.jjr.tomwodz.resttemplate;

import java.util.List;

public record SampleServerShawnMendesResponse(
        String message,
        List<String> songsName
) {
}
