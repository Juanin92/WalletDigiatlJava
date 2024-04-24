package test.wallet;

import wallet.Usuario;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.*;

public class UsuarioTest {

    @DisplayName("Comprobación de ingreso de datos")
    @Test
    void testConstructor(){
        Usuario usuario = new Usuario("Juan", "Claveria", "jc@gmail.com", "12345678-9", 123456);

        assertEquals("Juan", usuario.getNombre());
        assertEquals("Claveria", usuario.getApellido());
        assertEquals("jc@gmail.com", usuario.getEmail());
        assertEquals("12345678-9", usuario.getRut());
        assertEquals(123456, usuario.getPass());

        usuario.setNombre("Dominique");
        usuario.setApellido("Cordero");
        usuario.setEmail("dc@gmail.com");
        usuario.setRut("98765432-1");
        usuario.setPass(654321);

        assertEquals("Dominique", usuario.getNombre());
        assertEquals("Cordero", usuario.getApellido());
        assertEquals("dc@gmail.com", usuario.getEmail());
        assertEquals("98765432-1", usuario.getRut());
        assertEquals(654321, usuario.getPass());
    }
}
