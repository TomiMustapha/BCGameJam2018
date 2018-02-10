package com.bacc.gameworld;

import com.bacc.gameobjects.Enemy;
import com.bacc.gameobjects.Obstacle;
import com.bacc.gameobjects.Collectible;

import java.util.ArrayList;

/**
 * Created by Tomi on 2018-02-10.
 */


public class ObstacleManager {
    private float spriteVelocity;
    private ArrayList<Obstacle> enemies;
    private ArrayList<Obstacle> collectables;

    /**
     *
     * @param enemies
     * @param collectables
     * @param spriteVelocity
     */
    public ObstacleManager(int enemies, int collectables, float spriteVelocity){
        this.spriteVelocity = spriteVelocity;
        this.enemies = new ArrayList<Obstacle>();
        this.collectables = new ArrayList<Obstacle>();
        createEnemies(enemies);
        createCollectables(collectables);


    }

    /**
     *
     * @param enemies
     */
    private void createEnemies(int enemies) {
        for (int i = 0; i < enemies; i++) {
            this.enemies.add(i, new Enemy(320, 160 - 48, 16, 16, spriteVelocity));
        }
    }

    /**
     *
     * @param collectables
     */
    private void createCollectables(int collectables) {
        for (int i = 0; i < collectables; i++) {
            this.collectables.add(i, new Collectible(320, 160 - 48, 16, 16, spriteVelocity));
        }

    }

    public void update(float delta, float width, float level){
        for(Obstacle o : enemies){
            o.update(delta, width, level);
            //end game
        }
        for(Obstacle o : collectables){
            o.update(delta, width, level);
            //end game
        }


    }




    public ArrayList<Obstacle> getEnemies(){return this.enemies;}
}
