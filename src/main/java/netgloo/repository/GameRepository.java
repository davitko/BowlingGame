package netgloo.repository;

import netgloo.models.City;
import netgloo.models.Game;
import netgloo.models.Player;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public interface GameRepository extends PagingAndSortingRepository<Game, Long> {

    Game findByDateOfGame(String dateOfGame);

}
