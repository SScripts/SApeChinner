package SApeChinner.Node;

import SApeChinner.Job;
import SApeChinner.Vars.Cons;
import SApeChinner.Vars.Vars;


import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Delay;


public class Banking extends Job {
    public Banking(MethodContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.backpack.size() > 28;
    }

    @Override
    public void execute() {

        if (ctx.bank.isOpen()){

            Vars.Status = "Banking";

            ctx.bank.withdraw(Cons.FOOD_ID,2);
            Delay.sleep(100, 150);
            ctx.bank.withdraw(Cons.ANTI_POTION,1);
            Delay.sleep(100, 150);
            ctx.bank.withdraw(Cons.PRAYER_FLASK, 23);
            Delay.sleep(100, 150);
            ctx.bank.withdraw(Cons.SUPER_ENERGY,1);
            Delay.sleep(100, 150);
            ctx.bank.withdraw(Cons.TELE_TAB,1);
            Delay.sleep(100, 150);


            if (ctx.backpack.contains(Cons.food)
                    && ctx.backpack.contains(Cons.energy)
                    && ctx.backpack.contains(Cons.anti)
                    && ctx.backpack.contains(Cons.tele)
                    && ctx.backpack.contains(Cons.prayer)) {
                Vars.Status = "Closing Bank";
                ctx.bank.close();
                Delay.sleep(100);
            } else {
                Vars.Status = "Banking";
                ctx.bank.depositInventory();
                Delay.sleep(100, 150);
            }

        } else {
            Vars.Status = "Opening Bank";
            ctx.bank.open();
        }

    }
}
