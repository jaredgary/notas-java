package hn.com.ceutec.final_project.utils;

/**
 * Menu.
 *
 * @author Gary Gonzalez Zepeda <mailto:gary.gonzalez@tigo.com.hn />
 * @version 1.0.0
 * @see
 * @since 09-07-2019 06:34:32 PM 2019
 */
public final class Menu {

	/**
	 * Instantiates a new menu.
	 */
	private Menu() {
	}

	/**
	 * Menu principal.
	 */
	public static void menuPrincipal() {
		System.out.println("---------------------------------------");
		System.out.println("SISTEMA CONTROL DE NOTAS UNITEC");
		System.out.println("---------------------------------------");
		System.out.print("1. Gestión de Alumnos. ");
		System.out.println();
		System.out.print("2. Gestión de Asignaturas. ");
		System.out.println();
		System.out.print("3. Gestión de Calificaciones. ");
		System.out.println();
		System.out.print("4. Reportes. ");
		System.out.println();
		System.out.print(Constants.MENU_EXIT);
		System.out.println();
	}

	/**
	 * Crud menu.
	 *
	 * @param label the label
	 */
	public static void crudMenu(final String label) {
		final String labelMenu = String.format(Constants.MENU_TITLE, label);
		final String labelCreate = String.format(Constants.MENU_CREATE, label);
		final String labelEdit = String.format(Constants.MENU_EDIT, label);
		final String labelDelete = String.format(Constants.MENU_DELETE, label);
		final String labelList = String.format(Constants.MENU_LIST, label);

		System.out.println("---------------------------------------");
		System.out.println(labelMenu);
		System.out.println("---------------------------------------");
		System.out.print(labelCreate);
		System.out.println();
		System.out.print(labelEdit);
		System.out.println();
		System.out.print(labelDelete);
		System.out.println();
		System.out.print(labelList);
		System.out.println();
		System.out.print(Constants.MENU_EXIT);
		System.out.println();

	}

	/**
	 * Rating menu.
	 *
	 * @param label the label
	 */
	public static void ratingMenu(final String label) {
		final String labelMenu = String.format(Constants.MENU_TITLE, label);
		System.out.println("---------------------------------------");
		System.out.println(labelMenu);
		System.out.println("---------------------------------------");
		System.out.print("1. Registar Estudiante-Asignatura. ");
		System.out.println();
		System.out.print("2. Registrar notas. ");
		System.out.println();	
		System.out.print(Constants.MENU_EXIT);
		System.out.println();

	}

	/**
	 * Report menu.
	 */
	public static void reportMenu() {
		System.out.println("---------------------------------------");
		System.out.println("REPORTERÍA");
		System.out.println("---------------------------------------");
		System.out.print("1. Por estado de asignatura. ");
		System.out.println();		
		System.out.print("2. Cantidad de aprobados y reprobados por asignatura. ");
		System.out.println();		
		System.out.print(Constants.MENU_EXIT);
		System.out.println();

	}

	/**
	 * End.
	 */
	public static void end() {
		System.out.println("*****");
		System.out.println("*End*");
		System.out.println("*****");

	}

	/**
	 * Message.
	 *
	 * @param message the message
	 */
	public static void message(final String message) {
		System.out.println();
		System.out.println("***************************************");
		System.out.println(message);
		System.out.println("***************************************");
		System.out.println();
	}

	/**
	 * Clear.
	 */
	public static void clear() {
		for (int i = 0; i < 2; i++) {
			System.out.println();
		}
	}

}