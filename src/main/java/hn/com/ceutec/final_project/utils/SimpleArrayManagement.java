package hn.com.ceutec.final_project.utils;

/**
 * SimpleArrayManagement.
 *
 * @author Gary Gonzalez Zepeda <mailto:gary.gonzalez@tigo.com.hn />
 * @version 1.0.0
 * @see
 * @since 09-07-2019 07:02:59 PM 2019
 */
public final class SimpleArrayManagement {

	/**
	 * Instantiates a new student manegment.
	 */
	private SimpleArrayManagement() {
	}

	/**
	 * Insert.
	 *
	 * @param array   the array
	 * @param name    the name
	 * @param message the message
	 * @return the string[]
	 */
	public static String[] insert(String[] array, final String name, final String message) {

		if (array.length == 0) {
			array = new String[1];
			array[0] = name;
		} else {
			final String[] newArray = new String[array.length + 1];
			SimpleArrayManagement.fillArray(newArray, array);
			newArray[array.length] = name;
			array = new String[newArray.length];
			SimpleArrayManagement.fillArray(array, newArray);
		}

		Menu.message(message);
		return array;
	}

	/**
	 * Update.
	 *
	 * @param array   the array
	 * @param index   the index
	 * @param name    the name
	 * @param message the message
	 * @return the string[]
	 */
	public static String[] update(final String[] array, final int index, final String name, final String message) {

		if (index < 0) {
			Menu.message(Constants.INDEX_ERROR);
			return array;
		}

		final boolean response = validateIndex(array, index);

		if (response) {
			array[index] = name;
			Menu.message(message);
		} else {
			Menu.message(Constants.INDEX_ERROR);
		}

		return array;
	}

	/**
	 * Delete.
	 *
	 * @param array   the array
	 * @param index   the index
	 * @param message the message
	 * @return the string[]
	 */
	public static String[] delete(final String[] array, final int index, final String message) {
		final boolean response = validateIndex(array, index);
		if (!response) {
			Menu.message(Constants.INDEX_ERROR);
			return array;
		}

		final String[] newArray = new String[array.length - 1];
		for (int i = 0, k = 0; i < array.length; i++) {
			if (i == index) {
				continue;
			}
			newArray[k++] = array[i];
		}
		Menu.message(message);
		return newArray;
	}

	/**
	 * Fill array.
	 *
	 * @param newArray the new array
	 * @param oldArray the old array
	 */
	public static void fillArray(final String[] newArray, final String[] oldArray) {
		for (int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}

	/**
	 * Validate index.
	 *
	 * @param array the array
	 * @param index the index
	 * @return true, if successful
	 */
	public static boolean validateIndex(final String[] array, final int index) {
		boolean flag = false;
		for (int i = 0; i < array.length; i++) {
			if (index == i) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * Prints the array.
	 *
	 * @param array the array
	 */
	public static void printArray(final String[] array) {
		System.out.println();
		System.out.println("***************");
		for (int i = 0; i < array.length; i++) {
			System.out.println(i + ": " + array[i]);
		}
		System.out.println("***************");
		System.out.println();
	}

}
