public class Duck {

    IQuackBehavior quackBehavior;
    IFlyingBehavior flyingBehavior;

    public Duck(IQuackBehavior quackBehavior, IFlyingBehavior flyingBehavior) {
        this.quackBehavior = quackBehavior;
        this.flyingBehavior = flyingBehavior;
    }

    public void display() {
        System.out.println("I am a duck!");
    }

    public void quack() {
        this.quackBehavior.quack();
    }

    public void fly() {
        this.flyingBehavior.fly();
    }
}