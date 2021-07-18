import java.util.List;

public class LeiloarDTO {
    private float valorInicial;
    private float valorMeta;
    private String descricao;
    private int categoria;
    private List<Integer> listaProdutos;

    public float getValorInicial() {
        return valorInicial;
    }
    public void setValorInicial(float valorInicial) {
        this.valorInicial = valorInicial;
    }
    public float getValorMeta() {
        return valorMeta;
    }
    public void setValorMeta(float valorMeta) {
        this.valorMeta = valorMeta;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getCategoria() {
        return categoria;
    }
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    public List<Integer> getListaProdutos() {
        return listaProdutos;
    }
    public void setListaProdutos(List<Integer> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}
