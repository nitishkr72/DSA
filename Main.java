import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,1,1,2,2,2,3,3,3,4,5,6,7,7));
        ArrayPart1 arrayPart1 = new ArrayPart1(arr);

        arrayPart1.run();
    }

}
