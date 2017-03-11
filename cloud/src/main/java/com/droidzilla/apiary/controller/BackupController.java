package com.droidzilla.apiary.controller;

import com.droidzilla.apiary.model.Beekeeper;
import com.droidzilla.apiary.repository.BeekeeperRepository;
import com.droidzilla.apiary.service.BackupNotAvailableException;
import com.droidzilla.apiary.service.BackupService;
import com.droidzilla.apiary.service.BeekeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BackupController {

    @Autowired
    private BackupService backupService;

    @RequestMapping(value = "/backup/hiveId/{hiveId}", method = RequestMethod.POST)
    public void uploadBackup(@PathVariable("hiveId") int hiveId, String content) {
        backupService.uploadBackup(hiveId, content);
    }

    @RequestMapping(value = "/backup/hiveId/{hiveId}", method = RequestMethod.GET)
    public String getBackup(@PathVariable("hiveId") int hiveId) {
        try {
            return backupService.getBackup(hiveId);
        } catch (BackupNotAvailableException e) {
            throw new ResourceNotFoundException();
        }
    }

}
