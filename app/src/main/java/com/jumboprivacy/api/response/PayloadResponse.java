package com.jumboprivacy.api.response;

public class PayloadResponse {

    String version;
    /**
     * Base 64 encoded string content
     */
    String content;


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
