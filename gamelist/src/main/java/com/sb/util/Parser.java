package com.sb.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.sb.model.Game;
import com.sb.repository.GameRepository;


/*Fighting, Shooter, Action, Puzzle, Adventure, Music, Platformer, RPG, Strategy, Sports*/
@Service
public class Parser {
	
	@Autowired
	GameRepository gameRepository;
	
	
	 Resource resource = new ClassPathResource("data.csv");
     
	 String line = "";
     String cvsSplitBy= ",";
     int c=0;
     
     
     public void csvReader() {
    	 
    	 
    	 try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));) {

         while ((line = br.readLine()) != null ) {
        	 c++;
        	 Game game=new Game();
        	 if(c==1) continue;
             // use comma as separator
             String[] st = line.split(cvsSplitBy);

            
             	
             	game.setTitle(st[0]);
             	game.setPlatform(st[2]);
             	game.setScore(st[3]);
             	game.setGenere(st[4]);
             	
             	game.setChoice(st[5]);
             	
             	gameRepository.save(game);
             	
         }

     } catch (IOException e) {
         e.printStackTrace();
     }	
    	 
     }

}
