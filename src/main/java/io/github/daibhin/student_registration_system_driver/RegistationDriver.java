package io.github.daibhin.student_registration_system_driver;

import java.util.ArrayList;

import org.joda.time.LocalDate;
import io.github.daibhin.student_registration_system.*;

public class RegistationDriver {

	public static void main(String[] args) {

		Module databases = new Module("Databases", "CT123");
		Module telecommunications = new Module("Telecommunications", "CT456");
		Module softwareEngineering = new Module("Software Engineering", "CT789");
		Module machineLearning = new Module("Machine Learning", "CT321");

		ArrayList<Module> computerScienceModules = new ArrayList<Module>();
		computerScienceModules.add(databases);
		computerScienceModules.add(softwareEngineering);
		computerScienceModules.add(machineLearning);

		ArrayList<Module> engineeringModules = new ArrayList<Module>();
		engineeringModules.add(telecommunications);
		engineeringModules.add(softwareEngineering);
		engineeringModules.add(machineLearning);

//		Create courses
		LocalDate startDate = new LocalDate(2013, 9, 1);
		LocalDate endDate = new LocalDate(2017, 5, 31);
		CourseProgramme computerScience = new CourseProgramme("Computer Science", computerScienceModules, startDate, endDate);
		CourseProgramme engineering = new CourseProgramme("Electronic and Computer Engineering", engineeringModules, startDate, endDate);

//		Create students
		Student student1 = new Student("David Newell", 21, new LocalDate(1995, 05, 25), 1);
		Student student2 = new Student("Bruce Wayne", 21, new LocalDate(1994, 7, 28), 2);
		Student student3 = new Student("Steven Rogers", 21, new LocalDate(1900, 6, 9), 3);

		Student student4 = new Student("Phillip Urich", 21, new LocalDate(1992, 1, 28), 4);
		Student student5 = new Student("Harvey Dent", 21, new LocalDate(1991, 9, 14), 5);
		Student student6 = new Student("Bruce Banner", 21, new LocalDate(1985, 06, 5), 6);

		ArrayList<Student> computerScienceStudents = new ArrayList<Student>();
		computerScienceStudents.add(student1);
		computerScienceStudents.add(student2);
		computerScienceStudents.add(student3);

		ArrayList<Student> engineeringStudents = new ArrayList<Student>();
		engineeringStudents.add(student4);
		engineeringStudents.add(student5);
		engineeringStudents.add(student6);

		enrollStudents(computerScienceStudents, computerScienceModules, computerScience);
		enrollStudents(engineeringStudents, engineeringModules, engineering);

		printStudents(computerScienceStudents);
		printStudents(engineeringStudents);
	}

	public static void enrollStudents(ArrayList<Student> students, ArrayList<Module> modules, CourseProgramme course) {
		for(Module module : modules) {
			module.addStudents(students);
		}
		for(Student student : students) {
			student.enroll(course);
		}
	}

	public static void printStudents(ArrayList<Student> students) {
		for(Student student : students) {
			printStudentPersonalDetails(student);
			CourseProgramme course = student.getCourse();
			System.out.println("Course Programme: " + course.getName());
			System.out.println("Modules:" + formattedModuleNames(course.getModules()));
			System.out.println("\n");
		}
	}

	public static void printStudentPersonalDetails(Student student) {
		System.out.println("Name: " + student.getName());
		System.out.println("Id: " + student.getId());
		System.out.println("Age: " + student.getAge());
		System.out.println("Date of Birth: " + student.getDateOfBirth());
		System.out.println("Username: " + student.getUsername());
	}

	public static String formattedModuleNames(ArrayList<Module> modules) {
		String moduleList = "";
		for(Module module : modules) {
			moduleList += " [" + module.getName() + "]";
		}
		return moduleList;
	}
}
