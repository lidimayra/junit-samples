import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.contains;

import java.io.IOException;

public class PlanetTest {

    @Test
    public void run() throws IOException {
        Http http = Mockito.mock(Http.class);

        Mockito.when(http.get(contains("search=Tatooine"))).thenReturn(
                "{\"results\":" +
                    "[" +
                        "{" +
                            "\"name\": \"Tatooine\"," +
                            "\"climate\": \"arid\"" +
                        "}" +
                    "]" +
                "}"
        );

        Planet planet = new Planet(http);
        String climate = planet.getClimate("Tatooine");

        Assert.assertEquals("arid", climate);
    }
}

