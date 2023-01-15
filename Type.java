package TypeRacer_Selenium;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

///https://stackoverflow.com/questions/15313469/java-keyboard-keycodes-list
public class Type {

	public void type(char[] text) {

		try {
			char inputchar[] = text;

			Robot bot = new Robot();

			System.out.println(inputchar);

			for (char x : inputchar) {

				if (x != '\t') {

					Thread.sleep(5);

					try {

						if (Character.isLowerCase(x)) {
							pressReleaseSet(Character.toUpperCase(x), bot);
						} else if (Character.isUpperCase(x)) {
							bot.keyPress(KeyEvent.VK_SHIFT);
							pressReleaseSet(x, bot);
							bot.keyRelease(KeyEvent.VK_SHIFT);

						} else {

							switch (x) {
							case '{':
								bot.keyPress(16);
								pressReleaseSet(91, bot);
								bot.keyRelease(16);

								break;
							case '}':
								bot.keyPress(16);
								pressReleaseSet(93, bot);
								bot.keyRelease(16);

								break;
							case '(':
								bot.keyPress(16);
								pressReleaseSet(56, bot);
								bot.keyRelease(16);
								break;
							case ')':
								bot.keyPress(16);
								pressReleaseSet(57, bot);
								bot.keyRelease(16);
								break;
							case '_':
								bot.keyPress(16);
								pressReleaseSet(92, bot);
								bot.keyRelease(16);
								break;
							case ':':
								pressReleaseSet(513, bot);
								break;
							case '+':
								bot.keyPress(16);
								pressReleaseSet(59, bot);
								bot.keyRelease(16);
								break;
							case '=':
								bot.keyPress(16);
								pressReleaseSet(45, bot);
								bot.keyRelease(16);
								break;
							case '’':
								bot.keyPress(16);
								pressReleaseSet(55, bot);
								bot.keyRelease(16);
								break;
							case '\'':
								bot.keyPress(16);
								pressReleaseSet(55, bot);
								bot.keyRelease(16);
								break;

							case '\"':
								bot.keyPress(16);
								pressReleaseSet(50, bot);
								bot.keyRelease(16);
								break;
							case '?':
								bot.keyPress(16);
								pressReleaseSet(47, bot);
								bot.keyRelease(16);
								break;

							case '-':
								pressReleaseSet(45, bot);
								break;
							case '—':
								pressReleaseSet(45, bot);
								break;

							default:
								bot.keyPress(x);
								bot.keyRelease(x);
							}

						}

					} catch (IllegalArgumentException e) {
						System.out.println("error:  " + x + "  keycode: ");
						e.printStackTrace();
					}
				}
			}

		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (AWTException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	public static void pressReleaseSet(int keycode, Robot bot) {
		try {
			bot.keyPress(keycode);
			bot.keyRelease(keycode);
		}

		catch (IllegalArgumentException e) {
			System.out.println("keycode: " + keycode);
			e.printStackTrace();
		}
	}

}
