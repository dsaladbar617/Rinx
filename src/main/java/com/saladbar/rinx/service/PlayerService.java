package com.saladbar.rinx.service;

import com.saladbar.rinx.entity.Player;
import com.saladbar.rinx.entity.Skater;

import java.util.List;

public interface PlayerService {
    List<Player> findAll();
    Player findById(int id);
    Player save(Player player);
    void delete(Player player);
}
