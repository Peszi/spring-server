package com.shutter.springserver.handler;

import com.shutter.springserver.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OAuthController {

    @Autowired
    private TokenStore tokenStore;

    @DeleteMapping("/oauth/revoke-token")
    public ResponseEntity<String> revokeToken(HttpServletRequest request, Authentication authentication) {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.contains("Bearer")){
            String tokenValue = authorization.substring("Bearer".length()).trim();
            OAuth2AccessToken accessToken =  this.tokenStore.readAccessToken(tokenValue);
            if (accessToken == null)
                throw new BadRequestException("Not logged in!");
            this.tokenStore.removeAccessToken(accessToken);
            this.tokenStore.removeRefreshToken(accessToken.getRefreshToken());
            return ResponseEntity.ok("Successfully logged out!");
        }
        return new ResponseEntity<>("Token is missing!", HttpStatus.BAD_REQUEST);
    }
}