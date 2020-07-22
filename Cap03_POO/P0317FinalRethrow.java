public class P0317FinalRethrow {
	@SuppressWarnings("deprecation")
	public static Object create (String className)
		throws Exception {
		try {
			Class<?> classe = Class.forName(className);
			return classe.newInstance();
		} catch (InstantiationException e) {
			// tratamento local
			System.out.println(e + "\nObjeto nao criado");
			return null;
		} catch (final Exception e) {
			throw e; // final rethrow
		}
	}
	public static void main(String... a) {
		try {
			Object o = create(a[0]);
			if (o != null) {
				System.out.println("Objeto: " + o.getClass());
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e + "\nFalta argumento com nome da classe!");
		// multi-catch
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
