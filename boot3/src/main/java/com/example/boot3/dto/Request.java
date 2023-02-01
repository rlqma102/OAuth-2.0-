package com.example.boot3.dto;

import com.example.boot3.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long member_id;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Role rq_role;

    @CreatedDate
    private LocalDateTime createDate;

    private LocalDateTime okDate;

    private char rqStatus; //권한상태 : Y-승인, N-반려, P-진행

}


