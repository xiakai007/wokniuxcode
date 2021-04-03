package com.woniu.product.tools;

import io.jsonwebtoken.*;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private static final String SECRET="ilovexiakai";
    private static final SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;

    private static Key getKey(){
        byte[] bytes = DatatypeConverter.parseBase64Binary(SECRET);
        return new SecretKeySpec(bytes,signatureAlgorithm.getJcaName());
    }
    public static String createToken(String username,int expireSeconds){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("alg","HS256");
        map.put("typ","JWT");
        JwtBuilder builder = Jwts.builder();
        builder.setHeaderParams(map);
        builder.claim("username",username);
        builder.claim("role","总管");
        builder.signWith(signatureAlgorithm,getKey());
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if(expireSeconds>=0){
            long expMillis=nowMillis+(expireSeconds+2)*1000;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate);
        }
        builder.setIssuedAt(now);
        String token = builder.compact();
        return token;
    }
    public static boolean verifyToken(String token){
        Claims body = null;
        try {
            body=Jwts.parser().setSigningKey(getKey()).parseClaimsJws(token).getBody();
        } catch (SignatureException e) {
            throw new RuntimeException(e);
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("超时", e);
        } catch (Exception e) {
            throw new RuntimeException("未知错误", e);
        }
        return body!=null;
    }
    public static String getUsername(String token){
        Claims body = null;
        try {
            body=Jwts.parser().setSigningKey(getKey()).parseClaimsJws(token).getBody();
        } catch (SignatureException e) {
            throw new RuntimeException(e);
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("超时", e);
        } catch (Exception e) {
            throw new RuntimeException("未知错误", e);
        }
        System.out.println((String)body.get("role"));
        return (String) body.get("username");
    }
    public static void main(String[] args) {
        String oldtoken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InpzZiIsInJvbGUiOiLlpKflhoXmgLvnrqEiLCJleHAiOjE2MDEwMjg5NDcsImlhdCI6MTYwMTAyMjk0NX0.IkL7JFBbsGbzdqbcz6Fq3arjl1oaZfi5EeVVeGTmcHU";

        String token = JwtUtils.createToken("zsf", 6000);
        System.out.println("token:"+token);

        System.out.println(JwtUtils.verifyToken(oldtoken));

        System.out.println(JwtUtils.getUsername(oldtoken));;
    }
}
