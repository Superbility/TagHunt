package me.superbility.taghunt.listeners;

import org.bukkit.event.Listener;

public class PortalTravelListener implements Listener {
/*
    @EventHandler
    public void onPortal(PlayerPortalEvent e) {
        Player player = e.getPlayer();

        Game game = GameUtils.getPlayerGame(player);

        if (game != null) {
            if (e.getCause() == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL) {
                e.setCanCreatePortal(true);
                Location location;
                if (player.getWorld() == game.getWorld()) {
                    location = new Location(game.getNether(), e.getFrom().getBlockX() / 8, e.getFrom().getBlockY(), e.getFrom().getBlockZ() / 8);
                } else {
                    location = new Location(game.getWorld(), e.getFrom().getBlockX() * 8, e.getFrom().getBlockY(), e.getFrom().getBlockZ() * 8);
                }
                e.setTo(e.getPortalTravelAgent().findOrCreate(location));
            }

            if (e.getCause() == PlayerTeleporte.TeleportCause.END_PORTAL) {
                if (player.getWorld() == getWorld()) {
                    Location loc = new Location(getEnd(), 100, 50, 0); // This is the vanilla location for obsidian platform.
                    e.setTo(loc);
                    Block block = loc.getBlock();
                    for (int x = block.getX() - 2; x <= block.getX() + 2; x++) {
                        for (int z = block.getZ() - 2; z <= block.getZ() + 2; z++) {
                            Block platformBlock = loc.getWorld().getBlockAt(x, block.getY() - 1, z);
                            if (platformBlock.getType() != Material.OBSIDIAN) {
                                platformBlock.setType(Material.OBSIDIAN);
                            }
                            for (int yMod = 1; yMod <= 3; yMod++) {
                                Block b = platformBlock.getRelative(BlockFace.UP, yMod);
                                if (b.getType() != Material.AIR) {
                                    b.setType(Material.AIR);
                                }
                            }
                        }
                    }
                } else if (player.getWorld() == getEnd()) {
                    e.setTo(getWorld().getSpawnLocation());
                }
            }
        }
    }

 */
}
