package com.example.smspr.repository;

import com.example.smspr.domain.Tbboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbboardRepository extends JpaRepository<Tbboard, Integer> {
}
