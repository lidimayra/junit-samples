import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.contains;

import java.io.IOException;

public class PlanetTest {
    @Mock private Http http;

    @InjectMocks private Planet planet;

    @Before
    public void setupPlanet() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void run() throws IOException {
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

        String climate = planet.getClimate("Tatooine");

        Assert.assertEquals("arid", climate);
    }
}

