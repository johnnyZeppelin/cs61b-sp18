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
}
