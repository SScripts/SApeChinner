package SApeChinner.Node;

import SApeChinner.Job;
import SApeChinner.Vars.Cons;
import SApeChinner.Vars.Vars;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Delay;


public class WalkingVillage extends Job {
    public WalkingVillage(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return Vars.Gatedone == false && !Cons.GateArea.contains(ctx.players.local().getLocation());
    }

    @Override
    public void execute() {
        Vars.Status = "Walking to the Village";
        ctx.movement.newTilePath(Cons.PathToGnomeVillage).traverse();
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
