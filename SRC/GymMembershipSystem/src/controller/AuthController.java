package controller;

import dao.UserDAO;

public class AuthController {

    UserDAO dao = new UserDAO();

    public boolean login(String u,String p) throws Exception{

        return dao.login(u,p);

    }

}