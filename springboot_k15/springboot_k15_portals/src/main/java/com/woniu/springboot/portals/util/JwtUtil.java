package com.woniu.springboot.portals.util;

import io.jsonwebtoken.*;

import java.util.Date;

public class JwtUtil {
    private static long EXPIRE_TIME=600000000;
    private static String SECRET_KEY="XIAKAI";
    public static String getJwt(JwtInfo jwtInfo){
        JwtBuilder builder = Jwts.builder();
        builder.setHeaderParam("alg","HS256");
        builder.setHeaderParam("typ","JWT");
        builder.setIssuer("xiakai");
        builder.setSubject("k15education");
        builder.setExpiration(new Date(System.currentTimeMillis()+EXPIRE_TIME));
        builder.claim("account",jwtInfo.getAccount());
        builder.signWith(SignatureAlgorithm.HS256,SECRET_KEY);
        String token = builder.compact();
        return token;
    }
    public static Claims parseJwt(String token){
        JwtParser parser = Jwts.parser();
        Jws<Claims> claimsJws = parser.setSigningKey(SECRET_KEY).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return claims;
    }
}
