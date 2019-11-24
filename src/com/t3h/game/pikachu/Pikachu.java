package com.t3h.game.pikachu;

import java.awt.*;

public class Pikachu extends Object2D {
    private int id;
    private Image bg;



    public Image getBg() {
        return bg;
    }

    public void setBg(Image gb) {
        this.bg = gb;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(bg,x,y,w,h,null);
        super.draw(g2);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
