package com.droidzilla.apiary.service;

import com.droidzilla.apiary.model.Backup;
import com.droidzilla.apiary.model.Beekeeper;
import com.droidzilla.apiary.repository.BackupRepository;
import com.droidzilla.apiary.repository.BeekeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created by ac on 22/10/16.
 */
@Service
public class BackupService {

    @Autowired
    private BeekeeperRepository beekeeperRepository;

    @Autowired
    private BackupRepository backupRepository;

    //    @PreAuthorize("#email == principal.username")
    public void uploadBackup(int hiveId, String content) {
        System.out.println("upload backup :" + hiveId);
        System.out.println("current user:" + ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        Beekeeper beekeeper = beekeeperRepository.findByEmail(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());

        List<Backup> allBackups = backupRepository.findByBeekeeperIdAndHiveId(beekeeper.id, hiveId);

        Backup lastBackup = allBackups.size() > 0 ? allBackups.get(0)  : null;
        for (Backup backup : allBackups) {
            if (backup.getVersion() > lastBackup.getVersion()) {
                lastBackup = backup;
            }
        }

        int version = lastBackup != null ? lastBackup.getVersion() + 1 : 1;

        Backup backup = new Backup();
        backup.setBeekeeperId(beekeeper.id);
        backup.setVersion(version);
        backup.setCreationTimestamp(Calendar.getInstance().getTimeInMillis());
        backup.setHiveId(hiveId);
        backup.setContent(content);

        backupRepository.save(backup);
    }

    //    @Secured("ROLE_USER")
    @PreAuthorize("#email == principal.username")
    public void getBeekeeperInfo(String email) {
        System.out.println("get user info user:" + email + "  ");
    }

    public String getBackup(int hiveId) throws BackupNotAvailableException {
        System.out.println("upload backup :" + hiveId);
        System.out.println("current user:" + ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        Beekeeper beekeeper = beekeeperRepository.findByEmail(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());

        List<Backup> allBackups = backupRepository.findByBeekeeperIdAndHiveId(beekeeper.id, hiveId);

        Backup lastBackup = allBackups.size() > 0 ? allBackups.get(0)  : null;
        for (Backup backup : allBackups) {
            if (backup.getVersion() > lastBackup.getVersion()) {
                lastBackup = backup;
            }
        }

        if (lastBackup == null) {
            throw new BackupNotAvailableException();
        }
        return lastBackup.getContent();
    }
}
