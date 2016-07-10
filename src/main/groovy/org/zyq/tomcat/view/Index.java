package org.zyq.tomcat.view;

import org.zyq.tomcat.common.BaseJPanel;
import tools.swing.SwingUtils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 邹宇泉 on 2016/7/7.
 */
public class Index extends BaseJPanel {

    public static void main(String[] args) {
        JFrame frame = new JframeApp();
        SwingUtils.window_init_end(frame, new Index());
    }

    @Override
    public void hook_init() {
        super.hook_init();
        setLayout(new BorderLayout());
        JPanel panel = new Button_group();

        add(panel, BorderLayout.NORTH);
    }

}
