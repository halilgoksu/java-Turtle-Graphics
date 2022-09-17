
public class GameBoard {
    public final static int GAME_BOARD_SIZE=20; //default size
    public final static char USED_SPACE='O';
    public final static char GAME_BOARD_SYMBOL= '-';
    public static char[][] gameBoardArray; //array we will be updating with our moves


    public  GameBoard(){
    gameBoardArray=new char[GAME_BOARD_SIZE][GAME_BOARD_SIZE];
    }

    public static void updateGameBoardX(int start,int spaceToMove,int upOrDown,int constantY){

        for (int i=0;i<spaceToMove;i++){
            gameBoardArray[start+(i*upOrDown)][constantY]=USED_SPACE;

        }
    }
    public static void updateGameBoardY(int start,int spaceToMove,int leftOrRight,int constantX){
        for (int i=0;i<spaceToMove;i++){
            gameBoardArray[constantX][start+(i*leftOrRight)]=USED_SPACE;

        }
    }

    public void drawGameBoard(int posX,int posY,char turtle){

        for (int i=0;i<GAME_BOARD_SIZE; i++)
        {
            for (int c=0; c<GAME_BOARD_SIZE;c++)
            {
                if (i==posX&&c==posY){
                    System.out.print(turtle);
                }else {
                    System.out.print(gameBoardArray[i][c]);
                }
            }
            System.out.println("");
        }

    }

    public void  initGameBoard(){
        for (int i=0;i<GAME_BOARD_SIZE; i++){
            for (int c=0; c<GAME_BOARD_SIZE;c++){
                gameBoardArray[i][c]=GAME_BOARD_SYMBOL;
            }
        }
    }
}
