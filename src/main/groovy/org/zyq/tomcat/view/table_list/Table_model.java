package org.zyq.tomcat.view.table_list;

import org.zyq.tomcat.CONFIG;
import org.zyq.tomcat.entity.TomcatInfo;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class Table_model extends AbstractTableModel {
    private String[] columnNames = {"id", "名称",
            "状态",
            "端口",
            "操作"};
    private Object[][] data = null;

    public Table_model() {
        List<TomcatInfo> s = CONFIG.subject.getList();
        data = new Object[s.size()][4];
        if (s.size() > 0) {
            for (int i = 0; i < s.size(); i++) {
                TomcatInfo t = s.get(i);
                data[i] = new Object[]{t.getId(), t.getName(), "开启", t.getPort(), "更多"};
            }
        }
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }


    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col == 3) return true;
        else return false;
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
    }
}