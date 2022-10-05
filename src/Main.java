import com.vitterre.imagebuilder.builder.ConsoleImageBuilder;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		ConsoleImageBuilder consoleImageBuilder = new ConsoleImageBuilder();
		consoleImageBuilder.build("resources/apple_golden.png");
	}
}