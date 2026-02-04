package day4_task;

import java.util.List;

public interface Repository<T, ID> {
    public void add(T item);

    public T findById(ID id);

    public List<T> findAll();

    public void removeById(ID id);
}
