package org.zyq.tomcat.service;

import javax.swing.*;
import javax.swing.event.ListDataListener;

/**
 * Created by Administrator on 2016/6/7.
 */
public class Com implements ComboBoxModel {
    private String s[] = {"是", "否"};
    private String str = null;

    @Override
    public Object getSelectedItem() {
        return str;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        str = (String) anItem;
    }

    @Override
    public int getSize() {
        return s.length;
    }

    @Override
    public Object getElementAt(int index) {
        return s[index];
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
