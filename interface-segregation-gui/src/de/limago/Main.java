package de.limago;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends Frame  {


    public Main()  {

        setSize(300, 300);
        Button button = new Button("Drück mich");
        button.addActionListener(e->beenden());
        add(button);
        this.addWindowListener(new MyWindowListener());
    }

    public static void main(String[] args) {
	    new Main().setVisible(true);
    }



    private void beenden() {
        // Speichern
        dispose();
    }

    private class MyWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
           beenden();
        }
    }
}
