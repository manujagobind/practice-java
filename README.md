# practice-java

### <a name="toc">Table of Contents</a>
- [Design Patterns](#dptrn)
    - [Strategy Pattern](#dptrn-strategy)
- [References](#ref)

### <a name="dptrn">Design Patterns</a>
Deisgn patterns can be used to make our code more flexible and eliminate code duplcication.

#### <a name="dptrn-strategy">Strategy Pattern</a>
In inheritance, the base class behaviors are propagated to the derived class. However, there could be a scenario where the derived class needs to have a different implementtion of that behavior. One way would be to override the base class behavior in the derived class. That's ok but as more and more derived classes begin to implement their own behaviors, maintaining the differenes becomes a challenge. 

Few derived classes may want to have the same new behavior. If we use the override approach, we will have to duplicate code in each of those derived classes. By using the strategy pattern, we decouple the behavior from the base class and have sepearate classes implement the different behaviors. The base class now just maintains a placeholder for the behavior and derived classes can choose which behavior they want.

In the following example, each derived class is supposed to have a separate ```display()``` behavior but could have same or different ```fly()``` and ```quack()``` behaviors. For instance, both the ```RubberDuck``` and ```HumanDuck``` classes could have the same ```NoFlyingBehavior``` but different ```quack()``` behaviors: ```NoQuack``` and ```SqueakingQuack``` respectively. By using the strategy pattern we can inject the required behaviors with minimal code duplication and improved flexibility.

![Strategy Pattern](assets/dptrn-strategy.png)

```
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
```
```
public class RubberDuck extends Duck {

    RubberDuck() {
        super(new NoQuack(), new NoFlying());
    }

    public void display() {
        System.out.println("I am a Rubber Duck!");
    }
}
```

### <a name="ref">References</a>
1. Head First Design Patterns