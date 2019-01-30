import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class PlanetTest {

    @Test
    public void run() throws IOException {
        Planet planet = new Planet();
        String climate = planet.getClimate("Tatooine");

        Assert.assertEquals("arid", climate);
    }
}

