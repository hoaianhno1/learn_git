package day4_task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
     static long count = 1;

     private final Repository<Task, Long> repo;

    public TaskService(Repository<Task, Long> repo) {
        if(repo == null) throw new IllegalArgumentException("Repository is null");
        this.repo = repo;
    }


    public Task create(String title, int priority){
         Task task = new Task(count++, title, false, priority);
         repo.add(task);
         return task;
     }

     public Task markDone(long id){
        Task oldTask = repo.findById(id);
        Task newTask = oldTask.markDone();

        repo.removeById(newTask.getId());
        repo.add(newTask);
        return newTask;
     }

     public List<Task> getDoneTasks(){
        List<Task> allTask = repo.findAll();
        List<Task> done = new ArrayList<>();
        for(Task t : allTask){
            if(t.isDone()) done.add(t);
        }

        return done;
     }

     public List<Task> getTopPriorityTasks(int k){
        if(k <= 0) throw new IllegalArgumentException("K must be > 0");

        List<Task> allTask = repo.findAll();
        allTask.sort(((o1, o2) ->{
            return Integer.compare(o2.getPriority(), o1.getPriority());
        }));

        if(k > allTask.size()) k = allTask.size();
        return allTask.subList(0, k);
     }
}
