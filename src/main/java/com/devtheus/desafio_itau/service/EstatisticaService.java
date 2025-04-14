package com.devtheus.desafio_itau.service;

import com.devtheus.desafio_itau.controllers.dto.EstatisticaResponseDto;
import com.devtheus.desafio_itau.controllers.dto.TransacaoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstatisticaService {
    private final TransacaoService transacaoService;

    public EstatisticaResponseDto gerarEstatisticas(Integer intervalo) {
        List<TransacaoRequestDto> transacoes = this.transacaoService.buscarTransacoes(intervalo);

        if (transacoes.isEmpty()) {
            return new EstatisticaResponseDto(0L, 0.0, 0.0, 0.0, 0.0);
        }

        DoubleSummaryStatistics estatisticas = transacoes.stream().mapToDouble(TransacaoRequestDto::valor).summaryStatistics();

        return new EstatisticaResponseDto(estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                estatisticas.getMin(),
                estatisticas.getMax());
    }
}
