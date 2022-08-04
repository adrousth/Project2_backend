package com.revature.service;

import com.revature.dao.WarrantyDao;
import com.revature.model.DeviceWarranty;

import java.util.List;
import java.util.Map;

public class WarrantyService {

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

    public DeviceWarranty addNewWarranty(DeviceWarranty newWarranty) {
        // TODO add business logic!!!
        return warrantyDao.addNewWarranty(newWarranty);

    }

    public List<DeviceWarranty> updateWarranty(Map<String, String> warranties, String username) {
        // TODO add business logic!!!
        return warrantyDao.updateWarranty(warranties, username);
    }
}
