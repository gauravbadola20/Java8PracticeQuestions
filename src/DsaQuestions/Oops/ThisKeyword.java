package DsaQuestions.Oops;

public class ThisKeyword {


    public static void main(String[] args) {

        ThisDemo td = new ThisDemo();

        td.m2();

    }

}


class ThisDemo{


    void m1(ThisDemo td){

        System.out.println("m1");
    }

    void m2(){

        m1(this);

        System.out.println("m2");
    }


}
