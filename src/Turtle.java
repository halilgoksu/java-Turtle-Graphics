
public class Turtle {
    public char turtleSymbol;
    public int positionX;
    public int positionY;

    public Turtle(){
        turtleSymbol='X';
        positionX=0;
        positionY=0;
    }


    public void walk(Directions.TurtleDirections directions,int spaces,Pen.PenAction pen){

        if (validateMove(directions,spaces)){
            boolean toDraw =(pen==Pen.PenAction.DOWN);

            switch (directions){
                case NORTH:
                    if (toDraw){
                        GameBoard.updateGameBoardX(positionX,spaces,-1,positionY);
                        positionX -=spaces;
                        break;
                    }

                case SOUTH:
                    if (toDraw){
                        GameBoard.updateGameBoardX(positionX,spaces,1,positionY);
                        positionX +=spaces;
                        break;
                    }

                case EAST:
                    if (toDraw){
                        GameBoard.updateGameBoardY(positionY,spaces,1,positionX);
                        positionY +=spaces;
                        break;
                    }

                case WEST:
                    if (toDraw){
                        GameBoard.updateGameBoardY(positionY,spaces,-1,positionX);
                        positionY -=spaces;
                        break;
                    }

            }
        }
    }

    private boolean validateMove(Directions.TurtleDirections directions, int spaces){

        //North
        if (directions==Directions.TurtleDirections.NORTH&& (positionX-spaces)<0){
            Messages.invalidMove(directions,positionX);
            return false;

        }
        //East
        if (directions==Directions.TurtleDirections.EAST&& (positionY+spaces)>GameBoard.GAME_BOARD_SIZE-1){

            Messages.invalidMove(directions,GameBoard.GAME_BOARD_SIZE-positionY-1);
            return false;

        }

        //South
        if (directions==Directions.TurtleDirections.SOUTH&& (positionX+spaces)>GameBoard.GAME_BOARD_SIZE-1){

            Messages.invalidMove(directions,GameBoard.GAME_BOARD_SIZE-positionX-1);
            return false;

        }

        //West
        if (directions==Directions.TurtleDirections.WEST&& (positionY-spaces)<0){

            Messages.invalidMove(directions,positionY);

        }
        return true;


    }
}
