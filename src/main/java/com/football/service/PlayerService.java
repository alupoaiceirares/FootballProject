package com.football.service;

import com.football.domain.Player;
import com.football.domain.Team;
import com.football.domain.User;
import com.football.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public void createPlayer(Player player){

        playerRepository.save(player);

    }

    public List<Player> findByLastName(String lastname) {
         return playerRepository.findByLastnameLike(lastname);
    }

    public List<Player> findByFirstName(String firstname) {
        return playerRepository.findByFirstnameLike(firstname);
    }


    public List<Player> findByBothNamesExactly(String firstname, String lastname){
        List<Player> FList = new ArrayList<>();
        List<Player> listfirst = playerRepository.findByFirstnameLike(firstname);
        List<Player> listlast = playerRepository.findByLastnameLike(lastname);

        if(listfirst.size() <= listlast.size()){
            int i=0;
            int j=0;
            int k=0;
            while(i<listfirst.size()){
                boolean ok = true;
                if(listfirst.get(i).getId() == listlast.get(i).getId()) {
                    for(k=0;k<FList.size();k++){
                        if(FList.get(k).getId()==listfirst.get(i).getId()){
                            ok = false;
                        }
                    }
                    if(ok==true){
                        FList.add(listfirst.get(i));
                    }

                }
                ok=true;
                for(j=listfirst.size(); j<listlast.size(); j++){
                    if(listfirst.get(i).getId() == listlast.get(j).getId()){
                        for(k=0;k<FList.size();k++){
                            if(FList.get(k).getId()==listlast.get(j).getId()){
                                ok = false;
                            }
                        }
                        if(ok==true){
                            FList.add(listlast.get(j));
                        }
                    }
                }
                i=i+1;
            }

        }else{
            int i=0;
            int j=0;
            int k=0;
            while(j<listlast.size()){
                boolean ok2 = true;
                if(listlast.get(j).getId() == listlast.get(j).getId()) {
                    for(k=0;k<FList.size();k++){
                        if(FList.get(k).getId()==listlast.get(j).getId()){
                            ok2 = false;
                        }
                    }
                    if(ok2==true){
                        FList.add(listlast.get(j));
                    }

                }
                ok2=true;
                for(i=listlast.size(); i<listfirst.size(); j++){
                    if(listlast.get(j).getId() == listfirst.get(i).getId()){
                        for(k=0;k<FList.size();k++){
                            if(FList.get(k).getId()==listfirst.get(i).getId()){
                                ok2 = false;
                            }
                        }
                        if(ok2==true){
                            FList.add(listfirst.get(i));
                        }
                    }
                }
                j=j+1;
            }
        }

        return FList;
    }

    public List<Player> findByBothNames(String name){

        List<Player> finalList = new ArrayList<>();
        List<Player> listfirstname = playerRepository.findByFirstnameLike(name);
        List<Player> listlastname = playerRepository.findByLastnameLike(name);


        finalList.addAll(listfirstname);
        finalList.addAll(listlastname);

        int i = 0;
        int j = 0;

        while(i<finalList.size()){
            boolean ok = true;
            j=i+1;
            while(j<finalList.size()){
                if(finalList.get(i).getId() == finalList.get(j).getId()){
                    finalList.remove(j);
                    ok = false;
                }else{
                    j=j+1;
                }
            }
            if(ok==true){
                i=i+1;
            }
        }

        return finalList;

    }

    public void updatePlayerTeam(Player player, Team team){

        player.setTeam(team);
        playerRepository.save(player);
    }

    public void deletePlayer(Player player){
        playerRepository.delete(player);
    }


}
