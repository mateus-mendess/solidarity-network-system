package com.mg.solidaritynetwork.domain.repository;

import com.mg.solidaritynetwork.domain.entity.Volunteer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VolunteerDAO {
    private final DataSource dataSource;

    public VolunteerDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertVolunteer(Volunteer volunteer) throws SQLException {
        String sql = """
                    INSERT INTO volunteer(cpf, lastname, birthdate, gender, profilepicture, profession, permission) VALUES 
                    (?, ?, ?, ?, ?, ?, ?);
                    """;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, volunteer.getCpf());
            statement.setString(2, volunteer.getLastName());
            statement.setDate(3, Date.valueOf(volunteer.getBirthDate()));
            statement.setString(5, volunteer.getProfilePicture());
            statement.setString(6, volunteer.getProfession());
            statement.setBoolean(7, volunteer.getPermission());

            statement.execute();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
