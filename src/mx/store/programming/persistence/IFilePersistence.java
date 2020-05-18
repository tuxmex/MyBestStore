package mx.store.programming.persistence;

import java.io.IOException;

public interface IFilePersistence {

	public void save(Object obj) throws IOException;

	public Object get() throws IOException, ClassNotFoundException;

}
