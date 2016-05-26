package com.crudwebapp.service.impl;

import com.crudwebapp.data.LoginDAO;
import com.crudwebapp.model.Login;
import com.crudwebapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 *
 * @author nikesh.maharjan
 */
@Service
@Primary
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDAO dao;

    @Override
    public int validateLogin(Object o) {
        return dao.validateLogin((Login) o);
    }

}
