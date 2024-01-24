// UserDetailsController.java
package com.example.Project.controller;

import com.example.Project.model.UserDetails;
import com.example.Project.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-details")
public class UserDetailsController {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @GetMapping
    public List<UserDetails> getAllUserDetails() {
        return userDetailsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetails> getUserDetailsById(@PathVariable Long id) {
        return userDetailsRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserDetails createUserDetails(@RequestBody UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetails> updateUserDetails(@PathVariable Long id, @RequestBody UserDetails userDetails) {
        if (!userDetailsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userDetails.setId(id);
        return ResponseEntity.ok(userDetailsRepository.save(userDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserDetails(@PathVariable Long id) {
        if (!userDetailsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userDetailsRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
