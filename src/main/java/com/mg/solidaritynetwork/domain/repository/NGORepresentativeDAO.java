package com.mg.solidaritynetwork.domain.repository;

import com.mg.solidaritynetwork.domain.entity.NGORepresentative;
import com.mg.solidaritynetwork.exception.DataBaseException;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class NGORepresentativeDAO {

    //service
    private final DataSource dataSource;

    public NGORepresentativeDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertRepresentative(NGORepresentative representative) {
        String sql = """
                INSERT INTO ngorepresentative(cpf, name, lastname, birthdate, gender, phone) VALUES
                (?, ?, ?, ?, ?::gendertype, ?);
                """;

        Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, representative.getCpf());
            statement.setString(2, representative.getName());
            statement.setString(3, representative.getLastname());
            statement.setDate(4, Date.valueOf(representative.getBirthdate()));
            statement.setString(5, representative.getGender().getLabel());
            statement.setString(5, representative.getPhone());

            statement.execute();

        } catch (SQLException e) {
            throw new DataBaseException("Erro no cadastro de representante no banco de dados.", e.getCause());
        }
    }
}
