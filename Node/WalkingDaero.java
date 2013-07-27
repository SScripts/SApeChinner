package SApeChinner.Node;

import SApeChinner.Job;
import SApeChinner.Vars.Cons;
import SApeChinner.Vars.Vars;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Delay;


public class WalkingDaero extends Job{
    public WalkingDaero(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return Cons.TreeAreaUF.contains(ctx.players.local().getLocation()) && !Cons.DaeroArea.contains(ctx.players.local().getLocation()) && Vars.Ladderdone == true;
    }

    @Override
    public void execute() {
        Vars.Status = "Walking to Daero";
        ctx.movement.newTilePath(Cons.PathToDaero).traverse();
        if (ctx.movement.getEnergyLevel() >= 10) {

            if (!ctx.movement.isRunning()) {
               ctx.movement.setRunning(true);
            }
        }
        if (ctx.movement.getEnergyLevel() <= 10) {
            Cons.energy.click(true);
            Delay.sleep(500, 750);
        }
    }
}
