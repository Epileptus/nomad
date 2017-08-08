import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Task {
    public Task(String content){
        this.content=content;
        this.id.set(taskCount.getAndIncrement());
    }
    private User author;
    private final AtomicInteger id = new AtomicInteger();
    private static AtomicInteger taskCount = new AtomicInteger();
    private String content;
    private Team whoFinished;


    public String getWhoFinished(){
        StringBuilder result = new StringBuilder();
        for(int i=0 ; i<whoFinished.getUsers().size() ; i++){
            result.append(whoFinished.getUsers().get(i).getName());
            if(i!=whoFinished.getUsers().size()-1)
                result.append(", ");
        }
        return result.toString();
    }
    public static void resetTaskCount(){
        taskCount.set(0);
    }
    @Override
    public String toString(){
        return "Task#"+id.toString()+" : "+getContent()+" ";
    }
}
