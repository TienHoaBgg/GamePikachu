package com.t3h.game.pikachu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

public class GUI extends JFrame  implements Constants{

    private PlayPanel playPanel;

    public GUI(){
        playPanel = new PlayPanel();
        this.setSize(W_F,H_F);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
        this.setLayout(null);
        this.setResizable(false);
        this.setUndecorated(true);
        this.add(initBtn_Exit());
        this.add(initBtn_Close());
        this.add(playPanel);
        Image img = rdImage();
        playPanel.setImageBg(img);
        this.add(new HeaderPanel(img));


    }

    public Image rdImage(){
         Random rd = new Random();
        int id = rd.nextInt(13);
        String path= "/ImageBG/bg"+id+".png";
        Image bgg = null;
        try {
            bgg = ImageIO.read(getClass().getResource(path)).getScaledInstance(W_F,H_F, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bgg;
    }
    public JButton initBtn_Close() {
        JButton btn_Close = new JButton();
        btn_Close.setIcon(getIcon("close1.png"));
        btn_Close.setBounds(W_F - SIZE_BTN-20, 5, SIZE_BTN/2, SIZE_BTN/2);
        btn_Close.setRolloverIcon(getIcon("close2.png"));
        btn_Close.setFocusPainted(false);
        btn_Close.setBorderPainted(false);
        btn_Close.setContentAreaFilled(false);
        btn_Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        return btn_Close;
    }

    public JButton initBtn_Exit() {
        JButton btn_Exit = new JButton();
        btn_Exit.setIcon(getIcon("exit1.png"));
        btn_Exit.setBounds(W_F - SIZE_BTN*2/3, 5, SIZE_BTN/2, SIZE_BTN/2);
        btn_Exit.setBorderPainted(false);
        btn_Exit.setFocusPainted(false);
        btn_Exit.setContentAreaFilled(false);
        btn_Exit.setRolloverIcon(getIcon("exit2.png"));
        btn_Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        return btn_Exit;
    }
    public ImageIcon getIcon(String name) {
        Image img;
        try {
             img = ImageIO.read(getClass().getResource("/ImageHeader/" + name)).getScaledInstance(SIZE_BTN/2,SIZE_BTN/2,Image.SCALE_SMOOTH);
               return new ImageIcon(img);
        } catch (IOException e) {
            System.out.println("Lỗi "+e);
        }
        return null;
    }

    public void close(){
        this.setState(JFrame.ICONIFIED);
    }



}
