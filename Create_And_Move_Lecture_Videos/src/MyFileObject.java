import java.io.File;

public class MyFileObject implements Comparable {
	public File myFile = null;
	public int index = -1;
	public int videoNum = -1;

	public MyFileObject(File myFile, int myIndex, int myVideoNum) {
		this.myFile = myFile;
		this.index = myIndex;
		this.videoNum = myVideoNum;
	}

	@Override
	public int compareTo(Object arg0) {
		MyFileObject otherObject = (MyFileObject) arg0;
		return this.videoNum - otherObject.videoNum;
	}

}
