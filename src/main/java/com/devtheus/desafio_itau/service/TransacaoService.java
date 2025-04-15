package com.devtheus.desafio_itau.service;

import com.devtheus.desafio_itau.controllers.dto.TransacaoRequestDto;
import com.devtheus.desafio_itau.service.exceptions.UnprocessableEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TransacaoService {

    private final List<TransacaoRequestDto> transacoes = new ArrayList<>();

    public void criarTransacao(TransacaoRequestDto dto) {
        log.info("Iniciando criação de nova transação com valor {} e timestamp de {}.", dto.valor(), dto.dataHora());

        if (dto.valor() < 0){
            log.error("Valor negativo recebido: {}. O valor da transação deve ser positivo.", dto.valor());
            throw new UnprocessableEntity("O valor da transação deve ser positivo.");
        }

        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            log.error("Erro de validação em um dos campos - O timestamp da transação não pode ser futuro ao atual.");
            throw new UnprocessableEntity("A data da transação não pode ser futura.");
        }

        transacoes.add(dto);
        log.info("Transação cadastrada corretamente. Total de transações {}.", transacoes.size());
    }

    public void limparLista() {
        log.info("Iniciando exclusão de todas as transações da lista.");
        transacoes.clear();
        log.info("Lista de transações excluida com sucesso.");
    }

    public List<TransacaoRequestDto> buscarTransacoes(Integer intervalo){
        log.info("Iniciando a busca por transações entre o intervalo de {} segundos.", intervalo);
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervalo);

        List<TransacaoRequestDto> resultado =  transacoes.stream().filter(transacao -> transacao.dataHora().isAfter(dataHoraIntervalo)).toList();
        log.debug("Transações encontradas no intervalo: {}", resultado.size());

        return resultado;
    }
}
