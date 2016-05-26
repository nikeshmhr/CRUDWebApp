package com.crudwebapp.data;

import com.crudwebapp.model.Login;
import com.crudwebapp.service.LoginService;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nikesh.maharjan
 */
@Repository
public class LoginDAO implements LoginService {

    @Autowired
    private JdbcOperations jdbc;

    @Override
    public int validateLogin(Object o) {
        Login login = (Login) o;
        int id;
        try {
            id = jdbc.queryForObject("SELECT id FROM appusers WHERE username=? AND password=?",
                    new RowMapper<Integer>() {
                @Override
                public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return rs.getInt("id");
                }
            },
                    login.getUsername(),
                    login.getPassword()
            );
            return id;
        } catch (EmptyResultDataAccessException exception) {
            return 0;
        }
    }

}
