package logic;

public interface IBeverage {

    default int getCost() {
        return 0;
    }

    default String getInfo() {
        return null;
    }

}
