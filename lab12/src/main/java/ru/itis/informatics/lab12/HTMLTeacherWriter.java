package ru.itis.informatics.lab12;

import java.io.FileWriter;
import java.io.IOException;

public class HTMLTeacherWriter extends HTMLPersonWriter {

	private Teacher teacher;

	public HTMLTeacherWriter(Teacher teacher, String fileName) {
		super(teacher, fileName);
		this.teacher = teacher;
	}

	protected void printAddedInfo(FileWriter writer) throws IOException {
		writer.write("<div>" + teacher.getPosition() + "</div>\n");

		for(String cource : teacher.getCources())
			writer.write("<div>" + cource + "</div>\n");
	}
}

