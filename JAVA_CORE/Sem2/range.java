public class range {
    public static void main(String[] args) {
        int[] arr = { -22, 0, 3, 0, 0, -23, 100, 3 };
        System.out.println(findRange(arr));
    }

    public static int findRange(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        return max - min;
    }
}
