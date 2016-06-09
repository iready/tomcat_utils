package org.zyq.tomcat

import org.apache.commons.io.FileUtils
import org.zyq.tomcat.entity.Subject

/**
 * Created by Administrator on 2016/6/4.
 */
class CONFIG {
    public static Subject subject = new Subject();

    public static String defaultConfig = "D:/conf"

    static {
        if (new File(defaultConfig).exists()) getconfig();
    }
    public static void getconfig() {
        ObjectInputStream objectInputStream = new ObjectInputStream(FileUtils.openInputStream(new File(defaultConfig)));
        subject = (Subject) objectInputStream.readObject();
        objectInputStream.close();
    }
}
