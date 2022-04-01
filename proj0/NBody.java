public class NBody {
    public static void main(String[] args) {
        /*Collecting all the needed input*/
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double universeRadius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        /*Drawing the background*/
        StdDraw.setScale(-1 * universeRadius, universeRadius);
        StdDraw.picture(0, 0, "images/starfield.jpg");

        /*Drawing the planets*/
        for (Planet planet : planets) {
            planet.draw();
        }

        /*Creating the animation*/
        StdDraw.enableDoubleBuffering();
        double time = 0;
        //Play the BGM
        StdAudio.play("audio/2001.mid");
        while (time <= T) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i = 0; i < planets.length; ++i) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; ++i) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.setScale(-1 * universeRadius, universeRadius);
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet planet : planets) {
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

        /*Printing the universe data after process*/
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", universeRadius);
        for (int i = 0; i < planets.length; ++i) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
    /**
     * TO get the radius of the universe
     * @param txtPath the file path of what we read to get data
     * @return the radius of the universe
     */
    public static double readRadius(String txtPath) {
        In in = new In(txtPath);
        in.readInt();
        return in.readDouble();
    }

    /**
     * To get all the planets in the file
     * @param txtPath the file path of what we read to get data
     * @return an array of Planet's of all the planets in the universe of the file
     */
    public static Planet[] readPlanets(String txtPath) {
        In in = new In(txtPath);
        int numberOfPlanets = in.readInt();
        Planet[] planets = new Planet[numberOfPlanets];
        in.readDouble();
        for (int i = 0; i < numberOfPlanets; ++i) {
            Planet planet = new Planet(in.readDouble(),
                    in.readDouble(),
                    in.readDouble(),
                    in.readDouble(),
                    in.readDouble(),
                    in.readString());
            planets[i] = planet;
        }
        return planets;
    }
}
