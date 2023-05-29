import java.io.IOException;
import java.util.Scanner;
public class FuelQueueManagementSystem {
    static FuelQueue q1 = new FuelQueue();
    static FuelQueue q2 = new FuelQueue();
    static FuelQueue q3 = new FuelQueue();
    static FuelQueue q4 = new FuelQueue();
    static FuelQueue q5 = new FuelQueue();

    static FuelQueue[] fuelQueues = {q1, q2, q3, q4, q5};
    static int fstock = 6600;
    static Scanner operator = new Scanner(System.in);



    public static void main(String[] args) {




            System.out.println("\n**********Fuel Station Task Menu***********\n");

            //        Display the task
            System.out.println("100 or VFQ: View all Fuel Queues");
            System.out.println("101 or VEQ: View all Empty Queues");
            System.out.println("102 or ACQ: Add customer to a Queue");
            System.out.println("103 or RCQ: Remove a customer from a Queue. (From a specific location)");
            System.out.println("104 or PCQ: Remove a served customer");
            System.out.println("105 or VCS: View Customers Sorted in alphabetical order");
            System.out.println("106 or SPD: Store Program Data into file");
            System.out.println("107 or LPD: Load Program Data from file");
            System.out.println("108 or STK: View Remaining Fuel Stock");
            System.out.println("109 or AFS: Add Fuel Stock");
            System.out.println("110 or IFQ: income of each Fuel queue");
            System.out.println("999 or EXT: Exit the Program");


            loop1:
            while (true) { // loop1 is label

//        Type to the user want task
                System.out.print("\nEnter your operator: ");
                String task = operator.next();
                String Task = task.toUpperCase();

                //adjustment Operator and Method calling
                switch (Task) {
                    case "100":
                    case "VFQ":
                        displayFuelQueues();
                        break;
                    case "101":
                    case "VEQ":
                        displayEmptyQueues();
                        break;
                    case "102":
                    case "ACQ":
                        addPassanger();
                        break;
                    case "103":
                    case "RCQ":
                        removeCustomerFromQueue();
                        break;
                    case "104":
                    case "PCQ":
                        servedCustomer();
                        break;
                    case "105":
                    case "VCS":
                        sortQueue();
                        break;
                    case "106":
                    case "SPD":
//                        storeData();
                        break;
                    case "107":
                    case "LPD":
//                    loadData();
                        break;
                    case "108":
                    case "STK":
                        displayRemainingFuelStock();
                        break;
                    case "109":
                    case "AFS":
                        addStock();
                        break;
                    case "110":
                    case "IFQ":
                        stockPrice();
                        break;
                    case "999":
                    case "EXT":
                        System.out.println("!!THANK YOU!!");
                        break loop1;

                }
            }

    }

    public static void displayFuelQueues() { //creating displayFuelQueues method

        for (int i = 0; i < 5; i++) {
            System.out.print("Queue" + (i+1) + " -> ");
            fuelQueues[i].printPassengers();
            System.out.println();
        }

    }

    public static void displayEmptyQueues() {

        for (int i = 0; i < 5; i++) {
            System.out.println("Queue" + (i+1) + " -> ");
                    fuelQueues[i].printEmpty();
        }

    }

    public static void addPassanger() {//creating Add passenger

        int minLenght = fuelQueues[0].GetLegth();
        FuelQueue smallestPump = fuelQueues[0];
        for (int j = 0; j < fuelQueues.length; j++)
        {
            if (fuelQueues[j].GetLegth() < minLenght)
            {
                minLenght = fuelQueues[j].GetLegth();
                smallestPump = fuelQueues[j];

            }
        }

        String firstName;
        String lastName;
        String vehiNo;
        int noOfLitersRequired;

        System.out.print("\nEnter First Name: ");
        firstName = operator.next();

        System.out.print("Enter Last Name: ");
        lastName = operator.next();

        System.out.print("Enter Vehicle No: ");
        vehiNo = operator.next();

        System.out.print("Enter Number of Litters Required: ");
        noOfLitersRequired = operator.nextInt();

        Passenger coustermer = new Passenger(firstName, lastName, vehiNo, noOfLitersRequired);
        smallestPump.addPassengerToQueue(coustermer);

        fstock = fstock - 10;
    }

    public static void removeCustomerFromQueue() {
        System.out.print("Enter Queue no: ");
        int qno = operator.nextInt();
        System.out.print("Please enter Customer position: ");
        int position = operator.nextInt() - 1;
        switch (qno) {
            case 1:
                q1.removeCustomer(position);
                break;
            case 2:
                q2.removeCustomer(position);
                break;
            case 3:
                q3.removeCustomer(position);
                break;
            case 4:
                q4.removeCustomer(position);
                break;
            case 5:
                q5.removeCustomer(position);
                break;
        }
        fstock = fstock +10;
    }

    public static void servedCustomer() {
        System.out.print("Enter Queue no: ");
        int qno = operator.nextInt();

        switch (qno) {
            case 1:
                q1.removeCustomer(0);
                break;
            case 2:
                q2.removeCustomer(0);
                break;
            case 3:
                q3.removeCustomer(0);
                break;
            case 4:
                q4.removeCustomer(0);
                break;
            case 5:
                q5.removeCustomer(0);
                break;
        }
        fstock = fstock -10;

    }

    public static void sortQueue() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Queue " + (i+1));
                    fuelQueues[i].alphabeticalCoder();
        }


    }


    public static void displayRemainingFuelStock() { //creating Display saving Fuel stock
        System.out.println("Display Fuel Stock: " + fstock);
    }
    public static void addStock() { //creating add stock method
        System.out.print("How much add the Fuel: ");
        int addFuel = operator.nextInt();
        fstock = fstock + addFuel;
        System.out.println("Successful add Fuel Stock");

    }

    public static void stockPrice() {

        System.out.println(" 1st queue income  "+fuelQueues[0].getNoLiters());
        System.out.println(" 2nd queue income  "+fuelQueues[1].getNoLiters());
        System.out.println(" 3th queue income  "+fuelQueues[2].getNoLiters());
        System.out.println(" 4th queue income  "+fuelQueues[3].getNoLiters());
        System.out.println(" 5th queue income  "+fuelQueues[4].getNoLiters());
    }

}
