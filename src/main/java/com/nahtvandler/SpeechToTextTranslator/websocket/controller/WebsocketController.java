package com.nahtvandler.SpeechToTextTranslator.websocket.controller;

import com.nahtvandler.SpeechToTextTranslator.websocket.Message;
import com.nahtvandler.SpeechToTextTranslator.websocket.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebsocketController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebsocketController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/ping")
    private void ping(@RequestBody Message message) {
        Message responseMessage = new Message();
        responseMessage.setMessage("pong");
        responseMessage.setCreatedAt(System.currentTimeMillis());
        responseMessage.setSender(new User("server"));

        //this.simpMessagingTemplate.convertAndSend("/questions/" + 1, "pong");
        this.simpMessagingTemplate.convertAndSend("/rooms/room#" + message.getChannelId(), responseMessage);
    }

    @MessageMapping("/sendMessage")
    private void sendMessage(@RequestBody Message message) {
        String channelId = message.getChannelId();
        if (message.getMessage().contains("/ping")) {
            message = createPingMessage();
        }

        this.simpMessagingTemplate.convertAndSend("/rooms/room#" + channelId, message);
    }

    private Message createPingMessage() {
        Message responseMessage = new Message();
        responseMessage.setMessage("pong");
        responseMessage.setCreatedAt(System.currentTimeMillis());
        responseMessage.setSender(new User("server"));

        return responseMessage;
    }
}
