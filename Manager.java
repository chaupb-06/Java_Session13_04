package bt04;

public interface Manage<T> {
    void add(T item);
    void update(int index, T item);
    void delete(int index);
    void display();
    boolean isExist(String id);
}