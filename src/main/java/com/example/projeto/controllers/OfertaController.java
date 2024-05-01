package com.example.projeto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto.models.ImovelModel;
import com.example.projeto.models.OfertaModel;
import com.example.projeto.models.UserModel;
import com.example.projeto.service.ImovelService;
import com.example.projeto.service.OfertaService;
import com.example.projeto.service.UserService;
import com.example.projeto.dtos.OfertaComDescontoDTO;
import com.example.projeto.dtos.OfertaDTOResposta;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/ofertas")
public class OfertaController {

    @Autowired
    private OfertaService ofertaService;

    @Autowired
    private ImovelService imovelService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OfertaModel>> getAll() {
        List<OfertaModel> list = ofertaService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<OfertaDTOResposta> insert(@RequestBody OfertaModel model, @RequestParam Integer imovelId, @RequestParam Integer usuarioId) {

        ImovelModel imovel = imovelService.find(imovelId);

        model.setImovelModel(imovel);

        UserModel userModel = userService.find(usuarioId);

        model.setUserModel(userModel);

        ofertaService.insert(model);

        OfertaDTOResposta dto = new OfertaDTOResposta(model);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/com-desconto")
    public ResponseEntity<List<OfertaComDescontoDTO>> buscarOfertasComDesconto() {
        List<OfertaModel> ofertasComDesconto = ofertaService.buscarOfertasComDesconto();
        List<OfertaComDescontoDTO> dtos = ofertasComDesconto.stream()
            .map(OfertaComDescontoDTO::new)
            .collect(Collectors.toList());
        return dtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(dtos);
    }
}
