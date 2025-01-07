
import java.util.Date;
import java.util.Map;

import io.jsonwebtoken.Claims;
import jwt.JwtUtil;
import mappping.MappingUtils;
import models.UserCreation;
import utils.mainUtils;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World JWT!");

        Date now  = new Date(System.currentTimeMillis());

        System.out.println("Now"+ now);

        UserCreation user = mainUtils.createUser();

        Map<String, Object> userMap = MappingUtils.convertObjectToMap(user);

        System.out.println(userMap);

        String newJwt = JwtUtil.createJWT("123", "First Token", 1000 * 60 * 10, userMap);

        Claims claims = JwtUtil.decodeJwt(newJwt);
        System.out.println("Decoded ID: "+ claims.getId());
        System.out.println("Decoded Subject: "+claims.getSubject());
        System.out.println("Issued At: "+claims.getIssuedAt());
        System.out.println("User: "+claims.get("user"));
        System.out.println("Nick: "+claims.get("nickname"));
        System.out.println("Hashed Password: "+claims.get("password"));

        System.out.println(mainUtils.resolve(user.getPassword()).verified);
    }
}
