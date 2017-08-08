import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class TeamList {
    private List<Team> teamy = new ArrayList<Team>();
    private List<Task> finishedTasks = new ArrayList<Task>();

}

