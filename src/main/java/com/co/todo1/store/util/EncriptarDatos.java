package com.co.todo1.store.util;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// ing  arobles
public class EncriptarDatos {

    private EncriptarDatos() {
        throw new IllegalStateException("Utility class");
    }
    private static final Logger log = LoggerFactory.getLogger(EncriptarDatos.class);
    public static final String KEY_CIFRADO = "TODO EN ONE";

    public static String encriptar(String texto) {
        String base64EncryptedString = "";
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(KEY_CIFRADO.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (Exception ex) {
            log.error("Error inesperperado al intentar ejecutar la peticion: {}", ex);

        }
        return base64EncryptedString;
    }

    public static String desencriptarDatos(String textoEncriptado) {
        String base64EncryptedString = "";
        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(KEY_CIFRADO.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainText = decipher.doFinal(message);
            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (Exception ex) {
            log.error("Error inesperperado al intentar ejecutar la peticion: {}", ex);
        }
        return base64EncryptedString;
    }
}
