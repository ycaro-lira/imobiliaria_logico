package principal;

public class Imovel {
    private int id;
    private String endereco;
    private String numero;
    private double valorCompra;
    private double valorAluguel;
    private static int proximoId = 1;

    public Imovel(String endereco, String numero, double valorCompra, double valorAluguel) {
        this.id = proximoId++;
        this.endereco = endereco;
        this.numero = numero;
        this.valorCompra = valorCompra;
        this.valorAluguel = valorAluguel;
    }

    public int getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public static int getProximoId() {
        return proximoId;
    }
}

