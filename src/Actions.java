/**
 * Created by Maksim.Muzafarov on 15.09.14.
 */
public class Actions {

    public static void fillA(Bottle A, Bottle B) {
        do {
           B.fillFull();
           B.transferTo(A);
        } while(!A.isFull());
    }

    public static void process(Bottle A, Bottle B, int goal) {
        while ((A.getWaterVolume() != goal) & (B.getWaterVolume() != goal)) {
            fillA(A, B);
            A.empty();
            B.transferTo(A);
        }
    }


}
