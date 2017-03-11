package com.droidzilla.apiary.fo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ac on 08/11/16.
 */
public class LoginFO {
    private String fullName;
    private boolean authenticated;
    private boolean termsAndConditionsApproved;
    private List<NewsReportFO> newsReports = new LinkedList<>();
    private int hivesAllowed;

    public LoginFO() {
    }

    public LoginFO(String fullName, boolean authenticated, boolean termsAndConditionsApproved, List<NewsReportFO> newsReports, int hivesAllowed) {
        this.fullName = fullName;
        this.authenticated = authenticated;
        this.termsAndConditionsApproved = termsAndConditionsApproved;
        this.newsReports = newsReports;
        this.hivesAllowed = hivesAllowed;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public boolean isTermsAndConditionsApproved() {
        return termsAndConditionsApproved;
    }

    public void setTermsAndConditionsApproved(boolean termsAndConditionsApproved) {
        this.termsAndConditionsApproved = termsAndConditionsApproved;
    }

    public List<NewsReportFO> getNewsReports() {
        return newsReports;
    }

    public void setNewsReports(List<NewsReportFO> newsReports) {
        this.newsReports = newsReports;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getHivesAllowed() {
        return hivesAllowed;
    }

    public void setHivesAllowed(int hivesAllowed) {
        this.hivesAllowed = hivesAllowed;
    }

    @Override
    public String toString() {
        return "LoginFO{" +
                "fullName='" + fullName + '\'' +
                ", authenticated=" + authenticated +
                ", termsAndConditionsApproved=" + termsAndConditionsApproved +
                ", newsReports=" + newsReports +
                ", hivesAllowed=" + hivesAllowed +
                '}';
    }
}
