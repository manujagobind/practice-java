public class WildDuck extends Duck {
    
    WildDuck() {
        super(new NormalQuack(), new SimpleFlying());
    }

    public void display() {
        System.out.println("I am a wild duck!");
    }
}