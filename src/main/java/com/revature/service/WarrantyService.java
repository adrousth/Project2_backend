package com.revature.service;

import com.revature.dao.WarrantyDao;
import com.revature.exception.InvalidParameterException;
import com.revature.model.DeviceWarranty;

import java.sql.Date;
import java.util.*;

public class WarrantyService {
    private final Set<String> DEVICE_TYPES = new HashSet<>(Arrays.asList("hospital bed","MRI","syringes","EKGs","heart moniter","respirator"));
    private WarrantyDao warrantyDao;

    public WarrantyService() {
        this.warrantyDao = new WarrantyDao();
    }

    public List<DeviceWarranty> getWarrantiesByUsername(String username) {
        return warrantyDao.getWarrantiesByUsername(username);
    }

    public List<DeviceWarranty> getAllWarranties() {
        return warrantyDao.getAllWarranties();
    }

    public DeviceWarranty addNewWarranty(Map<String, String> newWarranty, String username) throws InvalidParameterException {
        DeviceWarranty warranty = new DeviceWarranty();
        warranty.setWarrantyRequester(username);
        InvalidParameterException exceptions = new InvalidParameterException();
        String deviceType = newWarranty.get("deviceType");
        if (deviceType == null) {
            exceptions.addMessage("Must have device type.");
        } else {
            if (!DEVICE_TYPES.contains(deviceType)) {
                exceptions.addMessage("Device type '" + deviceType + "' is not a valid device type");
            } else {
                warranty.setDeviceType(deviceType);
            }
        }
        String issueDate = newWarranty.get("warrantyIssueDate");
        if (issueDate == null) {
            exceptions.addMessage("Must have warranty issue date");
        } else {
            try {
                Date warrantyIssueDate = Date.valueOf(issueDate);
                warranty.setWarrantyIssueDate(warrantyIssueDate);
            } catch (IllegalArgumentException e) {
                exceptions.addMessage("Warranty issue date " + issueDate + " is invalid, please enter date in the YYYY-MM-DD");
            }
        }
        String expirationDate = newWarranty.get("warrantyExpirationDate");
        if (expirationDate == null) {
            exceptions.addMessage("Must have warranty expiration date.");
        } else {
            try {
                Date warrantyExpirationDate = Date.valueOf(expirationDate);
                warranty.setWarrantyExpirationDate(warrantyExpirationDate);
            } catch (IllegalArgumentException e) {
                exceptions.addMessage("Warranty issue date " + expirationDate + " is invalid, please enter date in the YYYY-MM-DD");
            }
        }
        if (warranty.getWarrantyIssueDate() != null && warranty.getWarrantyExpirationDate() != null) {
            if (warranty.getWarrantyIssueDate().after(warranty.getWarrantyExpirationDate())) {
                exceptions.addMessage("Warranty issue date must be before warranty expiration date");
            }
        }
        String amount = newWarranty.get("warrantyAmount");
        if (amount == null) {
            exceptions.addMessage("Must have warranty amount.");
        } else {
            try {
                float warrantyAmount = Float.parseFloat(amount);
                if (warrantyAmount < 0) {
                    exceptions.addMessage("Warranty amount must be positive.");
                }
                warranty.setWarrantyAmount(warrantyAmount);
            } catch (NumberFormatException e) {
                exceptions.addMessage("Warranty amount " + amount + " is invalid, please enter a valid numeric amount");
            }
        }

        if (exceptions.containsMessage()) {
            throw exceptions;
        }

        return warrantyDao.addNewWarranty(warranty);

    }

    public List<DeviceWarranty> updateWarranty(Map<String, String> warranties, String username) {
        return warrantyDao.updateWarranty(warranties, username);
    }
}
