
import java.util.Scanner;

public class Game {
    private Pen.PenAction pen;
    private Directions.TurtleDirections directions;
    private Turtle turtle;
    private GameBoard gameBoard;
    private  boolean quit; //quit game
    private int option;
    private Scanner scanner;


    public Game(){
        turtle=new Turtle();
        quit=false;
        gameBoard=new GameBoard();
        scanner=new Scanner(System.in);
        pen=Pen.PenAction.UP;
        directions=Directions.TurtleDirections.SOUTH;
    }


    public void gameLoop(){
        gameBoard.initGameBoard();
        do {
            System.out.println(Messages.errorMessage);
            Messages.errorMessage="";
            gameBoard.drawGameBoard(turtle.positionX,turtle.positionY,turtle.turtleSymbol);
            Messages.instructions();//display game instructions
            System.out.println("Pen is "+(pen== Pen.PenAction.UP ? "NOT DRAWING ": "DRAWING"));
            System.out.println("Turtle is moving "+ directions.toString());
            System.out.println("Select your option: ");
            option=Integer.parseInt(scanner.nextLine());
            if (option==1){
                pen=Pen.PenAction.UP;
            } else if (option==2) {
                pen=Pen.PenAction.DOWN;

            } else if (option==3) {
                directions=Directions.TurtleDirections.NORTH;
            } else if (option==4) {
                directions=Directions.TurtleDirections.EAST;
            } else if (option==5) {
                directions=Directions.TurtleDirections.SOUTH;
            } else if (option==6) {
                directions=Directions.TurtleDirections.WEST;
            } else if (option==7) {
                quit=true;
            }else {
                Messages.invalidInput();

            }
            if (option==3 || option==4|| option==5 || option ==6){
                System.out.println("Turtle is moving "+directions.toString());
                System.out.println("Enter number of spaces to move: ");
                int spaces=Integer.parseInt(scanner.nextLine());
                turtle.walk(directions,spaces,pen);
            }


        }while (!quit);
    }



}
