package principal;

public class Compra {
    private Cliente cliente;
    private Imovel imovel;
    private double valorCompra;
    private double valorAluguel;

    public Compra(Cliente cliente, Imovel imovel, double valorCompra, double valorAluguel) {
        this.cliente = cliente;
        this.imovel = imovel;
        this.valorCompra = valorCompra;
        this.valorAluguel = valorAluguel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
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
}

