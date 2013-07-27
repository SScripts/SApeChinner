package SApeChinner;

import SApeChinner.Node.*;
import SApeChinner.Vars.Vars;
import org.powerbot.event.PaintListener;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.util.Timer;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

@Manifest(name = "SApeChinner", description = "Trains Mage or Range on the Ape Atoll", authors = {"SScripts"}, version = 1.0)

public class SApeChinner extends PollingScript implements PaintListener, MouseListener {

    gui g = new gui();



    private JobContainer container = null;

    public SApeChinner() {
        getExecQueue(State.START).add(new Runnable() {
            @Override
            public void run() {
                if (container == null) {
                    container = new JobContainer(new Job[]{
                            new Banking(getContext()), new  Door(getContext()), new Gate(getContext()), new LadderGF(getContext()), new TalkingDaero(getContext()), new WalkingDaero(getContext()), new WalkingKing(getContext()), new WalkingStone(getContext()), new WalkingVillage(getContext())
                    });

                }
            }
        });
    }

    @Override
    public int poll() {
        final Job job = container.get();
        if (job != null) {
            job.execute();
            return job.delay();
        }
        return 250;
    }

    @Override
    public void start() {

        g.setVisible(true);
        g.setSize(280,333);
        if (ctx.game.isLoggedIn()){


            Vars.StartEXPM = ctx.skills.getExperience(ctx.skills.MAGIC);
            Vars.StartEXPR = ctx.skills.getExperience(ctx.skills.RANGE);

        }
        Timer l = new Timer(3000);
        while(l.isRunning()&& Vars.dontstart == true){
            sleep(75);
        }


    }

    public static void startScript(){
        Vars.dontstart = false;
    }


    private final LinkedList<MousePathPoint> mousePath = new LinkedList<MousePathPoint>();



    @SuppressWarnings("serial")
    private class MousePathPoint extends Point { // All credits to Enfilade

        private long finishTime;
        private double lastingTime;

        public MousePathPoint(int x, int y, int lastingTime) {
            super(x, y);
            this.lastingTime = lastingTime;
            finishTime = System.currentTimeMillis() + lastingTime;
        }

        public boolean isUp() {
            return System.currentTimeMillis() > finishTime;
        }
    }

    private Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch(IOException e) {
            return null;
        }
    }

    private final Image img1 = getImage("http://i.imgur.com/5cuxbCs.png");
    boolean hide = false;
    Point p;
    Rectangle close = new Rectangle(500, 375, 25, 25);
    Rectangle open = new Rectangle(427, 405, 90, 90);
    Image button = getImage("http://i.imgur.com/H7UBt9i.png");

    @Override
    public void mouseClicked(MouseEvent e) {
        p = e.getPoint();
        if (close.contains(p) && !hide) {
            hide = true;
        } else if (open.contains(p) && hide) {
            hide = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void repaint(Graphics g) {

       if (ctx.game.getClientState()  == 11) {
            if (!hide) {

                g.drawImage(img1, 1, 385, null);
                g.setColor(Color.WHITE);
                g.setFont(Vars.font1);
                g.drawString(""+ Vars.Status,290,420);
                g.drawString("" + (ctx.skills.getExperience(ctx.skills.MAGIC)-Vars.StartEXPM),  125, 458);
                g.drawString("" + (getPerHour(ctx.skills.getExperience(ctx.skills.MAGIC)-Vars.StartEXPM)),147, 491);
                g.drawString("" + (ctx.skills.getExperience(ctx.skills.RANGE)-Vars.StartEXPR),  387, 446);
                g.drawString("" + (getPerHour(ctx.skills.getExperience(ctx.skills.RANGE)-Vars.StartEXPR)),409, 483);
                g.drawString("" + Vars.RunTime.toElapsedString(), 119, 427);

            }

            if (hide) {

                g.drawImage(button, 427, 405, null);
            }
        }

        g.setColor(Color.CYAN);
        g.drawLine(ctx.mouse.getLocation().x - 0, ctx.mouse.getLocation().y  - 0, ctx.mouse.getLocation().x  + 0, ctx.mouse.getLocation().y  + 900);
        g.drawLine(ctx.mouse.getLocation().x  - 0, ctx.mouse.getLocation().y  + 0, ctx.mouse.getLocation().x  + 900, ctx.mouse.getLocation().y  - 0);
        g.drawLine(ctx.mouse.getLocation().x  - 900, ctx.mouse.getLocation().y  + 0, ctx.mouse.getLocation().x  + 0, ctx.mouse.getLocation().y  - 0);
        g.drawLine(ctx.mouse.getLocation().x  - 0, ctx.mouse.getLocation().y  + 0, ctx.mouse.getLocation().x  + 0, ctx.mouse.getLocation().y  - 900);


    }
    private static int getPerHour(final int value) {
        if (Vars.RunTime != null && Vars.RunTime.getElapsed() > 0) {
            return (int) (value * 3600000d / Vars.RunTime.getElapsed());
        } else {
            return 0;
        }
    }
}


