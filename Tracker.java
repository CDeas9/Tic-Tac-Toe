
/**
 * Write a description of class Tracker here.
 * 
 * @author Callie 
 * @version 12-24-2017
 */
public class Tracker
{
    private String[] board;
    private String[] spaces;
    private String xMove;
    private String oMove;
    public boolean isOver;
    public int timesWon1;
    public int timesWon2;
    public int numOfMoves;
    public String player1;
    public String player2;

    /**
     * Constructor for objects of class Tracker
     */
    public Tracker(String player1, String player2)
    {
        board = new String[] {"a1", "a2", "a3", "b1", "b2", "b3", "c1", "c2", "c3"};
        spaces = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
        xMove = "X";
        oMove = "O";
        isOver = false;
        timesWon1 = 0;
        timesWon2 = 0;
        numOfMoves = 0;
        this.player1 = player1;
        this.player2 = player2;
    }

    /** A method the returns if a move is valid or invalid
     *
     *@param move of what type of move they made
     *@param whereTo for where on the board it will go
     *@return boolean true or false
     */
    public boolean isValidMove(String move, String whereTo)
    {
        for(int i = 0; i< board.length; i++){
            if(whereTo.equals(board[i])){
                if(spaces[i].equals(xMove) || spaces[i].equals(oMove)){
                    return false;
                }
            }
        }
        if(move.equals(xMove) || move.equals(oMove)){
            for(int i = 0; i< board.length; i++){
                if(whereTo.equals(board[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * A method to make a move on the board
     * 
     * @param move is an string that represents if the player is playing an x or o
     * @param whereTo is a string saying where the move is being placed
     */
    public String makeMove(String move, String whereTo)
    {
        for(int i = 0; i < board.length; i++){
            if(whereTo.equals(board[i])){
                spaces[i] = move;
            }
        }
        numOfMoves++;
        return "You placed " + move + " in " + whereTo;
    }

    /** 
     * A method to see who has won the game. Adds one to timesWon.
     * 
     * @return a string of which player won.
     */
    public String whoWon()
    {
        if(!isOver) return "The game is not over";
        if(spaces[0] == spaces[1] && spaces[1] == spaces[2] && spaces[0] == xMove){
            timesWon1++;
            return player1 + " has won";
        }else if(spaces[3] == spaces[4] && spaces[4] == spaces[5] && spaces[3] == xMove){
            timesWon1++;
            return player1 + " has won";
        }else if(spaces[6] == spaces[7] && spaces[7] == spaces[8] && spaces[6] == xMove){
            timesWon1++;
            return player1 + " has won";
        }else if(spaces[0] == spaces[3] && spaces[3] == spaces[6] && spaces[0] == xMove){
            timesWon1++;
            return player1 + " has won";
        }else if(spaces[1] == spaces[4] && spaces[4] == spaces[7] && spaces[1] == xMove){
            timesWon1++;
            return player1 + " has won";
        }else if(spaces[2] == spaces[5] && spaces[5] == spaces[8] && spaces[2] == xMove){
            timesWon1++;
            return player1 + " has won";
        }else if(spaces[0] == spaces[4] && spaces[4] == spaces[8] && spaces[0] == xMove){
            timesWon1++;
            return player1 + " has won";
        }else if(spaces[2] == spaces[4] && spaces[4] == spaces[6] && spaces[2] == xMove){
            timesWon1++;
            return player1 + " has won";
        }
        //Question 1
        else if(spaces[0].equals(spaces[2]) && spaces[2].equals(spaces[6]) && 
        spaces[6].equals(spaces[8]) && spaces[0].equals(xMove)){
            timesWon1++;
            return player1 + " has won";
        }
        if(spaces[0] == spaces[1] && spaces[1] == spaces[2] && spaces[0] == oMove){
            timesWon2++;
            return player2 + " has won";
        }else if(spaces[3] == spaces[4] && spaces[4] == spaces[5] && spaces[3] == oMove){
            timesWon2++;
            return player2 + " has won";
        }else if(spaces[6] == spaces[7] && spaces[7] == spaces[8] && spaces[6] == oMove){
            timesWon2++;
            return player2 + " has won";
        }else if(spaces[0] == spaces[3] && spaces[3] == spaces[6] && spaces[0] == oMove){
            timesWon2++;
            return player2 + " has won";
        }else if(spaces[1] == spaces[4] && spaces[4] == spaces[7] && spaces[1] == oMove){
            timesWon2++;
            return player2 + " has won";
        }else if(spaces[2] == spaces[5] && spaces[5] == spaces[8] && spaces[2] == oMove){
            timesWon2++;
            return player2 + " has won";
        }else if(spaces[0] == spaces[4] && spaces[4] == spaces[8] && spaces[0] == oMove){
            timesWon2++;
            return player2 + " has won";
        }else if(spaces[2] == spaces[4] && spaces[4] == spaces[6] && spaces[2] == oMove){
            timesWon2++;
            return player2 + " has won";
        }
        //Question 1
        else if(spaces[0].equals(spaces[2]) && spaces[2].equals(spaces[6]) && 
        spaces[6].equals(spaces[8]) && spaces[0].equals(oMove)){
            timesWon2++;
            return player2 + " has won";
        }

        if(numOfMoves >= 9 && isOver){
            isOver = false;
            return "It is a tie.";
        }
        return "The game is over.";
    }

    /**
     * A method to check the state of the board
     */
    public String toString()
    {   
        String state = "  1   2   3\n" + "a " + spaces[0] + " | " + spaces[1] + " | " + spaces[2] + " |\n" + "b " 
            + spaces[3] + " | " + spaces[4] + " | " + spaces[5] + " |\n" + "c "+ spaces[6] + " | " + spaces[7] 
            + " | " + spaces[8] + " |";
        return state;

    }
    
    public void resetBoard(){
        spaces =  new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
        isOver = false;
        numOfMoves = 0;
    }

    /**
     * A method to check if the game is over or not
     * 
     * @return boolean to know if it is over or is still going
     */
    public boolean isOver()
    {
        if(spaces[0].equals(spaces[1]) && spaces[1].equals(spaces[2]) 
        && (spaces[0].equals(xMove) || spaces[0].equals(oMove)))
        {
            isOver = true;
        }else if(spaces[3].equals(spaces[4]) && spaces[4].equals(spaces[5])
        && (spaces[3].equals(xMove) || spaces[3].equals(oMove)))
        {
            isOver = true;
        }else if(spaces[6].equals(spaces[7]) && spaces[7].equals(spaces[8])
        && (spaces[6].equals(xMove) || spaces[6].equals(oMove)))
        {
            isOver = true;
        }else if(spaces[0].equals(spaces[3]) && spaces[3].equals(spaces[6])
        && (spaces[0].equals(xMove) || spaces[0].equals(oMove)))
        {
            isOver = true;
        }else if(spaces[1].equals(spaces[4]) && spaces[4].equals(spaces[7]) 
        && (spaces[1].equals(xMove) || spaces[1].equals(oMove)))
        {
            isOver = true;
        }else if(spaces[2].equals(spaces[5]) && spaces[5].equals(spaces[8]) 
        && (spaces[2].equals(xMove) || spaces[2].equals(oMove)))
        {
            isOver = true;
        }else if(spaces[0].equals(spaces[4]) && spaces[4].equals(spaces[8])
        && (spaces[0].equals(xMove) || spaces[0].equals(oMove)))
        {
            isOver = true;
        }else if(spaces[2].equals(spaces[4]) && spaces[4].equals(spaces[6])
        && (spaces[2].equals(xMove) || spaces[2].equals(oMove)))
        {
            isOver = true;
        }
        //Question 1
        else if(spaces[0].equals(spaces[2]) && spaces[2].equals(spaces[6]) && 
        spaces[6].equals(spaces[8]) && (spaces[0].equals(xMove) || spaces[0].equals(oMove))){
            isOver = true;
        }
        if(numOfMoves >= 9 && !isOver){
            isOver = true;
        }
        return isOver;
    }

    /**
     * A method to check how many moves have been played
     * 
     * @return String of the amount of moves
     */
    public String numOfMoves(){
        return ("There has been " + numOfMoves + " moves");
    }

    /**
     * A method that says how many times the X and O player has won
     * 
     * @return String of times they won
     */
    public String timesWon(){
        return (player1 + " has won " + timesWon1 + " and " + player2 + " has won " + timesWon2); 
    }
    
    public void quit(){
        isOver = true;
    }

}

