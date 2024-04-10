public class app {
    public static void main(String[] arg){
        int[][] array2d = {{3,68,63},{22,49,90}};
        final int MIN_TEMP = 75;
        final int MAX_TEMP = 100;

        for (int col = 0; col < array2d[0].length; col++) {
            for (int row = 0; row < array2d.length; row++) {
                if ((array2d[row][col] >= MIN_TEMP) && (array2d[row][col] <= MAX_TEMP)) {
                    System.out.println(String.format("col is %d and row is %d : the value is %d",col,row,array2d[row][col]));
                    System.out.println("Go to the park.");
                }
            }
        }
    }
}
