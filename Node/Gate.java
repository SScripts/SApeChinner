package SApeChinner.Node;

import SApeChinner.Job;
import SApeChinner.Vars.Cons;
import SApeChinner.Vars.Vars;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Delay;
import org.powerbot.script.util.Random;
import org.powerbot.script.wrappers.GameObject;


public class Gate extends Job {

    GameObject Gate = ctx.objects.select().id(Cons.GATE).nearest().iterator().next();

    public Gate(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return Cons.GateArea.contains(ctx.players.local()) && Vars.Gatedone == false;
    }

    @Override
    public void execute() {

        if (Gate.isOnScreen()) {
            Gate.interact("Open");
            Vars.Gatedone = true;
            Delay.sleep(500,750);
            ctx.camera.getAngleTo(Random.nextInt(0,250));

        }



}
}
