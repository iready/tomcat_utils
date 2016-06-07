package org.zyq.tomcat.entity;

import java.io.Serializable;

public class TomcatInfo implements Serializable {
    private String id;
    private String name;
    private Integer port;
    private Integer redPort;
    private Integer conPort;
    private Integer shutdownPort;
    private String version;
    private String status;

    public Integer getShutdownPort() {
        return shutdownPort;
    }

    public void setShutdownPort(Integer shutdownPort) {
        this.shutdownPort = shutdownPort;
    }

    public Integer getRedPort() {
        return redPort;
    }

    public void setRedPort(Integer redPort) {
        this.redPort = redPort;
    }

    public Integer getConPort() {
        return conPort;
    }

    public void setConPort(Integer conPort) {
        this.conPort = conPort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
