// BillRepository.java
package com.example.Project.repository;

import com.example.Project.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByUserId(Long userId);
    List<Bill> findByClientIdAndUserId(Long clientId, Long userId);
    // You can add custom queries or methods if needed
}
