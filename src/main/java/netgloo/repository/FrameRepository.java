package netgloo.repository;

import netgloo.models.Frame;
import netgloo.models.Player;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface FrameRepository extends PagingAndSortingRepository<Frame, Long> {

}
