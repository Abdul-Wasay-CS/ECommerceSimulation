package pakMart;

import java.io.*;

public class FileManager {
    
    // Constants for CSV column indices

    protected static final int ID_INDEX = 0;
    protected static final int FULLNAME_INDEX = 1;
    protected static final int USERNAME_INDEX = 2;
    protected static final int PASSWORD_INDEX = 3;
    protected static final int COUNTRY_INDEX = 4;
    protected static final int CITY_INDEX = 5;
    protected static final int SOCIETY_INDEX = 6;
    protected static final int STREET_NO_INDEX = 7;
    protected static final int HOUSE_NO_INDEX = 8;
    protected static final int SSN_INDEX = 9;
    protected static final int SIGNED_UP_INDEX = 10;
    protected static final int POST_INDEX = 11;
    protected static final int SALARY_INDEX = 12;

    protected static final String DATA_DIR = "data";

    protected static String csvPath(String fileName) {
        return DATA_DIR + File.separator + fileName;
    }

    protected static void ensureDataDirectory() {
        File dataDir = new File(DATA_DIR);
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
    }
}