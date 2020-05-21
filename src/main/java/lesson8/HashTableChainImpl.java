package lesson8;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashTableChainImpl<K, V> implements HashTable<K, V> {

  LinkedList<Item<K, V>> item;
  private ArrayList<LinkedList<Item<K, V>>> data;

  @SuppressWarnings("unchecked")
  public HashTableChainImpl(int maxSize) {
    this.item = new LinkedList<>();
    this.data = new ArrayList<>(maxSize);
    for (int i = 0; i < maxSize; i++) {
      data.add(new LinkedList<>());
    }

  }

  private int hashFunc(K key) {
    return key.hashCode() % data.size();
  }

  @Override
  public boolean put(K key, V value) {
    if (isUnique(key)) {
      data.get(hashFunc(key)).addFirst(new Item<>(key, value));
      return true;
    } else {
      getItem(key).value = value;
      return true;
    }
    // оставил boolean чтобы не ломать контракт. Может быть void т.к нет размера у списка
  }

  private boolean isUnique(K key) {
    while (item.descendingIterator().hasNext()) {
      if (item.pop().key.equals(key)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public V get(K key) {
    return getItem(key).value;
  }

  private Item<K, V> getItem(K key) {
    LinkedList<Item<K, V>> items = data.get(hashFunc(key));
    if (items.isEmpty()) {
      throw new NoSuchElementException("Collection is empty");
    }

    int count = 0;
    while (count < items.size()) {
      if (items.get(count).key.equals(key)) {
        return items.get(count);
      }
      count++;
    }

    throw new NoSuchElementException("Not Found");
  }

  @Override
  public V remove(K key) {
    V value = get(key);
    remove(key, value);
    return value;
  }

  @Override
  public boolean remove(K key, V value) {
    LinkedList<Item<K, V>> items = data.get(hashFunc(key));
    if (items.isEmpty()) {
      throw new NoSuchElementException("Collection is empty");
    }

    if (items.size() == 1) {
      items.removeFirst();
      return true;
    }

    int count = 0;
    while (count < items.size()) {
      if (items.get(count).key.equals(key) && items.get(count).value.equals(value)) {
        items.remove(count);
        return true;
      }
      count++;
    }

    return false;
  }

  @Override
  public int size() {
    return data.size();
  }

  @Override
  public boolean isEmpty() {
    return data.isEmpty();
  }

  @Override
  public void display() {
    System.out.println("----------");
    for (int i = 0; i < data.size(); i++) {
      System.out.printf("%d = [%s]", i, data.get(i));
      System.out.println();
    }
    System.out.println("----------");
  }

  static class Item<K, V> implements Entry<K, V> {

    private final K key;
    private V value;

    public Item(K key, V value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public String toString() {
      return "Item{" +
          "key=" + key +
          ", value=" + value +
          '}';
    }

    @Override
    public K getKey() {
      return key;
    }

    @Override
    public V getValue() {
      return value;
    }

    @Override
    public void setValue(V value) {
      this.value = value;
    }
  }
}
