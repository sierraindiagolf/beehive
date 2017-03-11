package com.droidzilla.apiary.model;

import org.springframework.data.annotation.Id;

/**
 * Created by ac on 15/10/16.
 */
public class Gateway {
    @Id
    private String serialNumber;

    private boolean active;

    private String beekeeperEmail;

    private boolean locked;


}
