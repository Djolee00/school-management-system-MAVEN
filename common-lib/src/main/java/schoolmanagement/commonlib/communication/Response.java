package schoolmanagement.commonlib.communication;

import java.io.Serializable;

/**
 * The Response class represents a response, implementing the Serializable
 * interface.
 *
 * <p>
 * It contains the response object and the response type.
 * </p>
 *
 * @see Serializable
 * @author Djordje Ivanovic
 */
public class Response implements Serializable {

	/**
	 * The object associated with the response.
	 */
	private Object object;

	/**
	 * The response type associated with the response.
	 */
	private ResponseType responseType;

	/**
	 * Constructs a Response object with the specified response object and response
	 * type.
	 *
	 * @param object       The response object.
	 * @param responseType The response type.
	 */
	public Response(Object object, ResponseType responseType) {
		this.object = object;
		this.responseType = responseType;
	}

	/**
	 * Constructs an empty Response object.
	 */
	public Response() {
	}

	/**
	 * Returns the response object.
	 *
	 * @return The response object.
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * Sets the response object.
	 *
	 * @param object The response object to be set.
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * Returns the response type.
	 *
	 * @return The response type.
	 */
	public ResponseType getResponseType() {
		return responseType;
	}

	/**
	 * Sets the response type.
	 *
	 * @param responseType The response type to be set.
	 */
	public void setResponseType(ResponseType responseType) {
		this.responseType = responseType;
	}

	/**
	 * Returns a string representation of the Response object. Representation
	 * contains object from response and response type.
	 * 
	 * @return A string representation of the object.
	 */
	@Override
	public String toString() {
		return "Response{" + "object=" + object + ", responseType=" + responseType + '}';
	}
}
