import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen(600, 480);
        for(int i = 0; i < screen.getWidth(); i++){
            for(int j = 0; j < screen.getHeight(); j++){
                screen.drawPixel(i, j, Color.RED);
            }
        }
    }
}
