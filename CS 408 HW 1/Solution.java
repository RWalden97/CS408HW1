import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {

          File file = new File("input.txt");
          int n, a, b;
        try {
        Scanner scan = new Scanner(file);

        n = scan.nextInt();
        if (n < 1 || n > 1000000000) {
          try{ PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
          System.setOut(out);}
          catch(FileNotFoundException f){System.out.println("INVALID OUTPUT");}
          System.out.println("INVALID INPUT");
          return;
        }
        a = scan.nextInt();
        if (a < 1 || a > 1000000000) {
          try{ PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
          System.setOut(out);}
          catch(FileNotFoundException f){System.out.println("INVALID OUTPUT");}
          System.out.println("INVALID INPUT");
          return;
        }
        b = scan.nextInt();
        if (b < 1 || b > 1000000000 || b < a) {
          try{ PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
          System.setOut(out);}
          catch(FileNotFoundException f){System.out.println("INVALID OUTPUT");}
          System.out.println("INVALID INPUT");
          return;
        }

        int counter = 0;
        int sIndex = a, eIndex = 0;
        boolean firstLoop = true;
        Map<Integer, Character> map = new TreeMap<>();
        boolean[] wasCounted = new boolean[b + 1];
        // Write your code here.

        int i,j,k;
        for(i = 0; i < n; i++) {

          char c = scan.next().charAt(0);
          //System.out.println("char is " + c);

          eIndex = scan.nextInt();

          map.put(eIndex, c);
        }
        scan.close();

        Set sortedData = map.entrySet();
        Iterator iterator = sortedData.iterator();



        while(iterator.hasNext()) {

          Map.Entry end = (Map.Entry)iterator.next();
          System.out.print(end.getKey() + ": ");
              System.out.println(end.getValue());

            if (!firstLoop) {

            sIndex = eIndex;
            eIndex = (int)end.getKey();
            //System.out.println("Start: " + sIndex + "End: " + eIndex + "\n");
            if (map.get(sIndex) == 'S' && map.get(eIndex) == 'S') {
             /*if (i == 1) {
                counter += (eIndex - sIndex + 1);
              }
              else*/
                counter += eIndex - sIndex;
            }
            else if (map.get(sIndex) == 'N' && map.get(eIndex) == 'S')
              counter += (eIndex - sIndex) / 2 + 1;

            else if(map.get(sIndex) == 'S' && map.get(eIndex) == 'N')
              counter += (eIndex - sIndex) / 2;
        }
        else {

          sIndex = a;
          eIndex = (int)end.getKey();
          //System.out.println(i + "Start: " + sIndex + "End: " + eIndex + "\n");
          if(map.get(eIndex) == 'S') {
            counter += eIndex - sIndex + 1;
          }

          firstLoop = false;
        }
      }

      sIndex = eIndex;
      eIndex = b;
      //System.out.println(i + "Start: " + sIndex + "End: " + eIndex + "\n");
      if (map.get(sIndex) == 'S') {
          counter += eIndex - sIndex;
      }
      PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
      System.setOut(out);
      System.out.println(counter);
      }
      catch (FileNotFoundException e) {

        try{ PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);}
        catch(FileNotFoundException f){System.out.println("INVALID OUTPUT");}
        System.out.println("INVALID INPUT");}

    }
}
