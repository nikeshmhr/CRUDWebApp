package com.crudwebapp.data;

import com.crudwebapp.model.Login;
import com.crudwebapp.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nikesh.maharjan
 */
@Repository
public class RegisterDAO implements RegisterService {

    @Autowired
    private JdbcOperations jdbc;

    @Override
    public Object registerUser(Object o) {
        Login login = (Login) o;
        try {
            jdbc.update("INSERT INTO appusers VALUES(?, ?)",
                    login.getUsername(),
                    login.getPassword()
            );
        } catch (DataAccessException ex) {
            System.out.println("ERROR EXCEPTION: " + ex.getMessage());
            return null;
        }

        return login;
    }

}
