package org.efrei.start.repositories;

import org.efrei.start.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
