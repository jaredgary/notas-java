package hn.com.ceutec.final_project.utils;

/**
 * Reports.
 *
 * @author Gary Gonzalez Zepeda <mailto:gary.gonzalez@tigo.com.hn />
 * @version 1.0.0
 * @see
 * @since 09-13-2019 10:27:19 AM 2019
 */
public final class Reports {

	/**
	 * Instantiates a new reports.
	 */
	private Reports() {
	}

	/**
	 * Prints the subject state.
	 *
	 * @param students      the students
	 * @param subjects      the subjects
	 * @param ratingAverage the rating average
	 */
	public static void printSubjectState(final String[] students, final String[] subjects, int[][][] ratingAverage) {

		for (int i = 0; i < ratingAverage.length; i++) {
			System.out.println("*********************************");
			System.out.println("Nombre del Estudiante: " + students[i]);
			System.out.println("*********************************");
			for (int j = 0; j < ratingAverage[0].length; j++) {
				System.out.println("Asignatura-> " + subjects[j] + ", Promedio-> " + ratingAverage[i][j][0] + ", Estado-> "
						+ Reports.state(ratingAverage[i][j][0]));
			}
		}
	}

	/**
	 * Prints the subject state.
	 *
	 * @param subjects      the subjects
	 * @param ratingAverage the rating average
	 */
	public static void printSubjectState(final String[] subjects, int[][][] ratingAverage) {
		for (int i = 0; i < subjects.length; i++) {
			System.out.println("--------------------------------");
			System.out.println("Nombre de la Asignatura: " + subjects[i]);
			System.out.println("--------------------------------");
			int[] j = Reports.studentsState(ratingAverage, i);
			System.out.println(Constants.APPROVED + ": " + j[1]);
			System.out.println(Constants.FAILED + ": " + j[0]);
		}
	}

	/**
	 * Students state.
	 *
	 * @param ratingAverage the rating average
	 * @param subject       the subject
	 * @return the int[]
	 */
	private static int[] studentsState(int[][][] ratingAverage, final int subject) {
		int[] studentsRatings = new int[2];
		for (int i = 0; i < ratingAverage.length; i++) {
			for (int j = 0; j < ratingAverage[0].length; j++) {
				if (subject == j) {
					if (ratingAverage[i][j][0] < 70) {
						studentsRatings[0]++;
					} else {
						studentsRatings[1]++;
					}
				}
			}
		}

		return studentsRatings;
	}

	/**
	 * State.
	 *
	 * @param average the average
	 * @return the string
	 */
	private static String state(final int average) {
		String response = null;
		if (average < 70) {
			response = Constants.FAILED;
		} else if (average >= 70 && average <= 90) {
			response = "Bueno";
		} else if (average >= 91 && average <= 99) {
			response = "Sobresaliente";
		} else {
			response = "Excelente";
		}
		return response;
	}

}
