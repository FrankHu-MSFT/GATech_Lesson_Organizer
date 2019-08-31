import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

// Note there can be no other folders in the classes.
public class FileMover {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		File folder = new File(
				"C:\\Users\\frhu\\Documents\\asdf\\GA Tech\\Fall 2019\\CPS Design\\Cyber-Physical Systems Design & Analysis Videos");
		File[] listOfFiles = folder.listFiles();
		ArrayList<MyFileObject> myFiles = new ArrayList<>();
		for (int i = 0; i < listOfFiles.length; ++i) {
			MyFileObject myFile = new MyFileObject(listOfFiles[i], i,
					Integer.parseInt(listOfFiles[i].getName().split("-")[0].trim()));
			myFiles.add(myFile);
		}

		Collections.sort(myFiles);
		for (int i = 10; i < myFiles.size(); i += 10) {
			File thisFolder = new File(folder.getAbsolutePath() + "\\" + (i - 10));
			boolean success = thisFolder.mkdir();
			if (!success) {
				// Directory creation failed
				System.out.println("failed to create dir");
			} else {
				for (int j = i - 10; j < i; ++j) {
					File fileToMove = myFiles.get(j).myFile;
					boolean succ = fileToMove
							.renameTo(new File(thisFolder.getAbsolutePath() + "\\" + fileToMove.getName()));
					if (!succ) {
						System.out.println("failed to move file");
					}
				}
			}
		}

	}
}
