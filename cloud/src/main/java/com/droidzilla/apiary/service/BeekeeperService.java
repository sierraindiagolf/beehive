package com.droidzilla.apiary.service;

import com.droidzilla.apiary.model.Beekeeper;
import com.droidzilla.apiary.repository.BeekeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ac on 22/10/16.
 */
@Service
public class BeekeeperService {
    @Autowired
    private BeekeeperRepository beekeeperRepository;

    @Autowired
    private MailSender mailSender;

    private static final int FREE_HIVES_COUNT_ALLOWED = 10;
    private static final int MAX_HIVES_COUNT_ALLOWED = 1000;

    public boolean createBeekeeper(String name, String email, String password) {
        System.out.println("Creating user");
        Beekeeper beekeeper = new Beekeeper();
        beekeeper.setName(name);
        beekeeper.setEmail(email);
        beekeeper.setPassword(password);
        beekeeper.setConfirmed(false);
        beekeeper.setHivesAllowed(FREE_HIVES_COUNT_ALLOWED);

        System.out.println("" + beekeeper);

        beekeeperRepository.save(beekeeper);

        return sendConfirmationEmail(email);
    }

    @Secured("ROLE_ADMIN")
    public void createConfirmedBeekeeper(String name, String email, String password) {
        System.out.println("Creating user");
        Beekeeper beekeeper = new Beekeeper();
        beekeeper.setName(name);
        beekeeper.setEmail(email);
        beekeeper.setPassword(password);
        beekeeper.setConfirmed(true);
        beekeeper.setHivesAllowed(MAX_HIVES_COUNT_ALLOWED);

        System.out.println("" + beekeeper);

        beekeeperRepository.save(beekeeper);
    }

    private boolean sendConfirmationEmail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Apiary Tools email address confirmation");
        message.setText("Apiary Tools email addres");
        message.setTo(email);
        message.setFrom("backup@apiary.tools");
        try {
            mailSender.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

//    @Secured("ROLE_USER")
    @PreAuthorize("#email == principal.username")
    public void getBeekeeperInfo(String email) {
        System.out.println("get user info user:"+ email +  "  " );
    }

    public List<Beekeeper> getAllBeekeepers() {
        return beekeeperRepository.findAll();
    }
}
