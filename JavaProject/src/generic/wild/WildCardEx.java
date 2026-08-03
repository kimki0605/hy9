package generic.wild;

import java.util.Arrays;

public class WildCardEx {
	
	public static void registerCourse(Course<?> course) { //Course 클래스의 제네릭 파라미터 타입에 제한이 없음
		System.out.println(course.getName()+"수강생 :"+Arrays.toString(course.getStudents()));
	}
	
	//학생 과정
	public static void registerCourseStudent(Course<? extends Student> course) {
		System.outprintln(course.getName()+"수강생:"+Arrays.toString(course.getStudents()));
	}
	
	//일반직장인과정
	public static void registerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName()+"수강생:"+Arrays.toString(course.getStudents()));
	}
	
	public static void main(String[] args) {
		// ? : 타입 제한 없음(관련된 (동일패키지) 4개의 클랙스만 사용)
		Course<Person> personCourse = new Course<Person>("일반인과정",5);
		personCourse.add(new Person("일반인"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Student("힉생"));
		personCourse.add(new HightStudent("고등학생"));
		
		Course<Worker> workerCourse = new Course<Worker>("직장인과정",5);
		workerCourse.add(new Worker("직장인"));
		
		Course<Student> studentCourse = new Course<Student>("학생과정",5);
		studentCourse.add(new Student("힉생"));
		
		Course<HightStudent> hightstudentCourse = new Course<HightStudent>("학생과정",5);

	}

}
