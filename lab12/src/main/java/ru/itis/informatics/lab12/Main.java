package ru.itis.informatics.lab12;


public class Main {
	public static void main(String[] args) {
		Student student = new Student();

		student.setFio("Михаил Сергеевич");
		student.setBirthDate("2000-01-01");
		student.setGender("M");

		student.setYear(2022);
		student.setGroup("11-200");

		HTMLPersonWriter writer
						= new HTMLStudentWriter(student, "student.html");
		writer.print();

		Teacher teacher = new Teacher();

		teacher.setFio("Препод");
		teacher.setBirthDate("2000-01-01");
		teacher.setGender("М");

		teacher.setPosition("Доцент");
		teacher.setCources(new String[]{"Предмет 1", "Предмет 2", "Предмет 3"});

		HTMLPersonWriter writer2
						= new HTMLTeacherWriter(teacher, "teacher.html");
		writer2.print();
	}
}
