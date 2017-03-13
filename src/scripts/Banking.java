package scripts;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import z.P;

import java.util.concurrent.Callable;

public class Banking extends Task<ClientContext>{

    private int[] logId = {1511};

    public static final Tile faladorBankingLocation = new Tile(3012, 3359, 0);

    public Banking(ClientContext ctx){
        super(ctx);
    }

    @Override
    public boolean activate(){
        //Returns true if inventory is full
        return ctx.inventory.select().count() == 28;
    }

    @Override
    public void execute(){
         //Get the currect location of the player
        //ctx.players.local().tile();

        if (!ctx.bank.inViewport()) {
            ctx.movement.step(faladorBankingLocation);
            ctx.camera.turnTo(faladorBankingLocation);

            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return faladorBankingLocation.distanceTo(ctx.players.local()) < 5;
                }
            }, 250, 10);

        } else if (ctx.bank.open()) {
//            Condition.wait(new Callable<Boolean>() {
//                @Override
//                public Boolean call() throws Exception {
//                    return null;
//                }
//            }, 250, 10);
        }
    }
}
