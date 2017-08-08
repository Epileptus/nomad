import java.util.concurrent.atomic.AtomicInteger;
import lombok.Data;


@Data
public class User {
    public User(String name){
        this.name=name;
        this.id.set(userCount.getAndIncrement());
    }
    public User(String name, Department department){
        this.name=name;
        this.department = department;
        this.id.set(userCount.getAndIncrement());
    }
    private String name;
    private final AtomicInteger id = new AtomicInteger();
    private static AtomicInteger userCount = new AtomicInteger();
    private Department department;
    private TaskList ownedTasks = new TaskList();



    public void addTeam(TaskList tasks, UserList users) {

        for(Task task : tasks){
            ownedTasks.add(task);
            task.setAuthor(this);
        }
        boolean k = true;
        for (int i = 0; i < department.getTeams().size(); i++) {
            if (users.equals(department.getTeams().get(i).getUsers())) {
                for(Task task : tasks){
                    if(!department.getTeams().get(i).getTasks().contains(task))
                        department.getTeams().get(i).addTask(task);
                }
                k = false;
            }
        }
        if (k) {
            department.getTeams().add(new Team(tasks, users));
        }
    }
    public void removeTeam(Team team){
        department.getTeams().remove(team);
    }
    public Task createTask(String content){

        return new Task(content);
    }
    public TaskList getTasks(){
        TaskList tasklist = new TaskList();
        for(int i = 0; i< department.getTeams().size() ; i++){
            if(department.getTeams().get(i).getUsers().contains(this)){
                for(int j = 0; j< department.getTeams().get(i).getTasks().size() ; j++){
                    tasklist.add(department.getTeams().get(i).getTasks().get(j));
                }
            }
        }
        return tasklist;
    }
    public String showTasks(){
        StringBuilder result = new StringBuilder();
       for(int i = 0; i< department.getTeams().size() ; i++){
           if(department.getTeams().get(i).getUsers().contains(this)) {
               for (int j = 0; j < department.getTeams().get(i).getTasks().size(); j++) {
                   result.append(department.getTeams().get(i).getTasks().get(j));
               }
           }
       }
       return result.toString();

    }
    public void finishTask(Task task){
        for(int i = 0; i< department.getTeams().size() ; i++) {
            if (department.getTeams().get(i).getTasks().contains(task)) {
                department.getFinishedTasks().add(task);
                task.setWhoFinished(department.getTeams().get(i));
                department.getTeams().get(i).getTasks().remove(task);
                break;
            }
        }
    }
//    public String showFinishedTasks(){
//        StringBuilder result = new StringBuilder("Finished tasks:");
//        for(int i = 0; i< department.getFinishedTasks().size() ; i++){
//            result.append("\n"+department.getFinishedTasks().get(i)+" finished by "+department.getFinishedTasks().get(i).getWhoFinished());
//        }
//        return result.toString();
//    }
//    public void showOwnedTasks(){
//        for(int i=0 ; i<ownedTasks.size() ; i++){
//            System.out.print(ownedTasks.get(i));
//            if(i!=ownedTasks.size()-1)
//                System.out.print(", ");
//        }
//    }

    @Override
    public String toString(){
        return "User#"+id.toString()+": "+name;
    }

}
