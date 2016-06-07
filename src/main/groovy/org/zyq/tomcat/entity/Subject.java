package org.zyq.tomcat.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Subject implements Serializable {
    private List<TomcatInfo> list = new ArrayList<>();

    private String workspace;
    private String JDKPath;

    public String getJDKPath() {
        return JDKPath;
    }

    public void setJDKPath(String JDKPath) {
        this.JDKPath = JDKPath;
    }

    public List<TomcatInfo> getList() {
        return list;
    }

    public void setList(List<TomcatInfo> list) {
        this.list = list;
    }

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

}
