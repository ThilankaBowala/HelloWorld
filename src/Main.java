import com.example.helloworld.Cycle;
import com.example.helloworld.HelloWorld;

public class Main {
    private static final Cycle c = new Cycle();
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Cycle c = new Cycle();
        HelloWorld.main(null);
    }
}