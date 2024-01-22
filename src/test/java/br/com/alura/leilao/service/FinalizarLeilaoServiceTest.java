package br.com.alura.leilao.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito.*;

import br.com.alura.leilao.dao.LeilaoDao;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Usuario;

class FinalizarLeilaoServiceTest {

    private FinalizarLeilaoService service;

    @Mock
    private LeilaoDao leilaoDao;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        this.service = new FinalizarLeilaoService(leilaoDao);
    }

    @Test
    void deveriaFinalizarUmLeilao() {
        List<Leilao> leiloes = leiloes();

        service.finalizarLeiloesExpirados();
        
        //Minha Lógica
        /*List<Leilao> leiloesExpirados = leiloes();
        when(leilaoDao.buscarLeiloesExpirados()).thenReturn(leiloesExpirados);

        service.finalizarLeiloesExpirados();

        for (Leilao leilao : leiloesExpirados) {
            verify(leilao).setLanceVencedor(any());
            verify(leilao).fechar();
            verify(leilaoDao).salvar(leilao);
        }*/
    }

    private List<Leilao> leiloes() {
        List<Leilao> lista = new ArrayList<>();

        Leilao leilao = new Leilao("Celular", new BigDecimal("500"), new Usuario("Fulano"));

        Lance primeiro = new Lance(new Usuario("Beltrano"), new BigDecimal("600"));
        Lance segundo = new Lance(new Usuario("Ciclano"), new BigDecimal("900"));

        leilao.propoe(primeiro);
        leilao.propoe(segundo);

        lista.add(leilao);

        return lista;
    }
}