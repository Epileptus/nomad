import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;

public class UserTest {
    private User kuba;
    private User marek;
    private User bartek;
    private Task task1;
    private Task task2;
    private Task task3;
    private Team team;
    private Department department;
    private UserList userList;
    private TaskList taskList;
    @Before
    public void start(){
        department = new Department();
        kuba = new User("Kuba", department);
        marek = new User("Marek", department);
        bartek = new User("Bartek",department);
        Task.resetTaskCount();
        task1 = new Task("A");
        task2 = new Task("B");
        task3 = new Task("C");
        userList = new UserList();
        taskList = new TaskList();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        userList.add(bartek);
        userList.add(marek);
    }
    @Test
    public void ICanAddATeam() throws Exception{
        kuba.addTeam(taskList,userList);
        assertTrue(department.getTeams().get(0).getUsers().contains(marek));

        kuba.addTeam(taskList,userList);
        assertEquals(1,department.getTeams().size());

        Task task3 = new Task("C");
        User marcin = new User("Marcin");
        TaskList taskList2 = new TaskList();
        UserList userList2 = new UserList(marcin);
        taskList2.add(task3);
        kuba.addTeam(taskList2,userList2);
    }
    @Test
    public void ICanAddTaskToATeam() throws Exception{
        kuba.addTeam(taskList,userList);
        Task task4 = new Task("D");
        kuba.addTeam(new TaskList(task4),userList);
        assertEquals(1,department.getTeams().size());
        assertTrue(bartek.getTasks().contains(task4));
    }
    @Test
    public void ICanShowTasks() throws Exception{
        kuba.addTeam(taskList,userList);
        assertEquals("Task#0 : A Task#1 : B Task#2 : C ",bartek.showTasks());
        assertTrue(bartek.getTasks().contains(task1));
        assertFalse(kuba.getTasks().contains(task1));

    }
    @Test
    public void ICanGetOwnedTasks() throws Exception{
        taskList.remove(task3);
        kuba.addTeam(taskList,userList);
        assertTrue(kuba.getOwnedTasks().contains(task1));
        assertFalse(kuba.getOwnedTasks().contains(task3));
    }
    @Test
    public void ICanFinishATask() throws Exception{
        kuba.addTeam(taskList,userList);
        bartek.finishTask(task1);
        marek.finishTask(task3);
        assertEquals(2,bartek.getDepartment().getFinishedTasks().size());
        assertTrue(marek.getDepartment().getFinishedTasks().contains(task1));
        assertFalse(kuba.getDepartment().getFinishedTasks().contains(task2));
    }
}