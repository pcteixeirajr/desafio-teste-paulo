package com.paulojr.desafiojava.controller;

import com.paulojr.desafiojava.dto.MessageResponseDTO;
import com.paulojr.desafiojava.dto.PautaDTO;
import com.paulojr.desafiojava.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pauta")
public class PautaController {

    private PautaService pautaService;

    @Autowired
    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping
    public MessageResponseDTO cadastrarPauta(@RequestBody PautaDTO pautaDTO) {
        return pautaService.create(pautaDTO);
    }

}
