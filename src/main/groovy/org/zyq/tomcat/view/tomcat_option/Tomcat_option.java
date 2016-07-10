package org.zyq.tomcat.view.tomcat_option;

//import org.apache.commons.io.FileUtils;
//import org.zyq.swing.SwingUtils;
//import org.zyq.tomcat.CONFIG;
//import org.zyq.tomcat.entity.TomcatInfo;
//import org.zyq.tomcat.service.TomcztUtils;
//import org.zyq.tomcat.view.table_list.Tomcat_list;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStreamReader;

public class Tomcat_option {
//    private JPanel o;
//    private JButton backButton;
//    private JButton qidongButton;
//    private JButton tingzhiButton;
//    private JButton deButton;
//    private JButton sureButton;
//    private JButton deleteButton;
//    private JLabel nowtomcat;
//    private JLabel qidongport;
//    private JLabel redport;
//    private JLabel conport;
//    private JLabel shutdownport;
//    private JComboBox isSign;
//    private JButton btn_zc;
//    private JTextField bslj;
//    private JLabel f1;
//    private JPanel p22;
//
//    public Tomcat_option(final String id) {
//        backButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                SwingUtils.setContent(new Tomcat_list().$$$getRootComponent$$$());
//            }
//        });
//        deleteButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                switch (JOptionPane.showConfirmDialog($$$getRootComponent$$$(), "是否删除")) {
//                    case 0:
//                        int index = -1;
//                        for (int i = 0; i < CONFIG.subject.getList().size(); i++) {
//                            if (CONFIG.subject.getList().get(i).getId().equals(id)) index = i;
//                        }
//                        if (index != -1) CONFIG.subject.getList().remove(index);
//                        JOptionPane.showMessageDialog($$$getRootComponent$$$(), "删除成功", "提示", JOptionPane.INFORMATION_MESSAGE);
//                        SwingUtils.setContent(new Tomcat_list().$$$getRootComponent$$$());
//                        TomcztUtils.saveConfig();
//                        break;
//                    case 1:
//                        break;
//                    case 2:
//                        break;
//                }
//            }
//        });
//        final String s = CONFIG.subject.getWorkspace() + "\\" + id;
//        nowtomcat.setText(s);
//        nowtomcat.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                if (e.getClickCount() == 2) {
//                    try {
//                        Runtime.getRuntime().exec("explorer " + s);
//                    } catch (IOException e1) {
//                        e1.printStackTrace();
//                    }
//                }
//            }
//        });
//        final TomcatInfo tom = TomcztUtils.getTomcatInfoById(id);
//        conport.setText(tom.getConPort() + "");
//        shutdownport.setText(tom.getShutdownPort() + "");
//        redport.setText(tom.getRedPort() + "");
//        qidongport.setText(tom.getPort() + "");
//        bslj.setText(tom.getBslj());
//        qidongButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                TomcztUtils.start_tomcat_normal(id);
//            }
//        });
//        tingzhiButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                TomcztUtils.stop_tomcat_normal(id);
//            }
//        });
//        btn_zc.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    String path_bin = CONFIG.subject.getWorkspace() + "/" + tom.getId() + "/bin";
//                    Process p = Runtime.getRuntime().exec(path_bin + "/service.bat install " + tom.getName(), new String[]{"JAVA_HOME=" + CONFIG.subject.getJDKPath(), "JRE_HOME=" + CONFIG.subject.getJDKPath() + "/jre", "JVM=" + CONFIG.subject.getJDKPath() + "/jre/bin/server/jvm.dll"}, new File(path_bin));
//                    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"));
//                    String temp = null;
//                    while ((temp = br.readLine()) != null) {
//                        System.out.println(temp);
//                    }
//                    br.close();
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        });
//        deButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                File dir = new File(bslj.getText());
//                if (dir.exists()) {
//                    try {
//                        File file = new File(CONFIG.subject.getWorkspace() + "/" + tom.getId() + "\\webapps\\ROOT");
//                        FileUtils.cleanDirectory(file);
//                        FileUtils.copyDirectory(dir, file);
//                        tom.setBslj(bslj.getText());
//                        TomcztUtils.saveConfig();
//                        JOptionPane.showMessageDialog(null, "部署成功");
//                    } catch (Exception e1) {
//                        e1.printStackTrace();
//                    }
//                }
//            }
//        });
//    }
//
//    {
//// GUI initializer generated by IntelliJ IDEA GUI Designer
//// >>> IMPORTANT!! <<<
//// DO NOT EDIT OR ADD ANY CODE HERE!
//        $$$setupUI$$$();
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
//        o = new JPanel();
//        o.setLayout(new GridBagLayout());
//        backButton = new JButton();
//        backButton.setText("返回");
//        backButton.setToolTipText("返回");
//        GridBagConstraints gbc;
//        gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        o.add(backButton, gbc);
//        qidongButton = new JButton();
//        qidongButton.setText("启动");
//        qidongButton.setToolTipText("启动");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 2;
//        gbc.gridy = 0;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        o.add(qidongButton, gbc);
//        tingzhiButton = new JButton();
//        tingzhiButton.setText("停止");
//        tingzhiButton.setToolTipText("停止");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 3;
//        gbc.gridy = 0;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        o.add(tingzhiButton, gbc);
//        deButton = new JButton();
//        deButton.setText("部署");
//        deButton.setToolTipText("部署");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 4;
//        gbc.gridy = 0;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        o.add(deButton, gbc);
//        sureButton = new JButton();
//        sureButton.setText("确定");
//        sureButton.setToolTipText("确定");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 5;
//        gbc.gridy = 0;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        o.add(sureButton, gbc);
//        deleteButton = new JButton();
//        deleteButton.setText("删除");
//        deleteButton.setToolTipText("删除");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 1;
//        gbc.gridy = 0;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        o.add(deleteButton, gbc);
//        final JLabel label1 = new JLabel();
//        label1.setHorizontalAlignment(4);
//        label1.setText("TOMCAT路径：");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//        gbc.gridwidth = 2;
//        gbc.anchor = GridBagConstraints.EAST;
//        o.add(label1, gbc);
//        final JLabel label2 = new JLabel();
//        label2.setHorizontalAlignment(4);
//        label2.setText("TOMCAT端口：");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 3;
//        gbc.gridwidth = 2;
//        gbc.fill = GridBagConstraints.BOTH;
//        o.add(label2, gbc);
//        final JLabel label3 = new JLabel();
//        label3.setHorizontalAlignment(4);
//        label3.setText("是否为CAS：");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 5;
//        gbc.gridwidth = 2;
//        gbc.fill = GridBagConstraints.BOTH;
//        o.add(label3, gbc);
//        nowtomcat = new JLabel();
//        nowtomcat.setHorizontalAlignment(2);
//        nowtomcat.setPreferredSize(new Dimension(150, 0));
//        nowtomcat.setText("");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 2;
//        gbc.gridy = 2;
//        gbc.gridwidth = 4;
//        gbc.anchor = GridBagConstraints.WEST;
//        gbc.fill = GridBagConstraints.VERTICAL;
//        o.add(nowtomcat, gbc);
//        final JLabel label4 = new JLabel();
//        label4.setHorizontalAlignment(4);
//        label4.setText("转发端口：");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 3;
//        gbc.gridy = 3;
//        gbc.gridwidth = 2;
//        gbc.fill = GridBagConstraints.BOTH;
//        o.add(label4, gbc);
//        final JLabel label5 = new JLabel();
//        label5.setHorizontalAlignment(4);
//        label5.setText("关闭端口：");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 3;
//        gbc.gridy = 4;
//        gbc.gridwidth = 2;
//        gbc.fill = GridBagConstraints.BOTH;
//        o.add(label5, gbc);
//        final JLabel label6 = new JLabel();
//        label6.setHorizontalAlignment(4);
//        label6.setText("连接端口：");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 4;
//        gbc.gridwidth = 2;
//        gbc.fill = GridBagConstraints.BOTH;
//        o.add(label6, gbc);
//        qidongport = new JLabel();
//        qidongport.setHorizontalAlignment(2);
//        qidongport.setText("");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 2;
//        gbc.gridy = 3;
//        gbc.fill = GridBagConstraints.BOTH;
//        o.add(qidongport, gbc);
//        redport = new JLabel();
//        redport.setHorizontalAlignment(2);
//        redport.setText("");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 5;
//        gbc.gridy = 3;
//        gbc.fill = GridBagConstraints.BOTH;
//        o.add(redport, gbc);
//        conport = new JLabel();
//        conport.setHorizontalAlignment(2);
//        conport.setText("");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 2;
//        gbc.gridy = 4;
//        gbc.fill = GridBagConstraints.BOTH;
//        o.add(conport, gbc);
//        shutdownport = new JLabel();
//        shutdownport.setHorizontalAlignment(2);
//        shutdownport.setText("");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 5;
//        gbc.gridy = 4;
//        gbc.fill = GridBagConstraints.BOTH;
//        o.add(shutdownport, gbc);
//        isSign = new JComboBox();
//        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
//        defaultComboBoxModel1.addElement("是");
//        defaultComboBoxModel1.addElement("否");
//        isSign.setModel(defaultComboBoxModel1);
//        gbc = new GridBagConstraints();
//        gbc.gridx = 2;
//        gbc.gridy = 5;
//        gbc.anchor = GridBagConstraints.WEST;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        o.add(isSign, gbc);
//        btn_zc = new JButton();
//        btn_zc.setText("注册成服务");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        o.add(btn_zc, gbc);
//        f1 = new JLabel();
//        f1.setText("部署连接路径:");
//        gbc = new GridBagConstraints();
//        gbc.gridx = 1;
//        gbc.gridy = 6;
//        gbc.anchor = GridBagConstraints.WEST;
//        o.add(f1, gbc);
//        bslj = new JTextField();
//        gbc = new GridBagConstraints();
//        gbc.gridx = 2;
//        gbc.gridy = 6;
//        gbc.gridwidth = 4;
//        gbc.anchor = GridBagConstraints.WEST;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        o.add(bslj, gbc);
//        p22 = new JPanel();
//        p22.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
//        gbc = new GridBagConstraints();
//        gbc.gridx = 1;
//        gbc.gridy = 7;
//        gbc.fill = GridBagConstraints.BOTH;
//        o.add(p22, gbc);
//    }
//
//    /**
//     * @noinspection ALL
//     */
//    public JComponent $$$getRootComponent$$$() {
//        return o;
//    }
}
