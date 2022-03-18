# Maze
Java implementaion of a solution to the maze problem using backtracking.
This works using a txt file that looks like this:  
9 7  
0 3  
1 1 1 Ε 1 1 1  
1 1 1 0 1 1 1  
1 0 0 0 1 0 1  
1 0 1 0 1 0 0  
1 1 1 0 1 1 1  
1 0 0 0 0 0 1  
1 0 1 1 1 0 1  
1 0 1 1 0 0 1  
0 1 1 1 0 1 1  
The first two numbers are the dimensions of our maze.
The next two are the coordinates for the entrance of the maze.
1 symbolizes a wall and 0 a clear path.
Backtracking was achieved using a Stack implementation.
This repository also contains a Queue (FIFO) used for the creation of a Queue with one pointer and an implementation of a linked list for the creation of the Stack and the Queue.
