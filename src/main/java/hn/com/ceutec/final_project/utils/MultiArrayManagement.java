package hn.com.ceutec.final_project.utils;

/**
 * MultiArrayManagement.
 *
 * @author Gary Gonzalez Zepeda <mailto:gary.gonzalez@tigo.com.hn />
 * @version 1.0.0
 * @see
 * @since 09-11-2019 04:57:01 PM 2019
 */
public final class MultiArrayManagement {

	/**
	 * Instantiates a new multi array management.
	 */
	private MultiArrayManagement() {
	}

	/**
	 * Update ratings.
	 *
	 * @param ratingArray the rating array
	 * @param student     the student
	 * @param subject     the subject
	 * @param period      the period
	 * @param na          the na
	 * @param ne          the ne
	 * @return the int[][][][]
	 */
	public static int[][][][] updateRatings(int[][][][] ratingArray, final int student, final int subject,
			final int period, final int na, final int ne) {
		final int periodtmp = period - 1;
		students: for (int i = 0; i < ratingArray.length; i++) {
			for (int j = 0; j < ratingArray[0].length; j++) {
				for (int k = 0; k < 2; k++) {
					if (student == i && subject == j && periodtmp == k) {
						ratingArray[i][j][k][0] = na;
						ratingArray[i][j][k][1] = ne;
						ratingArray[i][j][k][2] = ne + na;
						System.out.println("Total: " + ratingArray[i][j][k][2]);
						break students;
					}
				}
			}
		}		
		return ratingArray;
	}

	/**
	 * Prints the multidimensional array.
	 *
	 * @param students      the students
	 * @param subjects      the subjects
	 * @param ratingArray   the rating array
	 * @param ratingAverage the rating average
	 * @return the int[][][]
	 */
	public static int[][][] print(final String[] students, final String[] subjects, int[][][][] ratingArray,
			int[][][] ratingAverage) {

		int total = 0;
		System.out.println("*********************************");
		System.out.println("Cuadro Resumen");
		System.out.println("*********************************");

		for (int i = 0; i < ratingArray.length; i++) {
			System.out.println("*********************************");
			System.out.println("Nombre del Estudiante: " + students[i]);
			System.out.println("*********************************");
			for (int j = 0; j < ratingArray[0].length; j++) {
				System.out.println("=================================");
				System.out.println("Asignatura: " + subjects[j]);
				System.out.println("=================================");
				for (int k = 0; k < 2; k++) {
					System.out.println("--------------------------------");
					System.out.println("Periodo " + (k + 1));
					System.out.println("--------------------------------");
					System.out.println("NA: " + ratingArray[i][j][k][0]);
					System.out.println("NE: " + ratingArray[i][j][k][1]);
					System.out.println("Total: " + ratingArray[i][j][k][2]);
					total += ratingArray[i][j][k][2];
					if (k == 1) {
						int average = (total / 2);
						System.out.println("Promedio -> " + average);
						ratingAverage[i][j][0] = average;
						total = 0;
					}
				}
			}
			System.out.println("*********************************");
		}
		return ratingAverage;
	}

}
