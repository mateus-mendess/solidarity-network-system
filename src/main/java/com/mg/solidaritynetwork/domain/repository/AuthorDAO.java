package com.mg.solidaritynetwork.domain.repository;

import com.mg.solidaritynetwork.domain.entity.Author;
import com.mg.solidaritynetwork.exception.DataBaseException;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class AuthorDAO {
    private final DataSource dataSource;

    public AuthorDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Long insertAuthor(Author author) throws SQLException {
        String sql = """
                INSERT INTO author(name, phone, email, password) VALUES
                (?, ?, ?, ?)
                """;

        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, author.getName());
            statement.setString(2, author.getPhone());
            statement.setString(3, author.getEmail());
            statement.setString(4, author.getPassword());

            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                return rs.getLong("id");
            } else {
                throw new SQLException("Falha ao obter o ID do autor inserido.");
            }

        } catch (SQLException e) {
            throw new DataBaseException("Erro de conexão com o database.", e.getCause());
        }
    }

}
