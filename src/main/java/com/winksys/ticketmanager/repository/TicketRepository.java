package com.winksys.ticketmanager.repository;

import com.winksys.ticketmanager.data.Cliente;
import com.winksys.ticketmanager.data.Grupo;
import com.winksys.ticketmanager.data.Ticket;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    public static interface TicketCliente {
        String getCliente();
        Long getQtd();
    }

    public static interface TicketGrupo {
        String getGrupo();
        String getCategoria();
        Long getQtd();
        Date getOldestDate();
    }

    public static interface TicketGrupoBacklog {
        String getGrupo();
        Integer getAvgAge();
        Long getQtd();
        Date getOldestDate();
    }

    @Query("select t from Ticket t where t.dataAbertura between :dtini and :dtfim and (:cliente is null or  t.cliente.id=:cliente) and (:grupo is null or t.grupo.id=:grupo) and t.excluido=false")
    Page<Ticket>list(@Param("dtini") Date dtIni, @Param("dtfim") Date dtFim, @Param("cliente") Integer cliente, @Param("grupo") Integer grupo, Pageable pageable) ;

    @Query(value = "select grupo.descricao as grupo, categoria.descricao as categoria,count(*) as qtd,min(ticket.data_abertura) as oldestDate from ticket inner join grupo on grupo.id=ticket.grupo left join categoria on categoria.id=ticket.categoria where data_abertura between :dtini and :dtfim and excluido=false group by grupo", nativeQuery = true)
    List<TicketGrupo> listTicketGrupo(@Param("dtini") Date dtIni, @Param("dtfim") Date dtFim);

    @Query(value = "select grupo.descricao as grupo, categoria.descricao as categoria,count(*) as qtd from ticket inner join grupo on grupo.id=ticket.grupo left join categoria on categoria.id=ticket.categoria where data_resolucao between :dtini and :dtfim and excluido=false group by grupo", nativeQuery = true)
    List<TicketGrupo> listTicketResolvidoGrupo(@Param("dtini") Date dtIni, @Param("dtfim") Date dtFim);

    @Query(value = "select * from (select cliente.nome as cliente,count(*) as qtd from ticket inner join cliente on cliente.id=ticket.cliente  where data_abertura between :dtini and :dtfim and excluido=false group by cliente) c order by c.qtd desc", nativeQuery = true)
    List<TicketCliente> listTicketCliente(@Param("dtini") Date dtIni, @Param("dtfim") Date dtFim);

    @Query(value = "select * from (select cliente.nome as cliente,count(*) as qtd from ticket inner join cliente on cliente.id=ticket.cliente where data_resolucao between :dtini and :dtfim and excluido=false group by cliente) c order by c.qtd desc", nativeQuery = true)
    List<TicketCliente> listTicketResolvidoCliente(@Param("dtini") Date dtIni, @Param("dtfim") Date dtFim);

    @Query(value = "select * from (select grupo.descricao as grupo,count(*) as qtd,min(data_abertura) as oldestDate,avg(datediff(now(), data_abertura)) as avgAge \n" +
            "from ticket \n" +
            "inner join grupo on grupo.id=ticket.grupo\n" +
            "where data_resolucao is null and data_exclusao is null\n" +
            "group by grupo) c order by c.qtd", nativeQuery = true)
    List<TicketGrupoBacklog> listBackLog();
}
