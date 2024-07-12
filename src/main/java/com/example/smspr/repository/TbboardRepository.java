package com.example.smspr.repository;

import com.example.smspr.domain.Tbboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository > 간단하게 DB와 데이터 접근 작업 처리 가능
//@Entity로 선언한 class가 결국 JPARepository를 사용하여 access할 class
@Repository
public interface TbboardRepository extends JpaRepository<Tbboard, String> {
}
