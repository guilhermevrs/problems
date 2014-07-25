import java.util.*;

class Main{

	private static final int MAX_ALG = 8;

	public static void main(String[] args){

		//Input
		int s;
		String n;

		int width, height;
		int[] algarismos;

		Scanner scan = new Scanner(System.in);

		while(true){

			s = scan.nextInt();
			n = scan.next();

			if(s == 0 && n.contains("0"))
				break;

			width = s + 2;
			height = 2*s + 3;
	
			algarismos = getAlgarismos(n);

			StringBuilder output = new StringBuilder();

			for(int i=0; i<height; i++){
				for(int j = MAX_ALG -1; j>= 0; j--){
					switch(algarismos[j]){
						case 1:	output.append(printNumber1InStage(i,height,width,s)); break;
						case 2:	output.append(printNumber2InStage(i,height,width,s)); break;
						case 3:	output.append(printNumber3InStage(i,height,width,s)); break;
						case 4:	output.append(printNumber4InStage(i,height,width,s)); break;
						case 5:	output.append(printNumber5InStage(i,height,width,s)); break;
						case 6:	output.append(printNumber6InStage(i,height,width,s)); break;
						case 7:	output.append(printNumber7InStage(i,height,width,s)); break;
						case 8:	output.append(printNumber8InStage(i,height,width,s)); break;
						case 9:	output.append(printNumber9InStage(i,height,width,s)); break;
						case 0: output.append(printNumber0InStage(i,height,width,s)); break;
						default: break;
					}
					if(algarismos[j] != -1 && j != 0)
						output.append(" ");
				}
				output.append('\n');
			}

			System.out.println(output.toString());

		}
	}

	static int[] getAlgarismos(String n){
		int[] algarismos = new int[MAX_ALG];
		int index = 0;
		char[] charn = n.toCharArray();

		for(int i =0; i < MAX_ALG; i++)
			algarismos[i] = -1;

		for(int i = charn.length - 1; i>=0; i--)
			algarismos[index++] = Integer.parseInt("" + charn[i]);
		return algarismos;
	}

	static String printNumber1InStage(int stage, int height, int width, int s){
		StringBuilder build = new StringBuilder();
		if( (stage == 0) || (stage == s+1) || (stage == height - 1)){
			for(int i=0; i<width; i++)
				build.append(" ");
		}
		else if( (stage > 0 && stage <= s) || (stage > s+1 && stage < (height - 1) )){
			for(int i=0; i<width-1; i++)
				build.append(" ");
			build.append("|");
		}
		return build.toString();
	}

	static String printNumber2InStage(int stage, int height, int width, int s){
		StringBuilder build = new StringBuilder();
		if( (stage == 0) || (stage == s+1) || (stage == height - 1)){
			build.append(" ");
			for(int i =0; i< s; i++)
				build.append("-");
			build.append(" ");
		}
		else if( (stage > 0 && stage <= s)){
			for(int i=0; i<width-1; i++)
				build.append(" ");
			build.append("|");
		}
		else if( stage > s+1 && stage < (height - 1) ){
			build.append("|");
			for(int i=0; i<width-1; i++)
				build.append(" ");
		}
		return build.toString();
	}

	static String printNumber3InStage(int stage, int height, int width, int s){
		StringBuilder build = new StringBuilder();
		if( (stage == 0) || (stage == s+1) || (stage == height - 1)){
			build.append(" ");
			for(int i=0; i<s; i++)
				build.append("-");
			build.append(" ");
		}
		else if( (stage > 0 && stage <= s) || (stage > s+1 && stage < (height - 1) )){
			for(int i=0; i<width-1; i++)
				build.append(" ");
			build.append("|");
		}
		return build.toString();
	}

	static String printNumber4InStage(int stage, int height, int width, int s){
		StringBuilder build = new StringBuilder();
		if( (stage == 0) || (stage == height - 1)){
			for(int i=0; i<width; i++)
				build.append(" ");
		}
		else if(stage > 0 && stage <= s){
			build.append("|");
			for(int i =0; i< s; i++)
				build.append(" ");
			build.append("|");
		}
		else if(stage == s+1){
			build.append(" ");
			for(int i=0; i<s; i++)
				build.append("-");
			build.append(" ");
		}
		else if( (stage > s+1 && stage < (height - 1)) ){
			for(int i=0; i<width-1; i++)
				build.append(" ");
			build.append("|");
		}
		return build.toString();
	}

