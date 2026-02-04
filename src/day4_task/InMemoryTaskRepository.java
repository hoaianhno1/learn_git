package day4_task;

import java.util.*;

public class InMemoryTaskRepository implements Repository<Task, Long>{
    private Map<Long, Task> taskHashMap = new HashMap<>();
    @Override
    public void add(Task item) {
        if(item == null) throw new IllegalArgumentException("Task is null");
        taskHashMap.put(item.getId(), item);
    }

    @Override
    public Task findById(Long aLong) {
        if(aLong == null) throw new IllegalArgumentException("Id is null");
        return taskHashMap.get(aLong);
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(taskHashMap.values());
    }

    @Override
    public void removeById(Long aLong) {
        if(aLong == null) throw new IllegalArgumentException("Id is null");
        taskHashMap.remove(aLong);
    }
}
