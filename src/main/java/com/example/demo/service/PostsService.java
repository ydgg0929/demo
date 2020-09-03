package com.example.demo.service;

import com.example.demo.repository.PostsRepository;
import com.example.demo.vo.PostsVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostsService {

    private PostsRepository postsRepository;

//    @Transactional(readOnly = true)
//    public List<PostsVo> findAll() {
//        List<PostsVo> resultList = new ArrayList<>();
//        postsRepository.findAll().forEach(e -> resultList.add(e));
//        return resultList;
//    }
//
//    @Transactional(readOnly = true)
//    public List<PostsVo> findAllDesc() {
//        return postsRepository.findAllDesc()
//                .map(PostsVo::new)
//                .collect(Collectors.toList());
//    }
//
//    @Transactional(readOnly = true)
//    public Optional<PostsVo> findByPokey(Long pokey){
//        //Optional<PostsVo> result = postsRepository.findByPokey(pokey);
//        return postsRepository.findByPokey(pokey)
//                .map(PostsVo::new)
//                .findFirst();
//    }
    
    //전체 조회
    @Transactional(readOnly = true)
    public List<PostsVo> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsVo::new)
                .collect(Collectors.toList());
    }
    
    //조건 조회
    @Transactional(readOnly = true)
    public Optional<PostsVo> findById(Long pokey){
        return postsRepository.findById(pokey)
                .map(PostsVo::new);
    }
    
    //삭제
    @Transactional
    public void deleteByPokey(Long pokey){
        postsRepository.deleteByPokey(pokey);
    }
    
    //저장
    @Transactional
    public Long save(PostsVo dto){
        return postsRepository.save(dto.toEntity()).getPokey();
    }


    //수정
    @Transactional
    public Long updateByPokey(Long pokey, PostsVo dto){
        Optional<PostsVo> e = postsRepository.findById(pokey)
                .map(PostsVo::new);

        if(e.isPresent()){
            e.get().builder()
                    .pokey(dto.getPokey())
                    .compcd(dto.getCompcd())
                    .orgcd(dto.getOrgcd())
                    .whcd(dto.getWhcd())
                    .title(dto.getTitle())
                    .content(dto.getContent())
                    .addusercd("ydg0929")
                    .updusercd("updusercd")
                    .build();
            postsRepository.save(e.get().toEntity());
        }

        /*if(e.isPresent()){
            postsRepository.save(dto.toEntity());
        }*/

//        e.ifPresent(postsVo -> {
//            postsVo.builder()
//                    .pokey(dto.getPokey())
//                    .compcd(dto.getCompcd())
//                    .orgcd(dto.getOrgcd())
//                    .whcd(dto.getWhcd())
//                    .title(dto.getTitle())
//                    .content(dto.getContent())
//                    .addusercd("ydg0929")
//                    .updusercd("updusercd")
//                    .build();
//
//            postsRepository.save(postsVo.toEntity());
//        });

        return dto.getPokey();
    }
}
