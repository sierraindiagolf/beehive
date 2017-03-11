package com.droidzilla.apiary.fo;

/**
 * Created by ac on 08/11/16.
 */
public class NewsReportFO {

    public enum TYPE {DONATION, INFORMATION, ADDS}

    private TYPE type;
    private String title;
    private String shortContent;
    private String content;

    public NewsReportFO() {
    }

    public NewsReportFO(TYPE type, String title, String shortContent, String content) {
        this.type = type;
        this.title = title;
        this.shortContent = shortContent;
        this.content = content;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
