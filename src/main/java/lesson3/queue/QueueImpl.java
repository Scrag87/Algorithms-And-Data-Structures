package lesson3.queue;

public class QueueImpl<E> implements Queue<E> {

    protected static final int DEFAULT_TAIL = -1;
    protected static final int DEFAULT_HEAD = 0;


    protected final E[] data;
    protected int size;

  protected int tail;
  protected int head;

  @SuppressWarnings("unchecked")
  public QueueImpl(int maxSize) {
    this.data = (E[]) new Object[maxSize];
    this.head = DEFAULT_HEAD;
    this.tail = DEFAULT_TAIL;
  }

  @Override
  public boolean insert(E value) {
    return false;
  }

  @Override
  public E remove() {
    return null;
  }

  @Override//O(1) InsertTail
  public boolean insertTail(E value) {
    System.out.println("insert tail " + value);
    if (isFull()) {
      return false;
    }
    if (tail == lastIndex()) {
      tail = DEFAULT_TAIL;

        }
        tail++;
        data[tail] = value;
        size++;
        return true;
    }

    @Override//O(1) RemoveHead
    public E removeHead() {
        System.out.println("remove head " + head);
        if (isEmpty()) {
            return null;
        }
        if (head == data.length) {
            head = DEFAULT_HEAD;
        }
        E removedValue = data[head];
        head++;
        size--;
        return removedValue;
    }

    protected int lastIndex() {
        return data.length - 1;
    }

    protected E lastElementToRemove() {
        E removedValue = data[head];

        size = 0;
        tail = DEFAULT_TAIL;
        head = DEFAULT_HEAD;
        return removedValue;
    }

    @Override//O(1)
    public E peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return data.length == size;
    }
}
