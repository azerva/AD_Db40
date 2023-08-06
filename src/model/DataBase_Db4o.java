package model;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Predicate;
import com.db4o.query.Query;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ROZER
 */
public class DataBase_Db4o {

    private static String FILE_DATA_BASE = "biblioteca.db4o";
    private static ObjectContainer db;

    /**
     * Establecemos una conexión a la base de datos.
     *
     * @return el estado de la conexión
     */
    public static ObjectContainer getDb() {
	if (db == null) {
	    db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), FILE_DATA_BASE);

	}
	return db;
    }

    /**
     * Cerramos la conexión con la base de datos.
     */
    public static void closeDb() {
	if (db != null) {
	    db.close();
	    db = null;
	}
    }

    /**
     * Guardamos un libro en la base de datos y comprobamos al guardar el libro
     * si ya existe o no en nuestra base de datos para evitar duplicados
     *
     * @param libro
     */
    public static void guardarLibro(Libros libro) {
	ObjectSet<Libros> libros = db.query(new Predicate<Libros>() {
	    @Override
	    public boolean match(Libros lib) {
		return lib.getTitulo().equalsIgnoreCase(libro.getTitulo()) && lib.getEditorial().equalsIgnoreCase(libro.getEditorial())
			&& lib.getTipo().equalsIgnoreCase(libro.getTipo());
	    }

	});

	if (libros.hasNext()) {

	    JOptionPane.showMessageDialog(null, "El libro que desea agregar ya existe.");
	} else {
	    db.store(libro);
	    System.out.println("El libro se ha guardado correctamente en la base de datos.");
	    JOptionPane.showMessageDialog(null, "El libro se ha guardado correctamente en la base de datos.");
	}
    }

    /**
     * Guardamos el nuevo Autor y comprobamos al guardar el autor si ya existe o
     * no en nuestra base de datos para evitar duplicados
     *
     * @param autor
     */
    public static void guardarAutor(Autores autor) {
	ObjectSet<Autores> auth = db.query(new Predicate<Autores>() {
	    @Override
	    public boolean match(Autores a) {
		return a.getNombre().equalsIgnoreCase(autor.getNombre()) && a.getFecha_nacimiento().equalsIgnoreCase(autor.getFecha_nacimiento());
	    }

	});

	if (auth.hasNext()) {
	    JOptionPane.showMessageDialog(null, "El autor que desea agregar ya existe.");

	} else {
	    db.store(autor);

	}

    }

    /**
     * Obtenemos todos los libros e la base de datos.
     *
     * @return devuelve los libros almacenados
     */
    public static List<Libros> obtenerTodosLibros() {
	ObjectSet<Libros> libros = db.query(Libros.class);
	return libros;
    }

    /**
     * Obtenemos una lista de libros en un intervalo de precios establecido
     *
     * @param precioMin precio mínimo del libro
     * @param precioMax precio máximo dle libro
     * @return devuele una lista de libros entre los precios establecidos
     */
    public static List<Libros> obtenerLibrosPorPrecio(double precioMin, double precioMax) {
	Query query = db.query();
	query.constrain(Libros.class);
//	query.descend("precio").constrain(precioMin).greater().and(precioMax).smaller();
	//declaramos una de las restricciones con Contraint
	Constraint constraint = query.descend("precio").constrain(precioMax).smaller();
	//enlazamos las dos restricciones
	query.descend("precio").constrain(precioMin).greater().and(constraint);
	ObjectSet<Libros> libros = query.execute();
	return libros;
    }

    /**
     * Elimininamos un libro por el titulo que solicitamos por parametro
     *
     * @param titulo nombre del libro
     */
    public static void deleteLibro(String titulo) {
	Query query = db.query();
	query.constrain(Libros.class);
	query.descend("titulo").constrain(titulo);
//	ObjectSet<Libros> libro = query.execute();
//	while (libro.hasNext()) {
//	    db.delete(libro.next());
//	    System.out.println("El libro ha sido borrado de la base de datos.");
//
//	}
//	db.commit();
	ObjectSet<Libros> result = query.execute();

	if (result.hasNext()) {
	    db.delete(result.next());
	    System.out.println("El libro ha sido borrado de la base de datos.");
	    JOptionPane.showMessageDialog(null, "El libro ha sido borrado de la base de datos.");

	} else {
	    System.out.println("No se ha encontrado el libro en la base de datos.");
	    JOptionPane.showMessageDialog(null, "No se ha encontrado el libro en la base de datos.");

	}
	db.commit();
    }

    /**
     * Aumentamos elprecio de todos los libros con el porcentaje que le pasamos
     * como parámetro.
     *
     * @param porcentaje número para aumentar el precio de los libros
     */
    public static void aumentarPrecioLibros(double porcentaje) {
	List<Libros> libros = obtenerTodosLibros();
	for (Libros libro : libros) {
	    double nuevoPrecio = libro.getPrecio() * (1 + porcentaje / 100);
	    libro.setPrecio(nuevoPrecio);
	    db.store(libro);
	}
    }

    /**
     * Obtenemos todos los autores de la base de datos
     *
     * @return devuelve una List de autores
     */
    public static List<Autores> obtenerTodosAutores() {
	ObjectSet<Autores> autores = null;
	try {
	    autores = db.query(Autores.class);
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "No exiten registros..");

	}

	return autores;

    }

    public static List<Autores> obtenerAutoresPorTipo() {
	Query query = db.query();
	query.constrain(Autores.class);
	query.descend("tipo").orderAscending();
	ObjectSet<Autores> autores = query.execute();
	return autores;

    }

    public static ObjectSet<Autores> obtenerDatosAutor(String nombre) {
	Query query = db.query();
	query.constrain(Autores.class);
	query.descend("nombre").constrain(nombre);
	ObjectSet<Autores> autores = query.execute();
	return autores;

    }

    public static List<Autores> obtenerAutoresPorNacionalidad(String nacionalidad) {
	Query query = db.query();
	query.constrain(Autores.class);
	query.descend("nacionalidad").constrain(nacionalidad);
	ObjectSet<Autores> autores = query.execute();
	return autores;
    }

    public static List<Libros> obtenerLibrosPorAutor(String nombreAutor) {
	Query query = db.query();
	query.constrain(Libros.class);
	query.descend("autor").descend("nombre").constrain(nombreAutor);
	ObjectSet<Libros> libros = query.execute();
	return libros;
    }

}
