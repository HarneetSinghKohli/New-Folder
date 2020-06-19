package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.mozilla.classfile.ByteCode;

public class readFile {

	public static String readExternalJson(String path) throws IOException{

		return new String(Files.readAllBytes(Paths.get(path)));
	}

	
}
