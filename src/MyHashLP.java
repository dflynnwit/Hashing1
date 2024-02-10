import java.util.Scanner;

public class MyHashLP {

    private int[] hashTable;


    public MyHashLP(int size) {
        this.hashTable = new int [size];
    }

    public void displayHashTable(){
        System.out.println("Hash table (using linear probing)\n============================");
        for(int i=0; i<hashTable.length;i++)
            System.out.println(i + ") " + hashTable[i]);
    }

    public int add(int item){
        int home = hashFunction(item);
        int loc = home;

        do {
            if (hashTable[loc]==0) //if bucket/slot is free = 0
            {
                hashTable[loc]=item;
                return loc; //tell the user where it put it
            }
            else //we have a collision -> resolve with LP
            {
                loc = (loc + 1) % hashTable.length; //ensure that we wrap-around to beginning
                System.out.println("Collision. probing location " +loc+ "...");
            }
        }while(loc != home); //while not full
        return -1; //using -1 as indication that it's full
    }

    private int hashFunction(int key) {
        return key % hashTable.length;
    }

    public static void main(String[] args){
        MyHashLP h = new MyHashLP(10);
        Scanner k = new Scanner(System.in);
        int data;

        do{
            System.out.println("Please enter value: ");
            data = k.nextInt();
            if (data!=0){
                int loc = h.add(data);
                if(loc != -1) System.out.println("Item "+ data+ " stored at location " + loc);
                else System.out.println("Error. Can't store " + data + " Table is full.");
            }
        }while(data!=0);

        h.displayHashTable();
    }
}
