package spostacursore_bella;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpostaCursore_bella {

    public static void main(String[] args) {
// frecce 24 27

        JFrame frame;
        frame = new JFrame("                SPOSTA IL CURSORE");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(1150, 400);
        frame.setAlwaysOnTop(true);
        String pos[] = {"West", "Center"};
        int P = 2;
        int N = 10;
        JLabel label[] = new JLabel[N * N];
        JPanel[] pannello = new JPanel[P];
        JButton button[] = new JButton[4];
        ActionListener l;
        l = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton bottone = ((JButton) e.getSource());
                String button = ((JButton) e.getSource()).getName();
                System.out.println("bottone.getName() " + bottone.getName());
                int numBottone = Integer.parseInt(button);
                System.out.println("bottone.getText() " + bottone.getText());

                int porco1 = 0;

                int bordo[] = new int[N];
                int numLabel[] = new int[N * N];
//   bottone 1
                if (bottone.getName() == "1") {
                    for (int i = 0; i < N * N; i++) {
                        if (label[i].getBackground() == Color.RED && porco1 == 0) {
                            for (int j = 0; j < N; j++) {
                                bordo[j] = ((j * N) + (j % N)) + 1;
                                int porco = i - N;
                                System.out.println("porco " + porco);
                                if (porco >= 0) {
                                    numLabel[i] = Integer.parseInt(label[(porco)].getName());
                                    System.out.println("numLabel[porco] " + numLabel[porco]);
                                    if (numLabel[porco] >= porco1 - N && porco >= 0) {
                                        System.out.println("numLabel[porco] " + numLabel[porco]);
//                                    System.out.println("j"+j);
                                        System.out.println("porco1+N " + (porco1 - N));
                                        porco = Integer.parseInt(label[i].getName());
                                        label[(porco - N)].setBackground(Color.RED);
                                        label[porco].setBackground(Color.white);
                                    }
                                    porco1++;
                                }
                            }
                        }
                    }

                    porco1 = 0;
                }
//pulsante 2

                if (bottone.getName() == "2") {
                    for (int i = 0; i < N * N; i++) {
                        if (label[i].getBackground() == Color.RED && porco1 == 0) {
                            for (int j = 0; j < N; j++) {
                                bordo[j] = ((j * N) + (j % N)) + 1;
                                int porco = i -1;
                                if (porco <= N * N) {

                                    numLabel[i] = Integer.parseInt(label[(porco)].getName());
                                    if (numLabel[i] > i*N) {
                                        porco = Integer.parseInt(label[i].getName());
                                        label[(porco - 1)].setBackground(Color.RED);
                                        label[porco].setBackground(Color.white);
                                    }
                                    porco1++;
                                }
                            }
                        }
                    }

                    porco1 = 0;
                }
//   pulsante 3
                if (bottone.getName() == "3") {
                    for (int i = 0; i < N * N; i++) {
                        if (label[i].getBackground() == Color.RED && porco1 == 0) {
                            for (int j = 0; j < N; j++) {
                                bordo[j] = ((j * N) + (j % N));
                                int porco = i + 1;
                                System.out.println("i " + i);
                                System.out.println("j " + j);

                                if (porco <= j * N) {
                                    System.out.println("porco  "+porco);
                                    numLabel[i] = Integer.parseInt(label[(i+1)].getName());
                                    System.out.println("numLabel[i] "+numLabel[i]);
                                    if (numLabel[i] <= porco1 + 1) {
                                        porco = Integer.parseInt(label[i].getName());
                                        System.out.println("label[i] "+porco);
                                        label[(porco+1)].setBackground(Color.RED);
                                        label[porco].setBackground(Color.white);
                                    }
                                    porco1++;
                                }
                            }
                        }
                    }

                    porco1 = 0;
                }

//                pulsante V
//bottone 4
                if (bottone.getName() == "4") {
                    for (int i = 0; i < N * N; i++) {
                        if (label[i].getBackground() == Color.RED && porco1 == 0) {
                            for (int j = 0; j < N; j++) {
                                bordo[j] = ((j * N) + (j % N)) + 1;
                                int porco = i + N;
                                if (porco < N * N) {

                                    System.out.println("porco " + porco);
                                    numLabel[i] = Integer.parseInt(label[(porco)].getName());
                                    System.out.println("numLabel[porco] " + numLabel[porco]);
                                    if (numLabel[porco] <= porco1 + N) {
//                                    System.out.println("numLabel[i/N] "+numLabel[porco]);
//                                    System.out.println("j"+j);
                                        System.out.println("porco1+N " + (porco1 + N));
                                        porco = Integer.parseInt(label[i].getName());
                                        label[(porco + N)].setBackground(Color.RED);
                                        label[porco].setBackground(Color.white);
                                    }
                                    porco1++;
                                }
                            }
                        }
                    }

                    porco1 = 0;
                }

            }
        };

        for (int i = 0; i < pannello.length; i++) {
            pannello[i] = new JPanel();
            frame.add(pannello[i], pos[i]);
        }
        for (int i = 0; i < 4; i++) {
            button[i] = new JButton();
            button[i].addActionListener(l);
        }

        button[0].setText("^");
        button[1].setText("<");
        button[2].setText(">");
        button[3].setText("v");
//        button[0].setText("1");
//        button[1].setText("2");
//        button[2].setText("3");
//        button[3].setText("4");
        button[0].setName("1");
        button[1].setName("2");
        button[2].setName("3");
        button[3].setName("4");

        pannello[0].setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        pannello[0].add(button[0], c);

//        button = new JButton("Button 2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        pannello[0].add(button[1], c);

//        button = new JButton("Button 3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 1;
        pannello[0].add(button[2], c);

//        button = new JButton("Button 4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        pannello[0].add(button[3], c);
        for (int i = 0; i < 4; i++) {

            button[i].setSize(50, 50);
        }

        for (int i = 0; i < label.length; i++) {
            label[i] = new JLabel();
            label[i].setName("" + i);
            pannello[1].add(label[i]);
            label[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pannello[1].setLayout(new GridLayout(N, N));
            label[0].setBackground(Color.RED);
            label[i].setBackground(Color.WHITE);
            label[i].setOpaque(true);
        }
        pannello[1].revalidate();
        pannello[1].repaint();

        frame.setVisible(true);

    }

}
