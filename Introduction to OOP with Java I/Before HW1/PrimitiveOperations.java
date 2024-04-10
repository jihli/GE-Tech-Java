public class PrimitiveOperations {
    public static void main(String[] args) {
        // HW1 Section 1
        int firstInt = 5;
        double secondInt = 3.5;
        System.out.println(firstInt);
        System.out.println(secondInt);

        double thirdInt = firstInt*secondInt;
        System.out.println(thirdInt);

        double firstInt_ = (double) firstInt;
        int secondInt_ = (int) secondInt;
        System.out.println(firstInt_);
        System.out.println(secondInt_);

        char firstChar = 'A';
        System.out.println(firstChar);
        
        char firstChar_ = (char)(firstChar+32);
        System.out.println(firstChar_);

        
    }
}
