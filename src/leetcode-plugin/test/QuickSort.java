public class QuickSort {

    public static void main(String[]args){
        int[] a = {7 , 8, 9, 10, 1, 20};
        quickSort(a, 0, a.length - 1);
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    public static void quickSort(int[] a, int low, int high){
        if(low < high){
            int partitionIndex = getPartionIndex(a, low, high);
            quickSort(a, low, partitionIndex - 1);
            quickSort(a, partitionIndex + 1, high);
        }
    }

    public static int getPartionIndex(int[] a, int low, int high){
        int pivot = a[high];
        int pointer = low;
        for(int i = low; i < high; i++){
            if(a[i] < pivot){
                swap(a, i, pointer);
                pointer++;
            }
        }
        swap(a, pointer, high);
        return pointer;
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
