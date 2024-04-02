package com.erichgamma.api.user;

import com.erichgamma.api.article.Article;
import com.erichgamma.api.enums.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl service;
    private final UserRepository repo;

    @PostMapping("/api/login")
    public Map<String, ?> login(@RequestBody Map<?, ?> paramap) {
        Map<String, Messenger> map = new HashMap<>();
        String userName = (String) paramap.get("username");
        String pw = (String) paramap.get("password");
        User dbUser = repo.findByUsername(userName).orElse(null);
        if (dbUser == null) {
            map.put("message", Messenger.FAIL);
        } else if (!dbUser.getPassword().equals(pw)) {
            map.put("message", Messenger.WRONG_PASSWORD);
        } else {
            map.put("message", Messenger.SUCCESS);
        }
        return map;
    }

    @PostMapping("/api/join")
    public Map<String, ?> join(@RequestBody Map<?, ?> paramap) {
        String strHeight = String.valueOf(paramap.get("height"));
        String strWeight = String.valueOf(paramap.get("weight"));

        User newUser = repo.save(User.builder()
                .username((String) paramap.get("username"))
                .password((String) paramap.get("password"))
                .name((String) paramap.get("name"))
                .phone((String) paramap.get("phone"))
                .job((String) paramap.get("job"))
                .height(Double.valueOf(strHeight))
                .weight(Double.valueOf(strWeight))
                .build());

        System.out.println("DB에 저장된: " + newUser);
        Map<String, Messenger> map = new HashMap<>();
        map.put("result", Messenger.SUCCESS);
        return map;
    }

    @GetMapping("/api/all-users")
    public Map<?, ?> findAll() {
        return Map.of("result",
                List.of(User.builder()
                        .id(0l)
                        .username("username")
                        .password("password")
                        .name("name")
                        .phone("phone")
                        .job("job")
                        .height(1.1)
                        .weight(1.1)
                        .build()));
    }
}
