package com.mg.solidaritynetwork.domain.repository;

import com.mg.solidaritynetwork.domain.entity.Volunteer;
import com.mg.solidaritynetwork.exception.DataBaseException;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class VolunteerDAO {
    private final DataSource dataSource;

    public VolunteerDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertVolunteer(Volunteer volunteer) throws SQLException {
        String sql = """
                    INSERT INTO volunteer(id, cpf, lastname, birthdate, gender, profilepicture, profession, permission) VALUES 
                    (?, ?, ?, ?, ?::gendertype, ?, ?, ?);
                    """;

        Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, volunteer.getId());
            statement.setString(2, volunteer.getCpf());
            statement.setString(3, volunteer.getLastName());
            statement.setDate(4, Date.valueOf(volunteer.getBirthDate()));
            statement.setString(5, volunteer.getGender().getLabel());
            statement.setString(6, volunteer.getProfilePicture().getOriginalFilename());
            statement.setString(7, volunteer.getProfession());
            statement.setBoolean(8, volunteer.getPermission());

            statement.execute();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Boolean existsByCpf(String cpf) {
        String sql = """
                SELECT cpf FROM volunteer
                WHERE cpf = ?;
                """;

        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, cpf);

            try(ResultSet set = statement.executeQuery()) {
                return set.next();
            }

        } catch (SQLException e) {
            throw new DataBaseException("Erro de verificação do cpf no database", e.getCause());
        }
    }
}
