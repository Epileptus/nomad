import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Team {
    public Team(List<Task> tasks, List<User> users) {
        this.tasks = tasks;
        this.users = users;
        id.set(teamCount.getAndIncrement());
    }

    private User author;
    private final AtomicInteger id = new AtomicInteger();
    private static AtomicInteger teamCount  = new AtomicInteger();
    private List<User> users = new ArrayList<User>();
    private List<Task> tasks = new ArrayList<Task>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }


}