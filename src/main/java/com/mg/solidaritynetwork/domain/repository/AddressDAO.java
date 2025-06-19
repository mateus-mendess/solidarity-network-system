package com.mg.solidaritynetwork.domain.repository;


import com.mg.solidaritynetwork.domain.entity.Address;
import com.mg.solidaritynetwork.exception.DataBaseException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class AddressDAO {

    private JdbcTemplate jdbcTemplate;

    public AddressDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertAddress(Address address) throws SQLException {
        String sql = """
                INSERT INTO address(postalcode, neighborhood, street, state, city, latitude, longitude, id_ong) VALUES
                (?, ?, ?, ?, ?, ?, ?, ?);
                """;

        jdbcTemplate.update(
                sql, address.getPostalCode(),
                address.getNeighborhood(), address.getStreet(),
                address.getState(), address.getCity(),
                address.getLatitude(), address.getLongitude(),
                address.getId_ong().getId()
        );
    }
}
