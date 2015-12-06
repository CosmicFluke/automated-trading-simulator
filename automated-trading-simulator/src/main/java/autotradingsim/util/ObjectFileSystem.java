package autotradingsim.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * <p>Utility class for saving and writing objects to the file system (serialization/deserialization).</p>
 * <p>Created by Tomek<br>
 *     Modified by Asher Minden-Webb</p>
 */
public class ObjectFileSystem {
	
	public static boolean saveObject (String path, Object toSave) {
		boolean fileCreatedSwitch = false;

		if (toSave == null) {
			throw new NullPointerException("saveObject: Object toSave was null");
		}

		File fileObj = new File(path);
		ObjectOutputStream serializer;
		FileOutputStream objectStream;

		try {
			if(!fileObj.exists()) {
				if (fileObj.createNewFile()) {
					fileCreatedSwitch = true;
				} else {
					throw new IOException("Failed to create new file.");
				}
			}

		} catch (IOException e) {
			System.err.println("Error in creating file for saving object. Path:" + path);
			return false;
		}

		try {
			objectStream = new FileOutputStream(fileObj);
			serializer = new ObjectOutputStream(objectStream);
			serializer.writeObject(toSave);
			serializer.close();
			return true;

		}catch (NotSerializableException e){
			String err = "Object " + toSave.getClass() + " not serializable.";
			err += " Aborting save.";
			if (fileCreatedSwitch) {
				if (!fileObj.delete())
					System.err.println("Failed to delete unused new file.");
			}
			throw new IllegalArgumentException(err);
			
		}catch (IOException e) {
			String err = "IO Exception occured in saving an object of type " + toSave.getClass();
			System.err.println(err);
			e.printStackTrace();
			if (fileCreatedSwitch) {
				if (!fileObj.delete())
					System.err.println("Failed to delete unused new file.");
			}
			return false;
		}
	}
	
	public static Object loadObject(String path){
		if (path == null) {
			throw new NullPointerException("loadObject: path was null");
		}
		if (path.equals("")) {
			throw new IllegalArgumentException("loadObject: path was empty");
		}

		File fileObj = new File(path);
		ObjectInputStream serializer;
		FileInputStream objectInputStream;
		Object result;

		if (!fileObj.exists()) {
			System.err.println("Error. Object at location \"" + path + "\" does not exist.");
			return null;
		}
		
		try {
			objectInputStream = new FileInputStream(fileObj);
			serializer = new ObjectInputStream(objectInputStream);
			result = serializer.readObject();
			objectInputStream.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Error loading object from memory at location: " + path);
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.err.println("Error reading from file at location: " + path);
			e.printStackTrace();
			return null;
		}
		
		return result;
	}

}
