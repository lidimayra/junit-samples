import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.io.IOException;

public class PlanetTest {
    @Spy
    private Planet planet;

    @Before
    public void setupPlanet() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void run() throws IOException {
        Mockito.doReturn(
                "{\"results\":" +
                    "[" +
                        "{" +
                            "\"name\": \"Tatooine\"," +
                            "\"climate\": \"arid\"" +
                        "}" +
                    "]" +
                "}"
        ).when(planet).getResponseFromAPI("Tatooine");

        String climate = planet.getClimate("Tatooine");

        Assert.assertEquals("arid", climate);
    }
}

