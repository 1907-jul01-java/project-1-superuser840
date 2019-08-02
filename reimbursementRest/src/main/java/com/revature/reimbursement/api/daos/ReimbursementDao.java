package com.revature.reimbursement.api.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursement.api.domain.Reimbursement;
import com.revature.reimbursement.api.daos.Dao;


/**
 * ReimbursementDao
 */
public class ReimbursementDao implements Dao<Reimbursement> {
    Connection connection;
    
    public ReimbursementDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Reimbursement reimbursement) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into reimbursements(approved, description, cost, employee) values(?, ?, ?, ?)");
            pStatement.setBoolean(1, reimbursement.isApproved());
            pStatement.setString(2, reimbursement.getDescription());
            pStatement.setFloat(3, reimbursement.getCost());
            pStatement.setString(4, reimbursement.getEmployee());
            pStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public List<Reimbursement> getAllReimbursements() {
        Reimbursement reimbursement;
        List<Reimbursement> reimbursements = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from reimbursements");
            while (resultSet.next()) {
                reimbursement = new Reimbursement();
                reimbursement.setId(resultSet.getInt("id"));
                reimbursement.setApproved(resultSet.getBoolean("approved"));
                //reimbursement.setPassword(resultSet.getString("password"));
                reimbursement.setDescription(resultSet.getString("description"));
                reimbursement.setCost(resultSet.getFloat("cost"));
                reimbursement.setEmployee(resultSet.getString("employee"));
                reimbursements.add(reimbursement);
            }
        } catch (SQLException e) {

        }
        return reimbursements;
    }

    public Reimbursement getReimbursement(String employee){
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setEmployee(employee);
        try{
            PreparedStatement pStatement = connection.prepareStatement("select * from reimbursements where employee=(?)");
            pStatement.setString(1, reimbursement.getEmployee());
            ResultSet resultSet = pStatement.executeQuery();
            resultSet.next();
            reimbursement.setApproved(resultSet.getBoolean("approved"));
            reimbursement.setDescription(resultSet.getString("description"));
            reimbursement.setId(resultSet.getInt("id"));
            reimbursement.setCost(resultSet.getFloat("cost"));
        } catch(SQLException e) {

        }
        return reimbursement;
    }

    @Override
    public List<Reimbursement> getAll() {
       
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}