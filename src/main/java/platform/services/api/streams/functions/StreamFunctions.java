package platform.services.api.streams.functions;

public enum StreamFunctions {

    RECORD_ON_TRIGGER("RECORD_ON_TRIGGER"),
    RECORD_CONTINUOUSLY("RECORD_CONTINUOUSLY"),
    MONITOR("MONITOR"),
    ONDEMAND("ONDEMAND");

    private final String s;

    StreamFunctions(final String s) {

        this.s = s;

    }

}
