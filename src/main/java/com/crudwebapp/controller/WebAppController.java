package com.crudwebapp.controller;

import com.crudwebapp.model.Login;
import com.crudwebapp.service.LoginService;
import com.crudwebapp.service.RegisterService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author nikesh.maharjan
 */
@Controller
@SessionAttributes("userId")
public class WebAppController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterService registerService;

    private static final int INVALID_ID = 0;

    @RequestMapping(value = {"login", "/"}, method = GET)
    public String showLoginPage(HttpServletRequest req) {
        return "redirect:/albums";
//        HttpSession s = req.getSession(false);
//        if (s == null) {
//            return "login";
//        } else if (s.getAttribute("userId") == null) {
//            return "login";
//        }
//        return "redirect:/albums";
    }

    @RequestMapping(value = {"/login"}, method = POST)
    public String processLogin(Login login, RedirectAttributes redir) {
        int id = loginService.validateLogin(login);
        if (id == INVALID_ID) {
            redir.addFlashAttribute("errorMessage", "Invalid username or password.");
            return "redirect:/";
        }
        redir.addFlashAttribute("userId", id);
        return "redirect:/info";
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegisterPage() {
        return "register";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegisteration(Login login, RedirectAttributes redir) {
        Login l = (Login) registerService.registerUser(login);
        if (l == null) {
            redir.addFlashAttribute("errorMessage", "Registeration failed.");
            return "redirect:/register";
        } else {
            redir.addFlashAttribute("loginInfo", l);
        }
        return "redirect:/registered";
    }

    @RequestMapping(value = "/info", method = GET)
    public String showLoginInfo(Model model) {
        return "info";
    }

    @RequestMapping(value = "/registered", method = GET)
    public String showRegisterationInfo() {
        return "registered";
    }

}
