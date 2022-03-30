public class TestPlanet {
    public static void main(String[] args) {
        checkPlanetConstructor();
        checkCalcDistance();
    }

    private static boolean approxEquals(double actual, double expected, double eps) {
        return Math.abs(actual - expected) <= eps * Math.max(Math.abs(actual), Math.abs(expected));
    }

    private static boolean checkEquals(double actual, double expected) {
        return Math.abs(actual - expected) == 0;
    }

    private static boolean checkEquals(String actual, String expected) {
        return actual.equals(expected);
    }

    private static void checkEquals(double actual, double expected, String label) {
        if (checkEquals(actual, expected)) {
            System.out.println("Pass: " + label + " Expected: " + expected + " You gave " + actual);
        } else {
            System.out.println("FAIL: " + label + " Expected: " + expected + " You gave " + actual);
        }
    }

    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (approxEquals(actual, expected, eps)) {
            System.out.println("Pass: " + label + " Expected: " + expected + " You gave " + actual);
        } else {
            System.out.println("FAIL: " + label + " Expected: " + expected + " You gave " + actual + " the precision is " + eps);
        }
    }

    private static void checkEquals(String actual, String expected, String label) {
        if (checkEquals(actual, expected)) {
            System.out.println("Pass: " + label + " Expected: " + expected + " You gave " + actual);
        } else {
            System.out.println("FAIL: " + label + " Expected: " + expected + " You gave " + actual);
        }
    }

    private static void checkPlanetConstructor() {
        System.out.println("Checking the first constructor...");
        double xP = 1.0, yP = 2.0, xV = 3.0, yV = 4.0, m = 5.0;
        String img = "Juan.jfif";
        Planet planet = new Planet(xP, yP, xV, yV, m, img);
        checkEquals(xP, planet.xxPos, "xxPos");
        checkEquals(yP, planet.yyPos, "yyPos");
        checkEquals(xV, planet.xxVel, "xxVel");
        checkEquals(yV, planet.yyVel, "yyVel");
        checkEquals(m, planet.mass, "mass");

        System.out.println("Checking the second constructor...");
        Planet planet1 = new Planet(planet);
        checkEquals(planet1.xxPos, planet.xxPos, "xxPos");
        checkEquals(planet1.yyPos, planet.yyPos, "yyPos");
        checkEquals(planet1.xxVel, planet.xxVel, "xxVel");
        checkEquals(planet1.yyVel, planet.yyVel, "yyVel");
        checkEquals(planet1.mass, planet.mass, "mass");
    }

    private static void checkCalcDistance() {
        System.out.println("Checking calDistance...");
        Planet planet1 = new Planet(1, 2, 2, 3, 5, "ghj");
        Planet planet2 = new Planet(0 , 0, 3, -4, 5, "55");
        checkEquals(planet1.calcDistance(planet2), Math.sqrt(5), "distanceBetween1And2");
    }
}
