package com.mg.solidaritynetwork.domain.repository;

import com.mg.solidaritynetwork.domain.entity.ActionType;
import com.mg.solidaritynetwork.exception.DataBaseException;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ActionTypeDAO {

    private  final DataSource dataSource;

    public ActionTypeDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<ActionType> findAllActionType() throws SQLException {

        String sql = """
                SELECT * FROM actionType;
                """;

        Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet set = statement.executeQuery()) {

            List<ActionType> actionTypes = new ArrayList<>();

            while (set.next()) {
                ActionType typeAction = new ActionType();

                typeAction.setId(set.getLong("id"));
                typeAction.setName(set.getString("name"));
                typeAction.setColor(set.getString("color"));

                actionTypes.add(typeAction);
            }

            return actionTypes;


        } catch (SQLException e) {
            throw  new DataBaseException("Erro de conexão com o database!", e);
        }
    }
}
