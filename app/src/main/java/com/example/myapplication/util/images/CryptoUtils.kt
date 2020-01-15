package com.example.myapplication.util.images

import android.util.Base64
import java.net.URL
import java.security.MessageDigest
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object CryptoUtils {
    fun md5(input: String): String {
        val digest = MessageDigest.getInstance("MD5")
        digest.update(input.toByteArray())
        val messageDigest = digest.digest()

        // Create Hex String
        val hexString = StringBuilder()
        messageDigest.map {
            var h = Integer.toHexString(0xFF and it.toInt())
            while (h.length < 2)
                h = "0$h"
            h
        }
                .forEach { hexString.append(it) }

        return hexString.toString()
    }

    /** Find documentation about signing for Google static maps here:
    https://developers.google.com/maps/documentation/maps-static/get-api-key#dig-sig-key**/
    fun generateSignedUrlForStaticGoogleMaps(apiKey: String, apiSecret: String, urlString: String): String {
        val url = URL(urlString)

        val resource = "${url.path}?${url.query}&key=$apiKey"

        val signature = generateSignature(apiSecret, resource)

        return "${url.protocol}://${url.host}$resource&signature=$signature"
    }

    private fun generateSignature(apiSecretString: String, resource: String): String {
        // Convert the secret from 'web safe' base 64 to binary
        val cleanedApiSecretString = apiSecretString
                .replace('-', '+')
                .replace('_', '/')

        val decodedApiSecret = Base64.decode(cleanedApiSecretString, Base64.DEFAULT)
        val apiSecretKey = SecretKeySpec(decodedApiSecret, 0, decodedApiSecret.size, "HmacSHA1")

        // Get an HMAC-SHA1 Mac instance and initialize it with the HMAC-SHA1 key
        val mac = Mac.getInstance("HmacSHA1")
        mac.init(apiSecretKey)

        // Compute the binary signature for the request
        val sigBytes = mac.doFinal(resource.toByteArray())

        val signature = Base64.encodeToString(sigBytes, Base64.DEFAULT)

        // Convert the signature to 'web safe' base 64
        return signature
                .replace('+', '-')
                .replace('/', '_')
    }
}