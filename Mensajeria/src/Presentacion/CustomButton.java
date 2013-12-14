package Presentacion;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.border.Border;

/**
 *
 * @author Luis García Estrades https://github.com/lgarest
 */
public class CustomButton extends javax.swing.JButton{
    Color background;
    Color light_gray = new Color(220, 220, 220);
    Color dark_gray = new Color(75, 75, 75);

    private CustomButton(String label) {
        super();
        this.setText(label);
        this.setBackground(dark_gray);
        this.setForeground(light_gray);
        this.setFocusPainted(false);
    }

    CustomButton() {
        super();
        this.setBackground(dark_gray);
        this.setForeground(light_gray);
        this.setFocusPainted(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension originalSize = super.getPreferredSize();
        int gap = (int) (originalSize.height * 0.2);
        int x = originalSize.width + gap;
        int y = gap;
        int diameter = originalSize.height - (gap * 2);

    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.width += size.height;
        return size;
    }

    /*Test the button*/
    public static void main(String[] args) {
        CustomButton button = new CustomButton("Hello, World!");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(button);

        frame.setVisible(true);
    }
}
