package model.repository;

import model.connection.ConnectionFactory;
import model.entities.NGORepresentative;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class NGORepresentativeRepository {
    private Connection connection;

    public NGORepresentativeRepository() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void insertNGORepresentative(NGORepresentative ngoRepresentative) {
        String sql = """
                INSERT INTO ngoRepresentative(cpf, name, age, email, phone, ngo_id)
                VALUES(?, ?, ?, ?, ?, ?);
                """;

        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {

            stmt.setString(1, ngoRepresentative.getCpf());
            stmt.setString(2, ngoRepresentative.getName());
            stmt.setInt(3, ngoRepresentative.getAge());
            stmt.setString(4, ngoRepresentative.getEmail());
            stmt.setString(5, ngoRepresentative.getPhone());
            stmt.setString(6, ngoRepresentative.getOngs().getCnpj());

            stmt.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
