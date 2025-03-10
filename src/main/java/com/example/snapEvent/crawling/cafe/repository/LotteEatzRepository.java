package com.example.snapEvent.crawling.cafe.repository;

import com.example.snapEvent.crawling.cafe.entity.LotteEatz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotteEatzRepository extends JpaRepository<LotteEatz, Long> {

    boolean existsByTitle(String title);
    LotteEatz findByTitle(String title);
}
