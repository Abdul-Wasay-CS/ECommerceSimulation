package pakMart;

import java.io.*;

public final class FileManager {
    
    // Constants for CSV column indices

    private static final int ID_INDEX = 0;
    private static final int FULLNAME_INDEX = 1;
    private static final int USERNAME_INDEX = 2;
    private static final int PASSWORD_INDEX = 3;
    private static final int COUNTRY_INDEX = 4;
    private static final int CITY_INDEX = 5;
    private static final int SOCIETY_INDEX = 6;
    private static final int STREET_NO_INDEX = 7;
    private static final int HOUSE_NO_INDEX = 8;
    private static final int SSN_INDEX = 9;
    private static final int SIGNED_UP_INDEX = 10;
    private static final int POST_INDEX = 11;
    private static final int SALARY_INDEX = 12;


//==================    Admin related methods   ==================

    static Admin loadAdmin(String username, String password) {
        String path = "data" + File.separator + "adminData.csv";
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {

                // csv file pattern:
                // id,fullName,username,password,country,city,society,streetNo,houseNo,ssn,signedUp,post,salary
                String[] values = line.split(",");

                if (values.length != 13)
                    throw new IOException("Invalid CSV format");

                if (values[USERNAME_INDEX].equals(username)
                        && values[PASSWORD_INDEX].equals(password)) {

                    Admin loadingAdmin = getLoadingAdmin(values);

                    // Set the signedUp status
                    loadingAdmin.signedUp = Boolean.parseBoolean(values[SIGNED_UP_INDEX]);

                    // Set the password
                    loadingAdmin.password = values[PASSWORD_INDEX];

                    return loadingAdmin;
                }
            }
        } catch (FileNotFoundException e) {
            File dataDir = new File("data");
            if (!dataDir.exists()) {
                dataDir.mkdirs();
            }

            try {
                File file = new File(path);
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                if (file.createNewFile()) {
                    System.out.println("File succesfully created, Adding default Admin");
                    bw.write(
                            "A1,Administrator,admin,admin123,USA,New York,PakMart St,10,5,123456789,true,Super Admin,100000.0");
                } else {
                    System.out.println("File couldnt be created, Returning to main method");
                }
                bw.close();
            } catch (IOException ex) {
                System.out.println("File couldnt be created: " + ex);
            }
        } catch (IOException e) {
            System.out.println("An error occured in files");
        }
        return null;
    }

    private static Admin getLoadingAdmin(String[] values) {
        Address adminAddress = new Address(
                values[COUNTRY_INDEX],
                values[CITY_INDEX],
                values[SOCIETY_INDEX],
                Integer.parseInt(values[STREET_NO_INDEX]),
                Integer.parseInt(values[HOUSE_NO_INDEX]));

        // Create Admin with ALL fields from CSV
        return new Admin(
                values[FULLNAME_INDEX], // fullName
                values[USERNAME_INDEX], // userName
                adminAddress, // address
                Integer.parseInt(values[SSN_INDEX]), // ssn
                values[ID_INDEX], // adminId (existing from CSV)
                values[POST_INDEX], // post
                Double.parseDouble(values[SALARY_INDEX]) // salary
        );
    }

    static boolean findAdmin(String username, String password) {
        String path = "data" + File.separator + "adminData.csv";
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                // csv file pattern:
                // id,fullName,username,password,country,city,society,streetNo,houseNo,ssn,signedUp,post,salary
                String[] values = line.split(",");

                if (values[USERNAME_INDEX].equals(username) && values[PASSWORD_INDEX].equals(password)) {
                    return true;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Data in files is in incorrect format, please check the saveData() method");
        } catch (IOException e) {
            System.out.println("Error occurred in files" + e);
        }
        return false; // default return value
    }

    static boolean saveAdminData(Object o) {
        if (o instanceof Admin admin) {
            String path = "data" + File.separator + "adminData.csv";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
                String adminData = String.join(",",
                        admin.getAdminId(),
                        admin.getFullName(),
                        admin.getUserName(),
                        admin.password,
                        admin.getAddress().getCountry(),
                        admin.getAddress().getCity(),
                        admin.getAddress().getSociety(),
                        String.valueOf(admin.getAddress().getStreetNo()),
                        String.valueOf(admin.getAddress().getHouseNo()),
                        String.valueOf(admin.getSsn()),
                        String.valueOf(admin.signedUp),
                        admin.getPost(),
                        String.valueOf(admin.getSalary()));
                bw.write(adminData);
                bw.newLine();
                return true;
            } catch(FileNotFoundException e){
                File dataDir = new File("data");
                if (!dataDir.exists()) {
                    dataDir.mkdirs();
                }

                try {
                    File file = new File(path);
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                    if (file.createNewFile()) {
                        System.out.println("File succesfully created, Adding default Admin");
                        bw.write(
                                "A1,Administrator,admin,admin123,USA,New York,PakMart St,10,5,123456789,true,Super Admin,100000.0");
                    } else {
                        System.out.println("File couldnt be created, Returning to main method");
                    }
                    bw.close();
                } catch (IOException ex) {
                    System.out.println("File couldnt be created: " + ex);
                }
            }
             catch (IOException e) {
                System.out.println("Error occurred while writing to file: " + e);
            }
        }
        return false;   // default return value if object is not an Admin or if an error occurs
    }

    static void viewAllAdmins() {
        

        String path = "data" + File.separator + "adminData.csv";
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println("Admins List:");
            System.out.println("---------------------------------------------");
            System.out.printf("%-10s %-20s %-15s %-10s %-20s%n", "Admin ID", "Full Name", "Username", "Post", "Salary");

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.printf("%-10s %-20s %-15s %-10s %-20s%n"
                                    , values[ID_INDEX], values[FULLNAME_INDEX], values[USERNAME_INDEX]
                                    , values[POST_INDEX], values[SALARY_INDEX]);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e);
        }
    }


//============  customer related methods (to be implemented)  ==============

    //  TODO: placeholder for outputing all customers (for admin menu) 

    // TODO: placeholder for outputing all products (for admin menu) 
}