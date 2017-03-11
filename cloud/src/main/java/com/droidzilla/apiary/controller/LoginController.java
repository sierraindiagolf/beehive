package com.droidzilla.apiary.controller;

import com.droidzilla.apiary.fo.LoginFO;
import com.droidzilla.apiary.model.Beekeeper;
import com.droidzilla.apiary.repository.BeekeeperRepository;
import com.droidzilla.apiary.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ac on 15/10/16.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private BeekeeperRepository beekeeperRepository;

    @Autowired
    private LoginService loginService;

    @RequestMapping("")
    public String index() {
        return "Salut";
    }

    @RequestMapping("/info")
    public LoginFO getInfo() {
        return loginService.getLoginInfo();
    }
}
