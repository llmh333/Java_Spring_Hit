package com.hit.week8.domain.repository;

import com.hit.week8.domain.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {

    boolean existsByTitle(String title);
}
