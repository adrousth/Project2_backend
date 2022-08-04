package com.revature.dao;

import com.revature.model.DeviceWarranty;
import com.revature.model.User;
import com.revature.utility.ConnectionUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class WarrantyDao {
    public List<DeviceWarranty> getWarrantiesByUsername(String username) {
        try (Connection con = ConnectionUtility.createConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM device_warranties WHERE warranty_requester = ?");

            ps.setString(1, username);


            ResultSet rs = ps.executeQuery();
            List<DeviceWarranty> warranties = new ArrayList<>();
            while (rs.next()) {
                int warrantyId = rs.getInt("warranty_id");
                int deviceId = rs.getInt("device_id");
                Date issueDate = rs.getDate("warranty_issue_date");
                Date warrantyExpirationDate = rs.getDate("warranty_expiration_date");
                float amount = rs.getFloat("warranty_amount");
                Date requestIssueDate = rs.getDate("request_issue_date");
                String recallStatus = rs.getString("recall_status");
                boolean confirmation = rs.getBoolean("confirmation");
                String requester = rs.getString("warranty_requester");
                String resolver = rs.getString("warranty_resolver");
                DeviceWarranty warranty = new DeviceWarranty(warrantyId, deviceId, issueDate, warrantyExpirationDate, amount, requestIssueDate, recallStatus, confirmation, requester, resolver);

                warranties.add(warranty); // Add user object to users List
            }
            return warranties;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DeviceWarranty> getAllWarranties() {
        try (Connection con = ConnectionUtility.createConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM device_warranties");




            ResultSet rs = ps.executeQuery();
            List<DeviceWarranty> warranties = new ArrayList<>();
            while (rs.next()) {
                int warrantyId = rs.getInt("warranty_id");
                int deviceId = rs.getInt("device_id");
                Date issueDate = rs.getDate("warranty_issue_date");
                Date warrantyExpirationDate = rs.getDate("warranty_expiration_date");
                float amount = rs.getFloat("warranty_amount");
                Date requestIssueDate = rs.getDate("request_issue_date");
                String recallStatus = rs.getString("recall_status");
                boolean confirmation = rs.getBoolean("confirmation");
                String requester = rs.getString("warranty_requester");
                String resolver = rs.getString("warranty_resolver");
                DeviceWarranty warranty = new DeviceWarranty(warrantyId, deviceId, issueDate, warrantyExpirationDate, amount, requestIssueDate, recallStatus, confirmation, requester, resolver);

                warranties.add(warranty); // Add user object to users List
            }
            return warranties;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DeviceWarranty addNewWarranty(DeviceWarranty newWarranty) {
        try (Connection con = ConnectionUtility.createConnection()) {

            PreparedStatement ps = con.prepareStatement("insert into device_warranties" +
                    "(device_id, warranty_issue_date, warranty_expiration_date, warranty_amount, warranty_requester)" +
                    "values (?, ?, ?, ?, ?) RETURNING *");

            ps.setInt(1, newWarranty.getDeviceId());
            ps.setDate(2, newWarranty.getWarrantyIssueDate());
            ps.setDate(3, newWarranty.getWarrantyExpirationDate());
            ps.setFloat(4, newWarranty.getWarrantyAmount());
            ps.setString(5, newWarranty.getWarrantyRequester());



            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new DeviceWarranty(rs.getInt("warranty_id"), rs.getInt("device_id"),
                        rs.getDate("warranty_issue_date"), rs.getDate("warranty_expiration_date"),
                        rs.getFloat("warranty_amount"), rs.getDate("request_issue_date"),
                        rs.getString("recall_status"), rs.getBoolean("confirmation"),
                        rs.getString("warranty_requester"), rs.getString("warranty_resolver"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DeviceWarranty updateWarranty(DeviceWarranty warrantyUpdate) {
        try (Connection con = ConnectionUtility.createConnection()) {

            PreparedStatement ps = con.prepareStatement("update device_warranties set recall_status = ?," +
                    "confirmation = true, warranty_resolver = ? where warranty_id = ? RETURNING *");

            ps.setString(1, warrantyUpdate.getRecallStatus());
            ps.setString(2, warrantyUpdate.getWarrantyResolver());
            ps.setInt(3, warrantyUpdate.getWarrantyId());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new DeviceWarranty(rs.getInt("warranty_id"), rs.getInt("device_id"),
                        rs.getDate("warranty_issue_date"), rs.getDate("warranty_expiration_date"),
                        rs.getFloat("warranty_amount"), rs.getDate("request_issue_date"),
                        rs.getString("recall_status"), rs.getBoolean("confirmation"),
                        rs.getString("warranty_requester"), rs.getString("warranty_resolver"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
