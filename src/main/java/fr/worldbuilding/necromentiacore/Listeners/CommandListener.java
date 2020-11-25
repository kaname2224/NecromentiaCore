package fr.worldbuilding.necromentiacore.Listeners;

import fr.worldbuilding.necromentiacore.NecromentiaCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CommandListener implements CommandExecutor {

    public CommandListener(NecromentiaCore necromentiaCore) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // ! Commandes Player uniquement

        if (!(sender instanceof Player)) {
            sender.sendMessage("Ta pa le droa");
            return false;
        }

        Player player = (Player)sender; // ? On récupère le joueur en faisant un cast (On transmet les methodes)

        // ? On récupère les arguments de la commandes

        if (args.length < 1) {
            player.sendMessage("Pas assez d'args");
            return false;
        }

        Bukkit.getLogger().info("BLABLA : " + args[0]);

        if (args[0].equalsIgnoreCase("give") && args.length >= 2) {

            String MatName = args[1];
            Bukkit.getLogger().info("BLABLA");

            if (MatName.equalsIgnoreCase("BT")) {

                Bukkit.getLogger().info("BLABLA2");


                ItemStack Baton = new ItemStack(Material.CARROT_ON_A_STICK, 1);

                ItemMeta BatonMeta = Baton.getItemMeta();
                BatonMeta.setDisplayName(ChatColor.RED + "Baton de la mort");
                List<String> LoreBaton = new ArrayList<>();
                LoreBaton.add(ChatColor.GOLD + "Le baton d'un puissant nécromancien");
                LoreBaton.add("§r§§§§");
                LoreBaton.add(ChatColor.AQUA + "Envoie des boules de feu");
                BatonMeta.setLore(LoreBaton);
                BatonMeta.setCustomModelData(2695);

                Baton.setItemMeta(BatonMeta);

                player.getInventory().addItem(Baton);

                Bukkit.getLogger().info("BLABLA3");

            }

            if (MatName.equalsIgnoreCase("armVol")){
                ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
                ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
                ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);

                ItemMeta bootsMeta = boots.getItemMeta();
                ItemMeta leggingsMeta = leggings.getItemMeta();
                ItemMeta chestplateMeta = chestplate.getItemMeta();
                ItemMeta helmetMeta = helmet.getItemMeta();

                bootsMeta.setDisplayName(ChatColor.RED + "Bottes de voleur");
                leggingsMeta.setDisplayName(ChatColor.RED + "Jambières de voleur");
                chestplateMeta.setDisplayName(ChatColor.RED + "Plastron de voleur");
                helmetMeta.setDisplayName(ChatColor.RED + "Chapeau de voleur");

                List<String> LoreVoleur = new ArrayList<>();
                LoreVoleur.add(ChatColor.GOLD + "Set Voleur");

                bootsMeta.setLore(LoreVoleur);
                leggingsMeta.setLore(LoreVoleur);
                chestplateMeta.setLore(LoreVoleur);
                helmetMeta.setLore(LoreVoleur);

                bootsMeta.setCustomModelData(2695);
                leggingsMeta.setCustomModelData(2695);
                chestplateMeta.setCustomModelData(2695);
                helmetMeta.setCustomModelData(2695);




            }



        }


        return false;
    }
}
