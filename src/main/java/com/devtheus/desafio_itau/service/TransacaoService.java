package com.devtheus.desafio_itau.service;

import com.devtheus.desafio_itau.controllers.dto.TransacaoRequestDto;
import com.devtheus.desafio_itau.service.exceptions.UnprocessableEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    private final List<TransacaoRequestDto> transacoes = new ArrayList<>();

    public void criarTransacao(TransacaoRequestDto dto) {
        if (dto.valor() < 0){
            throw new UnprocessableEntity("O valor da transação deve ser positivo.");
        }

        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            throw new UnprocessableEntity("A data da transação não pode ser futura.");
        }

        transacoes.add(dto);
    }

    public void limparLista() {
        transacoes.clear();
    }

    public List<TransacaoRequestDto> buscarTransacoes(Integer intervalo){
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervalo);

        return transacoes
                .stream()
                .filter(transacao -> transacao.dataHora()
                        .isAfter(dataHoraIntervalo))
                .toList();
    }
}
