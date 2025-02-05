// Amir Valeev CSE-06
// Some of the code snippets were taken from prof.Ikechi
// he showed how to implement hash maps
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        String[] words = s.split(" ");
        HashMap hashMap = new HashMap(n);
        for (int i = 0; i < words.length; i++) {
            if (hashMap.get(words[i]) == null){
                hashMap.put(words[i],1);
            }
            else {
                hashMap.put(words[i], (int)hashMap.get(words[i]) + 1);
            }
        }
        int[] frequency = new int[n];
        for (int i = 0; i < words.length; i++){
            frequency[i] = (int) hashMap.get(words[i]);
        }
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < frequency.length - 1; i++) {
                if (frequency[i] < frequency[i + 1]) {
                    int temp = frequency[i];
                    frequency[i] = frequency[i+1];
                    frequency[i+1] = temp;
                    String temp1 = words[i];
                    words[i] = words[i+1];
                    words[i+1] = temp1;
                    changed = true;
                }
            }
        }
        List<String> uniqueWords = new ArrayList<>();
        for (String word : words) {
            if (!uniqueWords.contains(word)) {
                uniqueWords.add(word);
            }
        }
        System.out.println(uniqueWords.get(k-1));
    }
}

interface Map<Key, Value>{
    Value get (Key key);
    void put (Key key, Value value);
    void remove(Key key);
    int size();
    boolean isEmpty();
}

class Entry<Key,Value>{
    Key key;
    Value value;
    public Entry(Key key, Value value){
        this.key = key;
        this.value = value;
    }
}

class HashMap<Key,Value> implements Map<Key,Value>{
    List<Entry<Key,Value>>[] hashTable;
    int size_of_hashTable;
    int n_elems;
    public int stringHash(String string){
        int hash = 0;
        for (int i = 0; i < string.length(); i++){
            hash += string.charAt(i);
        }
        return hash;
    }
    public HashMap(int size_of_hashTable){
        this.size_of_hashTable = size_of_hashTable;
        this.n_elems = 0;
        this.hashTable = new List[size_of_hashTable];
        for (int i = 0; i < size_of_hashTable; i ++){
            hashTable[i] = new LinkedList<>();
        }
    }
    @Override
    public void put(Key key, Value value){
        int cell = stringHash((String) key) % size_of_hashTable;
        if (cell < 0){
            cell *= -1;
        }
        for (Entry<Key,Value> keyValueEntry : this.hashTable[cell]){
            if (keyValueEntry.key.equals(key)){
                keyValueEntry.value  = value;
                return;
            }
        }
        this.hashTable[cell].add(new Entry<>(key,value));
        ++this.n_elems;
    }
    @Override
    public Value get(Key key) {
        int cell = stringHash((String) key) % size_of_hashTable;
        for (Entry<Key, Value> keyValueEntry : this.hashTable[cell]) {
            if (keyValueEntry.key.equals(key)) {
                return keyValueEntry.value;
            }
        }
        return null;
    }
    @Override
    public void remove(Key key){
        int cell = stringHash((String) key) % size_of_hashTable;
        for(Entry<Key,Value> keyValueEntry: this.hashTable[cell]){
            if(keyValueEntry.key.equals(key)){
                keyValueEntry.value = null;
                --this.n_elems;
                break;
            }
        }
    }
    @Override
    public int size(){
        return this.n_elems;
    }
    @Override
    public boolean isEmpty(){
        return (this.n_elems == 0);
    }
}
