package paramount.alphabet;

public class D {
    public static void main(String[] args) {
        //B a0 = new A();
        //B a0 = (B) new A();
        B a0 = new B();
        a0.m1(); a0.m2();
        a0.m2(16);
        A b0 = new B();
        System.out.println(b0.x);
        b0.m1();
        b0.m2();
        //b0.m2(61);
        ((B) b0).m2(61);
        B b1 = new B();
        b1.m2(61);
        b1.m3();

        A c0 = new C();
        /**
         * c0 :
         * A.x=5
         * A.m1()
         * A.m2()->Overridden by C.m2()
         * A.update()
         * A.jusam()
         * *B.m2()->Overridden by C.m2()
         * *B.m2(int y)
         * *B.m3()
         * *C.y=6
         * *C.m2()
         * *C.m4()
         * *C.m5()
         */
        System.out.println("楷书");
        B bbc = (B) c0;
        c0.m1(); // Am1-> 5
        c0.update();
        c0.m1(); // Am1-> 99
        c0.jusam(); //sasddq
        ((C) c0).m5(); //Cm5-> 6
        C cback = (C) c0;
        cback.m5(); //Cm5-> 6
        ((C) bbc).m5(); //Cm5-> 6
        cback.m4();// Cm4-> 99
        c0.m2(); //Cm2-> 99
        bbc.m2(); //Cm2-> 99

        System.out.println("楷书");
        A ba0 = new B();
        /**
         * A.x
         * A.mm0()
         * A.m1()
         * A.m2()->Overridden by B.m2()
         * A.update()
         * A.jusam()
         * *B.m2()
         * *B.m2(int y)
         * *B.m3()
         */
        A aa0 = new A();
        aa0.m00();
        ba0.m00();
        ba0.m1();//Am1-> 7
        ba0.m2();//Bm2-> 8
        ba0.m1();//Am1-> 8
        System.out.println(++ba0.xxx);
        ba0.m1();//Am1-> 9
        System.out.println("隶书");

        c0.m2();
        //C c1 = (A) new C();
        C c1 = new C();
        A a1 = (A) c0;
        C c2 = (C) a1;
        c2.m3();
        c2.m4();
        c2.m5();
        ((C) c0).m3();
        //(C) c0.m3();
        b0.update();
        b0.m1();

        C abc = new C();
        abc.jusam();

        A zz2 = new C();
        A zz = zz2;
        C zz1 = (C) zz;
        zz1.jusam();
    }
}
