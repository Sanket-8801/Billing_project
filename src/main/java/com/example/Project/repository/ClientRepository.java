// ClientRepository.java
package com.example.Project.repository;

import com.example.Project.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByUserId(Long userId);
    // You can add custom queries or methods if needed
}
