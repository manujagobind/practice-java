public class StatisticsDisplay implements IObserver, IDisplay {
    
    private double avgTemperature;
    private double minTemperature;
    private double maxTemperature;    

    private int count;

    // Maintains a reference to the subject
    private WeatherData weatherData;

    // The subject is provided at runtime
    StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.count = 0;

        // Register with the subject
        this.weatherData.registerObserver(this);
    }

    // Implementing IObserver
    // The ISubject will invoke this function
    public void update() {
        // Get the required data from the ISubject
        double temprature = this.weatherData.getTemprature();        

        // Perform required operation
        if (this.count == 0) {
            this.avgTemperature = temprature;
            this.minTemperature = temprature;
            this.maxTemperature = temprature;
            count++;
        } else {
            this.avgTemperature = (this.avgTemperature * count + temprature) / (count + 1);
            this.minTemperature = this.minTemperature > temprature ? temprature : this.minTemperature;
            this.maxTemperature = this.maxTemperature > temprature ? this.maxTemperature : temprature;
            count++;
        }
        
        this.display();
    }

    // Implementing IDisplay
    public void display() {
        System.out.println(String.format("Avg/Min/Max temperature: %,.2f/%,.2f/%,.2f degrees C",
            this.avgTemperature, this.minTemperature, this.maxTemperature));
    }
}