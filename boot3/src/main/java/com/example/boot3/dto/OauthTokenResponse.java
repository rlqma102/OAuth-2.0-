package com.example.boot3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
public class OauthTokenResponse {


    /**
     * accessToken 받아올 DTO
     * */

    @JsonProperty("access_token")
    private String accessToken;
    private String scope;

    @JsonProperty("token_type")
    private String tokenType;

    @Builder
    public OauthTokenResponse(String accessToken, String scope, String tokenType) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.scope = scope;
    }
}
