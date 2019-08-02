package com.revature.reimbursement.api.domain;

import java.util.List;

import com.revature.reimbursement.api.daos.Dao;

/**
 * UserService
 */
public class UserService implements Service<User> {
    private Dao<User> dao;

    public UserService(Dao<User> dao) {
        this.dao = dao;
    }

    @Override
    public void insert(User User) {
        this.dao.insert(User);
    }

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {
		
    }

}