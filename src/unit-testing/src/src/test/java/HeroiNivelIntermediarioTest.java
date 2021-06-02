import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Heroi.class)
public class HeroiNivelIntermediarioTest {
    byte nivel_tres;
    byte nivel_cinco;

    @Before
    public void preparar() {
        nivel_tres = 3;
        nivel_cinco = 5;
    }

    @Test
    public void deve_habilitar_habilidade_secundaria_quando_aumentar_nivel() throws Exception {
        Heroi spyHero = PowerMockito.spy(new Heroi("Le Million"));
        PowerMockito
                .when(spyHero, "getNivel")
                .thenReturn(nivel_tres);

        spyHero.aumentarNivel();
        String resultado = spyHero.usarHabilidadeSecundaria();

        Assert.assertEquals("Você usou sua habilidade secundária", resultado);
        PowerMockito
                .verifyPrivate(spyHero, Mockito.times(1))
                .invoke("habilitarProximaHabilidade");
    }

    @Test
    public void deve_habilitar_habilidade_especial_quando_aumentar_nivel() throws Exception {
        Heroi spyHero = PowerMockito.spy(new Heroi("Midnight"));

        PowerMockito
                .when(spyHero, "getNivel")
                .thenReturn(nivel_cinco);
        PowerMockito.when(spyHero, "permiteSubirNivel")
                .thenReturn(true);

        spyHero.aumentarNivel();
        String resultado = spyHero.usarHabilidadeEspecial();

        Assert.assertEquals("Você usou sua habilidade especial", resultado);
        PowerMockito
                .verifyPrivate(spyHero, Mockito.times(1))
                .invoke("habilitarProximaHabilidade");
    }
}
