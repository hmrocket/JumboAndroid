package com.jumboprivacy.event;

public class PayloadEvent {

    private boolean successful;
    private String version;
    /**
     * Decoded payload in its final form i.e javascript
     */
    private String payload;

    /**
     * create a failed event
     */
    public PayloadEvent() {
        successful = false;
        version = null;
        payload = null;
    }

    public PayloadEvent(boolean successful, String version, String payload) {
        this.successful = successful;
        this.version = version;
        this.payload = payload;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getVersion() {
        return version;
    }

    public String getPayload() {
        return payload;
    }
}
