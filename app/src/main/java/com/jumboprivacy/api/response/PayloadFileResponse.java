package com.jumboprivacy.api.response;

public class PayloadFileResponse {

    private PayloadResponse payload;
    private String signature;


    public PayloadFileResponse(PayloadResponse payload, String signature) {
        this.payload = payload;
        this.signature = signature;
    }

    public PayloadResponse getPayload() {
        return payload;
    }

    public void setPayload(PayloadResponse payload) {
        this.payload = payload;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
