package SApeChinner.Node;

import SApeChinner.Job;
import SApeChinner.Vars.Cons;
import SApeChinner.Vars.Vars;
import org.powerbot.script.methods.MethodContext;


public class WalkingStone extends Job {
    public WalkingStone(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return Cons.LoadStoneArea.contains(ctx.players.local().getLocation());
    }

    @Override
    public void execute() {
        Vars.Status = "Walking back to Bank";
        ctx.movement.newTilePath(Cons.PathToBank).traverse();
        if (ctx.movement.getEnergyLevel() >= 10) {
            if (!ctx.movement.isRunning()) {
                ctx.movement.setRunning(true);
            }
        }
    }
}
