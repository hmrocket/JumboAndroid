package com.jumboprivacy.api

import java.math.BigInteger
import java.nio.charset.StandardCharsets
import java.security.MessageDigest

object ApiUtil {

    /**
     * return a hex
     */
    fun generateRepoUrl(publicKey: String): String {

        val md = MessageDigest.getInstance("SHA-256")
        md.update(publicKey.trim().toByteArray(StandardCharsets.UTF_8))
        val digest = md.digest()
        return String.format("%064x", BigInteger(1, digest))
    }
}
