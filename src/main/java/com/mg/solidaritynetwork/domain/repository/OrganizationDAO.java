package com.mg.solidaritynetwork.domain.repository;


import com.mg.solidaritynetwork.domain.entity.Organization;
import com.mg.solidaritynetwork.exception.DataBaseException;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class OrganizationDAO {

    //service
    private final DataSource dataSource;

    public OrganizationDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertOrganization(Organization organization) {
        String sql = """
                INSERT INTO organization(id, cnpj, corporatename, about, profilepicture, coverphoto) VALUES
                (?, ?, ?, ?, ?, ?)
                """;

        Connection connection = DataSourceUtils.getConnection(dataSource);

        try(PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, organization.getId());
            statement.setString(2, organization.getCnpj());
            statement.setString(3, organization.getCorporateName());
            statement.setString(4, organization.getAbout());
            statement.setString(5, organization.getProfilePicture().getOriginalFilename());
            statement.setString(6, organization.getCoverPhoto().getOriginalFilename());

            statement.execute();

        } catch (SQLException e) {
            throw new DataBaseException("Erro no cadastro da organização ao banco de dados", e);
        }
    }

    public Boolean existsByCnpj(String cnpj) {
        String sql = """
                SELECT cnpj FROM organization
                WHERE cnpj = ?
                """;

        try (Connection connection = DataSourceUtils.getConnection(dataSource);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, cnpj);

            try(ResultSet set = statement.executeQuery()) {
                return set.next();
            }

        } catch (SQLException e) {
            throw new DataBaseException("Erro na verificação do cnpj", e.getCause());
        }
    }
}
