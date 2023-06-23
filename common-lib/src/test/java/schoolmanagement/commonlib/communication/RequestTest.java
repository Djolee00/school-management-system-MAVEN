package schoolmanagement.commonlib.communication;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RequestTest {

	private Request request;

	@BeforeEach
	public void setUp() {
		Operation operation = Operation.GET_ALL_STUDENTS;
		Object obj = "object";
		request = new Request(operation, obj);
	}

	@AfterEach
	public void tearDown() {
		request = null;
	}

	@Test
	public void testGetOperation() {
		Operation result = request.getOperation();

		assertEquals(Operation.GET_ALL_STUDENTS, result);
	}

	@Test
	public void testSetOperation() {
		Operation newOperation = Operation.ADD_NEW_STUDENT;

		request.setOperation(newOperation);

		Operation result = request.getOperation();
		assertEquals(Operation.ADD_NEW_STUDENT, result);
	}

	@Test
	public void testGetObject() {
		Object result = request.getObject();

		assertEquals("object", result);
	}

	@Test
	public void testSetObject() {
		Object newObj = 123;

		request.setObject(newObj);

		Object result = request.getObject();
		assertEquals(123, result);
	}

	@Test
	public void testToString() {
		String expected = "Request{operation=" + Operation.GET_ALL_STUDENTS + ", object=object}";
		String result = request.toString();

		assertEquals(expected, result);
	}

}
