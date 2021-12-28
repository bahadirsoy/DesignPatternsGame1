import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Trap extends GameObject{

    protected int damage;
    protected int stunDuration;

    public Trap(int xPosition, int yPosition){

        super.xPosition = xPosition;
        super.yPosition = yPosition;

    }

}
