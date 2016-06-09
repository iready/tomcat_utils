package org.zyq.tomcat.service

import org.apache.commons.io.FileUtils
import org.apache.commons.io.input.ReaderInputStream
import org.dom4j.Document
import org.dom4j.io.SAXReader
import org.dom4j.tree.DefaultElement
import org.zyq.core.lang.NumberUtils
import org.zyq.swing.SwingUtils
import org.zyq.tomcat.CONFIG
import org.zyq.tomcat.entity.Subject
import org.zyq.tomcat.entity.TomcatInfo
import org.zyq.tomcat.view.table_list.Tomcat_list

import javax.swing.*

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
            TomcatInfo info = getTomcatInfoById(id);
            info.setShutdownPort(ports[0])
            info.setRedPort(ports[1])
            info.setConPort(ports[2])
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


    public static void clearWorkSpace() {
        if (!handle_space_ex()) return;
        String[] s = new File(CONFIG.subject.workspace).list(new FilenameFilter() {
            boolean accept(File dir, String name) {
                if (new File(dir, name).isDirectory() && CONFIG.subject.list.find { it.id == name } == null) {
                    new File(dir, name).deleteDir();
                    return false;
                }
                return true;
            }
        });
        CONFIG.subject.list.findAll {
            if (!s.contains(it.id)) return true;
            return false;
        }.each {
            CONFIG.subject.list.remove(it);
            saveConfig();
            SwingUtils.setContent(new Tomcat_list().$$$getRootComponent$$$());
        }
    }

    public static boolean spaceExisted() {
        if (CONFIG.subject.getWorkspace() != null) {
            File f = new File(CONFIG.subject.getWorkspace());
            if (f.exists() && f.isDirectory()) return true;
        }
        return false;
    }

    public static boolean handle_space_ex() {
        if (!spaceExisted()) {
            JOptionPane.showMessageDialog(null, "工作目录不存在", "提示", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }

    public static TomcatInfo getTomcatInfoById(String id) {
        return CONFIG.subject.list.find { return it.id == id; };
    }

/**
 * 正常开启tomcat
 * @param id
 */
    public static void start_tomcat_normal(String id) {
        TomcatInfo info = getTomcatInfoById(id);
        if (info != null) {
            new Thread(new Runnable() {
                void run() {
                    String bin = "${CONFIG.subject.getWorkspace()}/$id/bin";
                    Process p = ("$bin\\catalina.bat run debug").execute(['JAVA_HOME=C:\\Program Files\\Java\\jdk1.7.0_67'], new File(bin));
                    new InputStreamReader(p.err, "UTF-8").text;
                }
            }).start();
        }
    }

    public static void stop_tomcat_normal(String id) {
        TomcatInfo info = getTomcatInfoById(id);
        if (info != null) {
            new Thread(new Runnable() {
                void run() {
                    String bin = "${CONFIG.subject.getWorkspace()}/$id/bin";
                    Process p = ("$bin\\catalina.bat stop").execute(['JAVA_HOME=C:\\Program Files\\Java\\jdk1.7.0_67'], new File(bin));
                }
            }).start();
        }
    }
/**
 * 测试端口是否被占用
 * @param port
 * @return true 为被占用
 */
    public static boolean duankouzhanyong(Integer port) {
        def p = "cmd /c netstat -aon|findstr \"$port\"".execute();
        return !p.text.isEmpty()
    }

    public static void main(String[] args) {
//        edit_port(9012, 312, 3123, 12312, 'D:\\Workspace/88c3a1bcbea64cd4a7421c55733bd00d/conf/server.xml')
//        println duankouzhanyong(3309)
    }
}
