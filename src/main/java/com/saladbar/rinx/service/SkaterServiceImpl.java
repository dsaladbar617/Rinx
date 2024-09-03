package com.saladbar.rinx.service;

import com.saladbar.rinx.dao.SkaterRepository;
import com.saladbar.rinx.entity.Skater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkaterServiceImpl implements SkaterService {

    private final SkaterRepository skaterRepository;

    @Autowired
    public SkaterServiceImpl(SkaterRepository skaterRepository) {
        this.skaterRepository = skaterRepository;
    }

    @Override
    public List<Skater> findAll() {
        return skaterRepository.findAll();
    }

    @Override
    public Skater findById(int id) {
        return skaterRepository.findById(id).orElse(null);
    }

    @Override
    public Skater save(int skaterId) {
//        Skater skater = skaterRepository.save(skaterId);
        return null;
    }

    @Override
    public void delete(Skater skater) {
        skaterRepository.delete(skater);
    }
}
