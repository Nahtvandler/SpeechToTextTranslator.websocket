package com.nahtvandler.SpeechToTextTranslator.websocket;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    @JsonProperty("message")
    String message;

    @JsonProperty("sender")
    User sender;

    @JsonProperty("createdAt")
    long createdAt;

    @JsonProperty("channelId")
    String channelId;

    @JsonProperty("isRecognized")
    boolean isRecognized;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public boolean isRecognized() {
        return isRecognized;
    }

    public void setRecognized(boolean recognized) {
        isRecognized = recognized;
    }
}
