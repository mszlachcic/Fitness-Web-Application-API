package org.mszlachcic.api.controllers;

import org.mszlachcic.api.dtos.PartyDto;
import org.mszlachcic.api.services.PartyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/parties")
public class PartyController {

    private final PartyService partyService;

    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @PostMapping("/createParty")
    public void createParty(@RequestBody PartyDto partyDto, @RequestParam String username){
        partyService.createParty(partyDto ,username);
    }

    @GetMapping("/getPartyById")
    public PartyDto getPartyById(@RequestParam Long id){
        return partyService.getPartyById(id);
    }

    @GetMapping("/getParties")
    public List<PartyDto> getParties(){
        return partyService.getParties();
    }

    @PutMapping("/addUserToParty")
    public void addUserToParty(@RequestParam Long id, @RequestParam String username){
        partyService.addUserToParty(id,username);
    }

    @DeleteMapping("/deleteUserFromGroup")
    public void removeUserFromGroup(@RequestParam Long id, @RequestParam String username){
        partyService.removeUserFromParty(id,username);
    }
}
