package com.example.boot3.dto;

import com.example.boot3.enums.Role;
import lombok.Builder;
import lombok.Getter;


/**
 * oauth server에서 들어올 유저의 정보를 받아줄 DTO
 * */

@Getter
public class UserProfile {

    private final String oauthId;
    private final String email;
    private final String name;
    private final String imageUrl;

    @Builder
    public UserProfile(String oauthId, String email, String name, String imageUrl) {
        this.oauthId = oauthId;
        this.email = email;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public Member toMember() {
        return Member.builder()
                .oauthId(oauthId)
                .email(email)
                .name(name)
                .imageUrl(imageUrl)
                .role(Role.GUEST)
                .build();
    }
}
