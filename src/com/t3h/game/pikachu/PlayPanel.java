package com.t3h.game.pikachu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class PlayPanel  extends JPanel implements Constants, MouseMotionListener {
    private  ManagerPlayer managerPlayer;
    private Image imagBg;

    public PlayPanel(){
        this.setBackground(Color.BLACK);
        this.setLocation(0,H_HEADER);
        this.setSize(W_F,H_PLAY);
        this.addMouseMotionListener(this);
         managerPlayer = new ManagerPlayer();

    }
    public void setImageBg(Image imageBg){
        this.imagBg  = imageBg;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(imagBg,0,0,W_F,H_PLAY,0,H_HEADER,W_F,H_F,null);
        managerPlayer.drawAll(g2);

    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        managerPlayer.mouseMove(e);
            repaint();
    }
}
