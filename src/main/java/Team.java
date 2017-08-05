import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Team {
    public Team(){
        id.set(teamCount.getAndIncrement());
    }

    private final AtomicInteger id = new AtomicInteger();
    private static AtomicInteger teamCount;
    private List<User> users = new ArrayList<User>();
    private List<Task> tasks = new ArrayList<Task>();

    public void addTask(Task task){
        tasks.add(task);
    }
    public void removeTask(Task task){
        tasks.remove(task);
    }

    public void addUser(User user){
        user.addTeam(this);
        users.add(user);
    }
    public void removeUser(User user){
        user.removeTeam(this);
        users.remove(user);
    }

}
