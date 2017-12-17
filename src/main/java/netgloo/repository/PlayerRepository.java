package netgloo.repository;

import netgloo.models.Game;
import netgloo.models.Player;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PlayerRepository extends PagingAndSortingRepository<Player, Long> {

    List<Player> findByOrdinalNumber(Integer ordinalNumber);
    Player findByDateOfPlaying(String dateOfPlaying);
}
