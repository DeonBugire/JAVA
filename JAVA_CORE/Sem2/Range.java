public class Range {
    public static void main(String[] args) {
        int[] arr = { -22, 0, 3, 0, 0, -23, 100, 3 };
        try {
            System.out.println(findRange(arr));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int findRange(int[] arr) {
        //Массив должен быть ненулевым, поэтому добавим проверку на это и кинем исключение, если будут проблемы
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

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