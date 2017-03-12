package scripts;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Script.Manifest( name = "ArvenzisCutting", description = "A simple cutting bot" )

public class ArvenzisCutting extends PollingScript<ClientContext> {

    private List<Task> taskList = new ArrayList<Task>();

    public void start() {
       taskList.addAll(Arrays.asList(new WalkingToTree(ctx), new Chop(ctx)));
    }

    public void poll() {
        for(Task task : taskList){
            if(task.activate()){
                task.execute();
            }
        }
    }
}