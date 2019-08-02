package com.revature.reimbursement.api.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Reimbursement{
    private int id;
    private boolean approved;
    // private String imageURL;
    private String description;
    private float cost;
    private String employee;
    // private User user;

    public Reimbursement(){
    }

    public Reimbursement(int id, boolean approved, String description, float cost, String employee) {
        this.id = id;
        this.approved = approved;
        // this.imageURL = imageURL;
        this.description = description;
        this.cost = cost;
        this.employee = employee;
        // this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    // public String getImageURL() {
    //     return imageURL;
    // }

    // public void setImageURL(String imageURL) {
    //     this.imageURL = imageURL;
    // }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    // public User getUser() {
    //     return user;
    // }

    // public void setUser(User user) {
    //     this.user = user;
    // }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (approved ? 1231 : 1237);
        result = prime * result + Float.floatToIntBits(cost);
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + id;
        // result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reimbursement other = (Reimbursement) obj;
        if (approved != other.approved)
            return false;
        if (Float.floatToIntBits(cost) != Float.floatToIntBits(other.cost))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id != other.id)
            return false;
        // if (user == null) {
        //     if (other.user != null)
        //         return false;
        // } else if (!user.equals(other.user))
        //     return false;
        return true;
    }

    @Override
    public String toString() {
        return "Reimbursement [approved=" + approved + ", cost=" + cost + ", description=" + description + ", employee="
                + employee + ", id=" + id + "]";
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

   

}