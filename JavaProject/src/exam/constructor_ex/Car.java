package exam.constructor_ex;

public class Car {
    String carNo;
    String carName;
    String carMaker;
    int carYear;

    // 생성자
    public Car(String carNo, String carName, String carMaker, int carYear) {
        this.carNo = carNo;
        this.carName = carName;
        this.carMaker = carMaker;
        this.carYear = carYear;
    }
}