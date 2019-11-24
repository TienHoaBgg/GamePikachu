package com.t3h.game.pikachu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Test extends JPanel implements Constants {
    private Image imgBg;
    private JButton btn_Back;
    private JButton btn_Next;
    private JButton btn_Restart;
    private JButton btn_Change;
    private JButton btn_Search;
    private JButton btn_Sound = new JButton();
    private JLabel lb_Time;
    private JLabel lb_TimeLine;
    private JLabel lb_TimeLine1;
    private int choose = 0;
    private int delay = 100;
    private int time = 10 * SIZE_BTN;
    private boolean stop = false;
    private ManagerPlayer managerPlayer;
    public Test(Image image) {
        imgBg = image;
        lb_TimeLine1 = new JLabel();
        this.setSize(W_F, H_F);
        this.setLayout(null);
        this.setLocation(0, 0);
        this.add(initBtn_Back());
        this.add(initBtn_Next());
        this.add(initBtn_Restart());
        this.add(initBtn_Change());
        this.add(initBtn_Search());
        this.add(initBtn_Sound());
        this.add(initTime());
        this.add(lb_TimeLine1);
        this.add(initTimeLine());
        initThread();

    }

    public void btn_BackAction(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Click nút Back");
    }

    public void btn_NextAction(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Click nút Next");
    }

    public void btn_RestartAction(ActionEvent e) {
        //    JOptionPane.showMessageDialog(this, "Click nút Restart");

        stop = false;
        time = 10 * SIZE_BTN;
    }

    public void btn_ChangeAction(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Click nút Change");
    }

    public void btn_SearchAction(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Click nút Search");
    }

    public void btn_SoundAction(ActionEvent e) {
        //   JOptionPane.showMessageDialog(this, "Click nút Sound");
    }


    public JButton initBtn_Back() {
        btn_Back = new JButton();
        btn_Back.setBounds(10 + SIZE_BTN, 10, SIZE_BTN, SIZE_BTN);
        btn_Back.setIcon(getIcon("back1.png"));
        btn_Back.setRolloverIcon(getIcon("back2.png"));
        btn_Back.setFocusPainted(false);
        btn_Back.setBorderPainted(false);
        btn_Back.setContentAreaFilled(false);
        btn_Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_BackAction(e);
            }
        });
        return btn_Back;
    }

    public JButton initBtn_Next() {
        btn_Next = new JButton();
        btn_Next.setBounds(10 + 2 * SIZE_BTN, 10, SIZE_BTN, SIZE_BTN);
        btn_Next.setIcon(getIcon("next1.png"));
        btn_Next.setRolloverIcon(getIcon("next2.png"));
        btn_Next.setFocusPainted(false);
        btn_Next.setBorderPainted(false);
        btn_Next.setContentAreaFilled(false);
        btn_Next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_NextAction(e);
            }
        });
        return btn_Next;
    }

    public JButton initBtn_Restart() {
        btn_Restart = new JButton();
        btn_Restart.setBounds(10 + 3 * SIZE_BTN, 10, SIZE_BTN, SIZE_BTN);
        btn_Restart.setIcon(getIcon("restart1.png"));
        btn_Restart.setRolloverIcon(getIcon("restart2.png"));
        btn_Restart.setFocusPainted(false);
        btn_Restart.setBorderPainted(false);
        btn_Restart.setContentAreaFilled(false);
        btn_Restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_RestartAction(e);
            }
        });
        return btn_Restart;
    }

    public JButton initBtn_Change() {
        btn_Change = new JButton();
        btn_Change.setBounds(10 + 5 * SIZE_BTN, 10, SIZE_BTN, SIZE_BTN);
        btn_Change.setIcon(getIcon("change1.png"));
        btn_Change.setRolloverIcon(getIcon("change2.png"));
        btn_Change.setFocusPainted(false);
        btn_Change.setBorderPainted(false);
        btn_Change.setContentAreaFilled(false);
        btn_Change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_ChangeAction(e);
            }
        });
        return btn_Change;
    }

    public JButton initBtn_Search() {
        btn_Search = new JButton();
        btn_Search.setBounds(10 + 19 * SIZE_BTN, 10, SIZE_BTN, SIZE_BTN);
        btn_Search.setIcon(getIcon("search1.png"));
        btn_Search.setRolloverIcon(getIcon("search2.png"));
        btn_Search.setFocusPainted(false);
        btn_Search.setBorderPainted(false);
        btn_Search.setContentAreaFilled(false);
        btn_Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_SearchAction(e);
            }
        });
        return btn_Search;
    }

    public JButton initBtn_Sound() {

        btn_Sound.setBounds(10 + 20 * SIZE_BTN, 10, SIZE_BTN, SIZE_BTN);
        btn_Sound.setIcon(new ImageIcon(getClass().getResource("/ImageBG/sound1.png")));

        btn_Sound.setFocusPainted(false);
        btn_Sound.setBorderPainted(false);
        btn_Sound.setContentAreaFilled(false);
        btn_Sound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (choose % 2 == 0) {
                    btn_Sound.setSelected(true);
                    choose++;
                } else {
                    btn_Sound.setSelected(false);
                    choose--;
                }
                btn_Sound.setSelectedIcon(new ImageIcon(getClass().getResource("/ImageBG/sound2.png")));
                btn_SoundAction(e);
            }
        });
        return btn_Sound;
    }

    public JLabel initTime() {
        lb_Time = new JLabel();
        lb_Time.setBounds(10 + 7 * SIZE_BTN, 10, SIZE_BTN, SIZE_BTN);
        lb_Time.setIcon(getIcon("addTime1.png"));

        return lb_Time;
    }

    public JLabel initTimeLine() {
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(ImageIO.read(getClass().getResource("/ImageHeader/time0.png"))
                    .getScaledInstance(10 * SIZE_BTN, SIZE_BTN / 2, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            System.out.println("Lỗi" + e);
            ;
        }
        lb_TimeLine = new JLabel();
        lb_TimeLine.setBounds(15 + 8 * SIZE_BTN, 20, 10 * SIZE_BTN, SIZE_BTN / 2);
        lb_TimeLine.setIcon(icon);
        return lb_TimeLine;
    }

    public void runTime() {
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(ImageIO.read(getClass().getResource("/ImageHeader/time1.png"))
                    .getScaledInstance(10 * SIZE_BTN, SIZE_BTN / 2 - 6, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            System.out.println("Lỗi" + e);
            ;
        }
        lb_TimeLine1.setBounds(15 + 8 * SIZE_BTN, 23, time, SIZE_BTN / 2 - 6);
        lb_TimeLine1.setIcon(icon);
        if (time < 150) {
            if (time % 5 == 0) {
                lb_Time.setIcon(getIcon("addTime2.png"));
            } else {
                lb_Time.setIcon(getIcon("addTime1.png"));
            }

        }


    }

    public void initThread() {

        Thread t = new Thread() {
            public void run() {
                while (!stop) {
                    runTime();
                    time--;
                    if (time == 0) {
                        JOptionPane.showMessageDialog(null,"Đã hết thời gian");
                        stop = true;
                    }
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
        };
        t.start();


    }

    public ImageIcon getIcon(String name) {
        Image imgIcon;
        try {
            imgIcon = ImageIO.read(getClass().getResource("/ImageHeader/" + name)).getScaledInstance(SIZE_BTN, SIZE_BTN, Image.SCALE_SMOOTH);
            return new ImageIcon(imgIcon);
        } catch (IOException e) {
            System.out.println("Lỗi " + e);
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(imgBg, 0, 0, W_F, H_HEADER, 0, 0, W_F, H_HEADER, null);

    }
}
