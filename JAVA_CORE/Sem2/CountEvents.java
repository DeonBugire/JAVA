public class CountEvents {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 7, 4, 1, 16, 0 };
        System.out.println(countEvent(arr));

    }

    public static int countEvent(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }
}
