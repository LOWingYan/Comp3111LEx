package org.example;

/*
 * note the bad coding style (deliberately written for debugging exercise) 
 */
public class main {
	public static void main(String[] args) {
		Animal animals[] = new Animal[10];

		for (int i = 0; i < animals.length;  ++i) // modified
			animals[i] = new Animal(); // modified

		for (int iii = 0; iii < 10; iii++) {
			int ii = 0;
			for (; ii < 100 && animals[iii].isAlive() ; ii++) {
				System.out.print(animals[iii].getWeight() + " ");
				animals[iii].eat();
				if (ii % 3 == 0)
				animals[iii].poo();
			}
		}
	}
}


/*
 * "modified" Explanation:
 *
 * The bug is in line 10-11 [original code: for(Animal a: animals) a = new Animal()]
 * As when we create the array of object, java initializes the elements as "null"
 * Then we enter the for loop with a new variable "a"
 * but "a" is an instance variable, the alias of the "null" but not the real array elements, which means when we iterate the array and assign the new Animal()
 * it only updates the alias "a" and temporarily reference to the Animal object which will be collected by garbage collector after the for-loop block
 * while the real array elements are not modified
 * so the NullPointerException occurs when we use the array elements (null) to access the Animal methods
 *
 * To fix that, we only have to directly assign the array elements to new Animal() without making any new variable
 */