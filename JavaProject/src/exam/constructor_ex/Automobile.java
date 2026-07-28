package exam.constructor_ex;

public class Automobile extends Car {
    String autoManual;

    // 생성자
    public Automobile(String carNo, String carName, String carMaker,
                      int carYear, String autoManual) {
        super(carNo, carName, carMaker, carYear);
        this.autoManual = autoManual;
    }

    // 출력 메서드
    public void printInfo() {
        System.out.println("차량 번호 : " + carNo);
        System.out.println("차종 : " + carName);
        System.out.println("제조사 : " + carMaker);
        System.out.println("연식 : " + carYear);
        System.out.println("기어변속 : " + autoManual);
    }
}