package com.wzm.oneapiclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * Signature tool
 *
 * @author wzm
 *
 */
public class SignUtils {
    /**
     * Generate signature
     * @param body
     * @param secretKey
     * @return
     */
    public static String genSign(String body, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = body + "." + secretKey;
        return md5.digestHex(content);
    }
}
