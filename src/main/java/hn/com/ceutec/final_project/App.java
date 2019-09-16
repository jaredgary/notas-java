package hn.com.ceutec.final_project;

import java.util.Scanner;

import hn.com.ceutec.final_project.utils.Constants;
import hn.com.ceutec.final_project.utils.Menu;
import hn.com.ceutec.final_project.utils.MultiArrayManagement;
import hn.com.ceutec.final_project.utils.Reports;
import hn.com.ceutec.final_project.utils.SimpleArrayManagement;

/**
 * App.
 *
 * @author Gary Gonzalez Zepeda <mailto:gary.gonzalez@tigo.com.hn />
 * @version 1.0.0
 * @see
 * @since 09-07-2019 06:49:44 PM 2019
 */
public class App {

	/** Attribute that determine student. */
	private static String[] students = {};

	/** Attribute that determine subjects. */
	private static String[] subjects = {};

	/** Attribute that determine ratingSubjects. */
	private static int[][][][] ratingSubjects = {};

	/** Attribute that determine ratingAverage. */
	private static int[][][] ratingAverage = {};

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		int option = -1;
		final Scanner read = new Scanner(System.in);

		while (option != 0) {
			Menu.menuPrincipal();
			System.out.print(Constants.OPTION);
			option = read.nextInt();
			Menu.clear();

			switch (option) {
			case 0:
				break;
			case 1:
				App.processSimpleArray(read, Constants.STUDENT_NAME, Constants.STUDENT_INDEX, Constants.STUDENT,
						option);
				Menu.clear();
				break;
			case 2:
				App.processSimpleArray(read, Constants.SUBJECT_NAME, Constants.SUBJECT_INDEX, Constants.SUBJECT,
						option);
				Menu.clear();
				break;
			case 3:
				App.rating(read);
				Menu.clear();
				break;
			case 4:
				App.reports(read);
				Menu.clear();
				break;
			default:
				System.out.println(Constants.OPTION_ERROR);
				break;

			}
		}

		Menu.end();

		read.close();

	}

	/**
	 * Process simple array.
	 *
	 * @param read       the read
	 * @param nameMsg    the name msg
	 * @param indexMsg   the index msg
	 * @param label      the label
	 * @param optionMenu the option menu
	 */
	public static void processSimpleArray(final Scanner read, final String nameMsg, final String indexMsg,
			final String label, final int optionMenu) {
		int option = -1, index = -1;
		String name = null;
		String[] array = App.fillArray(optionMenu);
		boolean response = false;

		while (option != 0) {
			Menu.crudMenu(label);
			System.out.print(Constants.OPTION);
			option = read.nextInt();
			System.out.println();

			switch (option) {
			case 0:
				break;
			case 1:
				System.out.print(nameMsg);
				name = read.next();
				array = SimpleArrayManagement.insert(array, name, String.format(Constants.ADD_MESSAGE, label));
				break;
			case 2:
				SimpleArrayManagement.printArray(array);
				System.out.print(indexMsg);
				index = read.nextInt();
				response = SimpleArrayManagement.validateIndex(array, index);
				if (!response) {
					System.out.println(Constants.INDEX_ERROR);
					break;
				}
				System.out.print(nameMsg);
				name = read.next();
				array = SimpleArrayManagement.update(array, index, name, String.format(Constants.EDIT_MESSAGE, label));
				break;
			case 3:
				SimpleArrayManagement.printArray(array);
				System.out.print(indexMsg);
				index = read.nextInt();
				response = SimpleArrayManagement.validateIndex(array, index);
				if (!response) {
					System.out.println(Constants.INDEX_ERROR);
					break;
				}
				array = SimpleArrayManagement.delete(array, index, String.format(Constants.DELETE_MESSAGE, label));
				break;
			case 4:
				SimpleArrayManagement.printArray(array);
				break;
			default:
				System.out.println(Constants.OPTION_ERROR);
				break;

			}
		}

		App.fillArray(optionMenu, array);
	}

	/**
	 * Rating.
	 *
	 * @param read the read
	 */
	public static void rating(final Scanner read) {
		int option = -1, period = 0, student = -1, subject = -1, na = 0, ne = 0;
		String message = null;
		boolean response = false;

		while (option != 0) {
			Menu.ratingMenu("notas");
			System.out.print(Constants.OPTION);
			option = read.nextInt();
			System.out.println();

			switch (option) {
			case 0:
				break;
			case 1:
				message = String.format(Constants.ADD_MESSAGE, "Registro");
				App.ratingSubjects = new int[App.students.length][App.subjects.length][2][3];
				App.ratingAverage = new int[App.students.length][App.subjects.length][1];
				Menu.message(message);
				break;
			case 2:
				SimpleArrayManagement.printArray(App.students);
				System.out.print(Constants.STUDENT_INDEX);
				student = read.nextInt();
				response = SimpleArrayManagement.validateIndex(App.students, student);
				if (!response) {
					System.out.println(Constants.INDEX_ERROR);
					break;
				}
				SimpleArrayManagement.printArray(App.subjects);
				System.out.print(Constants.SUBJECT_INDEX);
				subject = read.nextInt();
				response = SimpleArrayManagement.validateIndex(App.subjects, subject);
				if (!response) {
					System.out.println(Constants.INDEX_ERROR);
					break;
				}

				System.out.print("Selecciona Periodo (1-2): ");
				period = read.nextInt();

				if (period != 1 && period != 2) {
					System.out.println(Constants.OPTION_ERROR);
					break;
				}

				System.out.print("NA: ");
				na = read.nextInt();

				System.out.print("NE: ");
				ne = read.nextInt();

				App.ratingSubjects = MultiArrayManagement.updateRatings(App.ratingSubjects, student, subject, period,
						na, ne);
				App.ratingAverage = MultiArrayManagement.print(App.students, App.subjects, App.ratingSubjects,
						App.ratingAverage);
				break;			
			default:
				System.out.println(Constants.OPTION_ERROR);
				break;

			}
		}
	}

	/**
	 * Reports.
	 *
	 * @param read the read
	 */
	public static void reports(final Scanner read) {
		int option = -1;
		while (option != 0) {
			Menu.reportMenu();
			System.out.print(Constants.OPTION);
			option = read.nextInt();
			System.out.println();

			switch (option) {
			case 0:
				break;
			case 1:
				Reports.printSubjectState(App.students, App.subjects, App.ratingAverage);
				break;
			case 2:
				Reports.printSubjectState(App.subjects, App.ratingAverage);
				break;
			default:
				System.out.println(Constants.OPTION_ERROR);
				break;
			}
		}
	}

	/**
	 * Fill array.
	 *
	 * @param optionMenu the option menu
	 * @param array      the array
	 */
	private static void fillArray(final int optionMenu, String[] array) {

		if (optionMenu == 1) {
			App.students = array;
		} else if (optionMenu == 2) {
			App.subjects = array;
		}

	}

	/**
	 * Fill array.
	 *
	 * @param optionMenu the option menu
	 * @return the string[]
	 */
	private static String[] fillArray(final int optionMenu) {
		String[] array = {};
		if (optionMenu == 1) {
			array = App.students;
		} else if (optionMenu == 2) {
			array = App.subjects;
		}

		return array;
	}

}
