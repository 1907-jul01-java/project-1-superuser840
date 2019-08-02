package com.revature.reimbursement.api.domain;

import java.util.List;

import com.revature.reimbursement.api.daos.Dao;

/**
 * ReimbursementService
 */
public class ReimbursementService implements Service<Reimbursement> {
    private Dao<Reimbursement> dao;

    public ReimbursementService(Dao<Reimbursement> dao) {
        this.dao = dao;
    }

    @Override
    public void insert(Reimbursement reimbursement) {
        this.dao.insert(reimbursement);
    }

    @Override
    public List<Reimbursement> getAll() {
        return dao.getAll();
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {
		
    }

}