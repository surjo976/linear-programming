
//Zero one Knapsack problem
package ZeroOneKnapsackProblem;
import java.util.*;
public class ZeroOneKnapsack {

    String name_Of_Item;
    double weight_Of_Item, value_Of_Item;

    ZeroOneKnapsack(String nameOfItem, double weightOfItem, double valueOfItem) {
        this.name_Of_Item = nameOfItem;
        this.weight_Of_Item = weightOfItem;
        this.value_Of_Item = valueOfItem;
    }

    public static void main(String[] args) {
        boolean condition = true;
        do {
            try {
                int total_Item, max_Weight;
                Scanner input = new Scanner(System.in);

                System.out.print("Enter The Total Number Of Item : ");
                total_Item = input.nextInt();
                System.out.print("Enter The Maximum Capacity Of Knapsack : ");
                max_Weight = input.nextInt();
                
                ZeroOneKnapsack[] k = new ZeroOneKnapsack[total_Item];

                String iName;
                double iWeight, iValue;

                for (int i = 0; i < total_Item; i++) {
                    System.out.print("\nEnter  Item Name : ");
                    iName = input.next();
                    System.out.print("Enter  Item Weight : ");
                    iWeight = input.nextDouble();
                    System.out.print("Enter  Item Value : ");
                    iValue = input.nextDouble();
                    
                    k[i] = new ZeroOneKnapsack(iName, iWeight, iValue);
                }

                double[][] knapsack = new double[total_Item + 1][max_Weight + 1];
                
                for (int row = 0; row <= total_Item; row++) {
                    knapsack[row][0] = 0;
                }
                
                for (int column = 0; column <= max_Weight; column++) {
                    knapsack[0][column] = 0;
                }

                for (int row = 1; row <= total_Item; row++) {
                    for (int column = 0; column <= max_Weight; column++) {

                        if (k[row - 1].weight_Of_Item <= column) {
                            if ((k[row - 1].value_Of_Item + knapsack[row - 1][column - (int) k[row - 1].weight_Of_Item]) > knapsack[row - 1][column]) {
                                knapsack[row][column] = k[row - 1].value_Of_Item + knapsack[row - 1][column - (int) k[row - 1].weight_Of_Item];
                            } else {    
                                knapsack[row][column] = knapsack[row - 1][column];
                            }
                        } else {
                            knapsack[row][column] = knapsack[row - 1][column];
                        }
                    }
                }
                System.out.println("\n\n===================================================\n");
                System.out.println("===================== Solution =====================");
                System.out.println("\n===================================================\n");
                System.out.println("\nMaximum value of knapsack " + knapsack[total_Item][max_Weight] + "\n\n");
                System.out.println("The Solution  is : \n");
                for (int row = 0; row <= total_Item; row++) {
                    for (int column = 0; column <= max_Weight; column++) {
                        System.out.print( knapsack[row][column]+"  |  ");
                    }
                    System.out.println("");
                }
                System.out.println("\n\n");
                System.out.print("Items are Taken : ");
                while(total_Item>0 && max_Weight>0)
                {
                    if(knapsack[total_Item][max_Weight]!=knapsack[total_Item-1][max_Weight])
                    {
                        System.out.print(k[total_Item-1].name_Of_Item +"    ");
                        max_Weight-=k[total_Item-1].weight_Of_Item;
                        total_Item--;
                    }
                    else 
                    {
                        total_Item--;
                    }
                }

                condition = false;
            } catch (Exception e) {
                System.out.println("\n=====================================================\n");
                System.out.println("Please Enter A Valid Input");
                System.out.println("=======================================================\n");
            }
        } while (condition == true);
    }
}
