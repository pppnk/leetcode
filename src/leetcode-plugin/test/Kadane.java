public class Kadane {

    static void maxSubArraySum(int a[], int size) {
        int maximum = Integer.MIN_VALUE;
        int accumulated = 0;
        int start = 0;
        int end = 0;
        int pointer = 0;
        for (int i = 0; i < a.length; i++){
            accumulated += a[i];
            if (maximum < accumulated) {
                maximum = accumulated;
                start = pointer;
                end = i;
            }
            if (accumulated < 0) {
                accumulated = 0;
                pointer = i + 1;
            }
        }
        System.out.println("Maximum contiguous sum is " + maximum);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }

    public static void main(String[] args) {
        int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int n = a.length;
        maxSubArraySum(a, n);
    }
}
