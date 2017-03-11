package com.droidzilla.apiary.repository;

import com.droidzilla.apiary.model.Beekeeper;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * Created by ac on 15/10/16.
 */
public interface BeekeeperRepository  extends MongoRepository<Beekeeper, String> {

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Beekeeper save(Beekeeper entity);

    Beekeeper findByEmail(String email);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<Beekeeper> findAll();
}
