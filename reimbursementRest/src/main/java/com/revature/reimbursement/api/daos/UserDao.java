package com.revature.reimbursement.api.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursement.api.domain.User;
import com.revature.reimbursement.api.daos.*;


/**
 * UserDao
 */
public class UserDao implements Dao<User> {
    Connection connection;
    
    public UserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(User user) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into workers(firstname, lastname, email, password, usertype) values(?, ?, ?, ?, ?)");
            pStatement.setString(1, user.getFirstName());
            pStatement.setString(2, user.getLastName());
            pStatement.setString(3, user.getEmail());
            pStatement.setString(4, user.getPassword());
            pStatement.setString(5, user.getUserType());
            pStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public List<User> getAllEmployees() {
        User user;
        List<User> workers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from workers where usertype=employee");
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                //user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("firstname"));
                user.setLastName(resultSet.getString("lastname"));
                user.setUserType(resultSet.getString("usertype"));
                workers.add(user);
            }
        } catch (SQLException e) {

        }
        return workers;
    }

    public User getEmployee(String email){
        User user;
        try{
            PreparedStatement pStatement = connection.prepareStatement("select * from workers where email=(?)");

            ResultSet resultSet = statement.executeQuery("select * from workers where email=(?)");
        } catch(SQLException e) {

        }
        return user;
    }

    @Override
    public List<User> getAll() {
       
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}