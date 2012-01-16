package easyexplorer.popup.actions;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;

/**
 * Handle the path.
 * @author etigwuu
 *
 */
public class PathUtil {

	public static String handlePath(Object object){
		
		String file_Path = null;
		if(object instanceof IFile){
			IPath path = ((IFile)object).getLocation();
			file_Path = path.toPortableString();
			File file1 = new File(file_Path);
			file_Path = file1.getParentFile().getAbsolutePath();
		}else if(object instanceof IFolder){
			IPath path = ((IFolder)object).getLocation();
			file_Path = path.toPortableString();
			File file1 = new File(file_Path);
			file_Path = file1.getAbsolutePath();
		}
		return file_Path;

	}
	
	public static String handleSpace(String path){
		
		if(path != null){
			path = path.replaceAll(" ", "%20");
		}
		return path;
	}
}
