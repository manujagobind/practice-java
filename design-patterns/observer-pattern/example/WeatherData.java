import java.util.ArrayList;
import java.util.List;

public class WeatherData implements ISubject {
    
    private List<IObserver> observers;
    private double temprature;
    private double humidity;    

    WeatherData() {
        observers = new ArrayList<IObserver>();
    }

    public void registerObserver(IObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
                
        for (int i = 0; i < this.observers.size() ; i++) {

            /*  The subject could have also sent the updated data but having separate getter
                functions makes the implementation a little more flexible.
                That way, subjects have an option to choose only the data they want. */
            this.observers.get(i).update();
        }
    }    

    public double getTemprature() {
        return this.temprature;
    }

    public double getHumidity() {
        return this.humidity;
    }

    public void setMeasurements(double temprature, double humidity) {
        this.temprature = temprature;
        this.humidity = humidity;        

        // Notify observers when something changes in the subject.        
        this.notifyObservers();
    }
}