public class AdjZeros {
    public static void main(String[] args) {
        int[] arr = { -22, 0, 0, 0, 2, -23, 100, 3 };
        System.out.println(isZerosAdj(arr));
    }

    public static boolean isZerosAdj(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0 && arr[i + 1] == 0)
                return true;
        }
        return false;
    }
}
