import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpImpl implements Http {
    public String get(String uri) throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(uri);
        CloseableHttpResponse response = client.execute(request);

        try {
            HttpEntity entity = response.getEntity();
            String entityStr = EntityUtils.toString(entity);
            return entityStr;
        } finally {
            response.close();
        }

    }
}

