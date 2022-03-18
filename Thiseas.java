import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
public class Thiseas{
	static boolean OutOfMaze(int i, int j, int r, int c) {
        return (i >= 0 && i < r && j >= 0 && j < c); 
    }
	static boolean PossibleExit(char[][] maze, int r, int c){
		for (int n =0; n <r; n++){
			if ((maze[n][0] == '0') || (maze[n][c-1] == '0'))
				return true;
		}
		for (int m =0; m <c; m++){
			if ((maze[0][m] == '0') || (maze[r-1][m] == '0'))
				return true;
		}
		return false;
	}
	public static void main (String[] args){
		try{
				Path path = Paths.get(args[0]);
				Path fileName = path.getFileName();
				Scanner in= new Scanner(new BufferedReader(new FileReader(fileName.toString())));
				int rows = in.nextInt();
				int columns = in.nextInt();
				char[][] maze = new char[rows][columns];
				int start_i = in.nextInt();
				int start_j = in.nextInt();
				while (in.hasNext()){
					for (int i=0; i<rows; i++) {
						String[] line = in.nextLine().trim().split(" ");
						for (int j=0; j<columns; j++) {
							maze[i][j] = in.next().charAt(0);
						}
					}
			    }
				boolean [][]visited=new boolean[rows][columns];
				for (int i = 0; i < visited.length; i++){ 
					for (int j = 0; j < visited[i].length; j++){ 
						visited[i][j] = false; 
					} 
				} 
				StringStackImpl<Integer> stack_I = new StringStackImpl<>();
				StringStackImpl<Integer> stack_J = new StringStackImpl<>();
				stack_I.push(start_i);
				stack_J.push(start_j);
				int mitos = 0;
				boolean done = false;
				if (!(PossibleExit(maze, rows, columns))){
					done = true;
					System.out.println("No exit!!!");
				}
				int i = start_i;
				int j = start_j;
				while (!done && !(stack_I.isEmpty()) && !(stack_J.isEmpty())){
					boolean move = false;
					i = stack_I.peek();
					j = stack_J.peek();
					
					stack_I.pop();
					stack_I.push(i);
					stack_J.pop();
					stack_J.push(j);
					if ((mitos == 0)&&!move){
						if ((OutOfMaze(i-1, j, rows, columns))&&!(visited[i-1][j])&&(maze[i-1][j] == '0')){
								stack_I.push(i-1);
								i = i-1;
								stack_J.push(j);
								visited[i][j]=true;
								move = true;
						}
						mitos+=1;
					}
					if ((mitos == 1)&&!move){
						if ((OutOfMaze(i, j+1, rows, columns))&&!(visited[i][j+1])&&(maze[i][j+1] == '0')){
								stack_I.push(i);
								stack_J.push(j+1);
								j = j+1;
								visited[i][j]=true;
								move = true;
						}
						mitos+=1;
				    }
					if ((mitos == 2)&&!(move)){
						if ((OutOfMaze(i+1, j, rows, columns))&&!(visited[i+1][j])&&(maze[i+1][j] == '0')){
								stack_I.push(i+1);
								i = i+1;
								stack_J.push(j);
								visited[i][j]=true;
								move=true;
						}
						mitos+=1;
					}
					if ((mitos == 3)&&!(move)){
						if ((OutOfMaze(i, j-1, rows, columns))&&!(visited[i][j-1])&&(maze[i][j-1] == '0')){
								stack_I.push(i);
								stack_J.push(j-1);
								j = j-1;
								visited[i][j]=true;
								move=true;
						}
						mitos+=1;
					}
					if (move==false){
						i = stack_I.peek();
						j = stack_J.peek();
						stack_I.pop();
						stack_J.pop();
						visited[i][j]=true;
					}
					mitos=0;
					
					if ((start_i!=stack_I.peek()) && (start_j!=stack_J.peek())){
						if ((stack_I.peek() == rows-1) || (stack_J.peek() == columns-1) || (stack_I.peek() == 0) || (stack_J.peek() == 0)){
							done = true;
							int x=stack_I.peek();
							int y=stack_J.peek();
							System.out.println("Exit!!!");
							System.out.println("Exit coordinates are: "+x+", "+y);
						}
					}
				}
				if (stack_I.isEmpty()||stack_J.isEmpty()){
					System.out.println("No exit!!!");
				}
		}
		catch(IOException ioe){
			System.err.println("Error! File not found!");
			System.exit(1);
		}
	}
}