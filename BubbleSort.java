import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    

    public static int[] createRandomArray(int arrayLength){
        int[] array = new int[arrayLength];
        Random random = new Random();

        for (int i = 0; i < arrayLength; i++){
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void writeArrayToFile(int[] array, String fileName) throws Exception {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (int j : array){
                writer.write(j + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Encountered IO Exception!");
            e.printStackTrace();
        }
        
        
    }

    public static int[] readFileToArray(String fileName){
        
        try{

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            int a = Integer.parseInt(str);
            arrayList.add(a);
        }
        int[] array = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++){
            array[i] = arrayList.get(i);
        }

        scanner.close();
        return array;

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } 
        return null;
    }

    public static void bubbleSort(int[] array){
        
        for (int i = array.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            for (int a : array){
                System.out.print(a +" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception{

        int[] array = createRandomArray(10);
        writeArrayToFile(array, "array.txt");
        bubbleSort(array);
    }
}
