package com.crudwebapp.service.impl;

import com.crudwebapp.data.RegisterDAO;
import com.crudwebapp.model.Login;
import com.crudwebapp.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 *
 * @author nikesh.maharjan
 */
@Service
@Primary
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterDAO dao;

    @Override
    public Object registerUser(Object obj) {
        return dao.registerUser((Login) obj);
    }

}
