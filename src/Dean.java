import java.rmi.Remote;
import java.util.List;

public interface Dean extends Remote {
    public List<Product> getProducts() throws Exception;
}