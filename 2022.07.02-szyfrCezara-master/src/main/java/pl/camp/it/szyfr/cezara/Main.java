package pl.camp.it.szyfr.cezara;

public class Main {
    public static void main(String[] args) {
        String result = Cezar.encode("1", 4);
        System.out.println(result);

        String result2 = Cezar.decode("iypmj hylsqx", 4);
        System.out.println(result2);
    }
}
