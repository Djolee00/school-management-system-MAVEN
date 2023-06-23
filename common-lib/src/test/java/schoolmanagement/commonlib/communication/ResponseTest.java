package schoolmanagement.commonlib.communication;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResponseTest {

	private Response response;

    @BeforeEach
    public void setUp() {
        Object obj = "response object";
        ResponseType responseType = ResponseType.SUCCESS;
        response = new Response(obj, responseType);
    }

    @AfterEach
    public void tearDown() {
        response = null;
    }

    @Test
    public void testGetObject() {
        Object result = response.getObject();

        assertEquals("response object", result);
    }

    @Test
    public void testSetObject() {
        Object newObj = 123;

        response.setObject(newObj);

        Object result = response.getObject();
        assertEquals(123, result);
    }

    @Test
    public void testGetResponseType() {
        ResponseType result = response.getResponseType();

        assertEquals(ResponseType.SUCCESS, result);
    }

    @Test
    public void testSetResponseType() {
        ResponseType newResponseType = ResponseType.FAILURE;

        response.setResponseType(newResponseType);

        ResponseType result = response.getResponseType();
        assertEquals(ResponseType.FAILURE, result);
    }

    @Test
    public void testToString() {
        String expected = "Response{object=response object, responseType=SUCCESS}";
        String result = response.toString();

        assertEquals(expected, result);
    }
}
