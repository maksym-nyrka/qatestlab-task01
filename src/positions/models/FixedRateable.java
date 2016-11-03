package positions.models;

// Interface for positions with fixed rate salary
public interface FixedRateable {

    void setFixedRate(double amount);
    double getFixedRate();
}
