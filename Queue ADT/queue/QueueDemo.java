package queue;


/**
 *
 * @author IT676
 */
public class QueueDemo {

    public static void main(String[] args) {

        Queue<String> q = new LinkedBasedQueue<>();//raw type -->  warning

        System.out.println("isEmpty? " + q.isEmpty());//true
        System.out.println("size: " + q.size());//0

        //Front                              Reaer
        // Sara<--Amal<---Reem --Rahaf<----Ruba
        q.enqueue("Sara");
        q.enqueue("Amal");
        q.enqueue("Reem");
        q.enqueue("Rahaf");
        q.enqueue("Ruba");

        System.out.println("Front : " + q.front());//Sara
        System.out.println("Dequed:  : " + q.dequeue());//Sara
        System.out.println("Dequed:  : " + q.dequeue());//Amal

        System.out.println("Front : " + q.front());//Reem

        System.out.println("isEmpty? " + q.isEmpty());//false
        System.out.println("size: " + q.size());//3

    }
    
    
    
}
