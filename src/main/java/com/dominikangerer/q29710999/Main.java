package com.dominikangerer.q29710999;


public class Main {

	public static void printShampooInstructions(int numCycles) {

        // i = 1 - i < (2+1=3) -> i will become 1 and than 2 -> done
        for (int i = 1; i < (numCycles+1); i++) {
            // this would be displayed every time you go throw the loop
            // System.out.println(i + ": Lather and Rise.");
            if (numCycles < 1) {
                System.out.println("Too few.");
            } else if (numCycles >= 4) {
                System.out.println("Too many");
            } else {
                System.out.println(numCycles + ": Lather and rinse.");
            }
        }
        // Done goes here because only after the loop we are done
        System.out.println("Done");
    }


    public static void main(String[] args) {
        printShampooInstructions(2);
        
        return;
    }

}
