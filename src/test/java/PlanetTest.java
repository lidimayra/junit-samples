import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class PlanetTest {

    @Test
    public void run() throws IOException {
        Http http = (String url) ->
            "{\"results\":" +
                "[" +
                    "{" +
                        "\"name\": \"Tatooine\"," +
                        "\"climate\": \"arid\"" +
                    "}" +
                "]" +
            "}";

        Planet planet = new Planet(http);
        String climate = planet.getClimate("Tatooine");

        Assert.assertEquals("arid", climate);
    }
}

