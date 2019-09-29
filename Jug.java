package ca.utoronto.utm.assignment1.q1;

public class Jug {

	
	public int size;
	public int name;
	public int capacity;
	public Jug(int name, int size, int capacity){
			this.name = name;
			this.size = size;
			this.capacity = capacity;
			}
	//outputs a string representation of what the jugs look like after each move made by the user
	public String toString() {
		return this.name + ":" + "(" + this.capacity + "/" + this.size + ")";
		
	}
}