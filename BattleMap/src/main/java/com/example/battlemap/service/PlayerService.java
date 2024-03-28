package com.example.battlemap.service;

import com.example.battlemap.model.Player;
import com.example.battlemap.model.Status;
import com.example.battlemap.repository.PlayerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService { //todo need refactor

    private final PlayerRepo playerRepo;
    public void savePlayer(Player player) {
        player.status = Status.ONLINE;
        playerRepo.save(player);
    }
    public List<Player> findConnectedPlayers() { //todo players in-game
        return playerRepo.findAll();
    }
    public void disconnectPlayer(Player player) {
        player.status = Status.OFFLINE;
        playerRepo.save(player);
    }
}
