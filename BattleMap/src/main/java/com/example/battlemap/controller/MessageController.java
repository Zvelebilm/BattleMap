package com.example.battlemap.controller;

import com.example.battlemap.model.DTOResponseMessage;
import com.example.battlemap.model.DTOTestMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {
    @MessageMapping("/message")
    @SendTo("/topic/messages") //whoever subscribe to this topic will receive the message
    public DTOResponseMessage getMessage(final DTOTestMessage message) throws InterruptedException {
        Thread.sleep(1000);
        return new DTOResponseMessage(HtmlUtils.htmlEscape(message.getMessageContent()));
    }
}
