package model.repository;

import model.connection.ConnectionFactory;
import model.entities.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddressRepository {
    private Connection connection;

    public AddressRepository() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void insertAddress(Address address) {
        String sql = """
                INSERT INTO address(id, street, neighborhood, city, state, cep, person)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {

            stmt.setLong(1, address.getId());
            stmt.setString(2, address.getStreet());
            stmt.setString(3, address.getNeighborhood());
            stmt.setString(4, address.getCity());
            stmt.setString(5, address.getState());
            stmt.setString(6, address.getCep());
            stmt.setString(7, address.getPerson().getCpf());

            stmt.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
