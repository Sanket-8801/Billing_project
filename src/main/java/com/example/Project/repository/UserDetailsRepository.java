// UserDetailsRepository.java
package com.example.Project.repository;

import com.example.Project.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    // You can add custom queries or methods if needed
}
