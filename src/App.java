import java.util.*;

public class App {
    private static int moveCount = 1; // To count the moves

    /**
     * @param n        The number of disks to move
     * @param source   The peg where disks are initially placed
     * @param auxiliary The auxiliary peg used for intermediate storage
     * @param target   The destination peg where disks should be moved
     * @param state    The current state of the pegs
     */
    private static void hanoi(int n, char source, char auxiliary, char target, Map<Character, Stack<Integer>> state) {
        if (n == 1) { // Move a single disk
            int disk = state.get(source).pop(); // Removing the top disk
            state.get(target).push(disk); // Putting the disk on the target

            // Correcting move count display formatting
            if (moveCount < 10) {
                System.out.println("   " + moveCount + ". Move disk " + disk + " from " + source + " to " + target + ". " + formatState(state));
            } else if (moveCount < 100) {
                System.out.println("  " + moveCount + ". Move disk " + disk + " from " + source + " to " + target + ". " + formatState(state));
            } else if (moveCount < 1000) {
                System.out.println(" " + moveCount + ". Move disk " + disk + " from " + source + " to " + target + ". " + formatState(state));
            } else {
                System.out.println(moveCount + ". Move disk " + disk + " from " + source + " to " + target + ". " + formatState(state));
            }

            moveCount++; // Counting the moves
            return;
        }

        // move n-1 disks from source to auxiliary peg, using target as a temporary peg
        hanoi(n - 1, source, target, auxiliary, state);

        // Move the nth (largest) disk directly from source to target peg
        hanoi(1, source, auxiliary, target, state);

        // Move the n-1 disks from auxiliary peg to target peg, using source as a temporary peg
        hanoi(n - 1, auxiliary, source, target, state);
    }

    /**
     * @param state The state
     * @return gives the state of pegs
     */
    private static String formatState(Map<Character, Stack<Integer>> state) {
        StringBuilder sb = new StringBuilder();
        for (char peg : new char[]{'A', 'B', 'C'}) {
            sb.append(peg).append("=").append(state.get(peg).toString()).append(", ");
        }
        return sb.substring(0, sb.length() - 2); // Remove the trailing comma and space
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of disks (1-10): ");
        int n = scanner.nextInt();

        // Validate input
        if (n < 1 || n > 10) {
            System.out.println("Invalid input. Please enter a number between 1 and 10.");
            scanner.close();
            return;
        }

        // start pegs
        Map<Character, Stack<Integer>> state = new HashMap<>();
        state.put('A', new Stack<>());
        state.put('B', new Stack<>());
        state.put('C', new Stack<>());

        // put disks on a in descending order
        for (int i = n; i >= 1; i--) {
            state.get('A').push(i);
        }

        //  initial state
        System.out.println("Initial state: " + formatState(state));

        // solve the problem using recursive method mine is named hanoi
        hanoi(n, 'A', 'B', 'C', state);
        
        System.out.println("Total number of moves is: " + (moveCount - 1));

        scanner.close();
    }
}
