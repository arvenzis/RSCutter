import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;

@Script.Manifest(
        name = "Cutting",
        properties = "author=Arvenzis; topic=1296203; client=4;",
        description = "A simple cutting script"
)
public class Cutting extends PollingScript<ClientContext> {

    @Override
    public void start() {
        log.info("Hello, RSBot!");
    }

    @Override
    public void poll() {

    }
}