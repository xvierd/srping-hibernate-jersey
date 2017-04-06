package com.jersey.persistence;

import com.jersey.representations.Auto;
import com.jersey.representations.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Xavier Guti&#233;rrez
 *         06/04/17.
 */
public interface TipoDAO extends JpaRepository<Tipo, Long> {
}
