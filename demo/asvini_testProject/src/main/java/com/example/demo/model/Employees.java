package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Employees {
    @Id
    @GeneratedValue
    private int eno;
    private String ename;

    public int getEno()
    {return eno;}

    public String getEname() {
        return ename;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

}
