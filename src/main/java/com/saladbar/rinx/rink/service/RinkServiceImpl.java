package com.saladbar.rinx.rink.service;

import com.saladbar.rinx.models.entity.Rink;
import com.saladbar.rinx.rink.repository.RinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RinkServiceImpl implements RinkService{

    private final RinkRepository rinkRepository;

    @Autowired
    public RinkServiceImpl(RinkRepository rinkRepository) {
        this.rinkRepository = rinkRepository;
    }


    @Override
    public Rink findById(long id) {
        Optional<Rink> rink = rinkRepository.findById(id);

        if (rink.isEmpty()) throw new RuntimeException("No Rink Found");

        return rink.get();
    }

    @Override
    public List<Rink> findAll() {
        return rinkRepository.findAll();
    }

    @Override
    public Rink save(Rink rink) {
        return rinkRepository.save(rink);
    }
}
