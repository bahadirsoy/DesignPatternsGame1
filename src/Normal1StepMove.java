public class Normal1StepMove implements MoveBehaviour {

    @Override
    public void move(Character c) {
        //log before move
        GameBoard.writeCharacterPosition(c);

        //pick random move direction for mob
        int direction = (int) (Math.random() * 4);

        //move mob according to the picked random direction
        switch (direction) {
            //move left
            case 0:
                if (c.xPosition - 1 < 0) {
                    c.xPosition++;
                } else {
                    c.xPosition--;
                }
                break;

            //move right
            case 1:
                if (c.xPosition + 1 > 11) {
                    c.xPosition--;
                } else {
                    c.xPosition++;
                }
                break;

            //move up
            case 2:
                if (c.yPosition - 1 < 0) {
                    c.yPosition++;
                } else {
                    c.yPosition--;
                }
                break;

            //move down
            case 3:
                if (c.yPosition + 1 > 5) {
                    c.yPosition--;
                } else {
                    c.yPosition++;
                }
                break;
        }

        //log after move
        GameBoard.writeCharacterPositionAfterMove(c);
    }


    @Override
    public void move(Character c, int direction) {
        //log before move
        GameBoard.writeCharacterPosition(c);

        //move hero
        switch (direction) {
            //move left
            case 0:
                c.xPosition--;
                break;

            //move right
            case 1:
                c.xPosition++;
                break;

            //move up
            case 2:
                c.yPosition--;
                break;

            //move down
            case 3:
                c.yPosition++;
                break;

        }

        //log after move
        GameBoard.writeCharacterPositionAfterMove(c);
    }
}
