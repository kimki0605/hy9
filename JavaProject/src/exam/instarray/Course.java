package exam.instarray;

import java.util.Scanner;

public class Course {
    String subject;
    String professor;
    int grade;
    int credit;

    Scanner sc = new Scanner(System.in);

    public void input() {
        System.out.print("과목명 : ");
        subject = sc.next();

        System.out.print("교수 : ");
        professor = sc.next();

        System.out.print("학년 : ");
        grade = sc.nextInt();

        System.out.print("이수 학점 : ");
        credit = sc.nextInt();

        System.out.println();
    }

    public void output() {
        System.out.println(subject + " " + professor + " " + grade + "학년 " + credit + "학점");
    }

    public static void main(String[] args) {

        Course[] c = new Course[3];

        System.out.println("****과목 정보 입력****");

        for (int i = 0; i < c.length; i++) {
            c[i] = new Course();
            c[i].input();
        }

        System.out.println("****과목 정보 출력****");

        for (int i = 0; i < c.length; i++) {
            c[i].output();
        }
    }
}