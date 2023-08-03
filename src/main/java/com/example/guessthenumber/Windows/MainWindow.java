package com.example.guessthenumber.Windows;

import com.example.guessthenumber.Logic.NumberCalculation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainWindow extends Component {
    JFrame frame = new JFrame();
    public static JTextArea area = new JTextArea();
    JTextField number = new JTextField();
    JButton button = new JButton("Ответить");
    JLabel label = new JLabel("Guess The Number");
    JLabel numbers = new JLabel("Число");
    JLabel correct_numbers = new JLabel("Правильные цифры");
    JLabel correct_POSITION = new JLabel("Правильные позиции");
    JButton exit = new JButton("Выйти");
    private int generateNumber;

    MainWindow(){
        int a =  NumberCalculation.generateUniqueFourDigitNumber();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(127, 173, 169));

        label.setBounds(550,100,800,100);
        label.setFont(new Font("Verdana", Font.PLAIN, 40));
        frame.add(label);

        number.setBounds(300,350,400,100);
        number.setFont(new Font("Verdana", Font.PLAIN, 40));
        frame.add(number);

        button.setBounds(300,500,400,100);
        button.setFont(new Font("Verdana", Font.PLAIN, 40));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = number.getText();
                try{
                    int inputNumber = Integer.parseInt(userInput);
                    if(inputNumber==generateNumber){
                        JOptionPane.showMessageDialog(frame, "Ты угадал это было число : "+inputNumber);
                        NumberCalculation.clearFile();
                        System.exit(1);
                    }
                    else{
                        ArrayList a =  NumberCalculation.returnCollection(inputNumber);
                        ArrayList b =  NumberCalculation.returnCollection(generateNumber);
                        NumberCalculation.writeToFile(a,b);
                        loadFromFile();



                    }

                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
            }
        });
        frame.add(button);

        exit.setBounds(300,650,400,100);
        exit.setFont(new Font("Verdana", Font.PLAIN, 40));
        frame.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NumberCalculation.clearFile();
                System.exit(2);
            }
        });

        area.setBounds(750,250,600,400);
        area.setFont(new Font("Verdana",Font.PLAIN,30));
        frame.add(area);

        numbers.setBounds(800,200,100,50);
        numbers.setFont(new Font("Verdana",Font.PLAIN,15));
        frame.add(numbers);

        correct_numbers.setBounds(950,200,200,50);
        correct_numbers.setFont(new Font("Verdana",Font.PLAIN,15));
        frame.add(correct_numbers);

        correct_POSITION.setBounds(1150,200,200,50);
        correct_POSITION.setFont(new Font("Verdana",Font.PLAIN,15));
        frame.add(correct_POSITION);

        generateNumber=NumberCalculation.generateUniqueFourDigitNumber();
        System.out.println(generateNumber);



    }

    public static void main(String[] args) {
        new MainWindow();
    }
    private void loadFromFile() {
        try {
            FileReader fileReader = new FileReader("numbers.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }



            area.setText(stringBuilder.toString());

            bufferedReader.close();
            fileReader.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ошибка при загрузке файла: ");
        }
    }


}