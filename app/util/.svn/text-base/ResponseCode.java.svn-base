package util;


/**
 * Created with IntelliJ IDEA.
 * User: Manzarul.Haque
 * Date: 5/21/13
 * Time: 11:27 AM
 * this class contains all error codes with their messages.
 */
public enum ResponseCode {
Success(Constants.SUCCESS,Constants.SUCCESS_MESSAGE),
Failure(Constants.FAILURE,Constants.FAILURE_MESSAGE),InCorrectData(Constants.INCORRECTDATA,Constants.INCORRECTDATA_MESSAGE),
InvalidSession(Constants.INVALID_SESSION,Constants.INVALID_SESSION_MESSAGE),InvalidRole(Constants.INVALID_ROLE,Constants.INVALID_ROLE_MESSAGE)
;

    /**
     * error code contains int value
     */
    private int errorCode;
    /**
     * errorMessage contains proper error message.
     */
    private String errorMessage;

    /**
     * @param errorCode
     * @param errorMessage
     */
    private ResponseCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getMessage(int errorCode) {
        return "";
    }

    /**
     * @return
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
