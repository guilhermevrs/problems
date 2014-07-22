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

	public static void main(String args[]){
		Main mywork = new Main();
		mywork.Begin();
	}


	void Begin(){
		int nStudents;
		String input;
		StringTokenizer idata;

		int totalSpent;
		int fairCost;
		int more, less;
		int[] costs;

		boolean round;

		while((input = Main.ReadLn(255))!=null){

			idata = new StringTokenizer(input);
			nStudents = Integer.parseInt(idata.nextToken());
			if(nStudents == 0)
				break;

			totalSpent = 0;
			costs = new int[nStudents];
			int currentCost = 0;

			for(int i = 0; i<nStudents; i++){
				input = Main.ReadLn(255);
				
				input = input.replace(",","");

				currentCost = (int)(Float.parseFloat(input) * 100);
				costs[i] = currentCost;
				totalSpent += currentCost;
			}

			round = (totalSpent % nStudents != 0);


			fairCost = totalSpent / nStudents;
			more = 0;
			less = 0;

			for(int i=0; i<nStudents; i++){
				if(round && costs[i]>=fairCost + 1)
					more += (costs[i] - (fairCost+1));
				else if(!round && costs[i]>fairCost)
					more += (costs[i] - fairCost);
				else
					less += (fairCost - costs[i]);

			}

			int amountExchange = (more > less)? more : less;

			System.out.print("$"+(amountExchange/100) + ".");
			
			if(less % 100 < 10)
				System.out.print("0");

			System.out.println(amountExchange % 100);
		}
	}


}