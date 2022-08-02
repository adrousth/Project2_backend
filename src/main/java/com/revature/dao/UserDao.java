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
                return new User(rs.getInt("userId"), rs.getString("username"),
                        rs.getString("firstName"), rs.getString("lastName"),
                        rs.getString("company"), rs.getString("password"),
                        rs.getString("positionRole"));
            } else {
                return null;
            }

        }
    }

}
