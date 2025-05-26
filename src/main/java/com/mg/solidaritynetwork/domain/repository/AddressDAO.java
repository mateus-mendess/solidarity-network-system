package com.mg.solidaritynetwork.domain.repository;


import com.mg.solidaritynetwork.domain.entity.Address;
import com.mg.solidaritynetwork.exception.DataBaseException;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class AddressDAO {
    //service
    private DataSource dataSource;

    public AddressDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertAddress(Address address) {
        String sql = """
                INSERT INTO address(postalcode, neighborhood, street, state, city, latitude, longitude, id_ong) VALUES
                (?, ?, ?, ?, ?, ?, ?, ?);
                """;

        Connection connection = DataSourceUtils.getConnection(dataSource);

        try(PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, address.getPostalCode());
            statement.setString(2, address.getNeighborhood());
            statement.setString(3, address.getStreet());
            statement.setString(4, address.getState());
            statement.setString(5, address.getCity());
            statement.setDouble(6, address.getLatitude());
            statement.setDouble(7, address.getLongitude());
            statement.setLong(8, address.getId_ong().getId());

        } catch (SQLException e) {
            throw new DataBaseException("Erro no cadastro de endereço", e.getCause());
        }
    }
}
