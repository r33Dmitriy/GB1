package ru.geekbrains.lesson3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;


public class MyWindow extends JFrame {
    JLabel date, time;

    public MyWindow()
    {
        super("clock");
        JPanel panel1 = new JPanel(new GridLayout(1,2));
        JButton btnTime = new JButton("Time");
        JButton btnDate = new JButton("Date");
        add(panel1);
        panel1.add(btnDate);
        panel1.add(btnTime);
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                Calendar current = Calendar.getInstance();
                current.setTimeZone(TimeZone.getTimeZone("Moscow"));
                current.setTime(new Date());
                date.setText((current.get(Calendar.MONTH) + 1) +"/" +current.get(Calendar.DATE) +"/" +current.get(Calendar.YEAR));
                String timeStr = String.format("%d:%02d:%02d", current.get(Calendar.HOUR), current.get(Calendar.MINUTE), current.get(Calendar.SECOND));
                time.setText(timeStr);
            }
        };

        date = new JLabel();
        time = new JLabel();
        setLocation(650,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(310,240);
        setResizable(false);
        setVisible(true);
        add(date);
        add(time);
        date.setFont(new Font("Arial", Font.BOLD, 64));
        time.setFont(new Font("Arial", Font.BOLD, 64));
        Timer timer = new Timer(500, listener);
        timer.setInitialDelay(0);
        timer.start();
        date.setVisible(false);
        time.setVisible(false);
        btnDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    date.setVisible(true);
            }
        });
        btnTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time.setVisible(true);
            }
        });
    }
}
