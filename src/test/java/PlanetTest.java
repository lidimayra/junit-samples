import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class PlanetTest {

    @Test
    public void run() throws IOException {
        Http http = (String url) -> {
            if(!url.contains("search=Tatooine"))
                Assert.fail(url + " does not contain expected param!");
            return "{\"results\":" +
                        "[" +
                            "{" +
                                "\"name\": \"Tatooine\"," +
                                "\"climate\": \"arid\"" +
                            "}" +
                        "]" +
                    "}";
        };

        Planet planet = new Planet(http);
        String climate = planet.getClimate("Tatooine");

        Assert.assertEquals("arid", climate);
    }
}

