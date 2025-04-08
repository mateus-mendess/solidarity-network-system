package model.repository;

import model.connection.ConnectionFactory;
import model.entities.Volunteer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VolunteerRepository {
    private Connection connection;

    public VolunteerRepository() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void insertVolunteer(Volunteer volunteer) {
        String sql = """
                INSERT INTO volunteer(cpf, name, age, email, phone, gander, work, address)
                VALUES(?, ?, ?, ?, ?, ?, ?, ?);
                """;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {

            stmt.setString(1, volunteer.getCpf());
            stmt.setString(2, volunteer.getName());
            stmt.setInt(3, volunteer.getAge());
            stmt.setString(4, volunteer.getEmail());
            stmt.setString(5, volunteer.getPhone());
            stmt.setString(6, String.valueOf(volunteer.getGander()));
            stmt.setString(7, volunteer.getWork());
            stmt.setString(8, volunteer.getAddress().getCep());

            stmt.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
