package com.mg.solidaritynetwork.domain.repository;

import com.mg.solidaritynetwork.domain.entity.Author;
import com.mg.solidaritynetwork.exception.DataBaseException;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

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

        Connection connection = DataSourceUtils.getConnection(dataSource);

        try(PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

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

    public Boolean existsByEmail(String email) {
        String sql = """
                SELECT email FROM author
                WHERE email = ?;
                """;

        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);

            try (ResultSet set = statement.executeQuery())  {
                return set.next();
            }

        } catch (SQLException e) {
            throw new DataBaseException("Erro de verificação do email com o database", e.getCause());
        }
    }

}
