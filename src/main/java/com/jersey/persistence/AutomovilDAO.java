package com.jersey.persistence;

import com.jersey.representations.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Xavier Guti&#233;rrez
 *         06/04/17.
 */
public interface AutomovilDAO extends JpaRepository<Auto, Long> {
}
