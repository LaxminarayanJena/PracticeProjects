package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by agarwalp on 5/31/2017.
 */
public class ObjectRepository {

    Properties properties = new Properties();

    /**
     * FUNCTION NAME        : ObjectRepository
     * DESCRIPTION          : Reads the properties fron Conf.Properties file
     * INPUT PARAMETERS     : None
     * OUTPUT               : None
     * AUTHOR               : Priyal Agarwal
     */
    public ObjectRepository() {
        File file = new File(GlobalVariables.OBJECT_REPOSITORY_PATH);
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("Object Repository does not exist at path=" + GlobalVariables.OBJECT_REPOSITORY_PATH);
            e.printStackTrace();
        }
        //loads the properties file
        try {
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FUNCTION NAME        : getObjectProperty
     * DESCRIPTION          : assigns the object property to respective variable name in the Conf.Properties file
     * INPUT PARAMETERS     : None
     * OUTPUT               : None
     * AUTHOR               : Priyal Agarwal
     */
    public String getObjectProperty(String objectName) {
        String objectProperty = properties.getProperty(objectName);
        if (objectProperty != null) {
            return objectProperty;
        } else {
            throw new IllegalArgumentException("Object=" + objectName + " does not exist in Object Repository");
        }
    }

}
