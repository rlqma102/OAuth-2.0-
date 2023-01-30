package com.example.boot3.repository;

import com.example.boot3.dto.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, String> {
    Request findByEmail(String email);
}
