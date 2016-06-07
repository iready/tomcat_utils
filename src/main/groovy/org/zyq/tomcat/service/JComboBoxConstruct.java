package org.zyq.tomcat.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JComboBoxConstruct {

    String[] s = {"喵喵", "狗狗", "小白兔", "大狮子"};

    public JComboBoxConstruct() {
        JFrame f = new JFrame("@调查问卷@");
        f.setBounds(10, 100, 90, 200);
        Container contentPane = f.getContentPane();
        ComboBoxModel mode = new UserDefineComboBoxModel();
        JComboBox combo = new JComboBox(mode);
        combo.setBorder(BorderFactory.createTitledBorder("你最喜欢哪种动物？"));
        contentPane.add(combo);
        f.pack();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        new JComboBoxConstruct();
    }

    class UserDefineComboBoxModel extends AbstractListModel implements ComboBoxModel {

        String item = null;

        @Override
        public Object getSelectedItem() {
            return this.item;
        }

        @Override
        public void setSelectedItem(Object item) {
            this.item = (String) item;
        }

        @Override
        public Object getElementAt(int index) {
            return s[index++];
        }

        @Override
        public int getSize() {
            return s.length;
        }

    }
}  