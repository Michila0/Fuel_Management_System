import java.util.Arrays;

public class FuelQueue {
    private Passenger[] queue;
    private int count;


    public FuelQueue() {//creating constructor for FuelQueue Class
        this.queue = new Passenger[6];
        this.count = 0;
    }

    public void addPassengerToQueue(Passenger passenger) {
            queue[count] = passenger;
            count++;
    }

    public void printPassengers() {
        for (int i = 0; i < count ; i++) {
            System.out.print(queue[i].getFname()+" "+ queue[i].getLname()+",");
        }
    }

    public void printEmpty() {
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                System.out.print(queue[i].getFname() + " " + queue[i].getLname() + ",");
            }
            for (int i = count; i < 6; i++) {
                System.out.print("empty"+ ",");
            }
        } else {
            System.out.println("Queue is empty!");
        }
        System.out.println("");
    }

    public int GetLegth() {

        return count;
    }


    public int getNoLiters() {

        int income = 0;
        for (int i = 0; i < count; i++) {
            income += (queue[i].getNoOfLiters() * 430);
        }
        return income;

    }

    public void removeCustomer(int position) {

        for (int i = position; i < count; i++) {
            queue[position] = queue[position + 1];
        }
        count--;
    }
    public void alphabeticalCoder() { //creating alphabeticalCoder method
        String[] queueNew = new String[6];
        for (int i = 0; i < count; i++) {
            queueNew[i] = queue[i].getFname() + " " + queue[i].getLname();
        }

        for (int i = 0; i < count - 1; i++)
        {
            for (int j = i + 1; j < count; j++)
            {
                if (queueNew[i].compareTo(queueNew[j]) > 0)
                {
                    String a = queueNew[i];
                    queueNew[i] = queueNew[j];
                    queueNew[j] = a;
                }
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.println(queueNew[i]);
        }
    }

}
