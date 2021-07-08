public class Main {
    
    public static void main(String[] args) {
        
        Duck[] ducks = {
            new RubberDuck(),
            new WildDuck(),
            new HumanDuck()
        };
        int len = 3;

        for (int i = 0; i < len ; i++) {
            ducks[i].display();
            ducks[i].quack();
            ducks[i].fly();            
        }
    }
}