The iterative algorithm for the Hanoi tower problem is less well-known than the recursive one.
First, we arrange the pegs in a circle, so that clockwise we have A, B, C, and then A again.
Following this, assuming we never move the same disk twice in a row, there will always only
be one disk that can be legally moved, and we transfer it to the first peg it can occupy, moving
in a clockwise direction, if n is even (2, 4, 6,…), and counterclockwise, in n is odd (1, 3, 5,…).
(See Brachman & Levesque (2004), “Knowledge representation and reasoning”, p. 133–134,
Exercise 2). Write a program. The program (1) reads and prints n; (2) prints the initial state, e.g.
“A=(3,2,1), B=(), C=().” in case n=3; and (3) prints the state after each move, e.g., “1. Move
disk 1 from A to C. A=(3,2), B=(), C=(1).” as shown in the previoussection. The program checks
and prints for correct n being between 1 and 10.



The same task as before, however, i am using a different method to solve this one.
For the record first one was iterative.