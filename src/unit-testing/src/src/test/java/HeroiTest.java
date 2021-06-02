import org.junit.Assert;
import org.junit.Test;

public class HeroiTest {

    @Test
    public void deve_permitir_aumentar_nivel() {
        Heroi deku = new Heroi("Deku");

        boolean podeSubirDeNivel = deku.permiteSubirNivel();

        Assert.assertTrue(podeSubirDeNivel);
    }

    @Test
    public void deve_usar_habilidade_primaria() {
        Heroi eraserhead = new Heroi("Erasehead");

        String resultado = eraserhead.usarHabilidadePrimaria();

        Assert.assertEquals("Você usou sua habilidade primária", resultado);
    }

    @Test
    public void nao_deve_possuir_habilidade_especial() throws Exception {
        Heroi allmight = new Heroi("All Might");

        Exception exception = Assert.assertThrows(Exception.class, () -> {
            allmight.usarHabilidadeEspecial();
        });

        Assert.assertEquals("Você ainda não aprendeu essa habilidade", exception.getMessage());
    }

    @Test
    public void nado_deve_possuir_habilidade_secundaria() throws Exception {
        Heroi endeavor = new Heroi("Endeavor");

        Exception exception = Assert.assertThrows(Exception.class, () -> {
            endeavor.usarHabilidadeSecundaria();
        });
        Assert.assertEquals("Você ainda não aprendeu essa habilidade", exception.getMessage());
    }

    @Test
    public void falta_4_niveis_para_liberar_especial() throws Exception {
        Heroi froppy = new Heroi("Froppy");

        byte resultado = froppy.quantoAteHabilidadeEspecial();

        Assert.assertEquals(4, resultado);
    }

    @Test
    public void deve_aumentar_um_nivel() {
        Heroi gangOrca = new Heroi("Gang Orca");

        gangOrca.aumentarNivel();
        byte nivel = gangOrca.getNivel();

        Assert.assertEquals(2, nivel);
    }
}
