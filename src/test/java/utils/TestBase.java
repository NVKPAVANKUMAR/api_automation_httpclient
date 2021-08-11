package utils;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.BeforeEach;


public class TestBase {
    public CloseableHttpClient client;

    @BeforeEach
    public void init() {
        client = HttpClientBuilder.create().build();
    }
}
