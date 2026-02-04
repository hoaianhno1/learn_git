package day4_task;

import java.util.List;

public class DemoTask {
    public static void main(String[] args) {
        Repository<Task, Long> repo = new InMemoryTaskRepository();
        TaskService service = new TaskService(repo);

        // create 5 tasks
        Task t1 = service.create("Learn Java Core", 5);
        Task t2 = service.create("Do LeetCode 20", 4);
        Task t3 = service.create("Do LeetCode 704", 3);
        Task t4 = service.create("Practice OOP", 2);
        Task t5 = service.create("Write small project", 5);

        // markDone 2 tasks
        service.markDone(t2.getId());
        service.markDone(t4.getId());

        System.out.println("=== All tasks ===");
        List<Task> all = repo.findAll();
        for (Task t : all) {
            System.out.println(t);
        }

        System.out.println("=== Done tasks ===");
        List<Task> done = service.getDoneTasks();
        for (Task t : done) {
            System.out.println(t);
        }

        System.out.println("=== Top 3 priority tasks ===");
        List<Task> top3 = service.getTopPriorityTasks(3);
        for (Task t : top3) {
            System.out.println(t);
        }
    }
}
