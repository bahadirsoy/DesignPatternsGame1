import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Tnt extends Trap{

    public Tnt(int xPosition, int yPosition) {
        super(xPosition, yPosition);

        super.damage = 50;
        super.stunDuration = 1;

        try {
            super.image = ImageIO.read(new File("C:\\Users\\oxika\\IdeaProjects\\DesignPatterns\\img\\tnt.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
