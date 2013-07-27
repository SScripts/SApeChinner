package SApeChinner.Node;

import SApeChinner.Job;
import SApeChinner.Vars.Cons;
import SApeChinner.Vars.Vars;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Delay;


public class WalkingKing extends Job{
    public WalkingKing(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return Cons.AfterGateArea.contains(ctx.players.local().getLocation()) && Vars.Gatedone == true && !Cons.TreeArea.contains(ctx.players.local().getLocation());
    }

    @Override
    public void execute() {
        Vars.Status = "Walking to the King";
        ctx.movement.newTilePath(Cons.PathToKing).traverse();
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
