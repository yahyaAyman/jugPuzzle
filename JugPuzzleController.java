package ca.utoronto.utm.assignment1.q1;
import java.io.*;
import java.util.*;
/**
 * @author aymanels
 * This class allows a console user to play an instance of JugPuzzle.
 */




public class JugPuzzleController {


        private static final String INVALID_INPUT_MESSAGE="Invalid number, please enter 0,1 or 2";

        private Scanner scanner;
        private JugPuzzle jugPuzzle;


        /**
         * Constructs a new JugPuzzleController with a new JugPuzzle, 
         * ready to play with a user at the console.
         */
        public JugPuzzleController(){
                jugPuzzle=new JugPuzzle();
                scanner=new Scanner(System.in);
        }

        /**
         * FILL THIS IN (checks if the entry made by the user is valid)
         * To see what good documentation looks like, look at the API documentation, 
         * for example ArrayList (in the bottom left frame) at 
         * http://download.oracle.com/javase/8/docs/api/
         * this documentation was created using Javadoc. 
         * FILL THIS IN (makes sure the input or desired move made by the user is valid)
         * @param message (required move of what is happening to the water by the user in the jar "spilled from or poured into")
         * @param lower   (prints the moves of jugs starting from "lower" number of a jug)
         * @param upper   (prints the moves of jugs up until "upper" number of a jug)
         * @return        (returns the move if it a valid entry by the user)
         */
        private int getMove(String message, int lower, int upper){
                int move;
                while(true){
                        try {
                                System.out.print(message);
                                String line=scanner.nextLine();
                                move=Integer.parseInt(line);
                                if(lower<=move && move<=upper){
                                        return move;
                                } else {
                                        System.out.println(INVALID_INPUT_MESSAGE);
                                }
                        }
                        catch(NumberFormatException e){
                                System.out.println(INVALID_INPUT_MESSAGE);
                        }
                }
        }
    
        /**
         * FILL THIS IN (makes the moves after confirming its validity by the getMove method)
         */
        public void play(){
                while(!jugPuzzle.isPuzzleSolved()){
                        System.out.println(jugPuzzle); // called the toString() method of jugPuzzle
                        int from, to;
                        from = getMove("spill from jug: ", 0,2);
                        to   = getMove("into jug: ",0,2);
                        JugPuzzle.move(from,to);
                }
                if(jugPuzzle.getMoves()==1) {
                    System.out.println("Congrats you solved it in "+jugPuzzle.getMoves()+" move!!");
                } else {
                	System.out.println("Congrats you solved it in "+jugPuzzle.getMoves()+" moves!!");
                }
        }

        public static void main(String [] args){
                JugPuzzleController jpcc=new JugPuzzleController();
                jpcc.play();
        }
}
