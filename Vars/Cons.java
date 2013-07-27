package SApeChinner.Vars;


import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Item;
import org.powerbot.script.lang.Filter;
import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Npc;
import org.powerbot.script.wrappers.Tile;

public class Cons {


    public static MethodContext ctx;
    //ID´s
    public static int PRAYER_FLASK = 0;
    public static int ANTI_POTION = 0;
    public static int FOOD_ID = 0;
    public static int TELE_TAB = 0;
    public static int SUPER_ENERGY = 0;
    public static final int[] PRAYER_POT = {23245,23247,23249,23251,23253,2434,139,141,143};
    public static int GATE = 68983;
    public static int DOOR = 69198;
    public static int LADDER_GF = 69499;
    public static final int Daero = 824;


    //Filter´s
    public static final Filter<GameObject> Filter_Gate = new Filter<GameObject>() {
        public boolean accept(GameObject Gate) {
            return Gate.getId() == Cons.GATE
                    && Cons.GateArea.contains(Gate.getLocation());
        }
    };
    public static final Filter<GameObject> Filter_DOOR = new Filter<GameObject>() {
        public boolean accept(GameObject Gate) {
            return Gate.getId() == Cons.DOOR;

        }
    };

    public static final Filter<GameObject> Filter_LADDERGF = new Filter<GameObject>() {
        public boolean accept(GameObject Gate) {
            return Gate.getId() == Cons.LADDER_GF;

        }
    };
    public static final Filter<Npc> Filter_DAERO = new Filter<Npc>() {
        @Override
        public boolean accept(Npc npc) {
            return npc.getId() == Cons.Daero;
        }
    };


    //Item´s
    public static Item food = ctx.backpack.getItemAt(FOOD_ID);
    public static Item anti = ctx.backpack.getItemAt(ANTI_POTION);
    public static Item prayer = ctx.backpack.getItemAt(PRAYER_FLASK);
    public static Item tele = ctx.backpack.getItemAt(TELE_TAB);
    public static Item energy = ctx.backpack.getItemAt(SUPER_ENERGY);


    //Areas

    public static final Area DaeroArea = new Area(new Tile[] {
            new Tile(2480, 3492, 0), new Tile(2480, 3485, 0),
            new Tile(2488, 3485, 0), new Tile(2488, 3493, 0)
    });
    public static final Area LoadStoneArea = new Area(new Tile[] {
            new Tile(2630, 3350, 0), new Tile(2630, 3341, 0),
            new Tile(2616, 3342, 0), new Tile(2621, 3335, 0),
            new Tile(2632, 3334, 0), new Tile(2640, 3336, 0),
            new Tile(2639, 3349, 0)
    });

    public static final Area TreeArea = new Area(new Tile[] {
            new Tile(2444, 3513, 0), new Tile(2447, 3478, 0),
            new Tile(2488, 3483, 0), new Tile(2486, 3515, 0)
    });

    public static final Area TreeAreaUF = new Area(new Tile[] {
            new Tile(2444, 3513, 1), new Tile(2447, 3478, 1),
            new Tile(2488, 3483, 1), new Tile(2486, 3515, 1)
    });


    public static final Area GateArea = new Area(new Tile[] {
            new Tile(2453, 3391, 0), new Tile(2455, 3376, 0),
            new Tile(2465, 3379, 0), new Tile(2466, 3392, 0)
    });

    public static final Area AfterGateArea = new Area(new Tile[] {
            new Tile(2419, 3384, 0), new Tile(2502, 3385, 0),
            new Tile(2501, 3499, 0), new Tile(2430, 3499, 0)
    });

    //Tiles

    public static final Tile[] PathToDaero = {
            new Tile(2474, 3495, 1), new Tile(2474, 3488, 1),
            new Tile(2482, 3486, 1)
    };

    public static final Tile[] PathToBank = {
            new Tile(2634, 3345, 0), new Tile(2635, 3341, 0),
            new Tile(2634, 3337, 0), new Tile(2628, 3337, 0),
            new Tile(2622, 3338, 0), new Tile(2618, 3334, 0)
    };

    public  static final Tile[] PathToGnomeVillage = {
            new Tile(2616, 3335, 0), new Tile(2613, 3341, 0),
            new Tile(2612, 3346, 0), new Tile(2611, 3352, 0),
            new Tile(2611, 3357, 0), new Tile(2611, 3363, 0),
            new Tile(2610, 3369, 0), new Tile(2605, 3373, 0),
            new Tile(2599, 3375, 0), new Tile(2592, 3378, 0),
            new Tile(2586, 3380, 0), new Tile(2579, 3379, 0),
            new Tile(2572, 3379, 0), new Tile(2567, 3383, 0),
            new Tile(2562, 3387, 0), new Tile(2557, 3391, 0),
            new Tile(2552, 3395, 0), new Tile(2546, 3399, 0),
            new Tile(2539, 3401, 0), new Tile(2533, 3401, 0),
            new Tile(2526, 3398, 0), new Tile(2520, 3395, 0),
            new Tile(2513, 3393, 0), new Tile(2506, 3390, 0),
            new Tile(2499, 3388, 0), new Tile(2492, 3388, 0),
            new Tile(2486, 3388, 0), new Tile(2478, 3388, 0),
            new Tile(2472, 3387, 0), new Tile(2466, 3384, 0),
            new Tile(2460, 3381, 0)
    };

    public static final Tile[] PathToKing = {
            new Tile(2461, 3387, 0), new Tile(2460, 3394, 0),
            new Tile(2460, 3401, 0), new Tile(2459, 3408, 0),
            new Tile(2459, 3414, 0), new Tile(2459, 3420, 0),
            new Tile(2458, 3426, 0), new Tile(2460, 3432, 0),
            new Tile(2461, 3437, 0), new Tile(2462, 3443, 0),
            new Tile(2465, 3449, 0), new Tile(2464, 3455, 0),
            new Tile(2465, 3461, 0), new Tile(2466, 3468, 0),
            new Tile(2466, 3474, 0), new Tile(2465, 3478, 0),
            new Tile(2465, 3485, 0)
    };



}
