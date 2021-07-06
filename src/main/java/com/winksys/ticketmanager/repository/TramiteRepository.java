package com.winksys.ticketmanager.repository;

import com.winksys.ticketmanager.data.Tramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TramiteRepository extends JpaRepository<Tramite, Integer> {

    public static interface TramiteUsuario {

        String getUsuario();
        String getGrupo();
        int getQtd();

    }

    public static interface TramiteGrupo {

        String getGrupo();
        int getQtd();

    }

    @Query(value = "select * from (select usuario.nome as usuario,grupo.descricao as grupo,sum(tramites.tempo) as qtd \n" +
            "from tramites\n" +
            "inner join ticket on ticket.id=tramites.ticket\n" +
            "inner join usuario on usuario.id=tramites.usuario\n" +
            "inner join grupo on grupo.id=ticket.grupo\n" +
            "where tramites.data between :dtini and :dtfim\n" +
            "group by usuario.id) c order by c.qtd desc", nativeQuery = true)
    List<TramiteUsuario> listTramitesUsuario(@Param("dtini") Date dtini, @Param("dtfim") Date dtfim);

    @Query(value = "select * from (select grupo.descricao as grupo,sum(tramites.tempo) as qtd \n" +
            "from tramites\n" +
            "inner join ticket on ticket.id=tramites.ticket\n" +
            "inner join usuario on usuario.id=tramites.usuario\n" +
            "inner join grupo on grupo.id=ticket.grupo\n" +
            "where tramites.data between :dtini and :dtfim\n" +
            "group by grupo.id) c order by c.qtd desc", nativeQuery = true)
    List<TramiteGrupo> listTramitesGrupo(@Param("dtini") Date dtini, @Param("dtfim") Date dtfim);

    @Query(value = "select * from (select usuario.nome as usuario, grupo.descricao as grupo,sum(tramites.tempo) as qtd \n" +
            "from tramites\n" +
            "inner join ticket on ticket.id=tramites.ticket\n" +
            "inner join usuario on usuario.id=tramites.usuario\n" +
            "inner join grupo on grupo.id=ticket.grupo\n" +
            "where tramites.data between :dtini and :dtfim\n" +
            "group by grupo.id,usuario.id) c order by c.grupo,c.qtd desc", nativeQuery = true)
    List<TramiteUsuario> listTramitesGrupoUsuario(@Param("dtini") Date dtini, @Param("dtfim") Date dtfim);

}
