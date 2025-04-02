package com.hit.week4.repository;

import com.hit.week4.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Integer> {
    boolean existsById(int id);

    Classes findClassesByName(String name);
}
