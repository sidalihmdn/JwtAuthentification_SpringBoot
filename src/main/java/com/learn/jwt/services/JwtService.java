package com.learn.jwt.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JwtService {

    private JwtEncoder encoder;

    public JwtService(JwtEncoder encoder){
        this.encoder = encoder;
    }

    public String encode(Authentication auth){
        Instant now = Instant.now();
        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .subject(auth.getName())
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(30)) //30 seconds until expiration - for testing purposes
                .subject(auth.getName())
                .build();
        JwtEncoderParameters encoderParameters = JwtEncoderParameters.from(
                        JwsHeader.with(MacAlgorithm.HS256).build(),claimsSet);
        return this.encoder.encode(encoderParameters).getTokenValue();
    }
}
