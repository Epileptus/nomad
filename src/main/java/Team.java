import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Team {
    private List<User> users = new ArrayList<User>();
    private List<Task> tasks = new ArrayList<Task>();

    public void addTask(Task task){
        tasks.add(task);
    }
    public void addUser(User user){
        user.addTeam(this);
        users.add(user);
    }

}
