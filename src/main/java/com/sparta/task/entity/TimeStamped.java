package com.sparta.task.entity;


import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@Getter // 생성날짜, 수정날짜 responsedto 로 가져오기위해
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class TimeStamped { //추상클래스
    // Task Entity에다가 TimeStamped 클래스를 상속해줌 -> application에 @EnableJpaAuditing 이 어노테이션 넣어줌

    @CreatedDate
    @Column(updatable = false) // 한 번 값을 정의한 뒤로 값을(=생성날짜) 절대 수정 못함
    @Temporal(TemporalType.TIMESTAMP) // 매핑할 데이터의 타입을 TIMESTAMP 로 설정
    private LocalDateTime createdAt; //데이터 베이스의 column으로 인식

    @LastModifiedDate
    @Column
    @Temporal(TemporalType.TIMESTAMP) // 매핑할 데이터의 타입을 TIMESTAMP 로 설정
    private LocalDateTime updatedAt; //데이터 베이스의 column으로 인식


}