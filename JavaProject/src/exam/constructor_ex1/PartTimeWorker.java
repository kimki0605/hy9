package exam.constructor_ex1;

public class PartTimeWorker {

    public static void main(String[] args) {

        PartTime worker = new PartTime(
                "990101-1034567",
                "홍길동",
                60,
                6000
        );

        System.out.println(worker);
    }
}