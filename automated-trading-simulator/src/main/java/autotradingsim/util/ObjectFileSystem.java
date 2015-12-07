package autotradingsim.util;

import autotradingsim.application.ITradingApplication;

import java.io.*;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>Utility class for saving and writing objects to the file system (serialization/deserialization).</p>
 * <p>Created by Tomek<br>
 *     Modified by Asher Minden-Webb</p>
 */
public class ObjectFileSystem {

	public static boolean saveObject (String path, Object toSave) {
		boolean fileCreatedSwitch = false;

		if (toSave == null)
			throw new NullPointerException("saveObject: Object toSave was null");
		if (path == null)
			throw new NullPointerException("saveObject: Path was null");
		if (path.matches("[\\s]*"))
			throw new IllegalArgumentException("saveObject: Path was empty string");

		path = ITradingApplication.rootPath + path;
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
			System.err.println("IO error in \"ObjectFileSystem::saveObject\"\n\tUsing path:" + path);
			e.printStackTrace();
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
		if (path.matches("[\\s]*")) {
			throw new IllegalArgumentException("loadObject: path was empty");
		}

		path = ITradingApplication.rootPath + path;

		File fileObj = new File(path);
		ObjectInputStream serializer;
		FileInputStream objectInputStream;
		Object result;

		if (!fileObj.exists()) {
			System.err.println("Error in 'ObjectFileSystem::loadObject'\n\tObject at location \"" + path + "\" does not exist.");
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

	/**
	 * Add an item to a list in a text file
	 * @param path path to file (not including application data folder)
	 * @param name
     * @return
     */
	public static boolean appendNameToListFile(String path, String name) {
		if (path == null)
			throw new NullPointerException("Path argument was null");
		if (path.matches("[\\s]*"))
			throw new IllegalArgumentException("Path argument was empty string");
		if (name == null)
			throw new NullPointerException("Name argument was null");
		if (name.matches("[\\s]*"))
			throw new IllegalArgumentException("Name argument was empty string");

		path = ITradingApplication.rootPath + path + ITradingApplication.listExtension;
		File checkFile = new File(path);
		if (!checkFile.exists()) {
			// Create new file if it doesn't exist
			try {
				if(!checkFile.createNewFile()) {
					System.err.println("New list file was not created: \"" + path + "\"");
					return false;
				}
			} catch (IOException e) {
				System.err.println("Could not create new list file:\n\t\"" + path + "\"");
				e.printStackTrace();
				return false;
			}
		}
		try {
			// Append name to file
			FileWriter listFile = new FileWriter(path, true);
			listFile.append(name).append("\n");
			listFile.close();
		} catch (IOException e) {
			System.err.println("Could not write to list file:\n\t\"" + path + "\"");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean deleteNameFromListFile(String path, String name) {
		if (path == null)
			throw new NullPointerException("Path argument was null");
		if (path.matches("[\\s]*"))
			throw new IllegalArgumentException("Path argument was empty string");
		if (name == null)
			throw new NullPointerException("Name argument was null");
		if (name.matches("[\\s]*"))
			throw new IllegalArgumentException("Name argument was empty string");

		path = ITradingApplication.rootPath + path + ITradingApplication.listExtension;
		String tempPath = path + ".tmp";
		File listFile = new File(path);
		File tempFile = new File(tempPath);
		String fileCreateErrMsg = "Could not create temp file for deleting name from list.";
		try {
			boolean success = tempFile.createNewFile();
			if (!success) {
				System.err.println(fileCreateErrMsg);
				return false;
			}
		} catch (IOException e) {
			System.err.println(fileCreateErrMsg);
			e.printStackTrace();
			return false;
		}
		if (!listFile.exists()) {
			throw new IllegalArgumentException("No list exists to delete from at:\n\t\"" + path + "\"");
		}
		try {
			FileReader listFileReader = new FileReader(listFile);
			BufferedWriter newWriter = new BufferedWriter(new FileWriter(tempFile));
			BufferedReader oldReader = new BufferedReader(listFileReader);

			String currentLine;

			while ((currentLine = oldReader.readLine()) != null) {
				currentLine = currentLine.trim();
				if (!currentLine.equals(name))
					newWriter.write(currentLine + "\n");
			}
			newWriter.close();
			oldReader.close();
			listFileReader.close();
			listFile.delete();
			if (!tempFile.renameTo(listFile)) {
				System.err.println("deleteNameFromListFile: Could not rename temporary file:\n\t\"" + path + "\"");
				if (!tempFile.delete())
					System.err.println("deleteNameFromListFile: Could not delete temporary file.");
				return false;
			}
			if (!tempFile.delete())
				System.err.println("deleteNameFromListFile: Could not delete temporary file.");
			return true;

		} catch (IOException e) {
			System.err.println("Error while attempting to delete name from list file at:\n\t\"" + path + "\n");
			e.printStackTrace();
			if (!tempFile.delete())
				System.err.println("deleteNameFromListFile: Could not delete temporary file.");
			return false;
		}
	}

	public static boolean checkListFileExists(String path) {
		if (path == null)
			throw new NullPointerException("Path argument was null");
		if (path.matches("[\\s]*"))
			throw new IllegalArgumentException("Path argument was empty string");

		path = ITradingApplication.rootPath + path + ITradingApplication.listExtension;
		File listsFile = new File(path);

		boolean exists = listsFile.exists();

		return exists;
	}

	public static Set<String> loadNamesFromListFile(String path) {
		if (path == null)
			throw new NullPointerException("Path argument was null");
		if (path.matches("[\\s]*"))
			throw new IllegalArgumentException("Path argument was empty string");

		path = ITradingApplication.rootPath + path + ITradingApplication.listExtension;
		File listsFile = new File(path);

		Set<String> returningSet = new HashSet<>();

		if (!listsFile.exists())
			throw new IllegalArgumentException("File does not exist at path: \n\t\"" + path + "\"");

		try {
			BufferedReader reader = new BufferedReader(new FileReader(listsFile));
			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				currentLine = currentLine.trim();
				if (!currentLine.matches("[\\s]*") && !currentLine.matches("[\\s]*")) {
					returningSet.add(currentLine);
				}
			}
			reader.close();
		} catch (IOException e) {
			System.err.println("loadNamesFromListFile: Could not read from file at:\n\t\"" + path + "\"");
		}
		return returningSet;
	}

	public static boolean deleteObjectFile(String path) {
		if (path == null) {
			throw new NullPointerException("deleteObjectFile: path was null");
		}
		if (path.matches("[\\s]*")) {
			throw new IllegalArgumentException("deleteObjectFile: path was empty");
		}
		String err =
				"Error in 'ObjectFileSystem::deleteObjectFile'\n\tObject at location \"" + path + "\" does not exist.";

		return deleteFile(ITradingApplication.rootPath + path, err);
	}

	public static boolean deleteListFile(String path) {
		if (path == null) {
			throw new NullPointerException("deleteListFile: path was null");
		}
		if (path.matches("[\\s]*")) {
			throw new IllegalArgumentException("deleteListFile: path was empty");
		}

		path = ITradingApplication.rootPath + path + ITradingApplication.listExtension;

		String err =
				"Error in 'ObjectFileSystem::deleteListFile'\n\tList file at location \"" + path + "\" does not exist.";

		return deleteFile(path, err);
	}

	public static boolean deleteFile(String path, String errMessage) {
		File fileObj = new File(path);
		if (!fileObj.exists()) {
			System.err.println(errMessage);
			throw new IllegalArgumentException("File does not exist at path:\n\t\"" + path + "\"");
		}
		return fileObj.delete();
	}

}
