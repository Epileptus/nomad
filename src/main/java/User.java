import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.Data;


@Data
public class User {
    public User(String name){
        this.name=name;
        this.id.set(userCount.getAndIncrement());
    }
    private String name;
    private final AtomicInteger id = new AtomicInteger();
    private static AtomicInteger userCount = new AtomicInteger();
    private Team solo;
    private List<Team> teamList = new ArrayList<Team>();

    public void addSoloTask(Task task){
        solo.addTask(task);
    }
    public void addTeam(Team team){
        teamList.add(team);
    }
    public void removeTeam(Team team){
        teamList.remove(team);
    }
    public Task createTask(String content){

        return new Task(this,content);
    }
}
