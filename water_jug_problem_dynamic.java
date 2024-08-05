import java.util.Scanner;// a statement to take input
class State { // calss 
    int x;//current state of jug 1
    int y;//current state of jug 2
    State(int x, int y) // constructor overloading
    {
        this.x = x;// this: self referrence variable
        this.y = y;
    }
}

public class JugProblem // a class  
{
    static void present(State state)//a method 
    {
        System.out.printf("Current state - Jug1: %d, Jug2: %d%n", state.x, state.y);// a statement that displays the current state of the jugs
    }
    static void Problem(int a, int b, int p, int q) // a method that contains logic
    {
        State state = new State(0, 0);// initial state
        while (!(state.x == p && state.y == q)) // a loop and if the condition true it executes the statements
        {
            if (state.y == 0) //  if jug 1 is empty
            {
                state.y = b;// Fill Jug1 if it is empty
                System.out.println("Filling the Jug2");
            } else if (state.x == a)// if jug 2 is full
            {
                state.x = 0;// Empty Jug2 if it is full
                System.out.println("Emptying the Jug1");
            } else if (state.x < a)//if jug 1 is not full
            {
                // Pour Jug1 into Jug1
                int transfer = (state.y + state.x <= a) ? state.y : (a - state.x);// state of jug2+state of jug1<=jug1.. if true: state of jug 2,if false: jug1 -state of jug2. and value stored in tranfer (i.e., temporary variable)
                state.y -= transfer;//state of y=state of y-transer
                state.x += transfer;//state of x=state of x+ transer
                System.out.println("Pouring Jug1 into Jug2");
            } else if (state.y == b) // if jug 2 is full
            {
                state.y = 0;// Empty Jug2 if it is full
                System.out.println("Emptying Jug1");
            }
            present(state);// to print current state of jugs
            if (state.x == p && state.y == q) // if they reach final state 
            {
                break;
            }
        }

        System.out.printf("Final state reached - Jug1: %d, Jug2: %d%n", state.x, state.y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacities of Jug1 and Jug2: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.print("Enter the final state of Jug1 and Jug2: ");
        int p = scanner.nextInt();
        int q = scanner.nextInt();

        Problem(a, b, p, q);

        scanner.close();
    }
}
