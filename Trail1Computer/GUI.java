package Trail1Computer;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static String content;
    public static String price;
    public void createPanel() {
        JFrame jFrame = new JFrame("Buy Computer");
        // 设置父面板，保证子面板垂直排布
        JPanel jPanel0 = new JPanel();
        BoxLayout boxLayout0 = new BoxLayout(jPanel0,BoxLayout.Y_AXIS);
        jPanel0.setLayout(boxLayout0);
        // 子面板一存放标题
        JPanel jPanel1 = new JPanel(new FlowLayout(FlowLayout.LEADING,100,20));
        BoxLayout boxLayout1 = new BoxLayout(jPanel1,BoxLayout.X_AXIS);
        jPanel1.setLayout(boxLayout1);
        JLabel jLabel = new JLabel("请输入配置");
        jPanel1.add(jLabel);
        // 子面板二，输入配置
        JPanel jPanel2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        BoxLayout boxLayout2 = new BoxLayout(jPanel2,BoxLayout.X_AXIS);
        jPanel2.setLayout(boxLayout2);
        JTextArea jTextArea = new JTextArea(1,1);
        JButton jButton21 = new JButton("清空");
        JButton jButton22 = new JButton("确定");
        jButton22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Result content = HandleInput.getContent(jTextArea.getText());
                    GUI.content = content.getContent();
                    GUI.price = String.valueOf(content.getPrice());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        String text = jTextArea.getText();
        jPanel2.add(jTextArea);
        jPanel2.add(jButton21);
        jPanel2.add(jButton22);
        // 子面板3，显示配置和价格
        JPanel jPanel3 = new JPanel(new FlowLayout(FlowLayout.LEADING,100,20));
        BoxLayout boxLayout3 = new BoxLayout(jPanel3,BoxLayout.X_AXIS);
        jPanel3.setLayout(boxLayout3);
        // 显示配置,价格
        JButton jButton31 = new JButton("查看配置");
        JButton jButton32 = new JButton("查看价格");
        jButton31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,content,"配置详情",JOptionPane.PLAIN_MESSAGE);
            }
        });
        jButton32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,price,"价格",JOptionPane.PLAIN_MESSAGE);
            }
        });
        jPanel3.add(jButton31);
        jPanel3.add(jButton32);

        jPanel0.add(jPanel1);
        jPanel0.add(jPanel2);
        jPanel0.add(jPanel3);
        jFrame.add(jPanel0);
        jFrame.setVisible(true);
        jFrame.setSize(500,500);
    }
}
