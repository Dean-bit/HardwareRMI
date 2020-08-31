import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
public class Client {

    private Client() {}
    public static void main(String[] args)throws Exception {
        try {
            // Getting the registry
            Registry registry = LocateRegistry.getRegistry("localhost");

            // Looking up the registry for the remote object
            Dean stub = (Dean) registry.lookup("Dean");

            // Calling the remote method using the obtained object
            List<Product> list = (List)stub.getProducts();
            for (Product s:list) {

                // System.out.println("bc "+s.getBranch());
                System.out.println("ID: " + s.getId());
                System.out.println("name: " + s.getName());
                System.out.println("quantity: " + s.getQuantity());

            }
            // System.out.println(list);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
