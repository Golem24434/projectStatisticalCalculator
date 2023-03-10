import java.awt.*;
import java.awt.event.*;
import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import static java.lang.Thread.sleep;


class main1 {

    public static void main(String[] args) throws IOException {




        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setSize(200,200);

        JButton button = new JButton();
        button.setText("Высчитать");
        button.setSize(100, 100);

        JTextField firstSample = new JTextField(10);
        JTextField secondSample = new JTextField(10);
        JTextField averageFirstSample = new JTextField(10);
        JTextField averageSecondSample = new JTextField(10);
        JTextField dispersionFirstSample = new JTextField(10);
        JTextField dispersionSecondSample = new JTextField(10);

        JTextField standartDeviationFirstSample = new JTextField(10);
        JTextField standartDeviationSecondSample = new JTextField(10);
        JTextField standartErrorFirstSample = new JTextField(10);
        JTextField standartErrorSecondSample  = new JTextField(10);
        JTextField testT = new JTextField(10);
        JTextField correlation  = new JTextField(10);



        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setSize(100, 300);

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);

        gbc.gridy = 0;
        gbc.gridx = 0;
        panel.add(new JLabel("Первая выборка :"), gbc);
        gbc.gridy = 0;
        gbc.gridx = 1;
        panel.add(firstSample, gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        panel.add(new JLabel("Вторая выборка :"), gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        panel.add(secondSample, gbc);
        gbc.gridy = 2;
        gbc.gridx = 1;
        panel.add(button, gbc);
        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(new JLabel("Среднее первой выборки :"), gbc);
        gbc.gridy = 3;
        gbc.gridx = 1;
        panel.add(averageFirstSample, gbc);
        gbc.gridy = 4;
        gbc.gridx = 0;
        panel.add(new JLabel("Среднее второй выборки :"), gbc);
        gbc.gridy = 4;
        gbc.gridx = 1;
        panel.add(averageSecondSample, gbc);
        gbc.gridy = 5;
        gbc.gridx = 0;
        panel.add(new JLabel("Стандартное отклонение первой выборки :"), gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        panel.add(standartDeviationFirstSample, gbc);
        gbc.gridy = 6;
        gbc.gridx = 0;
        panel.add(new JLabel("Стандартное отклонение второй выборки :"), gbc);
        gbc.gridy = 6;
        gbc.gridx = 1;
        panel.add(standartDeviationSecondSample, gbc);
        gbc.gridy = 7;
        gbc.gridx = 0;
        panel.add(new JLabel("Стандартная ошибка первой выборки :"), gbc);
        gbc.gridy = 7;
        gbc.gridx = 1;
        panel.add(standartErrorFirstSample, gbc);
        gbc.gridy = 8;
        gbc.gridx = 0;
        panel.add(new JLabel("Стандартная ошибка второй выборки :"), gbc);
        gbc.gridy = 8;
        gbc.gridx = 1;
        panel.add(standartErrorSecondSample, gbc);
        gbc.gridy = 9;
        gbc.gridx = 0;
        panel.add(new JLabel("Дисперсия первой выборки :"), gbc);
        gbc.gridy = 9;
        gbc.gridx = 1;
        panel.add(dispersionFirstSample, gbc);
        gbc.gridy = 10;
        gbc.gridx = 0;
        panel.add(new JLabel("Дисперсия второй выборки :"), gbc);
        gbc.gridy = 10;
        gbc.gridx = 1;
        panel.add(dispersionSecondSample, gbc);
        gbc.gridy = 11;
        gbc.gridx = 0;
        panel.add(new JLabel("Критерий Стьюдента :"), gbc);
        gbc.gridy = 11;
        gbc.gridx = 1;
        panel.add(testT, gbc);
        gbc.gridy = 12;
        gbc.gridx = 0;
        panel.add(new JLabel("Корреляция выборок :"), gbc);
        gbc.gridy = 12;
        gbc.gridx = 1;
        panel.add(correlation, gbc);



        window.add(panel);

        ActionListener AListener1 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello, world!");
                try {
                    String fileName = "C://interface//interface.txt";

                    try {
                        PrintWriter pw = new PrintWriter(fileName);
                        pw.close();
                    } catch (IOException er) {
                        er.printStackTrace();
                    }
                    File file1 = new File("C://interface", "interface.txt");
                    FileWriter writer = new FileWriter(file1, false);
                    writer.write(firstSample.getText());
                    writer.write("\n");
                    writer.write(secondSample.getText());
                    writer.flush();
                    writer.close();
                    Runtime.getRuntime().exec("cmd.exe /c start C:\\Users\\Omar\\Desktop\\SelfStudy\\Cpp\\withVector.exe");
                    sleep(100);

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                averageFirstSample.setText("23");

                System.out.println("!!!\n");

                try {
                    File file = new File("C://interface//feedback.txt");
                    FileReader fr = new FileReader(file);
                    BufferedReader reader = new BufferedReader(fr);
                    String line = reader.readLine();
                    String[] num = new String(line).replaceAll(",", ".").split(" ");
                    averageFirstSample.setText(String.valueOf(Double.parseDouble(num[0])));
                    averageSecondSample.setText(String.valueOf(Double.parseDouble(num[1])));
                    dispersionFirstSample.setText(String.valueOf(Double.parseDouble(num[2])));
                    dispersionSecondSample.setText(String.valueOf(Double.parseDouble(num[3])));
                    standartDeviationFirstSample.setText(String.valueOf(Double.parseDouble(num[4])));
                    standartDeviationSecondSample.setText(String.valueOf(Double.parseDouble(num[5])));
                    standartErrorFirstSample.setText(String.valueOf(Double.parseDouble(num[6])));
                    standartErrorSecondSample.setText(String.valueOf(Double.parseDouble(num[7])));
                    testT.setText(String.valueOf(Double.parseDouble(num[8])));
                    correlation.setText(String.valueOf(Double.parseDouble(num[9])));

                } catch (FileNotFoundException err) {
                    err.printStackTrace();
                } catch (IOException err) {
                    err.printStackTrace();
                }
            }
        };
        button.addActionListener(AListener1);
    }
}
