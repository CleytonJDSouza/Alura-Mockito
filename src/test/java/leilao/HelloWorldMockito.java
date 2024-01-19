package leilao;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.dao.LeilaoDao;

public class HelloWorldMockito {

    @Test
    void hello() {
        LeilaoDao mock = Mockito.mock(LeilaoDao.class);
        List<Leilao> todos = mock.buscarTodos();
        Assert.assertTrue(todos.isEmpty());
    }
}
