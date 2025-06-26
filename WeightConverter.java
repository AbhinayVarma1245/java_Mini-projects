import java.util.Scanner;
class WeightConverter{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an option from the given");
        
        System.out.println("1:convert weigth from lbs to kg's");

        System.out.println("2: convert the weigth from kg's to lbs");

        double weight;
        
        double newweight;
        
        int choice = sc.nextInt();
        
        if(choice ==1 ){
            System.out.println("Eneter the weight in lbs: ");
            weight = sc.nextDouble();
            newweight = weight*0.453592;
            System.out.printf("THe weight after conversion is: .%f "+newweight);
        }
        /*else if(choice == 2){
            System.out.println("Enter the weight ih kg's: ");
            weight = sc.nextDouble();
            newweignt =*/
        
    }
}