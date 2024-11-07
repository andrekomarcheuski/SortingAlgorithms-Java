import java.util.ArrayList;

public class BubbleSort {
    public static void bubbleSort(ArrayList<Integer> list) {
        int size = list.size();
        int aux;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < (size - i - 1); j++) {
                if (list.get(j) > list.get(j + 1)) {
                    aux = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, aux);
                }
            }
        }
    }
}