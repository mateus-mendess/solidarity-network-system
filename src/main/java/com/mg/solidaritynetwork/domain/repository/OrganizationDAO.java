package com.mg.solidaritynetwork.domain.repository;


import com.mg.solidaritynetwork.domain.entity.Organization;
import com.mg.solidaritynetwork.exception.DataBaseException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class OrganizationDAO {

    private final JdbcTemplate jdbcTemplate;

    public OrganizationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertOrganization(Organization organization) throws SQLException {
        String sql = """
                INSERT INTO organization(id, cnpj, corporatename, about, profilepicture, coverphoto) VALUES
                (?, ?, ?, ?, ?, ?)
                """;

        jdbcTemplate.update(
                sql, organization.getId(),
                organization.getCnpj(), organization.getCorporateName(),
                organization.getAbout(), organization.getProfilePicture().getOriginalFilename(),
                organization.getCoverPhoto().getOriginalFilename()
        );
    }

    public Boolean existsByCnpj(String cnpj) {
        String sql = """
                SELECT COUNT(*) FROM organization
                WHERE cnpj = ?
                """;

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, cnpj);

        return count != null && count > 0;
    }
}
