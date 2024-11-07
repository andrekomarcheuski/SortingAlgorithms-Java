import java.util.ArrayList;

public class InsertionSort {
    public static void insertionSort(ArrayList<Integer> list) {
        int size = list.size();
        int aux;
        for (int i = 1; i < size; ++i) {
            int j = i - 1;
            while (j >= 0 && list.get(j) > list.get(j + 1)) {
                aux = list.get(j);
                list.set(j, list.get(j + 1));
                list.set(j + 1, aux);
                j -= 1;
            }
        }
    }
}