package com.example.smspr.repository;

import com.example.smspr.domain.Tbpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// DB에 적기 위한 repository
// String -> @Id의 자료형
public interface TbpostRepository extends JpaRepository<Tbpost, String> {
}
