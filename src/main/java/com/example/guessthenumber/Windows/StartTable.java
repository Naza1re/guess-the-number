package com.example.guessthenumber.Windows;

import com.example.guessthenumber.DBConnection.DBConnection;
import com.example.guessthenumber.Model.User;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartTable implements ActionListener {
    JFrame frame = new JFrame("Заполните поле");
    JLabel label = new JLabel("Введите ваш ник");
    JTextField textField = new JTextField();
    JButton button = new JButton("Начать игру");

        public StartTable(){
            frame.setVisible(true);
            frame.setLayout(null);
            frame.setExtendedState(Frame.MAXIMIZED_BOTH);

            label.setBounds(600,200,500,50);
            label.setFont(new Font("Verdana", Font.PLAIN, 40));
            frame.add(label);
            textField.setBounds(550,250,500,50);
            textField.setFont(new Font("Verdana", Font.PLAIN, 40));
            frame.add(textField);

            button.setBounds(600,400,350,100);
            button.setFont(new Font("Verdana", Font.PLAIN, 40));
            frame.add(button);
            button.addActionListener(this);
        }

    public static void main(String[] args) {
        new StartTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Session session =  DBConnection.getSession();
        session.beginTransaction();
        User user = new User(textField.getText(),0);
        session.save(user);
        session.getTransaction().commit();
        new MainWindow();
        frame.setVisible(false);
    }
}
