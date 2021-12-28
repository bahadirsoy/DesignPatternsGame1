import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class HealthKit extends GameObject{

    public HealthKit(int xPosition, int yPosition) {
        super.xPosition = xPosition;
        super.yPosition = yPosition;

        try {
            super.image = ImageIO.read(new File("C:\\Users\\oxika\\IdeaProjects\\DesignPatterns\\img\\health.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
