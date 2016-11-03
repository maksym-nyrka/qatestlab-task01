package positions.models;

// Interface for positions with hourly rate salary
public interface HourlyRateable {
    void setHourlyRate(double amount);

    double getHourlyRate();
}
