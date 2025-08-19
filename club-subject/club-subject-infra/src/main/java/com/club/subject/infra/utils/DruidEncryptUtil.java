package com.club.subject.infra.utils;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * packageName com.club.subject.infra.utils
 *
 * @author zh
 * @version 1.0
 * @className DruidEncryptUtil
 * @date 2025-08-17
 * @description TODO druid 数据库加密
 */

public class DruidEncryptUtil {
    public static void main(String[] args) throws Exception {
//        // 生成一对长度为512的密钥
//        String[] keyPair = ConfigTools.genKeyPair(512);
//        String privateKey = keyPair[0];
//        String publicKey = keyPair[1];
//
//        System.out.println("请妥善保管以下生成的密钥对：");
//        System.out.println("privateKey: " + privateKey);
//        System.out.println("publicKey: " + publicKey);
//
//        String priKey = privateKey;
//        // 加密您的密码
//        String encryptedPassword = ConfigTools.encrypt(priKey, "123456");
//        System.out.println("请将以下加密后的密码用于 application.yml 文件中：");
//        System.out.println("encryptedPassword: " + encryptedPassword);
//        String pubKey = publicKey;

//        请妥善保管以下生成的密钥对：
//        privateKey: MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAjSH5D13h5n0h1mLT+wSK36HYwg4Ncx790Fa+rsiB7Q7s57SF3hItJVbPRXD08iYHoYnPDj8ZsMurrdnYLBsNGwIDAQABAkBCZxCbBU4LNybbisY4HawFik3FB/2WA6fiBV5UOCzBTwJXkuMgD0zoE4yifGE6I9Cm2KFDhiiK+gFrhFveVto5AiEAkhLj1WG7wUSGgr2yDjy01nf0pl5l8NcgOKSCQFNYwtcCIQD3Vy7/SGdIlykcTVsYCVPpZos0IEpeWU/0ifzHp1JDXQIhAILVLoFxbyR0xvGVDETaNLKfcF4O0Ml9NVvmZM9Ol4KzAiBt8S/vw3Q9fQuGDBCAx6yn46/etLe55oM21Jsq+AIF9QIgGzzkdjo0lvy40wrDMGI7vYldibOlNdfTyicbq1y1P9s=
//        publicKey: MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAI0h+Q9d4eZ9IdZi0/sEit+h2MIODXMe/dBWvq7Ige0O7Oe0hd4SLSVWz0Vw9PImB6GJzw4/GbDLq63Z2CwbDRsCAwEAAQ==
//        请将以下加密后的密码用于 application.yml 文件中：
//        encryptedPassword: Tb9WP4g50FOt6x1na3hykTKH0ziqW3NSZVtV6EwGfis1HrOtoBkIjskUb6KGazcWPIy5MEGOH3upOZCYXCdUxg==
//        解密： 123456

        String encryptedPassword = "Tb9WP4g50FOt6x1na3hykTKH0ziqW3NSZVtV6EwGfis1HrOtoBkIjskUb6KGazcWPIy5MEGOH3upOZCYXCdUxg==";
        String pubKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAI0h+Q9d4eZ9IdZi0/sEit+h2MIODXMe/dBWvq7Ige0O7Oe0hd4SLSVWz0Vw9PImB6GJzw4/GbDLq63Z2CwbDRsCAwEAAQ==";
        // 解密
        String decryptedPassword = ConfigTools.decrypt(pubKey, encryptedPassword);
        System.out.println("解密： " + decryptedPassword); // 解密： 123456
    }
}
