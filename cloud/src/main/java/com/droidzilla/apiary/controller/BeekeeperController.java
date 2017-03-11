package com.droidzilla.apiary.controller;

import com.droidzilla.apiary.model.Beekeeper;
import com.droidzilla.apiary.repository.BeekeeperRepository;
import com.droidzilla.apiary.service.BeekeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BeekeeperController {

    @Autowired
    private BeekeeperService beekeeperService;

    @RequestMapping("/beekeeper/add/name/{name}/email/{email}/{email2}password/{password}/{password2}")
    public void registerBeekeeper(@PathVariable("name") String name, @PathVariable("email") String email, @PathVariable("email2") String email2, @PathVariable("password") String password, @PathVariable("password2̵") String password2) {
        if (!email.equals(email2)) {
            throw new BadRequestException();
        }
        if (!password.equals(password2)) {
            throw new BadRequestException();
        }
//        beekeeperService.createBeekeeper(name, email, password);

    }

    @RequestMapping("/beekeeper/add/name/{name}/email/{email}/password/{password}")
    public void addBeekeeper(@PathVariable("name") String name, @PathVariable("email") String email, @PathVariable("password") String password) {
        beekeeperService.createConfirmedBeekeeper(name, email, password);
    }

    @RequestMapping("/beekeeper/get/email/{email}")
    public void getBeekeeperInfo(@PathVariable("email") String email) {
        System.out.println("Controller:" + email);
        beekeeperService.getBeekeeperInfo(email);
    }

    @RequestMapping("/beekeepers")
    public List<Beekeeper> getAllBeekeepers() {
        return beekeeperService.getAllBeekeepers();
    }
}
