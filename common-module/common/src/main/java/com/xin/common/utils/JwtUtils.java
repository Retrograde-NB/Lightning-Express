package com.xin.common.utils;

import cn.hutool.core.util.StrUtil;
import com.xin.common.constant.Constants;
import com.xin.common.exception.XinException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/08 下午 1:53
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class JwtUtils {
    public static final long EXPIRE = 1000 * 60 * 60 * 24;
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";
    /**
     * 根据id生成token
     * @param id id
     * @return token
     */
    public static String getJwtToken(Long id){
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject("xin-user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("id", id)
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
    }
    /**
     * 判断token是否存在与有效
     * @param jwtToken token
     * @return 是否存在有效
     */
    public static boolean checkToken(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * 判断token是否存在与有效
     * @param request 请求头
     * @return 是否存在有效
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");
            if(StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token获取会员id
     * @param jwtToken token
     * @return id
     */
    public static Long getIdByJwtToken(String jwtToken) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return Long.parseLong(claims.get("id").toString());
    }

    /**
     * 根据请求头获取id
     * @return id
     */
    public static Long getId(){
        HttpServletRequest request = ServletUtils.getRequest();
        if (request == null) {
            throw new XinException(Constants.FAIL, "获取失败");
        }
        String token = request.getHeader("token");
        if (StrUtil.isEmpty(token)) {
            throw new XinException(Constants.FAIL, "获取失败,无token");
        }
        if (!JwtUtils.checkToken(token)) {
            throw new XinException(Constants.FAIL, "凭证已过期请从新认证");
        }
        return JwtUtils.getIdByJwtToken(token);
    }

    /**
     * 获取当前请求的token
     * @return token
     */
    public static String getToken(){
        HttpServletRequest request = ServletUtils.getRequest();
        if (request == null) {
            throw new XinException(Constants.FAIL, "获取失败");
        }
        return request.getHeader("token");
    }

    public static String getToken(ServerHttpRequest request) {
        return request.getHeaders().getFirst(Constants.TOKEN);
    }
}
