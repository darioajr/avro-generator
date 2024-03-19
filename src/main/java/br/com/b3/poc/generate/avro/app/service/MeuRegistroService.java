package br.com.b3.poc.generate.avro.app.service;

import br.com.b3.poc.generate.avro.app.model.avro.meuregistro.MeuRegistro;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class MeuRegistroService {

    private List<MeuRegistro> registros = new ArrayList<>();

    public void adicionar(MeuRegistro registro) {

        registros.add(registro);
    }

    public List<MeuRegistro> listar() {
        return registros;
    }

    public MeuRegistro buscarPorId(int id) {
        for (MeuRegistro registro : registros) {
            if (registro.getId() == id) {
                return registro;
            }
        }
        return null;
    }

    public void atualizar(MeuRegistro meuRegistroAtualizado) {
        for (int i = 0; i < registros.size(); i++) {
            MeuRegistro registro = registros.get(i);
            if (registro.getId() == meuRegistroAtualizado.getId()) {
                registros.set(i, meuRegistroAtualizado);
                return;
            }
        }
    }

    public void remover(int id) {
        registros.removeIf(registro -> registro.getId() == id);
    }
}
