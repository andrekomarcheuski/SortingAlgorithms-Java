import java.util.ArrayList;

class QuickSort {
    public static void quickSort(ArrayList<Integer> list, int firstNum, int lastNum) {
        if (firstNum < lastNum) {
            int pivot = list.get(firstNum);
            int left = firstNum + 1;
            int right = lastNum;

            while (left <= right) {
                while (left <= right && list.get(left) <= pivot) {
                    left++;
                }
                while (right >= left && list.get(right) > pivot) {
                    right--;
                }
                if (left < right) {
                    swap(list, left, right);
                    left++;
                    right--;
                }
            }
            swap(list, firstNum, right);
            quickSort(list, firstNum, right - 1);
            quickSort(list, right + 1, lastNum);
        }
    }

    private static void swap(ArrayList<Integer> list, int i, int j) {
        int aux = list.get(i);
        list.set(i, list.get(j));
        list.set(j, aux);
    }
}