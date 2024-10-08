import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    public void testClienteAtributos() {
        Cliente cliente = new Cliente("Carlos Silva", "123.456.789-00", "31999999999");

        assertEquals("Carlos Silva", cliente.getNome());
        assertEquals("123.456.789-00", cliente.getCpf());
        assertEquals("31999999999", cliente.getTelefone());
    }

    @Test
    public void testAdicionarVeiculo() {
        Cliente cliente = new Cliente("Carlos Silva", "123.456.789-00", "31999999999");
        Veiculo veiculo1 = new Veiculo("ABC-1234", "Fiat", "Palio", 2015);
        
        cliente.adicionarVeiculo(veiculo1);

        assertEquals(veiculo1, cliente.getVeiculo()[0]);
    }
}
