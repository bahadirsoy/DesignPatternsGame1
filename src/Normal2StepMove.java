public class Normal2StepMove implements MoveBehaviour {

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
                if (c.xPosition - 2 < 0) {
                    c.xPosition+=2;
                } else {
                    c.xPosition-=2;
                }
                break;

            //move right
            case 1:
                if (c.xPosition + 2 > 11) {
                    c.xPosition-=2;
                } else {
                    c.xPosition+=2;
                }
                break;

            //move up
            case 2:
                if (c.yPosition - 2 < 0) {
                    c.yPosition+=2;
                } else {
                    c.yPosition-=2;
                }
                break;

            //move down
            case 3:
                if (c.yPosition + 2 > 5) {
                    c.yPosition-=2;
                } else {
                    c.yPosition+=2;
                }
                break;
        }

        //log after move
        GameBoard.writeCharacterPositionAfterMove(c);
    }


    @Override
    public void move(Character c, int direction) {
        //move hero
        switch (direction) {
            //move left
            case 0:
                c.xPosition-=2;
                break;

            //move right
            case 1:
                c.xPosition+=2;
                break;

            //move up
            case 2:
                c.yPosition-=2;
                break;

            //move down
            case 3:
                c.yPosition+=2;
                break;

        }
    }
}
