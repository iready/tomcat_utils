package org.zyq.tomcat.service

import org.apache.commons.io.FileUtils
import org.dom4j.Document
import org.dom4j.io.SAXReader
import org.dom4j.tree.DefaultElement
import org.zyq.core.lang.NumberUtils
import org.zyq.tomcat.CONFIG
import org.zyq.tomcat.entity.Subject
import org.zyq.tomcat.entity.TomcatInfo

class TomcztUtils {
    public
    static void edit_port(Integer port, Integer shutdown, Integer redirect, Integer connector_port, String xmlPath) {
        SAXReader sax = new SAXReader();
        File xml = new File(xmlPath);
        Document document = sax.read(xml);
        (document.selectSingleNode('//Server') as DefaultElement).addAttribute('port', "$shutdown");
        DefaultElement ele = document.selectNodes("//Service")[0] as DefaultElement;
        List<DefaultElement> conn = ele.selectNodes('//Connector');
        conn[0].addAttribute('port', "$port").addAttribute('redirectPort', "$redirect");
        conn[1].addAttribute('port', "${connector_port}").addAttribute('redirectPort', "$redirect");
        xml.write(document.asXML());
    }

    public static void edit_port(Integer port, Subject subject, String id) {
        List<TomcatInfo> tomcatInfos = subject.list;
        if (tomcatInfos != null) {
            Integer[] ports = createPort(subject);
            edit_port(port, ports[0], ports[1], ports[2], CONFIG.subject.getWorkspace() + '/' + id + '/conf/server.xml')
        }
    }

    private static Integer[] createPort(Subject subject) {
        List<TomcatInfo> tomcatInfos = subject.list;
        List<Integer> ports = new ArrayList<>();
        if (tomcatInfos != null) {
            ports.addAll(tomcatInfos.collect { return it.redPort });
            ports.addAll(tomcatInfos.collect { return it.conPort });
        }
        Integer[] integer = new Integer[3];
        integer[0] = NumberUtils.random_not_in_set(4000, 12000, ports);
        ports.add(integer[0]);
        integer[1] = NumberUtils.random_not_in_set(4000, 12000, ports);
        ports.add(integer[1]);
        integer[2] = NumberUtils.random_not_in_set(4000, 12000, ports);
        return integer;
    }

    public static void saveConfig() {
        ObjectOutputStream oos = new ObjectOutputStream(FileUtils.openOutputStream(new File(CONFIG.defaultConfig)));
        oos.writeObject(CONFIG.subject);
        oos.close();
    }

    public static void main(String[] args) {
        edit_port(9012, 312, 3123, 12312, 'D:\\Workspace/88c3a1bcbea64cd4a7421c55733bd00d/conf/server.xml')
    }
}
