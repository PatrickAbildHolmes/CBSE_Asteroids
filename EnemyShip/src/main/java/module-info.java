import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module EnemyShip {
    requires Common;
    requires CommonEnemyShips;
    provides IGamePluginService with dk.sdu.mmmi.cbse.enemysystem.EnemyShipPlugin;
}