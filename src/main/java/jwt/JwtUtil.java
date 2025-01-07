package jwt;

import java.util.Date;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
    private static final String SECRET_KEY = "thisisareallybigsecretthatithastobesolonginordertobesafe";

    @SuppressWarnings("deprecation")
    public static String createJWT(String id, String subject, long ttlMillis, Map<String, Object> claims) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date();

        return Jwts.builder()
                    .setId(id)
                    .setSubject(subject)
                    .setClaims(claims)
                    .setIssuedAt(now)
                    .setExpiration(new Date(nowMillis +  ttlMillis))
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
    }

    @SuppressWarnings("deprecation")
	public static Claims decodeJwt(String jwt) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt).getBody();
    }
}
