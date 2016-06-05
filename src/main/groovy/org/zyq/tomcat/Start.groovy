package org.zyq.tomcat

import org.zyq.swing.SwingUtils
import org.zyq.tomcat.view.table_list.Tomcat_list

import javax.swing.*

class Start {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tomcat_add");
        SwingUtils.beatiful_up();
        SwingUtils.setjFrame(frame);
        SwingUtils.window_init_end(frame, new Tomcat_list().$$$getRootComponent$$$());
    }
}
