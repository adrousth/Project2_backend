package com.revature.service;

import com.revature.dao.WarrantyDao;
import com.revature.model.DeviceWarranty;

import java.util.List;

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
}
