package com.saladbar.rinx.rink.repository;

import com.saladbar.rinx.model.entity.Rink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RinkRepository extends JpaRepository<Rink, Long> {
}
