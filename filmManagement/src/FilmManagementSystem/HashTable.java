package FilmManagementSystem;

public class HashTable<K, V> {
    public LinkedList<HashNode<K, V>>[] buckets;
    public int capacity;
    public int size;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
        this.size = 0;
    }

    // Hash function
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % capacity);
    }

    // Add a key-value pair
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode<K, V>> bucket = buckets[bucketIndex];

        Node<HashNode<K, V>> current = bucket.head;
        while (current != null) {
            if (current.data.key.equals(key)) {
                current.data.value = value; // Update existing key's value
                return;
            }
            current = current.next;
        }

        // If key doesn't exist, add a new node
        bucket.add(new HashNode<>(key, value));
        size++;
    }

    // Retrieve a value by key
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode<K, V>> bucket = buckets[bucketIndex];

        Node<HashNode<K, V>> current = bucket.head;
        while (current != null) {
            if (current.data.key.equals(key)) {
                return current.data.value;
            }
            current = current.next;
        }
        return null; // Key not found
    }

    // Remove a key-value pair by key
    public boolean remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode<K, V>> bucket = buckets[bucketIndex];

        Node<HashNode<K, V>> current = bucket.head;
        Node<HashNode<K, V>> previous = null;

        while (current != null) {
            if (current.data.key.equals(key)) {
                if (previous == null) { // Removing the head
                    bucket.head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false; // Key not found
    }

    // Get the size of the hash table
    public int size() {
        return size;
    }

    // Check if the hash table is empty
    public boolean isEmpty() {
        return size == 0;
    }
}
