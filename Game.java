import java.util.Scanner;
/**
 * Write a description of class Game here.
 * 
 * @author Callie Deas 
 * @version 1-24-2017
 */
public class Game
{
    /**
     * Constructor for objects of class Game
     */
    public static void main(String player1, String player2)
    {
        Tracker tracker = new Tracker(player1, player2);
        String move, whereTo, numOfMoves;
        boolean playAgain;
        playAgain = true;

        Scanner reader = new Scanner(System.in);

        System.out.println("Welcome to the tic-tac-toe game!");
        System.out.println("Player 1 is Xs and Player 2 is Os. Each player picks a spot ");
        System.out.println("on the board until there is three in a row or a tie.");
        System.out.println("A player can also win by marking all four corners.");
        System.out.println("The board is labeled as");
        System.out.println(tracker.toString());
        numOfMoves = tracker.numOfMoves();
        while(playAgain){
            while(!tracker.isOver()){

                while(true){
                    System.out.println(player1 + " make your move");
                    whereTo = reader.nextLine();
                    if(whereTo.equals("quit")){
                        System.out.println("Thanks for playing!");
                        tracker.quit();
                        break;
                    }

                    if(!tracker.isValidMove("X", whereTo)){
                        System.out.println("Sorry, that is not a valid move. Please try again.");
                        continue;
                    }else System.out.println(tracker.makeMove("X", whereTo));
                    numOfMoves = tracker.numOfMoves();
                    break;
                }
                if(tracker.isOver()){
                    System.out.println(tracker.whoWon());
                    System.out.println(tracker.timesWon());
                    break;
                }

                while(true){
                    System.out.println(player2 + " make your move");
                    whereTo = reader.nextLine();
                    if(whereTo.equals("quit")){
                        System.out.println("Thanks for playing!");
                        tracker.quit();
                        break;
                    }

                    if(!tracker.isValidMove("O", whereTo)){
                        System.out.println("Sorry, that is not a valid move. Please try again.");
                        continue;
                    }else System.out.println(tracker.makeMove("O", whereTo));
                    numOfMoves = tracker.numOfMoves();
                    break;
                }
                if(tracker.isOver()){
                    System.out.println(tracker.whoWon());
                    System.out.println(tracker.timesWon());
                    break;
                }
                System.out.println(numOfMoves);
                System.out.println(tracker.toString());

            }
            System.out.println("Type continue if you want to play again.");
            whereTo = reader.nextLine();
            if(!whereTo.equals("continue")){
                playAgain = false;
            }
            tracker.resetBoard();
        }
    }
}
