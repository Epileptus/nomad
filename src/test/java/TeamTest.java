import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {
    @Test
    public void ICanAddATask(){

        Team team = new Team(new TaskList(),new UserList());
        Task task = new Task();
        team.addTask(task);
        assertTrue(team.getTasks().contains(task));
    }
}