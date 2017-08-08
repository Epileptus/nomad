import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        TeamList lista1 = new TeamList();
        User kuba = new User("Kuba");
        User marek = new User("Marek");
        User bartek = new User("Bartek");
        bartek.setTeamList(lista1);
        kuba.setTeamList(lista1);
        marek.setTeamList(lista1);
        List<Task> tasked = new ArrayList<Task>();
        Task sranie = new Task(kuba,"zesrtaj sie");
        tasked.add(sranie);
        tasked.add(new Task(kuba,"i to zjedz"));
        List<User> usered = new ArrayList<User>();
        usered.add(marek);
        usered.add(bartek);
        kuba.addTeam(tasked,usered);
        kuba.getTasks();
        marek.getTasks();
        marek.finishTask(sranie);
        marek.getTasks();
        bartek.getTasks();
        marek.showFinishedTasks();
        kuba.showFinishedTasks();


    }
}
