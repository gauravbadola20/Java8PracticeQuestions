public class Newclass {

    public static void main(String[] args){

        Abc abc = new bca();

        abc.show();
    }


}


class Abc{

    public void show(){
        System.out.println("This is abc class");
    }


}

class  bca extends Abc{

    public void show(){
        System.out.println("This is the bas class");
    }

}
