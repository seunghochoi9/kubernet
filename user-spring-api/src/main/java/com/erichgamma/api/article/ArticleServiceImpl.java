package com.erichgamma.api.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl  {
    private final ArticleRepository repo;

    public List findAll() throws SQLException {
        return repo.findAll();
    }

}
