package ca.utoronto.utm.assignment1.puzzle;

import ca.utoronto.utm.assignment1.q2.JugPuzzle;

/**
 * An abstract Puzzle class which includes a generic algorithm 
 * to solve them. To take advantage of the solver, a user subclasses
 * this class as well as implements their own Move class.
 * 
 * @author arnold
 * NOTE: YOU ARE NOT ALLOWED TO MODIFY ANY PART OF THIS PACKAGE!!
 */
//Returns the total moves done by the user to solve the puzzle

public abstract class Puzzle {
	/**
	 * Required by solve, after execution of nextStates, all 
	 * puzzles which are one move away from this puzzle should
	 * have been added to states. Be careful that each puzzle is an 
	 * independent copy of this puzzle. 
	 * 
	 * The user should execute the following algorithm.
	 * public void nextStates(States states){
	 *     for(move in allPossibleMoves){
	 *         tempPuzzle = this.copy()
	 *         tempPuzzle.move()
	 *         states.add(tempPuzzle, move)
	 *     }
	 * }
	 * 
	 * @param states initially empty, will contain all puzzle states 
	 * reachable from this by the execution of one valid puzzle move.
	 */
	public abstract void nextStates(States states);
	public abstract boolean isPuzzleSolved();
	
	public static void solve(Puzzle p) {
		States previousStates=new States();
		previousStates.add(p, null);//adds a puzzle and a move //javadoc for me to follow through
		
		while(true) {
			States nextStates=new States();
			for(State s: previousStates) {
				if(s.getPuzzle().isPuzzleSolved()) {
					printSolution(s);
					return;
				}
				nextStates.setPreviousState(s);
				s.getPuzzle().nextStates(nextStates);
			}
			if(nextStates.isEmpty()) {
				System.out.println("No solution");
				return;
			}
			previousStates=nextStates;
		}
	}
	
	
	/**
	 * Print out the sequence of moves needed to solve the puzzle.
	 * @param s
	 */
	private static void printSolution(State s) {
		if(s.getMove()==null)return;
		printSolution(s.getPreviousState());
		System.out.println(s.getMove());
	}
	public static void solve(JugPuzzle jugPuzzle) {
		// TODO Auto-generated method stub
		
		
	}
}
