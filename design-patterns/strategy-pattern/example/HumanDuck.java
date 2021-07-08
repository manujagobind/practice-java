public class HumanDuck extends Duck {

    HumanDuck() {
        super(new SqueakingQuack(), new NoFlying());
    }

    public void display() {
        System.out.println("I am a human posing as a duck!");
    }
}