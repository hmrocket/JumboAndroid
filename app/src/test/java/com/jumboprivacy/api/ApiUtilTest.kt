package com.jumboprivacy.api

import org.junit.Assert.assertEquals
import org.junit.Test

class ApiUtilTest {

    /**
     * test if The URL generation works as expected
     */
    @Test
    fun generateRepoUrl() {
        val publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx+AGTuBG7W0/4zcb979Lqn+IbGl+fHMBXo5nWJ088cIfI/nken6Z8uVCoLdDitJWVghXdK+50vPT/049vBX4fJSZjIYf2CQrzthVvW8UM0uSa59AjYBjPTBmyE2jus5LbtXqx4/xorcBcEksNAl/2CUoFpyxzfn5+CMpH2qnimk/KIRHUDx+qU1qz/qHxhCzaLJXBmHUvzPa2orU78Ca02Xo7Fg8L5cN/FMUvHk5Mn4TTHaAdDKNdvDgkfXlpl80QnT9yRFyeAVaWu6GA1PWXlODgFTSHOObyJazjoEpwZKVaoiB82hKXcWrH/5wD8n8ll9ysGtKGzNMePHqHKXM6wIDAQAB"

        val hex = ApiUtil.generateRepoUrl(publicKey)

        val repo = "b6e60cb831003b2d51bfac3288160ad13e7a407e6be0f2cec8c3e32a303857bd"
        assertEquals(hex, repo)
    }

//    @Test
//    fun signature() {
//        val publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvj/vNM+fcg1EsqUNVpWt" +
//                "0R5vHS1KpSOSYN0oBUzcnKNXREuFQAWxhopx6cf4/F0TnP+P9XkDYpDIVvyybeoJ" +
//                "lxKcgXClitKKqsYI45GHIhoUdYkE8a4u4qKJkPqvev7mY0Yoa6pASTjCroOjIHCY" +
//                "EwuPy1Tm0TqIL99x4DMJnTgi5VFd580iHb4kzSlkt10sLKqYiJ8w4rjB2sG6FXqW" +
//                "27hnpiWxWUkGIqkF+UahAwEx+dcqKf3z9y8V/VpKDbBQNq8fvGcawyHgIBBaB0+C" +
//                "AdaTJbBY15pn27+f5XRxZja21Gof3+TLMzj/vsiwaQ4IHklj5VEDU65Rc4jz+C0m" +
//                "IQIDAQAB"
//
//        val sign = "Mcc5CwRh670YN8HUCbxVlsbg+Y89BoFQgJ0rIn6DTEp8Jz6zM7YBYOAbVRZQ0UwDZDHqOsFnmDZmOGPNfzp2fdQaqc30h0S8NZiGtOsSw9DKFDCRc9kBoReccDi6Q4WRxKq0vsPfXJnDyz6xArZHKAdADRuRoSSu8li9yrVb9WYOyZ55rGqbPyI9m8fcTzvK7JlHwp+gtzTCOiRf0J3aGdgiPa3+xX+WRGHLt847LnwYylqIpNWHuFvlEdVqNpGd9BAOqFc+MrDXlXWAFu3IDWKEYsE8C1bFx4qLPpXOl4vTS/NulNTTXpUU1fDtcgBw3nIaQ76BZ+RWAZkJFBn/pg=="
//
//        Assert.assertTrue(ApiUtil.verifySign(publicKey, "Hello", sign))
//
//    }
}