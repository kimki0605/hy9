package exam;

public class Reservation {

    // 멤버 필드
    String airplane;
    String name;
    String departure;
    String arrival;
    int price;
    String seatNo;

    // 생성자
    public Reservation(String airplane, String name, String departure,
                       String arrival, int price, String seatNo) {

        this.airplane = airplane;
        this.name = name;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.seatNo = seatNo;
    }

    // 예약 정보 출력
    void showRsvInfo() {
        System.out.println("**항공권 예약 정보**");
        System.out.println("항공기 : " + airplane);
        System.out.println("예약자 : " + name);
        System.out.println("출발지 : " + departure);
        System.out.println("도착지 : " + arrival);
        System.out.println("금액 : " + price);
        System.out.println("좌석번호 : " + seatNo);
    }
}