package com.winksys.ticketmanager.controller;

import com.winksys.ticketmanager.data.Cliente;
import com.winksys.ticketmanager.data.Ticket;
import com.winksys.ticketmanager.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketRepository repository;

    @CrossOrigin("*")
    @GetMapping("/list")
    public Page<Ticket> listTickets(@RequestParam("dtini") String dtIni, @RequestParam("dtfim") String dtFim, @RequestParam(value = "cliente", required = false) Integer cliente, @RequestParam(value = "grupo", required = false) Integer grupo, Pageable pageable) {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date dataIni, dataFim;

        try {
            dataIni = sdf.parse(dtIni);
            dataFim = sdf.parse(dtFim);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

        return repository.list(dataIni, dataFim, cliente, grupo, pageable);

    }
    @CrossOrigin("*")
    @GetMapping("/listTicketGrupo")
    public List<TicketRepository.TicketGrupo> listTicketgrupo(@RequestParam("dtini") String dtIni, @RequestParam("dtfim") String dtFim) {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date dataIni, dataFim;

        try {
            dataIni = sdf.parse(dtIni);
            dataFim = sdf.parse(dtFim);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

        return repository.listTicketGrupo(dataIni, dataFim);

    }
    @CrossOrigin("*")
    @GetMapping("/listTicketResolvidoGrupo")
    public List<TicketRepository.TicketGrupo> listTicketResolvidoGrupo(@RequestParam("dtini") String dtIni, @RequestParam("dtfim") String dtFim) {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date dataIni, dataFim;

        try {
            dataIni = sdf.parse(dtIni);
            dataFim = sdf.parse(dtFim);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

        return repository.listTicketResolvidoGrupo(dataIni, dataFim);

    }

    @CrossOrigin("*")
    @GetMapping("/listTicketCliente")
    public List<TicketRepository.TicketCliente> listTicketCliente(@RequestParam("dtini") String dtIni, @RequestParam("dtfim") String dtFim) {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date dataIni, dataFim;

        try {
            dataIni = sdf.parse(dtIni);
            dataFim = sdf.parse(dtFim);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

        return repository.listTicketCliente(dataIni, dataFim);

    }
    @CrossOrigin("*")
    @GetMapping("/listTicketResolvidoCliente")
    public List<TicketRepository.TicketCliente> listTicketResolvidoCliente(@RequestParam("dtini") String dtIni, @RequestParam("dtfim") String dtFim, Pageable pageable) {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date dataIni, dataFim;

        try {
            dataIni = sdf.parse(dtIni);
            dataFim = sdf.parse(dtFim);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

        return repository.listTicketResolvidoCliente(dataIni, dataFim);

    }

    @CrossOrigin("*")
    @GetMapping("/getBacklog")
    public List<TicketRepository.TicketGrupoBacklog> getBacklog() {
        return repository.listBackLog();
    }



}
