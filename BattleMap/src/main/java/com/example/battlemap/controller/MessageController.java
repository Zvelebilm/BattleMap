package com.example.battlemap.controller;

import com.example.battlemap.model.DTOResponseMessage;
import com.example.battlemap.model.DTOTestMessage;
import com.example.battlemap.model.Flag;
import com.example.battlemap.model.Game;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
@Log4j2
public class MessageController {
    @MessageMapping("/message")
    @SendTo("/topic/messages") //whoever subscribe to this topic will receive the message
    public DTOResponseMessage getMessage(final DTOTestMessage message) throws InterruptedException {
        Thread.sleep(10);
        log.info("message received: " + message.getMessageContent());
        return new DTOResponseMessage(HtmlUtils.htmlEscape(message.getMessageContent()));
    }

    @MessageMapping("/flag")
    @SendTo("/topic/flag")
    public String getFlag(String flag) throws JsonProcessingException {

        log.info("flag received: " + flag);

        ObjectMapper mapper = new ObjectMapper();

        Game game = mapper.readValue(flag, Game.class);
        System.out.println(game.getGameName());
        for (Flag flagTest : game.getFlags()) {
            System.out.println(flagTest.getProperties().getFlagName());
            System.out.println(flagTest.getProperties().getFlagIconURL());
            System.out.println(flagTest.getGeometry().getCoordinates());
        }


        return flag;
    }
}
