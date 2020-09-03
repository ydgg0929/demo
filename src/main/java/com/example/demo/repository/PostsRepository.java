package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

    void deleteByPokey(Long pokey);

    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.pokey DESC")
    Stream<Posts> findAllDesc();
}
