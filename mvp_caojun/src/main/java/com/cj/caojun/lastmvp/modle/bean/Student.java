package com.cj.caojun.lastmvp.modle.bean;

import java.util.ArrayList;

/**
 * Created by caojun on 2017/11/3.
 */

public class Student {
    private String name;
    private ArrayList<Project> projects;

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
