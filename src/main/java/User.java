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
    private TeamList teamList;
    private List<Task> ownedTasks = new ArrayList<Task>();



    public void addTeam(List<Task> tasks, List<User> users)
    {for(int z=0; z<tasks.size();z++){
        ownedTasks.add(tasks.get(z));
    }
        int k = 0;
        for(int i=0;  i<teamList.getTeamy().size(); i++){
            if(users.equals(teamList.getTeamy().get(i).getUsers())){
                for(int j=0; j<tasks.size(); j++)
                teamList.getTeamy().get(i).addTask(tasks.get(j));
                k++;
            }
        }
        if(k==0) {
            Team new1 = new Team(tasks, users);
            teamList.getTeamy().add(new1);
        }
    }
    public void removeTeam(Team team){
        teamList.getTeamy().remove(team);
    }
    public Task createTask(String content){

        return new Task(this,content);
    }

    public void getTasks(){
       for(int i=0 ; i<teamList.getTeamy().size() ; i++){
           for(int j=0 ; j<teamList.getTeamy().get(i).getTasks().size() ; j++){
               if(teamList.getTeamy().get(i).getUsers().contains(this))
                    System.out.print(teamList.getTeamy().get(i).getTasks().get(j).getContent());
           }
       }

    }
    public void finishTask(Task task){
        for(int i=0 ; i<teamList.getTeamy().size() ; i++) {
            if (teamList.getTeamy().get(i).getTasks().contains(task)) {
                teamList.getFinishedTasks().add(task);
                teamList.getTeamy().get(i).getTasks().remove(task);
                break;
            }
        }
    }
    public void showFinishedTasks(){
        System.out.print("Ukonczone zadania: ");
//        for(int i=0; i<teamList.getTeamy().size(); i++){
//            for( int j = 0 ; j< teamList.getTeamy().get(i).getTasks().size();j++){
//                if(teamList.getTeamy().get(i).getTasks().get(j).isDone())
//                    System.out.println(teamList.getTeamy().get(i).getTasks().get(j).getContent());
//            }
//        }
        for(int i=0 ; i<teamList.getFinishedTasks().size() ; i++){
            System.out.print(teamList.getFinishedTasks().get(i).getContent());
        }
    }

}
