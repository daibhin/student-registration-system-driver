package io.github.daibhin.student_registration_system_driver;

import java.util.ArrayList;
import java.util.Date;

import org.joda.time.LocalDate;

import io.github.daibhin.student_registration_system.*;

public class RegistationDriver {
	
	public static void main(String[] args) {
		
		ArrayList<Student> students = new ArrayList<Student>();
		for (int i = 0; i < 100; i++) {
			LocalDate dob = new LocalDate(1995, 05, 25);
			Student student = new Student("David Newell", 21, dob, i+1);
			students.add(student);
		}
		
		ArrayList<Module> modules = new ArrayList<Module>();
		modules.add(new Module("Software Engineering", "CT417", students));
		modules.add(new Module("Machine Learning", "CT123", students));
		modules.add(new Module("Programming", "CT456", students));
		modules.add(new Module("Databases", "CT789", students));
		
		LocalDate startDate = new LocalDate(2013, 9, 1);
		LocalDate endDate = new LocalDate(2017, 5, 31);
		CourseProgramme engineering = new CourseProgramme("Electronic and Computer Engineering",
														  modules,
														  startDate,
														  endDate);
		
		
		printCourseProgrammeStudents(engineering);
	}
	
	public static void printCourseProgrammeStudents(CourseProgramme course) {
		ArrayList<Student> courseStudents = new ArrayList<Student>();
		
		for(Module module: course.getModules()) {
			courseStudents.addAll(module.getStudents());
		}
		
		for(Student student : courseStudents) {
			ArrayList<Module> studentModules = student.getModules(course.getModules());
			
			printStudentPersonalDetails(student);
			System.out.println("Modules:" + getModuleNames(studentModules));
			System.out.println("Course Programme: " + course.getName());
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

	public static String getModuleNames(ArrayList<Module> modules) {
		String moduleList = "";
		for(Module module : modules) {
			moduleList += " [" + module.getName() + "]";
		}
		return moduleList;
	}
}
