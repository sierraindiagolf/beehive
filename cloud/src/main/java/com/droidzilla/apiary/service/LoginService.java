package com.droidzilla.apiary.service;

import com.droidzilla.apiary.fo.LoginFO;
import com.droidzilla.apiary.fo.NewsReportFO;
import com.droidzilla.apiary.model.Backup;
import com.droidzilla.apiary.model.Beekeeper;
import com.droidzilla.apiary.repository.BackupRepository;
import com.droidzilla.apiary.repository.BeekeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ac on 22/10/16.
 */
@Service
public class LoginService {

    @Autowired
    private BeekeeperRepository beekeeperRepository;

    public LoginFO getLoginInfo() {
        Beekeeper beekeeper = beekeeperRepository.findByEmail(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        boolean authenticated = true;
        boolean termsAndConditionApproved = true;

        List<NewsReportFO> newsReports = new LinkedList<>();

        System.out.println("Returning:"+ beekeeper.getName());
        return new LoginFO(beekeeper.getName(), authenticated, termsAndConditionApproved, newsReports, beekeeper.getHivesAllowed());
    }
}
