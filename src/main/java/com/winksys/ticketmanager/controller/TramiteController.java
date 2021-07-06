package com.winksys.ticketmanager.controller;

import com.winksys.ticketmanager.repository.TramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("tramite")
public class TramiteController {

    @Autowired
    private TramiteRepository repository;

    @CrossOrigin("*")
    @GetMapping("listTramiteUsuario")
    public List<TramiteRepository.TramiteUsuario> listTramiteUsuario(@RequestParam("dtini") String pDataIni, @RequestParam("dtfim") String pDataFim) {

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date dataIni, dataFim;

        try {
            dataIni = sdf.parse(pDataIni);
            dataFim = sdf.parse(pDataFim);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

        return repository.listTramitesUsuario(dataIni, dataFim);
    }

    @CrossOrigin("*")
    @GetMapping("listTramiteGrupo")
    public List<TramiteRepository.TramiteGrupo> listTramiteGrupo(@RequestParam("dtini") String pDataIni, @RequestParam("dtfim") String pDataFim) {

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date dataIni, dataFim;

        try {
            dataIni = sdf.parse(pDataIni);
            dataFim = sdf.parse(pDataFim);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

        return repository.listTramitesGrupo(dataIni, dataFim);
    }

    @CrossOrigin("*")
    @GetMapping("listTramiteGrupoUsuario")
    public List<TramiteRepository.TramiteUsuario> listTramiteGrupoUsuario(@RequestParam("dtini") String pDataIni, @RequestParam("dtfim") String pDataFim) {

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date dataIni, dataFim;

        try {
            dataIni = sdf.parse(pDataIni);
            dataFim = sdf.parse(pDataFim);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

        return repository.listTramitesGrupoUsuario(dataIni, dataFim);
    }

}
