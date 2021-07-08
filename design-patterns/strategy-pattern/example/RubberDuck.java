public class RubberDuck extends Duck {

    RubberDuck() {
        super(new NoQuack(), new NoFlying());
    }

    public void display() {
        System.out.println("I am a Rubber Duck!");
    }
}