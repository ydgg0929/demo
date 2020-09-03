package com.example.demo.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class PostsEntityRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
//    public void cleanup() {
//        /**
//         이후 테스트 코드에 영향을 끼치지 않기 위해
//         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
//         **/
//        postsRepository.deleteAll();
//    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        postsRepository.save(Posts.builder()
                .compcd("1000")
                .orgcd("C0014")
                .whcd("2000")
                .title("testtitle")
                .content("testcontent")
                .addusercd("ydg0929")
                .updusercd("ydg0929")
                .build());

        //when
        List<Posts> postsEntityList = postsRepository.findAll();

        //then
        Posts postsEntity = postsEntityList.get(0);
        assertThat(postsEntity.getCompcd(), is("1000"));
        assertThat(postsEntity.getOrgcd(), is("C0014"));
    }


}