package org.zyq.tomcat

import org.zyq.tomcat.view.Index
import org.zyq.tomcat.view.JframeApp
import tools.swing.SwingUtils

import javax.swing.*

class Start {
    public static void main(String[] args) {
        JFrame frame = new JframeApp();
        SwingUtils.setjFrame(frame);
        SwingUtils.window_init_end(frame, new Index());
    }
}