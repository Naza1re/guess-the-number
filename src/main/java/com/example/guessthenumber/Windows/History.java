package com.example.guessthenumber.Windows;

import com.example.guessthenumber.DBConnection.DBConnection;
import com.example.guessthenumber.Model.User;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class History {
    JFrame frame = new JFrame("Итория");
    JTextArea area = new JTextArea();
    JButton button = new JButton("Узнать");
    JButton button1 = new JButton("Обратно");


    History(){

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);

        area.setBounds(300,200,500,400);
        area.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.add(area);

        button.setBounds(300,700,200,100);
        frame.add(button);
        button1.setBounds(500,700,300,100);
        frame.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new WinTable();
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Session session = DBConnection.getSession();
                session.beginTransaction();
                List<User> userList = session.createQuery("FROM User", User.class).list();
                String list = "";
                for(int i = 0;i<userList.size();i++){

                    list = list + userList.get(i).toString() + "\n";

                }
                area.setText(list);
                session.getTransaction().commit();
            }
        });








    }


}
