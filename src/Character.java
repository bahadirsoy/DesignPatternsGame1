import java.util.ArrayList;

public abstract class Character extends GameObject{
    MoveBehaviour moveBehaviour;

    protected int health;
    protected int damage;
    protected int range;
    protected int stunCounter = 0;

    protected ArrayList<GameObject> gameUnits;

    public Character(int xPosition, int yPosition, ArrayList<GameObject> gameUnits){
        super.xPosition = xPosition;
        super.yPosition = yPosition;

        this.gameUnits = gameUnits;
    }

    public void checkCollision(){
        checkObjectCollisions();
        checkHealth();
    }

    public abstract void checkObjectCollisions();
    public abstract void checkHealth();

    public void performMove(){
        moveBehaviour.move(this);
        this.checkCollision();
    }

    public void performMove(int direction){
        moveBehaviour.move(this, direction);
        this.checkCollision();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
