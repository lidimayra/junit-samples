import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;


public class Planet {
    private Http http = new HttpImpl();

    public String getClimate(String name) throws IOException {
        String response = getResponseFromAPI(name);
        JSONArray jsonArray = new JSONObject(response).getJSONArray("results");
        String climate = jsonArray.getJSONObject(0).get("climate").toString();

        return climate;
    }

    protected String getResponseFromAPI(String name) throws IOException {
        String uri = String.format("https://swapi.co/api/planets/?search=%s", name);

        return http.get(uri);
    }
}
