package mainPackage;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Filter {

    public DefaultListModel<String> finder( String dirName)
    {
    	File dir = new File(dirName);
    	DefaultListModel<String> tmp = new DefaultListModel <String>();

    	for (File file : dir.listFiles())
    	{
    		if (file.getName().endsWith(".txt"))
    		{
    			tmp.addElement(file.getName());
    		}
    	}
    	return tmp;
    }

}