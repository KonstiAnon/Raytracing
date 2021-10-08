import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Screen extends JFrame {

    private final int width, height;

    private final Canvas canvas;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        canvas = new Canvas(width, height);
        add(canvas);
        pack();
        setVisible(true);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void drawPixel(int x, int y, Color c) {
        canvas.draw(x, y, c);
    }

    static class Canvas extends JPanel {

        private final BufferedImage image;

        public Canvas(int width, int height) {
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(image.getWidth(), image.getHeight());
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(image, null, null);
        }

        public void draw(int x, int y, Color c) {
            image.setRGB(x, y, c.getRGB());
            repaint();
        }
    }

}