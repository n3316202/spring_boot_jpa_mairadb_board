package edu.mariadb.ex.entity;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mvc_board")
public class Boards extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bid;

    @Column(length = 20, nullable = false)
    private String bwriter;

    @Column(length = 100, nullable = false)
    private String btitle;

    @Column(length = 1200, nullable = false)
    private String bcontent;

    private long bhit;

    private long bgroup;
    private long bstep;
    private long bindent;
}
