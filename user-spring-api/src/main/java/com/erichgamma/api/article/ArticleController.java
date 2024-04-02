package com.erichgamma.api.article;

import com.erichgamma.api.enums.Messenger;
import com.erichgamma.api.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleServiceImpl service;
    private final ArticleRepository repo;

    @GetMapping("/api/all-articles")
    public Map<?, ?> findAll() throws SQLException {
//        Map<String, Object> map = new HashMap<>();
//        map.put("message", Messenger.SUCCESS);
//        @SuppressWarnings("unchecked")
//        List<Article> list = new ArrayList<>();
////        list.add(Article.builder()
////                .id(Long.valueOf(1))
////                .title("제목")
////                .content("내용")
////                .writer("작성자")
////                .registerDate("작성일")
////                .build());
//
//        list = service.findAll();
//        System.out.println(map.get("message"));
//        System.out.println("성공");
//        map.put("result", list);
//        return map;
        return Map.of(
                "message",Messenger.SUCCESS,
                "result", List.of(Article.builder().id(0l).title("제목").content("내용").registerDate("작성일").build())
        );
    }

}
