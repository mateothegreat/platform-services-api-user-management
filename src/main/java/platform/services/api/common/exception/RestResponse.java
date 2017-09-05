package platform.services.api.common.exception;

public class RestResponse {

    public static final int    ENTITY_EXISTS_CODE    = 1001;
    public static final String ENTITY_EXISTS_MESSAGE = "A %s already exists with the %s \"%s\"";

    private int    errorCode;
    private String message;

    public RestResponse(final int code, final String message, final Object... args) {

        this.errorCode = code;
        this.message = format(message, args);

    }
//    public RestResponse(int errorCode, String message) {
//
//        this.errorCode = errorCode;
//        this.message = message;
//
////        return new ResponseEntity<RestErrorResponse>(new RestErrorResponse(errorCode, message));
////        return new ResponseEntity<RestErrorResponse>(new RestErrorResponse(errorCode, message));
//
//    }
    public static String format(final String message, final Object... args) {

        return String.format(message, args);

    }

    @Override public String toString() {

        return String.format("RestResponse{errorCode=%d, message='%s'}", errorCode, message);
    }
//    @Override public String toString() {
//
//        return MessageFormat.format("RestResponse'{'errorCode={0}, message=''{1}'''}'", errorCode, message);
//
//    }

    public int getCode() {

        return errorCode;

    }

    private void setCode(final int errorCode) {

        this.errorCode = errorCode;

    }

    public String getMessage() {

        return message;

    }

    private void setMessage(final String message) {

        this.message = message;

    }

}
