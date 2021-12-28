import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Nuke extends Trap{

    public Nuke(int xPosition, int yPosition) {
        super(xPosition, yPosition);

        super.damage = 999;
        super.stunDuration = 0;

        try {
            super.image = ImageIO.read(new File("C:\\Users\\oxika\\IdeaProjects\\DesignPatterns\\img\\nuke.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
