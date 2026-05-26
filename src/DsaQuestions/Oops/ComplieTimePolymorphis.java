package DsaQuestions.Oops;

public class ComplieTimePolymorphis {


    public static void main(String[] args) {


        Test t = new Test();
        t.show("Hello");


    }


}


class Test {

    void show(Object o){

        System.out.println("Object");

    }
    void show(String s){

        System.out.println("String");

    }




}
