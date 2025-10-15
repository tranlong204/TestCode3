package codingame.stack.memoryleak;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    // < 512 KB to avoid humongous: 128 KB works well
    static class Big { byte[] payload = new byte[128 * 1024]; }

    public static void main(String[] args) {
        boolean fixed = args.length > 0 && args[0].equals("fixed");
        System.out.println("Using " + (fixed ? "FixedStack" : "LeakyStack"));

        final int BATCH = 40;   // 40 * 128KB ≈ 5 MB per stack
        final int CYCLES = 200; // number of stacks to create

        // Keep references to all stacks so they (and their backing arrays) stay alive
        List<Object> keepAlive = new ArrayList<>(CYCLES);

        for (int c = 0; c < CYCLES; c++) {
            if (fixed) {
                FixedStack s = new FixedStack(16);
                for (int i = 0; i < BATCH; i++) s.push(new Big());
                for (int i = 0; i < BATCH; i++) s.pop();   // slots nulled → no retained Bigs
                keepAlive.add(s);                          // safe to keep; no leaks retained
            } else {
                LeakyStack s = new LeakyStack(16);
                for (int i = 0; i < BATCH; i++) s.push(new Big());
                for (int i = 0; i < BATCH; i++) s.pop();   // slots still reference Bigs → leaked
                keepAlive.add(s);                          // keep the whole leaked array
            }
            if ((c & 15) == 0) System.gc(); // give GC a chance
        }
        System.out.println("Done");
    }
}

