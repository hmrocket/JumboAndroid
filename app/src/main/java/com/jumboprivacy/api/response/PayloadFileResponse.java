package com.jumboprivacy.api.response;

public class PayloadFileResponse {

    private String payload;
    private String signature;


    public PayloadFileResponse(String payload, String signature) {
        this.payload = payload;
        this.signature = signature;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
