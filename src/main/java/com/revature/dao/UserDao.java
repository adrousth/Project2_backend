package com.revature.dao;

import com.revature.model.User;
import com.revature.utility.ConnectionUtility;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        try (Connection con = ConnectionUtility.createConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username = ? AND " +
                    "user_password = ?");

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(rs.getInt("user_id"), rs.getString("username"),
                        rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("company"), rs.getString("user_password"),
                        rs.getString("position_role"));
            } else {
                return null;
            }

        }
    }

}
