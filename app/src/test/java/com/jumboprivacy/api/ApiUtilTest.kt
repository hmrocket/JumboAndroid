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
}