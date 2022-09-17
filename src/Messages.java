
    public final class Messages{
        public static void instructions(){


            System.out.println("Type your commands to draw on the game board");
            System.out.println("1=pen up; 2= pen down");
            System.out.println("3 = North, 4 = East, 5 = South, 6 = West");
            System.out.println("7 = Quit");

        }

        public static String errorMessage="";
        public static void  invalidInput(){
            errorMessage="\nINVALID INPUT.Input must be an integer between 1 -7\n";
        }

        public static void invalidMove(Directions.TurtleDirections direction, int spaces ){
            errorMessage="\nINVALID MOVE. You can only move "+ spaces+" spaces to the "+direction+ "\n";
        }


}
