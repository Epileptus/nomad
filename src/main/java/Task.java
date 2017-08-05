import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Task {
    public Task(User author,String content){
        this.author=author;
        this.content=content;
    }
    private final User author;
    private final AtomicInteger id = new AtomicInteger();
    private AtomicInteger taskCounter = new AtomicInteger();
    private String content;
}
