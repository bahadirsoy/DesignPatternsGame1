import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class LandMine extends Trap{

    public LandMine(int xPosition, int yPosition) {
        super(xPosition, yPosition);

        super.damage = 100;
        super.stunDuration = 0;

        try {
            super.image = ImageIO.read(new File("C:\\Users\\oxika\\IdeaProjects\\DesignPatterns\\img\\landMine.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
