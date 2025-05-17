package com.saladbar.rinx.location.repository;

import com.saladbar.rinx.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
