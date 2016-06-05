package org.zyq.tomcat.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/4.
 */
public class Subject implements Serializable {
    private List<TomcatInfo> list = new ArrayList<>();

    private String workspace;

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
