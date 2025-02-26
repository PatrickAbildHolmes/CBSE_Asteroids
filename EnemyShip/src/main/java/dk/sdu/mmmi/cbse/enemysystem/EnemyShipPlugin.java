package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.enemyships.EnemyShip;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.Random;

public class EnemyShipPlugin implements IGamePluginService {
    @Override
    public void start(GameData gameData, World world) {
        Entity enemyShip = createEnemyShip(gameData);
        world.addEntity(enemyShip);
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        for (Entity enemyShip : world.getEntities(EnemyShip.class)) {
            world.removeEntity(enemyShip);
        }
    }

    private Entity createEnemyShip(GameData gameData) {
        Entity enemyShip = new EnemyShip();
        Random rnd = new Random();
        int size = rnd.nextInt(10) + 5; // new size.
        enemyShip.setPolygonCoordinates(size, -size, -size, -size, -size, size, size, size);
        enemyShip.setX(0);
        enemyShip.setY(0);
        enemyShip.setRadius(size);
        enemyShip.setRotation(rnd.nextInt(90));
        return enemyShip;
    }
}
