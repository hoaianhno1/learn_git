package day4_task;

public class Task {
    private final long id;
    private final String title;
    private final boolean done;
    private final int priority;

    public Task(long id, String title, boolean done, int priority) {
        if(id < 0){
            throw new IllegalArgumentException("ID must be > 0");
        }

        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Title is null or blank");
        }

        if(priority <= 0 || priority > 5){
            throw new IllegalArgumentException("Priority must be in [1, 5]");
        }
        this.id = id;
        this.title = title;
        this.done = done;
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public int getPriority() {
        return priority;
    }

    public Task markDone(){
        return new Task(this.getId(), this.getTitle(), true, this.getPriority());
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", done=" + done +
                ", priority=" + priority +
                '}';
    }
}
