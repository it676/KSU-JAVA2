

 /**
 *
 * @author IT676
 */

package  queue;

public interface Queue<E> {

    public abstract boolean isEmpty();

    public abstract int size();

    public abstract void enqueue(E item);

    public abstract E dequeue();

    public abstract E front();

}
