import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Task {
    public Task(User author,String content){
        this.author=author;
        this.content=content;
        this.id.set(taskCount.getAndIncrement());
    }
    private boolean done=false;
    private final User author;
    private final AtomicInteger id = new AtomicInteger();
    private static AtomicInteger taskCount = new AtomicInteger();
    private String content;
}
