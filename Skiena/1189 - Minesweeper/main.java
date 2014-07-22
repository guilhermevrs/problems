import java.io.*;
import java.util.*;

class Main{
	static String ReadLn (int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;

        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg));
    }

	public static void main (String args[]){
		Main myWork = new Main();
		myWork.Begin();
	}

	void Begin(){
		StringTokenizer idata;
		
		//INPUT
		String input;
		int n, m;
		char[][] matrix;

		//OUTPUT
		int fieldNumber = 0;

		while((input = Main.ReadLn(255)) != null){

			if(fieldNumber > 0)
				System.out.println();

			idata = new StringTokenizer(input);
			n = Integer.parseInt(idata.nextToken());
			m = Integer.parseInt(idata.nextToken());

			if(n == 0 && m == 0)
				break;

			System.out.println("Field #" + (++fieldNumber) + ":" );

			
			matrix = new char[n][m];
			for(int i = 0; i<n; i++){
				matrix[i] = Main.ReadLn(m+2).toCharArray();
			}

			for(int i = 0; i<n; i++){
				for(int j = 0; j<m; j++){
					this.processCell(matrix, i, j, n, m);
				}
				System.out.println();
			}

		}

	}

	private void processCell(char[][] matrix, int i, int j, int n, int m){

		int proximity = 0;		

		if(matrix[i][j] == '*'){
			System.out.print("*");
			return;
		}

		if( (j-1) >= 0)
			proximity = getAddition(matrix, i, j-1);
		if( (i-1) >= 0)
			proximity += getAddition(matrix, i-1, j);
		if( ((i-1) >= 0) && ((j-1) >= 0))
			proximity += getAddition(matrix, i-1, j-1);

		if( (j+1) < m)
			proximity += getAddition(matrix, i, j+1);
		if( (i+1) < n)
			proximity += getAddition(matrix, i+1, j);
		if( ((i+1) < n) && ((j+1) < m))
			proximity += getAddition(matrix, i+1, j+1);

		if( ((i+1) < n) && ((j-1) >= 0))
			proximity += getAddition(matrix, i+1, j-1);
		if( ((i-1) >= 0) && ((j+1) < m))
			proximity += getAddition(matrix, i-1, j+1);

		System.out.print(proximity);

	}

	private int getAddition(char[][] matrix, int i, int j){
		return (matrix[i][j]=='*')? 1 : 0;
	}
}