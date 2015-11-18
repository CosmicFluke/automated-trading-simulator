package autotradingsim.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
<<<<<<< HEAD
import java.io.NotSerializableException;
=======
>>>>>>> b769d790b3cd4527a53f8a7713a4f02e0d6c3b82
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ObjectFileSystem {
	
	public static boolean saveObject(String path, Object toSave){
		File FileObj = new File(path);
		ObjectOutputStream serializer = null;
		FileOutputStream ObjectStream = null;
		try {
			if(!FileObj.exists())
				FileObj.createNewFile();
		} catch (IOException e) {
			System.err.println("Error in creating file for saving object. Path:" + path);
			e.printStackTrace();
			return false;
		}
		try{
			ObjectStream = new FileOutputStream(FileObj);
			serializer = new ObjectOutputStream(ObjectStream);
			serializer.writeObject(toSave);
			serializer.close();
<<<<<<< HEAD
			return true;

		}catch (NotSerializableException e){
			String err = "Object " + toSave.getClass() + " not serializable.";
			err += " Aborting save.";
			System.err.println(err);
			
		}catch (IOException e) {
			String err = "IO Exception occured in saving an object of type " + toSave.getClass();
			System.err.println(err);
			e.printStackTrace();
		}
		try {
			if(serializer != null)
				serializer.close();
		} catch (IOException e1) {
			assert("false" == "this should never happen");
			e1.printStackTrace();
		}
		FileObj.delete();
		return false;
=======

		}catch (IOException e) {
			try {
				if(serializer != null)
					serializer.close();
			} catch (IOException e1) {
				assert("false" == "this should never happen");
				e1.printStackTrace();
			}
			FileObj.delete();
			System.err.println("IO Exception occured in saving experiment");
			e.printStackTrace();
		}
		return true;
>>>>>>> b769d790b3cd4527a53f8a7713a4f02e0d6c3b82
	}
	
	public static Object loadObject(String path){
		File FileObj = new File(path);
		ObjectInputStream serializer = null;
		FileInputStream ObjectInputStream = null;
		Object result = null;
		
		if(!FileObj.exists()){
			System.err.println("Error. Object at location " + path + " does not exist.");
			return result;
		}
		
		try {
			ObjectInputStream = new FileInputStream(FileObj);
			serializer = new ObjectInputStream(ObjectInputStream);
			result = serializer.readObject();
			serializer.close();
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("Error loading object from memory at location: " + path);
			e.printStackTrace();
		}
		
		return result;
	}

}
