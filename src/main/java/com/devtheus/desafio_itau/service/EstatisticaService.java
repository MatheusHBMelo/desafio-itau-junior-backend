package com.devtheus.desafio_itau.service;

import com.devtheus.desafio_itau.controllers.dto.EstatisticaResponseDto;
import com.devtheus.desafio_itau.controllers.dto.TransacaoRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticaService {
    private final TransacaoService transacaoService;

    public EstatisticaResponseDto gerarEstatisticas(Integer intervalo) {
        long startTime = System.currentTimeMillis();
        log.info("Iniciando geração de estatisticas para intervalo {}", intervalo);
        List<TransacaoRequestDto> transacoes = this.transacaoService.buscarTransacoes(intervalo);
        log.debug("Número de transações encontrada {}", transacoes.size());

        if (transacoes.isEmpty()) {
            log.warn("Nenhuma transação encontrada para o intervalo {}, quadro de estatisticas vazio", intervalo);
            return new EstatisticaResponseDto(0L, 0.0, 0.0, 0.0, 0.0);
        }

        DoubleSummaryStatistics estatisticas = transacoes.stream().mapToDouble(TransacaoRequestDto::valor).summaryStatistics();
        log.info("Estatisticas geradas - count {}, sum {}, avg {}, min {}, max {}",
                estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                estatisticas.getMin(),
                estatisticas.getMax());

        log.info("Operação concluída em {} ms", (System.currentTimeMillis() - startTime));
        return new EstatisticaResponseDto(estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                estatisticas.getMin(),
                estatisticas.getMax());
    }
}
