package schoolmanagement.commonlib.communication;

import java.io.Serializable;

public class Response implements Serializable {

	private Object object;
	private ResponseType responseType;

	public Response(Object object, ResponseType responseType) {
		this.object = object;
		this.responseType = responseType;
	}

	public Response() {
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public ResponseType getResponseType() {
		return responseType;
	}

	public void setResponseType(ResponseType responseType) {
		this.responseType = responseType;
	}

	@Override
	public String toString() {
		return "Response{" + "object=" + object + ", responseType=" + responseType + '}';
	}

}
