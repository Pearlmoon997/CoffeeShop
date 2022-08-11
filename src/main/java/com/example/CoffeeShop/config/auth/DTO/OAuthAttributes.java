package com.example.CoffeeShop.config.auth.DTO;

import com.example.CoffeeShop.Entity.UserManage.Role;
import com.example.CoffeeShop.Entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Getter
@Slf4j
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String token;
    private String birth;
    private String phoneNum;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String token, String birth, String phoneNum) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.token = token;
        this.birth = birth;
        this.phoneNum = phoneNum;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {

        if ("naver".equals(registrationId)) {
            return ofNaver("id", attributes);
        }
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {

        log.info("attribute : " +attributes);

        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .token((String) attributes.get("email"))
                .birth((String) attributes.get("age"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>)attributes.get("response");

        log.info("naver response : " + response);


        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .token((String) response.get("id"))
                .phoneNum((String) response.get("mobile"))
                .birth((String) response.get("birthyear"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .token(token)
                .phoneNum(phoneNum)
                .birth(birth)
                .role(Role.GUEST)
                .build();
    }
}
