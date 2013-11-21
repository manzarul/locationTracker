/**
 * 
 */
package util;

import org.codehaus.jackson.node.ObjectNode;

import play.libs.Json;


/**
 * @author Manzarul.Haque
 *
 */
public class Constants {
	
	public static final int SUCCESS = 200;
	public static final int FAILURE = 300;
	public static final int INCORRECTDATA = 301;
	public static final int INVALID_SESSION = 302;
	public static final int INVALID_ROLE = 302;
	public static final String SUCCESS_MESSAGE = "Success";
	public static final String FAILURE_MESSAGE = "Failure";
	public static final String INCORRECTDATA_MESSAGE = "Please check data.";
	public static final String INVALID_SESSION_MESSAGE = "Invalid session.";
	public static final String INVALID_ROLE_MESSAGE = "You don't have access.";
	
	
	
	/**
	 * this method will crate invalid access response as json and send it to
	 * controller.
	 * 
	 * @return ObjectNode object.
	 */
	public static ObjectNode InvalidDataResponse() {
		ObjectNode response = Json.newObject();
		response.put(JsonKey.STATUSCODE,
				ResponseCode.InCorrectData.getErrorCode());
		response.put(JsonKey.STATUSMESSAGE,
				ResponseCode.Failure.getErrorMessage());
		response.put(JsonKey.ERROR_MESSAGE,
				ResponseCode.InCorrectData.getErrorMessage());
		return response;
	}
	
	
	/**
	 * this method will crate failure response and send to 
	 * controller.
	 * 
	 * @return ObjectNode object.
	 */
	public static ObjectNode failureResponse() {
		ObjectNode response = Json.newObject();
		response.put(JsonKey.STATUSCODE,
				ResponseCode.Failure.getErrorCode());
		response.put(JsonKey.STATUSMESSAGE,
				ResponseCode.Failure.getErrorMessage());
		response.put(JsonKey.ERROR_MESSAGE,
				ResponseCode.Failure.getErrorMessage());
		return response;
	}

	
}
