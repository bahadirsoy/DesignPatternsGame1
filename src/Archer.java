import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Archer extends Character{

    public Archer(int xPosition, int yPosition, ArrayList<GameObject> gameUnits){
        super(xPosition, yPosition, gameUnits);

        moveBehaviour = new Normal1StepMove();

        super.health = 100;
        super.damage = 10;
        super.range = 1;

        try {
            super.image = ImageIO.read(new File("C:\\Users\\oxika\\IdeaProjects\\DesignPatterns\\img\\archer.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkCollision() {
        super.checkCollision();
    }

    @Override
    public void checkObjectCollisions() {
        for(Iterator<GameObject> o = gameUnits.iterator(); o.hasNext();){
            GameObject object = o.next();

            if(this.xPosition == object.xPosition && this.yPosition == object.yPosition || this.xPosition+1 == object.xPosition && this.yPosition == object.yPosition
                    || this.xPosition-1 == object.xPosition && this.yPosition == object.yPosition || this.xPosition == object.xPosition && this.yPosition+1 == object.yPosition
                    || this.xPosition == object.xPosition && this.yPosition-1 == object.yPosition || this.xPosition+1 == object.xPosition && this.yPosition+1 == object.yPosition
                    || this.xPosition+1 == object.xPosition && this.yPosition-1 == object.yPosition || this.xPosition-1 == object.xPosition && this.yPosition+1 == object.yPosition
                    || this.xPosition-1 == object.xPosition && this.yPosition-1 == object.yPosition){
                if(object instanceof Archer){

                } else if(object instanceof Character && this.xPosition == object.xPosition && this.yPosition == object.yPosition){

                    ((Character) object).health -= this.damage;
                    this.health -= ((Character) object).damage;

                    System.out.println("Archer dealed " + this.damage + " damage to " + object.getClass().getName());
                    System.out.println(object.getClass().getName() + " dealed " + ((Character) object).damage + " to archer");

                } else if(object instanceof Character){

                    ((Character) object).health -= this.damage;

                    System.out.println("Archer dealed " + this.damage + " damage to " + object.getClass().getName());
                } else if(object instanceof MovementBuff){
                    this.moveBehaviour = new Normal2StepMove();
                    System.out.println(this.getClass().getName() + " has movement buff now");

                    o.remove();
                    GameBoard.setGameUnits(this.gameUnits);
                } else if(object instanceof HealthKit){
                    this.health += 100;
                    System.out.println(this.getClass().getName() + " gained 100 hp");

                    o.remove();
                    GameBoard.setGameUnits(this.gameUnits);
                }
            } else{

            }
        }
    }

    @Override
    public void checkHealth() {
        if(this.health <= 0){
            System.out.println(this.getClass().getName() + " is dead.");
            this.gameUnits.remove(this);
            GameBoard.setGameUnits(this.gameUnits);
        } else{
            //System.out.println(this.getClass().getName() + " is NOT dead.");
        }
    }
}
