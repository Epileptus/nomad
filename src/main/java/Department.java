import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private TeamList teams = new TeamList();
    private TaskList finishedTasks = new TaskList();

}

