package com.saladbar.rinx.service;

import com.saladbar.rinx.entity.Skater;
import com.saladbar.rinx.repository.SkaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("Skater")
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
    public Skater save(Skater skater) {
        return skaterRepository.save(skater);
    }

    @Override
    public void delete(Skater skater) {
        skaterRepository.delete(skater);
    }
}
