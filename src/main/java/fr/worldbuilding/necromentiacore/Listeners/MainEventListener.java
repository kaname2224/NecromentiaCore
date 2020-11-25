package fr.worldbuilding.necromentiacore.Listeners;

import fr.worldbuilding.necromentiacore.NecromentiaCore;
import org.bukkit.*;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class MainEventListener implements Listener {

    public MainEventListener(NecromentiaCore necromentiaCore) {

    }

    @EventHandler
    public void onConnect(PlayerJoinEvent event) {

        event.getPlayer().sendMessage("Bonjour " + event.getPlayer().getName());

    }

    @EventHandler
    public void onRightClickEvent(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if(event.getMaterial() == Material.CARROT_ON_A_STICK){

            ItemMeta meta = event.getItem().getItemMeta();

            if (meta.getDisplayName().equalsIgnoreCase("§cBaton de la mort")) {

                Location loc = player.getLocation();


                for(int i = 0; i < 20; i++) {
                    Fireball fire = player.getLocation().getWorld().spawn(loc, Fireball.class);
                    fire.setGlowing(true);
                    fire.setYield(25f);
                    fire.setBounce(true);
                    fire.setIsIncendiary(false);
                    fire.setShooter(player);
                    fire.setCustomName("§cLa Vie c'est une Pute");
                    fire.setCustomName("§cLa Vie c'est une Pute");
                    loc.add(-1, -1, -1);
                }
            }

        }

        if (event.getMaterial() == Material.DIRT) {

            Location loc = event.getPlayer().getLocation();

            loc.getWorld().createExplosion(loc, 150f, false, false);
        }

    }

    @EventHandler
    public void onMoveOnPlayer(PlayerMoveEvent event) {
        Location playerLocation = event.getPlayer().getLocation();
        Particle.DustOptions blue = new Particle.DustOptions(Color.NAVY,1);
        playerLocation.getWorld().spawnParticle(Particle.REDSTONE,playerLocation,99,blue);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        int slot = event.getSlot();
        boolean isSameArmor = true;

        if (slot >= 100 && event.getInventory().getType() == InventoryType.PLAYER){
            PlayerInventory playerInventory = event.getWhoClicked().getInventory();
            StringList verif = playerInventory.getHelmet().getLore();



            // todo : Faire un truc pour récupérer un moyen d'authentification
            if (){

            }
            String set = "voleur";

            for (ItemStack armor : playerInventory.getArmorContents()) {
                if (!(armor.getItemMeta().getDisplayName().contains(set))) {
                    isSameArmor = false;
                }
            }

            if (isSameArmor) {
                switch (set) {
                    case "voleur":

                        break;
                    case "autre":

                        break;
                }
            }

        }
    }

}
