package com.example.demo.vo;

import com.example.demo.repository.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class PostsVo {

    private Long pokey;
    private String compcd;
    private String orgcd;
    private String whcd;
    private String title;
    private String content;
    private String terminalcd;
    private String addusercd;
    private String adddatetime;
    private String updusercd;
    private String upddatetime;

    public PostsVo(Posts entity) {
        pokey = entity.getPokey();
        compcd = entity.getCompcd();
        orgcd = entity.getOrgcd();
        whcd = entity.getWhcd();
        title = entity.getTitle();
        content = entity.getContent();
        terminalcd = entity.getTerminalcd();
        addusercd = entity.getAddusercd();
        adddatetime = toStringDateTime(entity.getAdddatetime());
        updusercd = entity.getUpdusercd();
        upddatetime = toStringDateTime(entity.getUpddatetime());
    }

    @Builder
    public PostsVo(Long pokey, String compcd, String orgcd, String whcd, String title, String content, String terminalcd, String addusercd, String updusercd){
        this.pokey = pokey;
        this.compcd = compcd;
        this.orgcd = orgcd;
        this.whcd = whcd;
        this.title = title;
        this.content = content;
        this.terminalcd = terminalcd;
        this.addusercd = addusercd;
        this.updusercd = updusercd;
    }

    public Posts toEntity(){
        return Posts.builder()
                .pokey(pokey)
                .compcd(compcd)
                .orgcd(orgcd)
                .whcd(whcd)
                .content(content)
                .title(title)
                .terminalcd(terminalcd)
                .build();
    }

    /**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }


}
