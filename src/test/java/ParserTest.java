
import calculadora2.CalculatorParser;
import org.junit.Assert;
import org.junit.Test;

public class ParserTest {

    private static final double DELTA = 0.01;
    private CalculatorParser parser = new CalculatorParser();

    @Test
    public void test01ParsearUnNumeroDevuelveEseNumero(){
        String test = "123456";
        Assert.assertEquals(123456, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test02SumarDosNumerosEvaluaCorrectamente(){
        String test = "62 + 8";
        Assert.assertEquals(70, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test03RestarDosNumerosEvaluaCorrectamente(){
        String test = "194 - 113";
        Assert.assertEquals(81, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test04MultiplicarDosNumerosEvaluaCorrectamente(){
        String test = "25 x 4";
        Assert.assertEquals(100, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test05DividirDosNumerosEvaluaCorrectamente(){
        String test = "64 / 16";
        Assert.assertEquals(4, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test06SumarUnNumeroYUnProductoEntreDosNumerosEvaluaCorrectamente(){
        String test = "30 x 3 + 10";
        String test2 = "10 + 30 x 3";

        Assert.assertEquals(100, parser.parsear(test).evaluar(), DELTA);
        Assert.assertEquals(100, parser.parsear(test2).evaluar(), DELTA);
    }

    @Test
    public void test07RestarUnNumeroYUnProductoEntreDosNumerosEvaluaCorrectamente(){
        String test = "200 - 25 x 4";
        String test2 = "25 x 8 - 100";

        Assert.assertEquals(100, parser.parsear(test).evaluar(), DELTA);
        Assert.assertEquals(100, parser.parsear(test2).evaluar(), DELTA);
    }

    @Test
    public void test08SumarUnNumeroYUnaDivisionEntreDosNumerosEvaluaCorrectamente(){
        String test = "200 + 300 / 15";
        String test2 = "300 / 15 + 200";

        Assert.assertEquals(220, parser.parsear(test).evaluar(), DELTA);
        Assert.assertEquals(220, parser.parsear(test2).evaluar(), DELTA);
    }

    @Test
    public void test09RestarUnNumeroYUnaDivisionEntreDosNumerosEvaluaCorrectamente(){
        String test = "1500 - 2000 / 20";
        String test2 = "3000 / 2 - 100";

        Assert.assertEquals(1400, parser.parsear(test).evaluar(), DELTA);
        Assert.assertEquals(1400, parser.parsear(test2).evaluar(), DELTA);
    }

    @Test
    public void test10DividirUnNumeroConUnProductoEntreDosNumerosEvaluaCorrectamente(){
        String test = "6 x 2 / 4";
        Assert.assertEquals(3, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test11MultiplicarUnNumeroConUnaDivisionEntreDosNumerosEvaluaCorrectamente(){
        String test = "16 / 2 x 4";
        Assert.assertEquals(32, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test12SumarUnProductoEntreDosNumerosConOtroProductoEntreDosNumerosEvaluaCorrectamente(){
        String test = "15 x 15 + 27 x 110";
        Assert.assertEquals(3195, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test13RestarUnProductoEntreDosNumerosConOtroProductoEntreDosNumerosEvaluaCorrectamente(){
        String test = "15 x 15 - 27 x 110";
        Assert.assertEquals(-2745, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test14UnProductoEntreMasDeDosNumerosEvaluaCorrectamente(){
        String test = "2 x 3 x 2 x 1 x 5";
        Assert.assertEquals(60, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test15UnaDivisionEntreMasDeDosNumerosEvaluaCorrectamente(){
        String test = "100 / 2 / 1 / 10"; // = 100 / 20
        Assert.assertEquals(5, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test16UnaSumaEntreMasDeDosNumerosEvaluaCorrectamente(){
        String test = "10 + 20 + 30 + 40 + 50 + 60";
        Assert.assertEquals(210, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test17UnaRestaEntreMasDeDosNumerosEvaluaCorrectamente(){
        String test = "210 - 10 - 20 - 30 - 40 - 50 - 60";
        Assert.assertEquals(0, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test18SumarYRestarVariosNumerosEvaluaCorrectamente(){
        String test = "10 + 60 - 20 - 40 + 90 - 100";
        Assert.assertEquals(0, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test19SumarUnNumeroConUnaDivisionEntreMasDeDosNumerosEvaluaCorrectamente(){
        String test = "50 + 100 / 2 / 1 / 10";
        Assert.assertEquals(55, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test20SumarUnNumeroConUnaDivisionEntreMasDeDosNumerosEvaluaCorrectamente(){
        String test = "50 - 100 / 2 / 1 / 10";
        Assert.assertEquals(45, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test21SumarUnNumeroConUnProductoEntreMasDeDosNumerosEvaluaCorrectamente(){
        String test = "50 + 2 x 3 x 2 x 1 x 5";
        Assert.assertEquals(110, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test22RestarUnNumeroConUnProductoEntreMasDeDosNumerosEvaluaCorrectamente(){
        String test = "50 - 2 x 3 x 2 x 1 x 5";
        Assert.assertEquals(-10, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test23SumarDosProductosCompuestosEvaluaCorrectamente(){
        String test = "2 x 25 + 2 x 3 x 2 x 1 x 5";
        Assert.assertEquals(110, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test24RestarDosProductosCompuestosEvaluaCorrectamente(){
        String test = "2 x 25 - 2 x 3 x 2 x 1 x 5";
        Assert.assertEquals(-10, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test25SumarYRestarVariosProductosEvaluaCorrectamente(){
        String test = "10 x 3 + 1 x 2 x 5 - 40 x 2 - 5 x 4 + 20 x 3 x 1 x 2";
        Assert.assertEquals(60, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test26SumarYRestarVariosCocientesEvaluaCorrectamente(){
        String test = "100 / 2 / 1 / 10 + 80 / 20 / 2 - 9 / 3 / 3 - 1200 / 600 + 36 / 6";
        Assert.assertEquals(10, parser.parsear(test).evaluar(), DELTA);
    }

    @Test
    public void test27PSumarYRestarVariasExpresionesEvaluaCorrectamente(){
        String test = "10 x 20 / 50 + 80 / 80 x 2 - 6 / 6 x 5 / 5 x 6 - 120 + 60 x 5";
        // = 4 + 2 - 6 - 120 + 300
        Assert.assertEquals(180, parser.parsear(test).evaluar(), DELTA);
    }
}
