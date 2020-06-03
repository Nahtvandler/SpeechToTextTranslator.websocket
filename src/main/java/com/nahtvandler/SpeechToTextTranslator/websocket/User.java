package com.nahtvandler.SpeechToTextTranslator.websocket;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("nickname")
    String nickname;

    @JsonProperty("profileUrl")
    String profileUrl;

    public User(String nickname) {
        this.nickname = nickname;
    }

    public User() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
}
