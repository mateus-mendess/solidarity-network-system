package model.repository;

import model.connection.ConnectionFactory;
import model.entities.NGO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class NGORepository {
    private Connection connection;

    public NGORepository() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void insertNGO(NGO ngo) {
        String sql = """
                INSERT INTO ngo(cnpj, name, phone, email, address, ngoRepresentative)
                VALUES(?, ?, ?, ?, ?, ?);
                """;
       try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {

           stmt.setString(1, ngo.getCnpj());
           stmt.setString(2, ngo.getName());
           stmt.setString(3, ngo.getPhone());
           stmt.setString(4, ngo.getEmail());
           stmt.setString(5, ngo.getAddress().getCep());
           stmt.setString(6, ngo.getNgoRepresentative().getCpf());

           stmt.execute();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
}
