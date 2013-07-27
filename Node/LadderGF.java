package SApeChinner.Node;

import SApeChinner.Job;
import SApeChinner.Vars.Cons;
import SApeChinner.Vars.Vars;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Delay;
import org.powerbot.script.util.Random;
import org.powerbot.script.wrappers.GameObject;


public class LadderGF extends Job {

    GameObject Ladder = ctx.objects.select().id(Cons.LADDER_GF).nearest().iterator().next();

    public LadderGF(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return Cons.TreeArea.contains(ctx.players.local()) && Vars.Doordone == true && Vars.Ladderdone == false;
    }

    @Override
    public void execute() {

        if (Ladder.isOnScreen()) {
            Ladder.click(true);
            Vars.Ladderdone = true;
            Delay.sleep(100,150);
            ctx.camera.getAngleTo(Random.nextInt(0,50));
        }


    }
}
