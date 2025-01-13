package com.saladbar.rinx.rink.service;

import com.saladbar.rinx.models.entity.Rink;

import java.util.List;

public interface RinkService {
    Rink findById(long id);
    List<Rink> findAll();
    Rink save(Rink rink);
}
