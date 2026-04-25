package pakMart;

import java.io.*;

public class AdminFileManager extends FileManager {

    private static final String ADMIN_CSV = "adminData.csv";

    static Admin load(String username, String password) {
        String path = csvPath(ADMIN_CSV);
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {

                // CSV file format:
                // id,fullName,username,password,country,city,society,streetNo,houseNo,ssn,signedUp,post,salary
                String[] values = line.split(",");

                if (values.length != 13) {
                    throw new IOException("Invalid CSV format");
                }

                if (values[USERNAME_INDEX].equals(username)
                        && values[PASSWORD_INDEX].equals(password)) {

                    Admin loadingAdmin = getLoadingAdmin(values);

                    loadingAdmin.signedUp = Boolean.parseBoolean(values[SIGNED_UP_INDEX]);
                    loadingAdmin.password = values[PASSWORD_INDEX];

                    return loadingAdmin;
                }
            }
        } catch (FileNotFoundException e) {
            createAdminFileWithDefault(path);
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

        return new Admin(
                values[FULLNAME_INDEX],
                values[USERNAME_INDEX],
                adminAddress,
                Integer.parseInt(values[SSN_INDEX]),
                values[ID_INDEX],
                values[POST_INDEX],
                Double.parseDouble(values[SALARY_INDEX]));
    }

    static boolean find(String username, String password) {
        String path = csvPath(ADMIN_CSV);
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
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
        return false;
    }

    static boolean saveData(Object o) {
        if (o instanceof Admin admin) {
            String path = csvPath(ADMIN_CSV);
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
            } catch (FileNotFoundException e) {
                createAdminFileWithDefault(path);
            } catch (IOException e) {
                System.out.println("Error occurred while writing to file: " + e);
            }
        }
        return false;
    }

    static void viewAll() {

        String path = csvPath(ADMIN_CSV);
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println("Admins List:");
            System.out.println("---------------------------------------------");
            System.out.printf("%-10s %-20s %-15s %-10s %-20s%n", "Admin ID", "Full Name", "Username", "Post", "Salary");

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.printf("%-10s %-20s %-15s %-10s %-20s%n",
                        values[ID_INDEX], values[FULLNAME_INDEX], values[USERNAME_INDEX],
                        values[POST_INDEX], values[SALARY_INDEX]);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e);
        }
    }

    private static void createAdminFileWithDefault(String path) {
        ensureDataDirectory();

        try {
            File file = new File(path);
            boolean fileCreated = file.createNewFile();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                if (fileCreated) {
                    System.out.println("File succesfully created, Adding default Admin");
                    bw.write(
                            "A1,Administrator,admin,admin123,USA,New York,PakMart St,10,5,123456789,true,Super Admin,100000.0");
                } else {
                    System.out.println("File couldnt be created, Returning to main method");
                }
            }
        } catch (IOException ex) {
            System.out.println("File couldnt be created: " + ex);
        }
    }
}
