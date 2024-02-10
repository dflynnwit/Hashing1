public class Main {

    public static int simpleHash(int k, int hashTableSize)
    {
        return k % hashTableSize;
    }

    public static int stringHash(String k, int HashTableSize){
        int total = 0;
        for (int i = 0; i<k.length(); i++)
        {
            total+= k.charAt(i); //get ascii value at position i of string
        }
        System.out.println("total = " + total);

        return total % HashTableSize;
    }
    public static void main(String[] args) {

        String message = "AB";
        int otherMessage = 21337321;
        int hashTableSize = 10;

        System.out.println("The hash for the first message is\t" + simpleHash(otherMessage, hashTableSize));
        System.out.println("The hash for the string message is\t " + stringHash(message, hashTableSize));

    }
}