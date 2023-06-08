package schoolmanagement.commonlib.communication;

import java.io.Serializable;

/**
 * The Request class represents a request to perform an operation, implementing
 * the Serializable interface.
 *
 * <p>
 * It contains information about the operation to be performed and the
 * associated object.
 * </p>
 *
 * @see Serializable
 * @author Djordje Ivanovic
 */
public class Request implements Serializable {

	/**
	 * The operation associated with the request.
	 */
	private Operation operation;

	/**
	 * The object associated with the request.
	 */
	private Object object;

	/**
	 * Constructs a Request object with the specified operation and object.
	 *
	 * @param operation The operation to be performed.
	 * @param object    The associated object.
	 */
	public Request(Operation operation, Object object) {
		this.operation = operation;
		this.object = object;
	}

	/**
	 * Constructs an empty Request object.
	 */
	public Request() {
	}

	/**
	 * Returns the operation of the request.
	 *
	 * @return The operation.
	 */
	public Operation getOperation() {
		return operation;
	}

	/**
	 * Sets the operation of the request.
	 *
	 * @param operation The operation to be set.
	 */
	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	/**
	 * Returns the object associated with the request.
	 *
	 * @return The associated object.
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * Sets the object associated with the request.
	 *
	 * @param object The object to be set.
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * Returns a string representation of the Request object. Representation
	 * contains operation and object which need to be sent
	 * 
	 * @return A string representation of the object.
	 */
	@Override
	public String toString() {
		return "Request{" + "operation=" + operation + ", object=" + object + '}';
	}
}
