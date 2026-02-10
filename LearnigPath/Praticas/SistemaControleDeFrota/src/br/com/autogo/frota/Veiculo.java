package br.com.autogo.frota;

import br.com.autogo.cadastro.Cliente;

public interface Veiculo {
    float abastecer(float litros);
    void serConsertado();
    void lavar();
    void serAlugado(Cliente locatario);
    void retornar();
}
