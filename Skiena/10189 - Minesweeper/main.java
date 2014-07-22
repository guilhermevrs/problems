import java.util.Scanner;

class Main{
 
  private static int[] arr = { -1, 0, 1 };
 
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int count = 1;
    while (sc.hasNextInt()) {
      int y = sc.nextInt();
      int x = sc.nextInt();
      if (x == 0 && y == 0)
        break;
      if (count != 1)
        System.out.println();
      char[][] field = new char[y + 2][x + 2];
      for (int i = 0; i < y; i++) {
        String t = sc.next();
        for (int j = 0; j < x; j++)
          field[i + 1][j + 1] = t.charAt(j);
      }
 
      for (int i = 0; i < y; i++) {
        for (int j = 0; j < x; j++) {
          int mines = 0;
          if (field[i + 1][j + 1] == '*')
            continue;
          if (field[i + 1][j + 1] == '.') {
            for (int zz = 0; zz < arr.length; zz++)
              for (int yy = 0; yy < arr.length; yy++)
                if (zz == 1 && yy == 1)
                  continue;
                else if (field[i + 1 + arr[zz]][j + 1 + arr[yy]] == '*')
                  mines++;
 
            String zxc = "" + mines;
            field[i + 1][j + 1] = (zxc.charAt(0));
          }
 
        }
      }
 
      System.out.println("Field #" + count + ":");
      for (int i = 0; i < y; i++) {
        for (int j = 0; j < x; j++) {
          if (j != x - 1)
            System.out.print(field[i + 1][j + 1]);
          else
            System.out.println(field[i + 1][j + 1]);
        }
      }
      count++;
    }
    sc.close();
  }
}