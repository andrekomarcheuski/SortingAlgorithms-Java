import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        String folder = "conjuntosDeDados/";
        String[] csvSelection = {"aleatorio_100.csv", "aleatorio_1000.csv", "aleatorio_10000.csv", 
                                    "crescente_100.csv", "crescente_1000.csv", "crescente_10000.csv",
                                    "decrescente_100.csv", "decrescente_1000.csv", "decrescente_10000.csv"};

        Double[] scoreBubble = new Double[9];
        Double[] scoreInsert = new Double[9];
        Double[] scoreQuick = new Double[9];

        for (int i = 0; i < csvSelection.length; i++) {
            String filePath = folder + csvSelection[i];
            readCSV(filePath);

            ArrayList<Integer> bubbleList = new ArrayList<>(list);
            Long start = System.nanoTime();
            BubbleSort.bubbleSort(bubbleList);
            Long end = System.nanoTime();
            scoreBubble[i] = (end - start) / 1_000_000.0;

            ArrayList<Integer> insertList = new ArrayList<>(list);
            start = System.nanoTime();
            InsertionSort.insertionSort(insertList);
            end = System.nanoTime();
            scoreInsert[i] = (end - start) / 1_000_000.0;

            ArrayList<Integer> quickList = new ArrayList<>(list); 
            start = System.nanoTime();
            QuickSort.quickSort(quickList, 0, quickList.size() - 1);
            end = System.nanoTime();
            scoreQuick[i] = (end - start) / 1_000_000.0;
        }

        System.out.println("             Bubble Sort");
        for (int j = 0; j < csvSelection.length; j++) {
            System.out.printf(">> %s: %.2f milisegundos\n", csvSelection[j], scoreBubble[j]);
        }

        System.out.println("\n             Insert Sort");
        for (int k = 0; k < csvSelection.length; k++) {
            System.out.printf(">> %s: %.2f milisegundos\n", csvSelection[k], scoreInsert[k]);
        }

        System.out.println("\n             Quick Sort");
        for (int l = 0; l < csvSelection.length; l++) {
            System.out.printf(">> %s: %.2f milisegundos\n", csvSelection[l], scoreQuick[l]);
            
        }
    }

    public static void readCSV(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line.trim()));  
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
