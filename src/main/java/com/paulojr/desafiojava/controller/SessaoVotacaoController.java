package com.paulojr.desafiojava.controller;

import com.paulojr.desafiojava.dto.ComandoAbrirSessaoVotacaoDTO;
import com.paulojr.desafiojava.dto.MessageResponseDTO;
import com.paulojr.desafiojava.dto.ResultadoSessaoVotacaoDTO;
import com.paulojr.desafiojava.service.SessaoVotacaoService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/sessoes")
public class SessaoVotacaoController {

    private final SessaoVotacaoService sessaoVotacaoService;
    private static final Logger logger = LoggerFactory.getLogger(SessaoVotacaoController.class);

    @Autowired
    public SessaoVotacaoController(SessaoVotacaoService sessaoVotacaoService) {
        this.sessaoVotacaoService = sessaoVotacaoService;
    }

    /**
     * Abre uma nova sessão de votação.
     * @param comandoAbrirSessaoVotacaoDTO Detalhes para abrir a sessão.
     * @return Mensagem de sucesso com detalhes da sessão aberta.
     */
    @PostMapping
    public ResponseEntity<MessageResponseDTO> abrirSessao(
            @Valid @RequestBody ComandoAbrirSessaoVotacaoDTO comandoAbrirSessaoVotacaoDTO) {
        try {
            logger.info("Abrindo nova sessão de votação.");
            MessageResponseDTO response = sessaoVotacaoService.create(comandoAbrirSessaoVotacaoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (NotFoundException e) {
            logger.error("Erro ao abrir sessão: pauta não encontrada.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponseDTO("Pauta não encontrada."));
        } catch (Exception e) {
            logger.error("Erro ao abrir sessão de votação.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponseDTO("Erro ao abrir a sessão de votação."));
        }
    }

    /**
     * Busca o resultado de uma sessão de votação.
     * @param id ID da sessão de votação.
     * @return Resultado da sessão de votação.
     */
    @GetMapping("/{id}/resultado")
    public ResponseEntity<ResultadoSessaoVotacaoDTO> buscarResultadoSessaoVotacao(@PathVariable Long id) {
        try {
            logger.info("Buscando resultado para a sessão de votação com ID: {}", id);
            ResultadoSessaoVotacaoDTO resultado = sessaoVotacaoService.buscarResultadoSessaoVotacao(id);
            return ResponseEntity.ok(resultado);
        } catch (NotFoundException e) {
            logger.error("Erro ao buscar resultado: sessão não encontrada.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            logger.error("Erro ao buscar resultado da sessão de votação.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
