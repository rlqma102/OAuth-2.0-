package com.example.boot3.dto;

import com.example.boot3.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request {


    //권한신청시 여기로 들어온다
    @Id
    private String email;
    private Role role;
    @CreatedDate
    private LocalDateTime createDate;

    private LocalDateTime okDate;

    private char rqStatus; //권한상태 : Y-승인, N-반려, P-진행

//    public Request() {
//
//    }
//
//    @Builder
//    public Request(String email, Role role, LocalDateTime createDate,LocalDateTime okDate, char rqStatus) {
//
//        this.email = email;
//        this.role = role;
//        this.createDate = createDate;
//        this.okDate = okDate;
//        this.rqStatus = rqStatus;
//    }
}


