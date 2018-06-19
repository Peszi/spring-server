package com.shutter.springserver.service.user;

import com.shutter.springserver.exception.NotFoundException;
import com.shutter.springserver.exception.ServerFailureException;
import com.shutter.springserver.model.Team;
import com.shutter.springserver.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void save(Team team) {
        this.teamRepository.save(team);
    }

    @Override
    public void delete(Team team) {
        this.teamRepository.delete(team);
    }

    @Override
    public void validateHasRoom(Team team) {
        if (!team.hasRoom())
            throw new ServerFailureException("Team not in any room!");
    }

    @Override
    public Team validateAndGetTeamById(long id) {
        final Optional<Team> team = this.teamRepository.findById(id);
        if (!team.isPresent() || !team.get().hasRoom())
            throw new NotFoundException("Team");
        return team.get();
    }
}
