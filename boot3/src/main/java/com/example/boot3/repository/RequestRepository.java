package com.example.boot3.repository;

import com.example.boot3.dto.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {

    Optional<Request> findById(Long id);

    Request findByEmail(String email);
}
