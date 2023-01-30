package com.example.boot3.repository;

import com.example.boot3.dto.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByOauthId(String id);
    List<Member> findAll();

    Member findById(String id);

    Member findByEmail(String email);
}
