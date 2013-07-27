package SApeChinner.Node;

import SApeChinner.Job;
import SApeChinner.Vars.Cons;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Delay;
import org.powerbot.script.wrappers.Npc;


public class TalkingDaero extends Job {

    Npc Daero = ctx.npcs.select().id(Cons.Daero).nearest().iterator().next();

    public TalkingDaero(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return Cons.DaeroArea.contains(ctx.players.local());
    }

    @Override
    public void execute() {
       if (Daero.isOnScreen()){
           if (Daero.interact("Talk")){
               ctx.keyboard.send(" ");
               Delay.sleep(100,125);
               ctx.keyboard.send("1");
               Delay.sleep(100,125);
               ctx.keyboard.send(" ");
               Delay.sleep(500,750);
           }
       }


    }
}
