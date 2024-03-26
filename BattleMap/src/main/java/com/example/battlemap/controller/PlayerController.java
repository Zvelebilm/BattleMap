package com.example.battlemap.controller;

import com.example.battlemap.model.Player;
import com.example.battlemap.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @MessageMapping("/user.addPlayer")
    @SendTo("/user/topic") //subscribe to topic
    public Player addPlayer(@Payload Player player) {
        playerService.savePlayer(player);
        return player;
    }
    @MessageMapping("/user.disconnectPlayer")
    @SendTo("/user/topic") //subscribe to topic
    public Player disconnectPlayer(@Payload Player player) {
        playerService.disconnectPlayer(player);
        return player;
    }

    @GetMapping("/players")
    public ResponseEntity<List<Player>> findConnectedPlayers() {
        return ResponseEntity.ok(playerService.findConnectedPlayers());
    }
}
