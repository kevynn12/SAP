import java.util.ArrayList;

public class AdminRepository {

    static ArrayList<Admin> getAdmins() {
        return null;
    }

    public ArrayList<Admin> addAdmin() {
        ArrayList<Admin> admins = new ArrayList<Admin>();

        
        Admin admin1 = new Admin("Kevynn", "adm","123","");
        Admin admin2 = new Admin("Eugenio", "adm2","123","");

        admins.add(admin1);
        admins.add(admin2);

        return admins;
    }
}