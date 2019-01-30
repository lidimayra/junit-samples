import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class Planet {

    public String getClimate(String name) throws IOException {
        String uri = String.format("https://swapi.co/api/planets/?search=%s", name);

        String response = new HttpImpl().get(uri);

        JSONArray jsonArray = new JSONObject(response).getJSONArray("results");
        String climate = jsonArray.getJSONObject(0).get("climate").toString();

        return climate;
    }
}

