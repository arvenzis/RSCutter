package scripts;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

public class WalkingToTree extends Task<ClientContext>{
    private int[] treeIds = {1276, 1278, 1271};
    //test if the axe ids are working
    private int[] axeIds = {1351, 1349, 1353, 1355, 1357, 1359};

    public WalkingToTree(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate(){
        //Returns true if inventory is not full, the player carries an axe and the player is not moving
        return ctx.inventory.select().count() < 28
                && !ctx.objects.select().id(treeIds).isEmpty()
                && !ctx.inventory.select().id(axeIds).isEmpty()
                && ctx.players.local().animation() == -1;
    }

    @Override
    public void execute(){
        if(ctx.players.local().animation() == -1){
            System.out.println("Walking towards tree");

            GameObject tree = ctx.objects.nearest().poll();

            if (!tree.inViewport()){
                ctx.movement.step(tree);
                ctx.camera.turnTo(tree);
            }
        }
    }
}
