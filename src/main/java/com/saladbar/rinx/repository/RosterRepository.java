package com.saladbar.rinx.repository;

import com.saladbar.rinx.entity.Roster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RosterRepository extends JpaRepository<Roster, Integer> {
}
