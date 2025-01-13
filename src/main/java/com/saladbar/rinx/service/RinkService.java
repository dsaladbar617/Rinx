package com.saladbar.rinx.service;

import com.saladbar.rinx.entity.Rink;

import java.util.List;
import java.util.Set;

public interface RinkService {
    Rink findById(long id);
    List<Rink> findAll();
    Rink save(Rink rink);
}
