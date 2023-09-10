package org.mszlachcic.api.party;

import org.modelmapper.ModelMapper;
import org.mszlachcic.api.address.Address;
import org.mszlachcic.api.route.Route;
import org.mszlachcic.api.user.User;
import org.mszlachcic.api.address.AddressRepository;
import org.mszlachcic.api.route.RouteRepository;
import org.mszlachcic.api.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartyService {
    private final PartyRepository partyRepository;
    private final RouteRepository routeRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public PartyService(PartyRepository partyRepository, RouteRepository routeRepository, AddressRepository addressRepository, UserRepository userRepository) {
        this.partyRepository = partyRepository;
        this.routeRepository = routeRepository;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public void removeUserFromParty(Long id,String username){
        Party party = partyRepository.findPartyById(id);
        List<User> users = party.getUsers();
        User user = userRepository.getUserByUsername(username);

        users.remove(user);
        party.setUsers(users);

        partyRepository.save(party);
    }
    public void addUserToParty(Long id,String username){
        Party party = partyRepository.findPartyById(id);
        List<User> users = party.getUsers();
        User user = userRepository.getUserByUsername(username);

        users.add(user);
        party.setUsers(users);

        partyRepository.save(party);
    }

    public void createParty(PartyDto partyDto, String username){
        Party party = modelMapper.map(partyDto,Party.class);
        Route route = routeRepository.findByName(partyDto.getRoute().getName());
        Address address = addressRepository.getAddressById(route.getAddress().getId());
        User user = userRepository.getUserByUsername(username);
        List<User> users = new ArrayList<>();

        users.add(user);
        route.setAddress(address);
        party.setRoute(route);
        party.setUsers(users);

        addressRepository.save(address);
        routeRepository.save(route);
        partyRepository.save(party);
    }

    public PartyDto getPartyById(Long id){
        return modelMapper.map(partyRepository.findPartyById(id),PartyDto.class);
    }

    public List<PartyDto> getParties(){
        return partyRepository
                .findAll()
                .stream()
                .map(p -> modelMapper.map(p,PartyDto.class))
                .collect(Collectors.toList());
    }
}
