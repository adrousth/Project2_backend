package com.revature.model;

import java.sql.Date;
import java.util.Objects;

public class DeviceWarranty {
    private int warrantyId;

    private String deviceType;
    private Date warrantyIssueDate;
    private Date warrantyExpirationDate;
    private float warrantyAmount;
    private Date requestIssueDate;
    private String recallStatus;
    private boolean confirmation;
    private String warrantyRequester;
    private String warrantyResolver;
    public DeviceWarranty(){}

    public DeviceWarranty(int warrantyId, String deviceType, Date warrantyIssueDate, Date warrantyExpirationDate,
                          float warrantyAmount, Date requestIssueDate, String recallStatus, boolean confirmation,
                          String warrantyRequester, String warrantyResolver) {
        this.warrantyId = warrantyId;
        this.deviceType = deviceType;
        this.warrantyIssueDate = warrantyIssueDate;
        this.warrantyExpirationDate = warrantyExpirationDate;
        this.warrantyAmount = warrantyAmount;
        this.requestIssueDate = requestIssueDate;
        this.recallStatus = recallStatus;
        this.confirmation = confirmation;
        this.warrantyRequester = warrantyRequester;
        this.warrantyResolver = warrantyResolver;
    }

    public int getWarrantyId() {
        return warrantyId;
    }

    public void setWarrantyId(int warrantyId) {
        this.warrantyId = warrantyId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Date getWarrantyIssueDate() {
        return warrantyIssueDate;
    }

    public void setWarrantyIssueDate(Date warrantyIssueDate) {
        this.warrantyIssueDate = warrantyIssueDate;
    }

    public Date getWarrantyExpirationDate() {
        return warrantyExpirationDate;
    }

    public void setWarrantyExpirationDate(Date warrantyExpirationDate) {
        this.warrantyExpirationDate = warrantyExpirationDate;
    }

    public float getWarrantyAmount() {
        return warrantyAmount;
    }

    public void setWarrantyAmount(float warrantyAmount) {
        this.warrantyAmount = warrantyAmount;
    }

    public Date getRequestIssueDate() {
        return requestIssueDate;
    }

    public void setRequestIssueDate(Date requestIssueDate) {
        this.requestIssueDate = requestIssueDate;
    }

    public String getRecallStatus() {
        return recallStatus;
    }

    public void setRecallStatus(String recallStatus) {
        this.recallStatus = recallStatus;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    public String getWarrantyRequester() {
        return warrantyRequester;
    }

    public void setWarrantyRequester(String warrantyRequester) {
        this.warrantyRequester = warrantyRequester;
    }

    public String getWarrantyResolver() {
        return warrantyResolver;
    }

    public void setWarrantyResolver(String warrantyResolver) {
        this.warrantyResolver = warrantyResolver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceWarranty that = (DeviceWarranty) o;
        return warrantyId == that.warrantyId && deviceType == that.deviceType && Float.compare(that.warrantyAmount, warrantyAmount) == 0 && confirmation == that.confirmation && Objects.equals(warrantyIssueDate, that.warrantyIssueDate) && Objects.equals(warrantyExpirationDate, that.warrantyExpirationDate) && Objects.equals(requestIssueDate, that.requestIssueDate) && Objects.equals(recallStatus, that.recallStatus) && Objects.equals(warrantyRequester, that.warrantyRequester) && Objects.equals(warrantyResolver, that.warrantyResolver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warrantyId, deviceType, warrantyIssueDate, warrantyExpirationDate, warrantyAmount, requestIssueDate, recallStatus, confirmation, warrantyRequester, warrantyResolver);
    }

    @Override
    public String toString() {
        return "DeviceWarranty{" +
                "warrantyId=" + warrantyId +
                ", deviceType=" + deviceType +
                ", warrantyIssueDate=" + warrantyIssueDate +
                ", warrantyExpirationDate=" + warrantyExpirationDate +
                ", warrantyAmount=" + warrantyAmount +
                ", requestIssueDate=" + requestIssueDate +
                ", recallStatus='" + recallStatus + '\'' +
                ", confirmation=" + confirmation +
                ", warrantyRequester='" + warrantyRequester + '\'' +
                ", warrantyResolver='" + warrantyResolver + '\'' +
                '}';
    }
}
