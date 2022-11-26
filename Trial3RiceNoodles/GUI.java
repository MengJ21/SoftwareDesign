package Trial3RiceNoodles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class GUI {
    private static String RNType = "";
    private static Double price = 0.0;
    private static String res = "未选购";
    public void createPanel() {
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        resultMap.put("牛肉",0);
        resultMap.put("豆腐",0);
        resultMap.put("鸡蛋",0);
        JFrame jf = new JFrame("Buy Ricenoodles");
        jf.setSize(500,500);
        // 父面板0
        JPanel jPanel0 = new JPanel();
        BoxLayout layout=new BoxLayout(jPanel0, BoxLayout.Y_AXIS);
        jPanel0.setLayout(layout);
        JLabel jLabel = new JLabel("价格表");
        jPanel0.add(jLabel);


        // 子面板1
        JPanel jPanel1 = new JPanel(new FlowLayout(FlowLayout.LEADING,100,20));
        // 子面板11
        JPanel jPanel11 = new JPanel();
        BoxLayout layout11 =new BoxLayout(jPanel11, BoxLayout.Y_AXIS);
        jPanel11.setLayout(layout11);
        JLabel jLabel1 = new JLabel("米线");
        JLabel jLabel2 = new JLabel("干米线：  10元");
        JLabel jLabel3 = new JLabel("酸米线：  10元");
        JLabel jLabel4 = new JLabel("水米线：  8元");
        jPanel11.add(jLabel1);
        jPanel11.add(jLabel2);
        jPanel11.add(jLabel3);
        jPanel11.add(jLabel4);
        jPanel1.add(jPanel11);
        // 子面板12。
        JPanel jPanel12 = new JPanel();
        BoxLayout layout12 =new BoxLayout(jPanel12, BoxLayout.Y_AXIS);
        jPanel12.setLayout(layout12);
        JLabel jLabel5 = new JLabel("配料");
        JLabel jLabel6 = new JLabel("牛肉：  5元");
        JLabel jLabel7 = new JLabel("鸡蛋：  2元");
        JLabel jLabel8 = new JLabel("豆腐：  2元");
        jPanel12.add(jLabel5);
        jPanel12.add(jLabel6);
        jPanel12.add(jLabel7);
        jPanel12.add(jLabel8);
        jPanel1.add(jPanel12);

        //子面板2
        JPanel jPanel2 = new JPanel(new FlowLayout(FlowLayout.LEADING,100,20));
        //子面板21
        JPanel jPanel21 = new JPanel();
        JComboBox<String> jComboBox = new JComboBox<String>();
        JLabel jLabel9 = new JLabel("米线：  ");
        jPanel21.add(jLabel9);
        jComboBox.addItem("酸米线");
        jComboBox.addItem("干米线");
        jComboBox.addItem("水米线");
        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RNType = (String) jComboBox.getSelectedItem();
                System.out.println(RNType);
            }
        });
        jPanel21.add(jComboBox);
        jPanel2.add(jPanel21);
        //子面板22
        JPanel jPanel22 = new JPanel();
        BoxLayout boxLayout22 = new BoxLayout(jPanel22,BoxLayout.Y_AXIS);
        jPanel22.setLayout(boxLayout22);
        JPanel jPanel221  = new JPanel();
        JLabel jLabel10 = new JLabel("牛肉: ");
        JTextField jTextField = new JTextField(2);
        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultMap.replace("牛肉", Integer.valueOf(jTextField.getText()));
                System.out.println(resultMap.get("牛肉"));
            }
        });
        JPanel jPanel222  = new JPanel();
        JLabel jLabel11 = new JLabel("鸡蛋: ");
        JTextField jTextField1 = new JTextField(2);
        jTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultMap.replace("鸡蛋", Integer.valueOf(jTextField1.getText()));
                System.out.println(resultMap.get("鸡蛋"));
            }
        });
        JPanel jPanel223  = new JPanel();
        JLabel jLabel12 = new JLabel("豆腐: ");
        JTextField jTextField2 = new JTextField(2);
        jTextField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultMap.replace("豆腐", Integer.valueOf(jTextField2.getText()));
                System.out.println(resultMap.get("豆腐"));
            }
        });
        jPanel221.add(jLabel10);
        jPanel221.add(jTextField);
        jPanel222.add(jLabel11);
        jPanel222.add(jTextField1);
        jPanel223.add(jLabel12);
        jPanel223.add(jTextField2);
        jPanel22.add(jPanel221);
        jPanel22.add(jPanel222);
        jPanel22.add(jPanel223);
        jPanel2.add(jPanel22);

        JButton btn = new JButton("确定");


        JPanel jPanel3 = new JPanel();
        JLabel jLabel13 = new JLabel("描述： ");
        JTextField jTextField3 = new JTextField(GUI.res,20);
        jPanel3.add(jLabel13);
        jPanel3.add(jTextField3);




        JPanel jPanel4 = new JPanel();
        JLabel jLabel14 = new JLabel("价格： ");
        JTextField jTextField4 = new JTextField(String.valueOf(GUI.price),3);
        JLabel jLabel15 = new JLabel("元");
        jPanel4.add(jLabel14);
        jPanel4.add(jTextField4);
        jPanel4.add(jLabel15);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Result result = handleInput.computeOrder(RNType, resultMap);
                GUI.price = result.getSum();
                GUI.res = result.getSelectInfo();
                System.out.println(price+res);
                jTextField4.setText(String.valueOf(price));
                jTextField3.setText(res);
            }
        });

        jPanel0.add(jPanel1);
        jPanel0.add(jPanel2);
        jPanel0.add(btn);
        jPanel0.add(jPanel3);
        jPanel0.add(jPanel4);
        jf.setContentPane(jPanel0);
        jf.setVisible(true);
    }
}
