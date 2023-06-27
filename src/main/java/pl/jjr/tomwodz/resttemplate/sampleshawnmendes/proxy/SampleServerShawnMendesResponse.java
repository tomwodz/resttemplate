package pl.jjr.tomwodz.resttemplate.sampleshawnmendes.proxy;

import java.util.List;

public record SampleServerShawnMendesResponse(
        String message,
        List<String> songsName
) {
}
