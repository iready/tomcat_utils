package org.zyq.tomcat.view.table_list;

import org.zyq.swing.SwingUtils;
import org.zyq.tomcat.view.tomcat_option.Tomcat_option;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Administrator on 2016/6/5.
 */
public class ZTable extends JTable {

    public ZTable() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ZTable table = (ZTable) e.getSource();
                SwingUtils.setContent(new Tomcat_option((String) table.getModel().getValueAt(table.getSelectedRow(), 0)).$$$getRootComponent$$$());
            }
        });
    }

    public void hideColumn(int index) {
        TableColumn tc = this.getColumnModel().getColumn(index);
        tc.setMaxWidth(0);
        tc.setPreferredWidth(0);
        tc.setWidth(0);
        tc.setMinWidth(0);
        this.getTableHeader().getColumnModel().getColumn(index).setMaxWidth(0);
        this.getTableHeader().getColumnModel().getColumn(index).setMinWidth(0);
    }


}
