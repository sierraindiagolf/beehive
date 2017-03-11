package com.droidzilla.apiary.model;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by ac on 15/10/16.
 */
public class Backup {
    @Id
    private String id;

    private String beekeeperId;

    private int hiveId;

    private int version;

    private Long creationTimestamp;

    private String content;

    public Backup() {
    }

    public Backup(String id, int version, String beekeeperId, int hiveId, String content) {
        this.id = id;
        this.version = version;
        this.beekeeperId = beekeeperId;
        this.hiveId = hiveId;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getHiveId() {
        return hiveId;
    }

    public void setHiveId(int hiveId) {
        this.hiveId = hiveId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBeekeeperId() {
        return beekeeperId;
    }

    public void setBeekeeperId(String beekeeperId) {
        this.beekeeperId = beekeeperId;
    }

    public Long getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Long creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }
}
