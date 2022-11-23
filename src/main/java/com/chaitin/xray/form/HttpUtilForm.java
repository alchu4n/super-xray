package com.chaitin.xray.form;

import com.chaitin.xray.utils.SocketUtil;
import com.chaitin.xray.utils.StringUtil;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class HttpUtilForm {
    public JPanel httpUtilPanel;
    private JTextArea reqArea;
    private JTextArea respArea;
    private JButton reqButton;
    private JTextField ipText;
    private JTextField portText;
    private JLabel reqLabel;
    private JLabel ipLabel;
    private JLabel portLabel;
    private JPanel ipPanel;
    private JScrollPane reqScroll;
    private JScrollPane respScroll;

    private void initLang(){
        if (MainForm.LANG == MainForm.CHINESE) {
            reqLabel.setText("  请求");
            ipLabel.setText("  目标IP");
            portLabel.setText("  目标端口");
            reqButton.setText("发送");
        }else {
            reqLabel.setText("  Request");
            ipLabel.setText("  Target IP");
            portLabel.setText("  Target Port");
            reqButton.setText("Send");
        }
    }

    public HttpUtilForm() {
        initLang();
        reqButton.addActionListener(e -> {
            String ip = ipText.getText().trim();
            String port = portText.getText().trim();
            String req = reqArea.getText().trim();
            if (!StringUtil.notEmpty(ip) || !StringUtil.notEmpty(port)) {
                JOptionPane.showMessageDialog(null, "请输入IP和端口");
                return;
            }
            int portInt = Integer.parseInt(port);
            new Thread(() -> {
                String finalReq = req + "\r\n\r\n";
                String resp = SocketUtil.sendRaw(ip, portInt, finalReq);
                respArea.setText(resp);
                respArea.setCaretPosition(0);
            }).start();
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        httpUtilPanel = new JPanel();
        httpUtilPanel.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        httpUtilPanel.setBackground(new Color(-725535));
        ipPanel = new JPanel();
        ipPanel.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        ipPanel.setBackground(new Color(-725535));
        httpUtilPanel.add(ipPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        ipLabel = new JLabel();
        ipLabel.setText("  目标IP");
        ipPanel.add(ipLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ipText = new JTextField();
        ipPanel.add(ipText, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        portLabel = new JLabel();
        portLabel.setText("  目标端口");
        ipPanel.add(portLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        portText = new JTextField();
        ipPanel.add(portText, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        reqLabel = new JLabel();
        reqLabel.setText("请求");
        ipPanel.add(reqLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        reqButton = new JButton();
        reqButton.setEnabled(true);
        reqButton.setText("发送");
        ipPanel.add(reqButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        reqScroll = new JScrollPane();
        reqScroll.setBackground(new Color(-725535));
        reqScroll.setToolTipText("");
        httpUtilPanel.add(reqScroll, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(500, 600), new Dimension(500, 600), new Dimension(500, 600), 0, false));
        reqScroll.setBorder(BorderFactory.createTitledBorder(null, "request", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        reqArea = new JTextArea();
        reqArea.setBackground(new Color(-725535));
        reqArea.setLineWrap(true);
        reqArea.setText("");
        reqScroll.setViewportView(reqArea);
        respScroll = new JScrollPane();
        respScroll.setBackground(new Color(-725535));
        httpUtilPanel.add(respScroll, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(500, 600), new Dimension(500, 600), new Dimension(500, 600), 0, false));
        respScroll.setBorder(BorderFactory.createTitledBorder(null, "response", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        respArea = new JTextArea();
        respArea.setBackground(new Color(-725535));
        respArea.setLineWrap(true);
        respArea.setText("");
        respArea.setWrapStyleWord(false);
        respScroll.setViewportView(respArea);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return httpUtilPanel;
    }

}
