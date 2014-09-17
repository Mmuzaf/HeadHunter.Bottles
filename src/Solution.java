/**
 * Add comment here
 * <p/>
 * HeadHunter.Bottles
 * Pakage PACKAGE_NAME
 * By @author Mmuzaf
 * Created at 14.09.14
 */
import java.util.Scanner;

public class Solution {

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        // Для считывания воспользуемся классом Scanner
        // Для вывода - классом PrintWriter
        Scanner scanner = new Scanner(System.in);

        int a;
        System.out.print("Enter volume of bottle A: ");
        a = scanner.nextInt();
        int b;
        System.out.print("Enter volume of bottle B: ");
        b = scanner.nextInt();
        int goal;
        System.out.print("Enter goal: ");
        goal = scanner.nextInt();

        if ((goal != 1) & ((goal / gcd(a, b)) != 0) & (goal > Math.max(a, b))) {
            System.out.println("Solution doesn't exists;");
        } else {
            SearchAsTree bl = new SearchAsTree(a, b);
            bl.search(goal);
        }
//        Bottle A = new Bottle(a);
//        Bottle B = new Bottle(b);
//        //B.fillFull();
//        //A.transferTo(B);
//        Actions.process(A, B, goal);
//        System.out.println("=======================");
//        A.empty();
//        B.empty();
//        Actions.process(B, A, goal);
        // После выполнения программы необходимо закрыть
        // потоки ввода и вывода
        scanner.close();

    }
}