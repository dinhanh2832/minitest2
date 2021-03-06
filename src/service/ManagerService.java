package service;

public interface ManagerService<T> {
    int findIndexById(int id);

    void add(T t);

    void update(T t, int id);

    void deleteById(int id);

    void print();

    void sort();

    T getNameStudent(int id);
}
