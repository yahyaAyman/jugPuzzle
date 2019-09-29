package ca.utoronto.utm.assignment1.q1;
/**
 * 
 * @author aymanels 
 *
 */

public class JugPuzzle {
	public static Jug jug0 = new Jug(0, 8, 8);
	public static Jug jug1 = new Jug(1, 5, 0);
	public static Jug jug2 = new Jug(2, 3, 0);
	static int counter = 0;

	
	
	public int getMoves(){
		{
		return (counter);
		}
	}

	public static void move(int from, int to) {
		// moves units of water from one jug to another
		Jug moveFrom = null ;
		Jug moveTo = null;
		
		if (from == 0){
			moveFrom = jug0;
		}
		if (from == 1) {
			moveFrom = jug1;
		}
		if (from == 2) {
			moveFrom = jug2;
		}
		if (to == 0) {
			moveTo = jug0;
		}
		if (to == 1) {
			moveTo = jug1;
		}
		if (to == 2) {
			moveTo = jug2;
		}
		
		if (moveFrom.name == moveTo.name) {
			counter++;
		}
			
		else if(moveFrom.name != moveTo.name) {
			if (moveFrom.capacity > moveTo.size- moveTo.capacity) {
				int amountToMove = moveTo.size - moveTo.capacity;
				moveFrom.capacity = moveFrom.capacity - amountToMove;
				moveTo.capacity = moveTo.capacity + amountToMove;
					counter++;
			}
		
			else if (moveFrom.capacity <= moveTo.size) {
				moveTo.capacity = moveFrom.capacity + moveTo.capacity;
				moveFrom.capacity = 0;
					counter++;
			}
			else if(moveFrom.name != moveTo.name) {
				if (moveTo.size == moveTo.capacity) {
					counter++;
				}
		}}
		}
		
		
		
	public String toString() {
		return counter +" " + jug0.toString() + " " + jug1.toString() + " " + jug2.toString();
	}
				
	
	
	// Returns True if the puzzle is solved
	public boolean isPuzzleSolved() {
		if (jug0.capacity == 4 && jug1.capacity == 4) {
			return true;}
		return false;}
	}

