public class Diagonal1StepMove implements MoveBehaviour {

    @Override
    public void move(Character c) {
        //log before move
        GameBoard.writeCharacterPosition(c);

        //pick random move direction for mob
        int direction = (int) (Math.random() * 4);

        //move mob according to the picked random direction
        switch (direction) {
            //move top left
            case 0:
                c.xPosition--;
                c.yPosition--;
                break;

            //move top right
            case 1:
                c.xPosition++;
                c.yPosition--;
                break;

            //move bottom right
            case 2:
                c.xPosition++;
                c.yPosition++;
                break;

            //move bottom left
            case 3:
                c.xPosition--;
                c.yPosition++;
                break;
        }

        if(c.xPosition < 0) c.xPosition = 0;
        if(c.xPosition > 11) c.xPosition = 11;
        if(c.yPosition < 0) c.yPosition = 0;
        if(c.yPosition > 5) c.yPosition = 5;

        //log after move
        GameBoard.writeCharacterPositionAfterMove(c);

    }


    @Override
    public void move(Character c, int direction) {}
}
