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
public class HeroiNivelMaximoTest {
    private byte nivelMaximo;

    @Before
    public void preparar() {
        nivelMaximo = 5;
    }

    @Test
    public void deve_usar_habilidade_especial() throws Exception {
        Heroi redRiot = new Heroi("Red Riot");

        Heroi spyHero = PowerMockito.spy(redRiot);
        PowerMockito
                .when(spyHero, "getNivel")
                .thenReturn(nivelMaximo);

        String resultado = spyHero.usarHabilidadeEspecial();

        Assert.assertEquals("Você usou sua habilidade especial", resultado);
        PowerMockito
                .verifyPrivate(spyHero, Mockito.times(1))
                .invoke("getNivel");
    }

    @Test
    public void nao_deve_permitir_aumentar_nivel() throws Exception{
        Heroi fumikage = new Heroi("Fumikage Tokoyami");

        Heroi spyHero = PowerMockito.spy(fumikage);
        PowerMockito
                .when(spyHero, "getNivel")
                .thenReturn(nivelMaximo);

        boolean nivelAtual = spyHero.permiteSubirNivel();

        Assert.assertFalse(nivelAtual);
        PowerMockito
                .verifyPrivate(spyHero, Mockito.times(1))
                .invoke("getNivel");
    }
}
