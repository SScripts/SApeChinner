package SApeChinner.Node;

import SApeChinner.Job;
import SApeChinner.Vars.Vars;
import SApeChinner.Vars.Cons;



import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Delay;
import org.powerbot.script.util.Random;
import org.powerbot.script.wrappers.GameObject;


public class Door extends Job{

    GameObject Gate = ctx.objects.select().id(Cons.GATE).nearest().iterator().next();

    public Door(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return Vars.Doordone == false && Cons.TreeArea.contains(ctx.players.local());
    }

    @Override
    public void execute() {
            if (Gate.isOnScreen()){
                Gate.interact("Open");
            Vars.Doordone = true;
            ctx.camera.getAngleTo(Random.nextInt(0, 250));
            Delay.sleep(800, 1000);
        }


    }
}

