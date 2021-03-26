package compulsory.application;

import compulsory.application.shapes.RegularPolygon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    int width, height;
    BufferedImage image; //the offscreen image

    Graphics2D graphics; //the "tools" needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        width = frame.getWidth();
        height = frame.getHeight();
        createOffscreenImage();
        init();
    }

    void createOffscreenImage() {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, width, height);
    }

    private void init() {
        setPreferredSize(new Dimension(width, height));
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });

    }

    private void drawShape(int x, int y) {
        int radius = frame.configPanel.size;
        int sides = frame.configPanel.sides;

        Color color = null;
        if (frame.configPanel.color != null)
            color = frame.configPanel.color;
        else {
            Random rand = new Random();
            // Java 'Color' class takes 3 floats, from 0 to 1.
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            frame.configPanel.color = new Color(r, g, b);
        }

        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));

    }

    @Override
    public void update(Graphics g) {
        repaint();
    } //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
        this.repaint();
    }
}
