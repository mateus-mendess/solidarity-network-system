package com.mg.solidaritynetwork.domain.repository;

import com.mg.solidaritynetwork.domain.entity.Author;
import com.mg.solidaritynetwork.exception.DataBaseException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Repository
public class AuthorDAO {
    private final JdbcTemplate jdbcTemplate;

    public AuthorDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long insertAuthor(Author author) throws SQLException {
        String sql = """
                INSERT INTO author(name, phone, email, password) VALUES
                (?, ?, ?, ?)
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(sql, new String[] {"id"});
            statement.setString(1, author.getName());
            statement.setString(2, author.getPhone());
            statement.setString(3, author.getEmail());
            statement.setString(4, author.getPassword());
            return statement;
        }, keyHolder);

        return  keyHolder.getKey().longValue();
    }


    public Boolean existsByEmail(String email) {
        String sql = """
                SELECT COUNT(*) FROM author
                WHERE email = ?;
                """;

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);

        return count != null && count > 0;
    }

}
