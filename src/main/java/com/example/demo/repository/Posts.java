package com.example.demo.repository;

import com.example.demo.common.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pokey;

    @Column(length = 30, nullable = false)
    private String compcd;

    @Column(length = 30, nullable = false)
    private String orgcd;

    @Column(length = 30, nullable = false)
    private String whcd;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String terminalcd;

    private String addusercd;

    private String updusercd;

    @Builder
    public Posts(Long pokey, String compcd, String orgcd, String whcd, String title, String content, String terminalcd, String addusercd, String updusercd){
        this.pokey = pokey;
        this.compcd = compcd;
        this.orgcd = orgcd;
        this.whcd = whcd;
        this.title = title;
        this.content = content;
        this.addusercd = addusercd;
        this.updusercd = updusercd;
        this.terminalcd = terminalcd;
    }
}
