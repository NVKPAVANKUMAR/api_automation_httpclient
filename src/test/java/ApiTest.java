import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.junit.jupiter.api.Test;
import utils.PropertiesLoader;
import utils.TestBase;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Publicapi.org Test Automation")
@Feature("Get API Routes")
public class ApiTest extends TestBase {

    HttpGet getRequest;
    HttpResponse response;

    String baseURL = PropertiesLoader.loadProperty("url");

    @Test
    @Description("GET API for Valid Entries")
    public void testEntries_valid() throws IOException {
        getRequest = new HttpGet(baseURL + Constants.ENTRIES + "?category=animals" + "&https=true");
        response = client.execute(getRequest);
        assertEquals(response.getStatusLine().getStatusCode(),
                HttpStatus.SC_OK);
    }

    @Test
    @Description("GET API for Valid Random Route")
    public void testRandom_valid() throws IOException {
        getRequest = new HttpGet(baseURL + Constants.RANDOM + "?auth=null");
        response = client.execute(getRequest);
        assertEquals(response.getStatusLine().getStatusCode(),
                HttpStatus.SC_OK);
    }

    @Test
    @Description("GET API for Valid Categories Route")
    public void testCategories_valid() throws IOException {
        getRequest = new HttpGet(baseURL + Constants.CATEGORIES);
        response = client.execute(getRequest);
        assertEquals(response.getStatusLine().getStatusCode(),
                HttpStatus.SC_OK);
    }

    @Test
    @Description("GET API for Valid Health Route")
    public void testHealth_valid() throws IOException {
        getRequest = new HttpGet(baseURL + Constants.HEALTH);
        response = client.execute(getRequest);
        assertEquals(response.getStatusLine().getStatusCode(),
                HttpStatus.SC_OK);
    }
}