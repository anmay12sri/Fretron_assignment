import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AppleDistributor {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Collect apple weights
        ArrayList<Integer> apples = new ArrayList<>();
        while (true) {
            System.out.print("Enter apple weight in grams (-1 to stop): ");
            int weight = scanner.nextInt();
            if (weight == -1) {
                break;
            }
            apples.add(weight);
        }
        
        // Proportional payments
        final int totalPayment = 100;
        final int ramPayment = 50;
        final int shamPayment = 30;
        final int rahimPayment = 20;
        
        double ramRatio = (double) ramPayment / totalPayment;
        double shamRatio = (double) shamPayment / totalPayment;
        double rahimRatio = (double) rahimPayment / totalPayment;
        
        // Calculate total weight of apples
        int totalWeight = apples.stream().mapToInt(Integer::intValue).sum();
        
        // Target weight for each person
        double ramTarget = ramRatio * totalWeight;
        double shamTarget = shamRatio * totalWeight;
        double rahimTarget = rahimRatio * totalWeight;
        
        // Sort apples in descending order
        Collections.sort(apples, Collections.reverseOrder());
        
        // Initialize distributions
        ArrayList<Integer> ramApples = new ArrayList<>();
        ArrayList<Integer> shamApples = new ArrayList<>();
        ArrayList<Integer> rahimApples = new ArrayList<>();
        
        double ramCurrentWeight = 0;
        double shamCurrentWeight = 0;
        double rahimCurrentWeight = 0;
        
        // Distribute apples
        for (int apple : apples) {
            if (ramCurrentWeight + apple <= ramTarget) {
                ramApples.add(apple);
                ramCurrentWeight += apple;
            } else if (shamCurrentWeight + apple <= shamTarget) {
                shamApples.add(apple);
                shamCurrentWeight += apple;
            } else if (rahimCurrentWeight + apple <= rahimTarget) {
                rahimApples.add(apple);
                rahimCurrentWeight += apple;
            }
        }
        
         
        System.out.println("Distribution Result:");
        System.out.println("Ram: " + ramApples.toString());
        System.out.println("Sham: " + shamApples.toString());
        System.out.println("Rahim: " + rahimApples.toString());
        
        scanner.close();
    }
}
