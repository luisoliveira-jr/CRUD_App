
package crud_app;

import com.databaseConnection.DB;
import com.crud.LoginView;

/** @author luiso */

public class CRUD_App {

    public static void main(String[] args) {
        
        LoginView loginObj = new LoginView();
        loginObj.show();
        
        DB.loadConnection();
        
    }
    
}
