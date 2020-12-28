package org.o7planning.springbootrestfulclient.Swing;

import org.o7planning.springbootrestfulclient.RestClientSpring.RestClient;
import sun.plugin2.message.JavaObjectOpMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientSwing {
    private JPanel PanelMain;
    private JButton button_msg;


    public ClientSwing() {
        button_msg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RestClient ress = new RestClient();
                JOptionPane.showMessageDialog(null, "Hello") ;


            }
        });
    }

    public static void main(String[] args) {
        RestClient res = new RestClient();
        JFrame frame = new JFrame("App") ;
        frame.setContentPane(new ClientSwing().PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
