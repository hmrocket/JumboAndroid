package com.jumboprivacy.api

import android.util.Base64
import java.math.BigInteger
import java.nio.charset.StandardCharsets
import java.security.KeyFactory
import java.security.MessageDigest
import java.security.PublicKey
import java.security.Signature
import java.security.spec.X509EncodedKeySpec

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

    fun verifySign(publicKey: String, content: String, signature: String): Boolean {
        val dsa = Signature.getInstance("SHA256withRSA")
        dsa.initVerify(publicKey(publicKey))

        dsa.update(content.toByteArray())
        val sign = Base64.decode(
            signature,
            Base64.DEFAULT
        )

        return dsa.verify(sign)
    }

    /**
     * generate PublicKey from string
     */
    fun publicKey(publicKey: String): PublicKey {
        val keyFac = KeyFactory.getInstance("RSA")
        val keySpec = X509EncodedKeySpec(Base64.decode(publicKey.trim { it <= ' ' }.toByteArray(), Base64.DEFAULT))
        val key = keyFac.generatePublic(keySpec)
        return key
    }
}
