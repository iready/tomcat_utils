package org.zyq.tomcat.view;


import tools.swing.SwingUtils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 邹宇泉 on 2016/7/10.
 */
public class Add extends JDialog {
    public Add(Frame owner) {
        super(owner, "新增", true);
        SwingUtils.dialog_init(this, owner);
    }
}
