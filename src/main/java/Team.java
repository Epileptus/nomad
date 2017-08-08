import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Team {
    public Team(TaskList tasks, UserList users) {
        this.tasks = tasks;
        this.users = users;
        id.set(teamCount.getAndIncrement());
    }

    private User author;
    private final AtomicInteger id = new AtomicInteger();
    private static AtomicInteger teamCount  = new AtomicInteger();
    private UserList users = new UserList();
    private TaskList tasks = new TaskList();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    @Override
    public String toString(){
        return "Users: "+users+"\nTasks: "+tasks;
    }
}