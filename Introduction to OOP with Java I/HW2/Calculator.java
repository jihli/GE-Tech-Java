package HW2;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:"); // 在这里添加了冒号和空格
        String operation = input.next();
        String lowOperation = operation.toLowerCase();

        if (lowOperation.equals("add")) {

            switch (lowOperation){
                case "add":
                lowOperation = "add";
                default:
                lowOperation = "add";
            }

            System.out.println("Enter two integers:");
            // 读取两个输入作为字符串
            String firstInput = input.next();
            String secondInput = input.next();
    
            // 尝试将输入转换为整数
            try {
                int firstNumber = Integer.parseInt(firstInput);
                int secondNumber = Integer.parseInt(secondInput);
                System.out.println("Answer: " + (firstNumber + secondNumber));
            } catch (NumberFormatException e) {
                // 如果转换失败，打印错误消息并终止
                System.out.println("Invalid input entered. Terminating...");
            }


        } else if (lowOperation.equals("subtract")) {
            System.out.println("Enter two integers:");
            // 读取两个输入作为字符串
            String firstInput = input.next();
            String secondInput = input.next();
    
            // 尝试将输入转换为整数
            try {
                int firstNumber = Integer.parseInt(firstInput);
                int secondNumber = Integer.parseInt(secondInput);
                System.out.println("Answer: " + (firstNumber - secondNumber));
            } catch (NumberFormatException e) {
                // 如果转换失败，打印错误消息并终止
                System.out.println("Invalid input entered. Terminating...");
            }

        } else if (lowOperation.equals("multiply")) {
            System.out.println("Enter two doubles:");
            // 读取两个输入作为字符串
            String firstInput = input.next();
            String secondInput = input.next();
    
            // 尝试将输入转换为整数
            try {
                double firstNumber = Double.parseDouble(firstInput);
                double secondNumber = Double.parseDouble(secondInput);
                System.out.println(String.format("Answer: %.2f",(firstNumber * secondNumber)));
            } catch (NumberFormatException e) {
                // 如果转换失败，打印错误消息并终止
                System.out.println("Invalid input entered. Terminating...");
            }
            
        } else if (lowOperation.equals("divide")) {

            System.out.println("Enter two doubles:");
            try {
                double firstNumber = Double.parseDouble(input.next());
                double secondNumber = Double.parseDouble(input.next());

                if (secondNumber == 0) {
                    System.out.println("Invalid input entered. Terminating...");
                } else {
                    System.out.println(String.format("Answer: %.2f", (firstNumber / secondNumber)));
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input entered. Terminating...");
            }
    

        } else if (lowOperation.equals("alphabetize")){
            System.out.println("Enter two words:");
            String firstString = input.next();
            String secondString = input.next();
        
            // 比较两个字符串，不区分大小写
            int comparison = firstString.compareToIgnoreCase(secondString);
            if (comparison < 0) {
                System.out.println(String.format("Answer: %s comes before %s alphabetically.", firstString, secondString));
            } else if (comparison > 0) {
                System.out.println(String.format("Answer: %s comes before %s alphabetically.", secondString, firstString));
            } else {
                // 当两个字符串相等（忽略大小写）时的处理
                System.out.println("Answer: Chicken or Egg.");
            }
        }
        else {
            System.out.println("Invalid input entered. Terminating...");
        }

        input.close();
    }
}
