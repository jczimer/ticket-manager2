package com.winksys.ticketmanager.repository;

import com.winksys.ticketmanager.data.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Usuario, Integer> {



}
