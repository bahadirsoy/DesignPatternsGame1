public class NoMove implements MoveBehaviour{
    @Override
    public void move(Character c) {
        if(c.stunCounter > 0) c.stunCounter--;

        if(c.stunCounter == 0){
            if(c instanceof Assassin || c instanceof Goblin){
                c.moveBehaviour = new Diagonal1StepMove();
            } else if(c instanceof Knight){
                c.moveBehaviour = new Normal2StepMove();
            } else{
                c.moveBehaviour = new Normal1StepMove();
            }
        }
    }

    @Override
    public void move(Character c, int direction) {
        if(c.stunCounter > 0) c.stunCounter--;

        if(c.stunCounter == 0){
            if(c instanceof Assassin || c instanceof Goblin){
                c.moveBehaviour = new Diagonal1StepMove();
            } else if(c instanceof Knight){
                c.moveBehaviour = new Normal2StepMove();
            } else{
                c.moveBehaviour = new Normal1StepMove();
            }
        }
    }
}
