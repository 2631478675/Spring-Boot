package deki.com.springbootsecurity.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JWTUtil {
    //30min
    private static final long EXPIRE_TIME = 30 * 60 * 1000;


    /**
     * 根据传入的用户名和密码判断token是否正确
     * @param token
     * @param username
     * @param password
     * @return
     */
    public static boolean verify(String token, String username, String password) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            String name = jwt.getClaim("username").asString();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需password解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }


    /**
     * @param username 用户名
     * @param password   用户的密码
     * @return 加密的token
     */
    public static String encryption(String username, String password) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(password);
        // 附带username信息
        return JWT.create()
                .withClaim("username", username)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    public static void main(String args[]) {


        System.out.println(JWTUtil.getUsername("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1MjQ3MTEwNDgsInVzZXJuYW1lIjoiaGFoYSJ9.kgcSgDplv1sBYyr4-oS8oV7B2K7Az2028rzP98Et7Bw"));
        System.out.println(JWTUtil.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1MjQ3MTEwNDgsInVzZXJuYW1lIjoiaGFoYSJ9.kgcSgDplv1sBYyr4-oS8oV7B2K7Az2028rzP98Et7Bw", "haha", "123321"));
    }
}
