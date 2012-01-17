package easyexplorer.popup.actions;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;

/**
 * Handle the path.
 * @author etigwuu
 *
 */
public class PathUtil {

	public static String handlePath(Object object){
		
		String file_Path = null;
		IPath path = null;
		if(object instanceof IFile){
			path = ((IFile)object).getLocation();
		}else if(object instanceof IFolder){
			path = ((IFolder)object).getLocation();
		} else if (object instanceof IJavaProject) {
			path = ((IJavaProject)object).getResource().getLocation();
		} else if (object instanceof IJavaElement) {
			path = ((IJavaElement)object).getResource().getLocation();
		}
		
		if (path != null) {
			
			File objFile = path.toFile();
			if (objFile.isDirectory()) {
				file_Path = objFile.getAbsolutePath();
			} else {
				file_Path = objFile.getParentFile().getAbsolutePath();
			}
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