	static String printNumber5InStage(int stage, int height, int width, int s){
		StringBuilder build = new StringBuilder();
		if( (stage == 0) || (stage == s+1) || (stage == height - 1)){
			build.append(" ");
			for(int i =0; i< s; i++)
				build.append("-");
			build.append(" ");
		}
		else if( (stage > 0 && stage <= s) ){
			build.append("|");
			for(int i=0; i<width-1; i++)
				build.append(" ");
		}
		else if( stage > s+1 && stage < (height - 1)){
			for(int i=0; i<width-1; i++)
				build.append(" ");
			build.append("|");
		}
		return build.toString();
	}

	static String printNumber6InStage(int stage, int height, int width, int s){
		StringBuilder build = new StringBuilder();
		if( (stage == 0) || (stage == s+1) || (stage == height - 1)){
			build.append(" ");
			for(int i =0; i< s; i++)
				build.append("-");
			build.append(" ");
		}
		else if( (stage > 0 && stage <= s) ){
			build.append("|");
			for(int i=0; i<width-1; i++)
				build.append(" ");
		}
		else if( stage > s+1 && stage < (height - 1)){
			build.append("|");
			for(int i=0; i<s; i++)
				build.append(" ");
			build.append("|");
		}
		return build.toString();
	}

	static String printNumber7InStage(int stage, int height, int width, int s){
		StringBuilder build = new StringBuilder();
		if(stage == 0){
			build.append(" ");
			for(int i=0; i<s; i++)
				build.append("-");
			build.append(" ");	
		}
		else if( (stage > 0 && stage <= s) || (stage > s+1 && stage < (height - 1) )){
			for(int i=0; i<width-1; i++)
				build.append(" ");
			build.append("|");
		}
		else if( (stage == s+1) || (stage == height - 1)){
			for(int i=0; i<width; i++)
				build.append(" ");
		}
		return build.toString();
	}
	
	static String printNumber8InStage(int stage, int height, int width, int s){
		StringBuilder build = new StringBuilder();
		if( (stage == 0) || (stage == s+1) || (stage == height - 1)){
			build.append(" ");
			for(int i =0; i< s; i++)
				build.append("-");
			build.append(" ");
		}
		else if( (stage > 0 && stage <= s) || (stage > s+1 && stage < (height - 1)) ){
			build.append("|");
			for(int i=0; i<s; i++)
				build.append(" ");
			build.append("|");
		}
		return build.toString();
	}

	static String printNumber9InStage(int stage, int height, int width, int s){
		StringBuilder build = new StringBuilder();
		if( (stage == 0) || (stage == s+1) || (stage == height - 1)){
			build.append(" ");
			for(int i =0; i< s; i++)
				build.append("-");
			build.append(" ");
		}
		else if( (stage > 0 && stage <= s) ){
			build.append("|");
			for(int i=0; i<s; i++)
				build.append(" ");
			build.append("|");
		}
		else if( stage > s+1 && stage < (height - 1)){
			for(int i=0; i<width-1; i++)
				build.append(" ");
			build.append("|");
		}
		return build.toString();
	}

	static String printNumber0InStage(int stage, int height, int width, int s){
		StringBuilder build = new StringBuilder();
		if( (stage == 0) || (stage == height - 1)){
			build.append(" ");
			for(int i =0; i< s; i++)
				build.append("-");
			build.append(" ");
		}
		else if( (stage > 0 && stage <= s) || (stage > s+1 && stage < (height - 1)) ){
			build.append("|");
			for(int i=0; i<s; i++)
				build.append(" ");
			build.append("|");
		}
		else if(stage == s+1){
			for(int i=0; i<width; i++)
				build.append(" ");
		}
		return build.toString();
	}

}