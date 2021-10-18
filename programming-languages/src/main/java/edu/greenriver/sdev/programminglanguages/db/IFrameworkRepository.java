package edu.greenriver.sdev.programminglanguages.db;

import edu.greenriver.sdev.programminglanguages.model.Framework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFrameworkRepository extends JpaRepository<Framework, Integer>
{
    Framework findByRankingIs(int rank);
}
