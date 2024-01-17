package com.thc.sprapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AuditingFields {
//    @Id // PK로 사용될 것을 정하는 코드
//    @GeneratedValue(strategy = GenerationType.UUID) //PK를 자동생성하기 위한 방법 정하기
    @Id
    private String id; // 인덱스
    @Column(nullable = false)
    private String deleted;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false)
    protected LocalDateTime modifiedAt;

    @PrePersist
    public void onPrePersist() {
        this.id = UUID.randomUUID().toString().replace("-","");
        this.deleted = "N";
    }
}
