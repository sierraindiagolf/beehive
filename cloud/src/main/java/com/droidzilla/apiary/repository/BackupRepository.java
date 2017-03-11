package com.droidzilla.apiary.repository;

import com.droidzilla.apiary.model.Backup;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by ac on 15/10/16.
 */
public interface BackupRepository extends MongoRepository<Backup, String> {
    
    public List<Backup> findByBeekeeperIdAndHiveId(String beekeeperId, int hiveId);
}
