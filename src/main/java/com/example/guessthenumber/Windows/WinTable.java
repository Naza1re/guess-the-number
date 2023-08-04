package com.example.guessthenumber.Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinTable   {
    JFrame jFrame = new JFrame("Ты выйграл");
    JButton button = new JButton("История");
    JLabel label = new JLabel("Вы проиграли");
    JButton button1 = new JButton("Заново");

    WinTable(){
        jFrame.setVisible(true);
        jFrame.setLayout(null);
        jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);

        label.setBounds(300,200,600,200);
        label.setFont(new Font("Verdana", Font.PLAIN, 40));
        jFrame.add(label);
        button.setBounds(500,400,300,100);
        button.setFont(new Font("Verdana", Font.PLAIN, 40));
        jFrame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                new History();
            }
        });
        button1.setBounds( 800,400,300,100);
        jFrame.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                new MainWindow();
            }
        });



    }
}
