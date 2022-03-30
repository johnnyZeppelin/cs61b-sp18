//import org.jetbrains.annotations.Contract;

public class Planet {

    /**
     * current x position
     */
    public double xxPos;
    /**
     * current y position
     */
    public double yyPos;
    /**
     * current velocity in the x direction
     */
    public double xxVel;
    /**
     * current velocity in the y direction
     */
    public double yyVel;
    /**
     * mass
     */
    public double mass;
    /**
     * the name of the file that corresponds to
     *  the image that depicts the planet
     *   (for example, jupiter.gif)
     */
    public String imgFileName;
    /**
     * constructor 1
     */
    public Planet(double xP, double yP,
                  double xV, double yV,
                  double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    /**
     * constructor 2
     */
    //@Contract(pure = true)
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /**
     * To calculate the distance between two Planet
     * @param p the Planet far away from this Planet
     * @return the distance from p to this
     */
    public double calcDistance(Planet p) {
        return Math.sqrt((p.xxPos - xxPos) * (p.xxPos - xxPos) + (p.yyPos - yyPos) * (p.yyPos - yyPos));
    }

    /**
     * The gravitational constant
     */
    final static double G = 6.67e-11;

    /**
     * To describe the force exerted on this planet
     * @param p the planet exerts the force on this
     * @return the force exerted on this planet by p
     */
    public double calcForceExertedBy(Planet p) {
        return G * p.mass * mass / ((p.xxPos - xxPos) * (p.xxPos - xxPos) + (p.yyPos - yyPos) * (p.yyPos - yyPos));
        //the denominator can be calcDistance(p), but the way above is more precise
    }

    /**
     * To calculate the force exerted by p in the X direction
     * @param p the given planet to exert the force on this
     * @return the force exerted on this in the X direction (can be minus)
     */
    public double calcForceExertedByX(Planet p) {
        return ((p.xxPos - xxPos) / calcDistance(p)) * calcForceExertedBy(p);
    }

    /**
     * To calculate the force exerted by p in the Y direction
     * @param p the given planet to exert the force on this
     * @return the force exerted on this in the Y direction (can be minus)
     */
    public double calcForceExertedByY(Planet p) {
        return ((p.yyPos - yyPos) / calcDistance(p)) * calcForceExertedBy(p);
    }

    /**
     * To calculate the net force in the X direction exerted on this by all the planets
     * @param planets an array of Planets to exert the gravitational force on this planet
     * @return the net force in the X direction exerted on this by all the planets in the array
     */
    public double calcNetForceExertedByX(Planet[] planets) {
        double netForceExertedByX = 0;
        for (Planet planet : planets) {
            if (!this.equals(planet)) {
                netForceExertedByX += calcForceExertedByX(planet);
            }
        }
        return netForceExertedByX;
    }

    /**
     * To calculate the net force in the Y direction exerted on this by all the planets
     * @param planets an array of Planets to exert the gravitational force on this planet
     * @return the net force in the Y direction exerted on this by all the planets in the array
     */
    public double calcNetForceExertedByY(Planet[] planets) {
        double netForceExertedByY = 0;
        for (Planet planet : planets) {
            if (!this.equals(planet)) {
                netForceExertedByY += calcForceExertedByY(planet);
            }
        }
        return netForceExertedByY;
    }

    /**
     * To update the position of this planet
     * @param dt the differential of the time to represent the least period we regard that the force are exerted constantly
     * @param fx the force exerted on this in the X direction during dt
     * @param fy the force exerted on this in the Y direction during dt
     */
    public void update(double dt, double fx, double fy) {
        double ax = fx / mass;
        double ay = fy / mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }
}
