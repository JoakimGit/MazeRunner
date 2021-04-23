Given a maze represented by 1s and 0s in columns and rows like the following:

6
0, 1, 0, 1, 1, 1, 1
1, 0, 1, 1, 0, 0, 0
2, 1, 0, 0, 1, 0, 0
3, 0, 0, 1, 0, 1, 0
4, 1, 1, 1, 1, 0, 1
5, 1, 1, 0, 1, 1, 1
7
0, 1, 1, 1, 1, 1
1, 0, 0, 1, 0, 0
2, 0, 1, 1, 1, 0
3, 0, 0, 0, 0, 0
4, 1, 1, 0, 1, 0
5, 0, 1, 1, 0, 0
6, 1, 1, 1, 1, 1

Where the first block is the rows and the second is columns. A 1 means a wall and a 0 means no wall. 

The 'bug' will find it's way through the maze starting outside the entrance and ending 1 step outside the maze.
The entrance is denoted by an opening (the 0) at the bottom of the maze (the first line in the block of rows).
The exit is denoted by an opening in the last line in the row block, or an opening in the first/last line in the column block.
