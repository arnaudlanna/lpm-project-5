import java.util.ArrayList;
import java.util.Arrays;

public class Caminhao extends Veiculo {

    private static final ArrayList<Combustivel> LISTACOMBUSTIVEL = new ArrayList<Combustivel>(
            Arrays.asList(Combustivel.DIESEL));
    private static final float CAPACIDADE = 250;
    private static final float PCT_SEGURO = 0.02f;
    private static final float PCT_IPVA = 0.01f;

    private static final float ADICIONAL_SEGURO = 2000;
    private static final float MANUTENCAO = 1000;
    private static final float VISTORIA = 1000;

    public Caminhao(String placa, float valordevenda, Combustivel combustivel) throws ExcecaoCombustivelInvalido {
        super(placa, valordevenda, PCT_SEGURO, PCT_IPVA, CAPACIDADE, "caminhao", combustivel, LISTACOMBUSTIVEL);
    }

    public float calcularSeguro() {
        float seguro = super.calcularSeguro();
        seguro += ADICIONAL_SEGURO;
        return seguro;
    }

    @Override
    public float calcularCustos() {
        float totalkm = super.calcularTotalKm();
        float kmdividido1 = totalkm % 20000;
        float kmdividido2 = totalkm % 30000;
        float total = 0;
        if (totalkm / 10000 >= 1) {
            total += (totalkm - kmdividido1) / 20000 * MANUTENCAO;
            total += (totalkm - kmdividido2) / 30000 * VISTORIA;
            return total;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Caminhão\n" +
                " - Capacidade: " + CAPACIDADE + "\n" +
                " - % Seguro: " + PCT_SEGURO + "\n" +
                " - % IPVA: " + PCT_IPVA + "\n" +
                " - Adicional Seguro: "  + ADICIONAL_SEGURO + "\n" +
                " - Manutenção: " + MANUTENCAO + "\n" +
                " - Vistoria: " + VISTORIA;

    }
}
