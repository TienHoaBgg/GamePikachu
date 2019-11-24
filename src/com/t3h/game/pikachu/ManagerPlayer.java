package com.t3h.game.pikachu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;

public class ManagerPlayer implements Constants{
    private Pikachu[][] pikachus;
    private  String path1 = null;
    private int id1;
    public ManagerPlayer(){
        initPikachu();

    }


    public void initPikachu(){
        Random rd = new Random();
        pikachus = new Pikachu[ROW][COLUME];
        id1 = rd.nextInt(5)+1;
        path1 = "/ImageBG/square_"+id1+".png";
        for(int i = 0; i < ROW;i++){
            for(int j = 0 ; j < COLUME;j++){
                Pikachu pi = new Pikachu();
                pi.setX(SIZE_PI*j + PADDING_HORIZONTAL);
                pi.setY(SIZE_PI*i + PADDING_VERTICAL);
                pi.setW(SIZE_PI);
                pi.setH(SIZE_PI);
                int id = rd.nextInt(48);
                String path = "/ImagesPikachu/p_"+id+"_cap1.png";
                pi.setBg(new ImageIcon(getClass().getResource(path1)).getImage());
                pi.setImg(new ImageIcon( getClass().getResource(path)).getImage());
                pikachus[i][j] = pi;
            }
        }

    }


    public void drawAll(Graphics2D g2) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUME; j++) {
                pikachus[i][j].draw(g2);

            }

        }
    }
    public void mouseMove(MouseEvent e) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUME; j++) {
                int x = pikachus[i][j].getX();
                int x1 = pikachus[i][j].getX()+SIZE_PI;
                int y = pikachus[i][j].getY();
                int y1 = pikachus[i][j].getY()+(SIZE_PI);
                if(e.getX() >= x && e.getX() <= x1 && e.getY() >= y && e.getY() <= y1 ){
                    pikachus[i][j].setBg(new ImageIcon(getClass().getResource("/ImageBG/squarec_"+id1+".png")).getImage());
                }else{
                    pikachus[i][j].setBg(new ImageIcon(getClass().getResource(path1)).getImage());
                }

            }

        }
    }


}
