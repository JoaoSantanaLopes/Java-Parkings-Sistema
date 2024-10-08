import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VeiculoTeste{
    
    private Veiculo veiculo;

    @BeforeEach
    public void setUp() {
        veiculo = new Veiculo("ABC1234", "Civic", "Honda", "João");
    }

    @Test
    public void testGetPlaca() {
        assertEquals("ABC1234", veiculo.getPlaca());
    }

    @Test
    public void testSetPlaca() {
        veiculo.setPlaca("XYZ9876");
        assertEquals("XYZ9876", veiculo.getPlaca());
    }

    @Test
    public void testGetModelo() {
        assertEquals("Civic", veiculo.getModelo());
    }

    @Test
    public void testSetModelo() {
        veiculo.setModelo("Corolla");
        assertEquals("Corolla", veiculo.getModelo());
    }

    @Test
    public void testGetMarca() {
        assertEquals("Honda", veiculo.getMarca());
    }

    @Test
    public void testSetMarca() {
        veiculo.setMarca("Toyota");
        assertEquals("Toyota", veiculo.getMarca());
    }

    @Test
    public void testGetDono() {
        assertEquals("João", veiculo.getDono());
    }

    @Test
    public void testSetDono() {
        veiculo.setDono("Maria");
        assertEquals("Maria", veiculo.getDono());
    }
}
