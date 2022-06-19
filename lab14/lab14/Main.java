package lab14;

import lab14lib.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /** Your code here. */
        /* 0
        Generator generator = new SineWaveGenerator(60);//440);
        GeneratorPlayer gp = new GeneratorPlayer(generator);
        gp.play(1000000);*/

        /* Alternative 1
        Generator generator = new SineWaveGenerator(200);
        GeneratorDrawer gd = new GeneratorDrawer(generator);
        gd.draw(4096);*/

        /* Alternative 2
        Generator generator = new SineWaveGenerator(200);
        GeneratorAudioVisualizer gav = new GeneratorAudioVisualizer(generator);
        gav.drawAndPlay(4096, 1000000);*/

        /* Alternative 3
        Generator generator = new SineWaveGenerator(200);
        GeneratorAudioAnimator gaa = new GeneratorAudioAnimator(generator);
        gaa.drawAndPlay(4096, 1000000);*/

        /* Alternative 4 */
        Generator g1 = new SineWaveGenerator(200);
        Generator g2 = new SineWaveGenerator(201);

        ArrayList<Generator> generators = new ArrayList<Generator>();
        generators.add(g1);
        generators.add(g2);
        MultiGenerator mg = new MultiGenerator(generators);

        GeneratorAudioVisualizer gav = new GeneratorAudioVisualizer(mg);
        gav.drawAndPlay(500000, 1000000);
    }
}
