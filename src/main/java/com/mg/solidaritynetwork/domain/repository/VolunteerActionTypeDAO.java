package com.mg.solidaritynetwork.domain.repository;

import com.mg.solidaritynetwork.domain.entity.VolunteerActionType;
import com.mg.solidaritynetwork.exception.DataBaseException;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class VolunteerActionTypeDAO {

    private final DataSource dataSource;

    public VolunteerActionTypeDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertVolunteerActionType(VolunteerActionType volunteerActionType) {
        String sql = """
                INSERT INTO volunteer_actiontype(id_volunteer, id_actiontype) VALUES 
                (?, ?);""";

        Connection connection = DataSourceUtils.getConnection(dataSource);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            for (Long idActionType : volunteerActionType.getIdActionTypes()) {
                statement.setLong(1, volunteerActionType.getIdVolunteer());
                statement.setLong(2, idActionType);

                statement.execute();
            }

        } catch (SQLException e) {
            throw  new DataBaseException("Erro de conexão com o database.", e.getCause());
        }
    }
}
