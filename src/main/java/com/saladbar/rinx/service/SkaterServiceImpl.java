package com.saladbar.rinx.service;

import com.saladbar.rinx.dao.SkaterRepository;
import com.saladbar.rinx.entity.Player;
import com.saladbar.rinx.entity.Skater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("Skater")
public class SkaterServiceImpl implements PlayerService {

    private final SkaterRepository skaterRepository;

    @Autowired
    public SkaterServiceImpl(SkaterRepository skaterRepository) {
        this.skaterRepository = skaterRepository;
    }

    @Override
    public List<Player> findAll() {
        return skaterRepository.findAll();
    }

    @Override
    public Player findById(int id) {
        return skaterRepository.findById(id).orElse(null);
    }

    @Override
    public Player save(Player skater) {
//        Skater test = (Skater)skater;
        return skaterRepository.save(skater);
    }

    @Override
    public void delete(Player skater) {
        skaterRepository.delete(skater);
    }
}
