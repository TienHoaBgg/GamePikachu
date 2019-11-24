package com.t3h.game.pikachu;

public interface Constants {
     int W_F = 1200;
     int H_F = 800;
     int H_HEADER = 100;
     int H_PLAY = H_F - H_HEADER;
     int PADDING_HORIZONTAL_TEMP = 70;
     int PADDING_VERTICAL_TEMP = 40;
     int COLUME = 10;
     int ROW = 8;
     int SIZE_PI = (W_F - PADDING_HORIZONTAL_TEMP*2 )/ COLUME < (H_F- H_HEADER - PADDING_VERTICAL_TEMP *2)/ROW
             ? (W_F - PADDING_HORIZONTAL_TEMP*2 )/ COLUME : (H_F- H_HEADER - PADDING_VERTICAL_TEMP *2)/ROW ;
     int PADDING_HORIZONTAL = (W_F - SIZE_PI*COLUME)/2;
     int PADDING_VERTICAL = (H_F - H_HEADER - SIZE_PI*ROW)/2;

     int SIZE_BTN = 50;

}
