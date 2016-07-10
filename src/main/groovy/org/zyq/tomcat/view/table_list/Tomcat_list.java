package org.zyq.tomcat.view.table_list;

//import org.zyq.core.lang.Str;
//import org.zyq.tomcat.CONFIG;
//import org.zyq.tomcat.service.TomcztUtils;
//import org.zyq.tomcat.view.tabel_add.Tomcat_add;
//import tools.swing.SwingUtils;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.File;
//import java.io.IOException;

public class Tomcat_list {
//
//    private JPanel list;
//    private JButton addButton;
//    private JButton selectButton;
//    private JButton daoruButton;
//    private JButton saveButton;
//    private JLabel workLabel;
//    private JTable listTable;
//    private JScrollPane sp1;
//    private JButton clearButton;
//    private JButton chooseJDKButton;
//    private JLabel jdkLabel;
//
//    public Tomcat_list() {
//        $$$setupUI$$$();
//        saveButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                TomcztUtils.saveConfig();
//            }
//        });
//        addButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                if (Str.isBlank(CONFIG.subject.getWorkspace())) {
//                    JOptionPane.showMessageDialog($$$getRootComponent$$$(), "请先选择工作目录", "错误", JOptionPane.ERROR_MESSAGE);
//                    return;
//                }
//                if (Str.isBlank(CONFIG.subject.getJDKPath())) {
//                    JOptionPane.showMessageDialog($$$getRootComponent$$$(), "请先选择JDK路径", "错误", JOptionPane.ERROR_MESSAGE);
//                    return;
//                }
//                SwingUtils.setContent(new Tomcat_add().$$$getRootComponent$$$());
//            }
//        });
//        selectButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String s = "D:/";
//                if (CONFIG.subject.getWorkspace() != null && !CONFIG.subject.getWorkspace().isEmpty())
//                    s = CONFIG.subject.getWorkspace();
//                JFileChooser jFileChooser = new JFileChooser(s);
//                jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//                jFileChooser.showDialog(new JLabel(), "请选择工作目录");
//                File dir = jFileChooser.getSelectedFile();
//                if (dir != null) CONFIG.subject.setWorkspace(dir.getAbsolutePath());
//                SwingUtils.setContent(new Tomcat_list().$$$getRootComponent$$$());
//                TomcztUtils.saveConfig();
//            }
//        });
//        workLabel.setText(CONFIG.subject.getWorkspace() == null ? "无" : CONFIG.subject.getWorkspace());
//        workLabel.setToolTipText(workLabel.getText());
//        jdkLabel.setText(CONFIG.subject.getJDKPath() == null ? "无" : CONFIG.subject.getJDKPath());
//        jdkLabel.setToolTipText(jdkLabel.getText());
//        workLabel.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                if (e.getClickCount() == 2 && Str.notBlank(CONFIG.subject.getWorkspace())) {
//                    try {
//                        Runtime.getRuntime().exec("explorer " + CONFIG.subject.getWorkspace());
//                    } catch (IOException e1) {
//                        e1.printStackTrace();
//                    }
//                }
//            }
//        });
//        clearButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                TomcztUtils.clearWorkSpace();
//            }
//        });
//        chooseJDKButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String s = "C:\\Program Files\\Java";
//                if (!new File(s).exists()) {
//                    if (new File("C:\\Program Files").exists()) {
//                        s = "C:\\Program Files";
//                    } else {
//                        s = "C:\\";
//                    }
//                }
//                if (CONFIG.subject.getJDKPath() != null && !CONFIG.subject.getJDKPath().isEmpty())
//                    s = CONFIG.subject.getJDKPath();
//                JFileChooser jFileChooser = new JFileChooser(s);
//                jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//                jFileChooser.showDialog(new JLabel(), "请选择JDK路径");
//                File dir = jFileChooser.getSelectedFile();
//                if (dir != null) CONFIG.subject.setJDKPath(dir.getAbsolutePath());
//                SwingUtils.setContent(new Tomcat_list().$$$getRootComponent$$$());
//                TomcztUtils.saveConfig();
//            }
//        });
//        jdkLabel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                if (e.getClickCount() == 2 && Str.notBlank(CONFIG.subject.getJDKPath())) {
//                    try {
//                        Runtime.getRuntime().exec("explorer " + CONFIG.subject.getJDKPath());
//                    } catch (IOException e1) {
//                        e1.printStackTrace();
//                    }
//                }
//            }
//        });
//    }
//
//    private void createUIComponents() {
//        listTable = new ZTable();
//        listTable.setModel(new Table_model());
//        TableUtils.hideColumn(listTable, 0);
//    }
//
//    /**
//     * Method generated by IntelliJ IDEA GUI Designer
//     * >>> IMPORTANT!! <<<
//     * DO NOT edit this method OR call it in your code!
//     *
//     * @noinspection ALL
//     */
//    private void $$$setupUI$$$() {
//        createUIComponents();
//        list = new JPanel();
//        list.setLayout(new GridBagLayout());
//        selectButton = new JButton();
//        selectButton.setHorizontalAlignment(2);
//        selectButton.setText("选择工作目录");
//        GridBagConstraints gbc;
//        gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        list.add(selectButton, gbc);
//        workLabel = new JLabel();
//        workLabel.setEnabled(true);
//        workLabel.setPreferredSize(new Dimension(100, 20));
//        workLabel.setText("");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 1;
//        gbc.gridy = 0;
//        gbc.fill = GridBagConstraints.BOTH;
//        gbc.insets = new Insets(0, 0, 0, 30);
//        list.add(workLabel, gbc);
//        sp1 = new JScrollPane();
//        sp1.setPreferredSize(new Dimension(400, 420));
//        gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//        gbc.gridwidth = 8;
//        gbc.fill = GridBagConstraints.BOTH;
//        list.add(sp1, gbc);
//        sp1.setViewportView(listTable);
//        saveButton = new JButton();
//        saveButton.setText("保存配置");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        list.add(saveButton, gbc);
//        clearButton = new JButton();
//        clearButton.setText("清理工作目录");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 1;
//        gbc.gridy = 1;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        list.add(clearButton, gbc);
//        chooseJDKButton = new JButton();
//        chooseJDKButton.setText("选择JDK");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 2;
//        gbc.gridy = 0;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        list.add(chooseJDKButton, gbc);
//        addButton = new JButton();
//        addButton.setText("新增");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 3;
//        gbc.gridy = 1;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        list.add(addButton, gbc);
//        daoruButton = new JButton();
//        daoruButton.setText("导入配置文件");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 2;
//        gbc.gridy = 1;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        list.add(daoruButton, gbc);
//        jdkLabel = new JLabel();
//        jdkLabel.setHorizontalTextPosition(2);
//        jdkLabel.setPreferredSize(new Dimension(112, 20));
//        jdkLabel.setText("");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 3;
//        gbc.gridy = 0;
//        gbc.gridwidth = 3;
//        gbc.anchor = GridBagConstraints.WEST;
//        gbc.fill = GridBagConstraints.VERTICAL;
//        list.add(jdkLabel, gbc);
//    }
//
//    /**
//     * @noinspection ALL
//     */
//    public JComponent $$$getRootComponent$$$() {
//        return list;
//    }
}
