package de.commands;

public class CommandFactory {
	private static final String PREFIX = "de.commands.";
	private static final String SUFFIX = "Command";

	public static Command createCommand(String zeile) {
		try {

			String [] tokens = zeile.split(" ");

			Command result = (Command) Class.forName(PREFIX + tokens[0] + SUFFIX).newInstance();
			result.parse(tokens);
			return result;
		} catch (Throwable e) {
			System.out.println(e.getClass().getSimpleName() + ": " +e.getMessage());
			return null;
		}
	}

}
