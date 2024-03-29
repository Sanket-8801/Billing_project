// BillItemRepository.java
package com.example.Project.repository;

import com.example.Project.model.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillItemRepository extends JpaRepository<BillItem, Long> {
    List<BillItem> findByBillId(Long billId);
    // You can add custom queries or methods if needed
}
