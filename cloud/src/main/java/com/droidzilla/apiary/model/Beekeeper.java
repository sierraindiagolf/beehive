package com.droidzilla.apiary.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created by ac on 15/10/16.
 */
public class Beekeeper {

    @Id
    public String id;

    private String name;

    @Indexed(unique = true)
    private String email;

    private String password;

    private boolean confirmed;

    private int hivesAllowed;

    public Beekeeper() {
        super();

    }

    public Beekeeper(String name, String email, String password, boolean confirmed, int hivesAllowed) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmed = confirmed;
        this.hivesAllowed = hivesAllowed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public int getHivesAllowed() {
        return hivesAllowed;
    }

    public void setHivesAllowed(int hivesAllowed) {
        this.hivesAllowed = hivesAllowed;
    }
}
