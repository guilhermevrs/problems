import java.io.*;
import java.util.*;

class Main
{

    private Hashtable hash;

    static String ReadLn (int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";

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

    public static void main (String args[])  // entry point from OS
    {
        Main myWork = new Main();  // create a dinamic instance
        myWork.Begin();            // the true entry point
    }

    private boolean isOdd(int n)
    {
	return n % 2 != 0;
    }

    private int calculateCycle(int n, int min, int max)
    {
	int cycle = 0;

	//Maybe we have already calculate the value;
	if(hash.containsKey(n))
		return (int)hash.get(n);


	if(n == 1)
		return 1;

	//Iterate until we reach 1 (final cycle) or we reach a number between our desired range
	do{
		cycle++;
		if(this.isOdd(n))
			n = (3*n)+1;
		else
			n = n/2;

	}while(n != 1 && (n >= max || n <= min));

	if(n==1)  //We reached the final
		return ++cycle;
	else      //We reached a number between our desired range
		return cycle + this.calculateCycle(n, min, max);		

    }

    void Begin()
    {
        String input;
        StringTokenizer idata;
        int a, b, min, max, cycle, cyclemax;

        while ((input = Main.ReadLn (255)) != null)
        {
          idata = new StringTokenizer (input);
          a = Integer.parseInt (idata.nextToken());
          b = Integer.parseInt (idata.nextToken());
          if (a < b) { min=a; max=b; } else { min=b; max=a; }
          
	  hash = new Hashtable();

	  cyclemax = 0;

	  for(int i = max; i>=min; i--){
		cycle = this.calculateCycle(i, min, max);
		hash.put(i, cycle);
		if(cycle > cyclemax)
			cyclemax = cycle;
	  }

          System.out.println (a + " " + b + " " + cyclemax);
        }
    }
}