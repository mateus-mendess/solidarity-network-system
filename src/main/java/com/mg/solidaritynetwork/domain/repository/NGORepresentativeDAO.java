package com.mg.solidaritynetwork.domain.repository;

import com.mg.solidaritynetwork.domain.entity.NGORepresentative;
import com.mg.solidaritynetwork.exception.DataBaseException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class NGORepresentativeDAO {

    private final JdbcTemplate jdbcTemplate;

    public NGORepresentativeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertRepresentative(NGORepresentative representative) throws SQLException {
        String sql = """
                INSERT INTO ngorepresentative(cpf, name, lastname, birthdate, gender, phone) VALUES
                (?, ?, ?, ?, ?::gendertype, ?);
                """;

        jdbcTemplate.update(
                sql, representative.getCpf(),
                representative.getName(), representative.getLastname(),
                Date.valueOf(representative.getBirthdate()),
                representative.getGender().getLabel(),
                representative.getPhone()
        );
    }
}
