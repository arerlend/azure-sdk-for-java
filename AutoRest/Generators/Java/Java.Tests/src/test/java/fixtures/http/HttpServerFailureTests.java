package fixtures.http;

import fixtures.http.models.ErrorException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class HttpServerFailureTests {
    private static AutoRestHttpInfrastructureTestService client;

    @BeforeClass
    public static void setup() {
        client = new AutoRestHttpInfrastructureTestServiceImpl("http://localhost.:3000");
    }

    @Test
    public void head501() throws Exception {
        try {
            client.httpServerFailure().head501();
        } catch (ErrorException ex) {
            Assert.assertEquals(501, ex.getResponse().code());
        }
    }

    @Test
    public void get501() throws Exception {
        try {
            client.httpServerFailure().get501();
        } catch (ErrorException ex) {
            Assert.assertEquals(501, ex.getResponse().code());
        }
    }

    @Test
    public void post505() throws Exception {
        try {
            client.httpServerFailure().post505(true);
        } catch (ErrorException ex) {
            Assert.assertEquals(505, ex.getResponse().code());
        }
    }

    @Test
    public void delete505() throws Exception {
        try {
            client.httpServerFailure().delete505(true);
        } catch (ErrorException ex) {
            Assert.assertEquals(505, ex.getResponse().code());
        }
    }
}
