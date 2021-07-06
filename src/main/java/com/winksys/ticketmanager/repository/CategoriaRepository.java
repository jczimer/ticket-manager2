package com.winksys.ticketmanager.repository;

import com.winksys.ticketmanager.data.Categoria;
import com.winksys.ticketmanager.data.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {



}
