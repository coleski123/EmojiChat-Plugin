package org.coleski123.emojichat;

import net.md_5.bungee.api.chat.*;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class EmojiChat extends JavaPlugin implements Listener, CommandExecutor {
    private Map<String, String> emojiMap;
    private int emojisPerPage = 10; // Number of emojis to display per page

    @Override
    public void onEnable() {
        //Enable Bstats
        int pluginId = 19880; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);

        // Let the console know plugin has been enabled
        String PluginPrefix = ChatColor.WHITE + "[" + ChatColor.GREEN + "EmojiChat" + ChatColor.WHITE + "]";
        sendMessage(PluginPrefix + " &2EmojiChat has been enabled!");

        // Check if the config file exists
        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            // Create the config.yml file with default values
            reloadConfig();
            createDefaultConfig(configFile);
        }

        // Load the configuration from the config.yml file
        reloadConfig();

        // Retrieve the emoji mappings from the configuration
        ConfigurationSection emojisSection = getConfig().getConfigurationSection("Emojis");
        if (emojisSection != null) {
            emojiMap = new HashMap<>();
            for (String key : emojisSection.getKeys(false)) {
                String tag = emojisSection.getString(key);
                emojiMap.put(key, tag);
            }
        } else {
            // If the emojis section is missing in the config, use the default mappings
            emojiMap = createDefaultEmojiMap();
        }

        new UpdateChecker(this, 111314).getVersion(version -> {
            if (this.getDescription().getVersion().equals(version)) {
                //String PluginPrefix = ChatColor.WHITE + "[" + ChatColor.GREEN + "EmojiChat" + ChatColor.WHITE + "]";
                sendMessage(PluginPrefix + " &2No new versions available.");
            } else {
                //String PluginPrefix = ChatColor.WHITE + "[" + ChatColor.GREEN + "EmojiChat" + ChatColor.WHITE + "]";
                sendMessage(PluginPrefix + " &cA new version is now available! Download: https://www.spigotmc.org/resources/emojichat.111314/");
            }
        });

        getServer().getPluginManager().registerEvents(this, this);
        getCommand("emojilist").setExecutor(this);
    }

    // This helper method sends a colored message to the server console.
    private void sendMessage(String message) {
        getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    // This method creates a default configuration file (config.yml) if it doesn't already exist.
    // The configuration file is used to store emojis for the plugin.
    private void createDefaultConfig(File configFile) {
        if (!configFile.exists()) {
            YamlConfiguration config = new YamlConfiguration();

            ConfigurationSection prefixSection = config.createSection("Prefix");
            prefixSection.set("Prefix", "&6[&2EmojiChat&6] ");

            ConfigurationSection messageSection = config.createSection("Messages");
            messageSection.set("NoPermMessage", "&cYou do not have permission to use this command!");
            messageSection.set("HoverMessage", "&6Click to copy!");
            messageSection.set("AvailableEmojisMessage", "&2Available Emojis - Page ");
            messageSection.set("PreviousPageMessage", "&c◀ Previous ");
            messageSection.set("NextPageMessage", " &2Next ▶");
            messageSection.set("PageOfMessage", "&f[Page {PAGENUMBER} of {TOTALPAGENUMBER}]");
            messageSection.set("CommandSenderFailMessage", "&cThis command can only be used by players.");
            messageSection.set("ConfigSavedMessage", "&9Config has been saved!");

            ConfigurationSection emojisSection = config.createSection("Emojis");
            emojisSection.set(":wave", "👋");
            emojisSection.set(":raised_hand", "🤚");
            emojisSection.set(":raised_fist", "✋");
            emojisSection.set(":vulcan_salute", "🖖");
            emojisSection.set(":ok_hand", "👌");
            emojisSection.set(":crossed_fingers", "🤞");
            emojisSection.set(":love_you_gesture", "🤟");
            emojisSection.set(":rock_on", "🤘");
            emojisSection.set(":call_me", "🤙");
            emojisSection.set(":point_left", "👈");
            emojisSection.set(":point_right", "👉");
            emojisSection.set(":point_up", "👆");
            emojisSection.set(":middle_finger", "🖕");
            emojisSection.set(":point_down", "👇");
            emojisSection.set(":selfie", "🤳");
            emojisSection.set(":nail_polish", "💅");
            emojisSection.set(":muscle", "💪");
            emojisSection.set(":leg", "🦵");
            emojisSection.set(":foot", "🦶");
            emojisSection.set(":ear", "👂");
            emojisSection.set(":nose", "👃");
            emojisSection.set(":footprints", "👣");
            emojisSection.set(":eyes", "👀");
            emojisSection.set(":tongue", "👅");
            emojisSection.set(":mouth", "👄");
            emojisSection.set(":lips", "💋");
            emojisSection.set(":glasses", "👓");
            emojisSection.set(":necktie", "👔");
            emojisSection.set(":shirt", "👕");
            emojisSection.set(":jeans", "👖");
            emojisSection.set(":scarf", "🧣");
            emojisSection.set(":gloves", "🧤");
            emojisSection.set(":coat", "🧥");
            emojisSection.set(":socks", "🧦");
            emojisSection.set(":dress", "👗");
            emojisSection.set(":kimono", "👘");
            emojisSection.set(":bikini", "👙");
            emojisSection.set(":blouse", "👚");
            emojisSection.set(":purse", "👛");
            emojisSection.set(":handbag", "👜");
            emojisSection.set(":clutch_bag", "👝");
            emojisSection.set(":backpack", "🎒");
            emojisSection.set(":man_shoe", "👞");
            emojisSection.set(":woman_shoe", "👟");
            emojisSection.set(":high_heeled_shoe", "👠");
            emojisSection.set(":woman_sandal", "👡");
            emojisSection.set(":woman_boot", "👢");
            emojisSection.set(":crown", "👑");
            emojisSection.set(":top_hat", "🎩");
            emojisSection.set(":graduation_cap", "🎓");
            emojisSection.set(":billed_cap", "🧢");
            emojisSection.set(":lipstick", "💄");
            emojisSection.set(":ring", "💍");
            emojisSection.set(":briefcase", "💼");
            emojisSection.set(":cold_face", "🥶");
            emojisSection.set(":woozy_face", "🥴");
            emojisSection.set(":dizzy_face", "😵");
            emojisSection.set(":exploding_head", "🤯");
            emojisSection.set(":cowboy_hat", "🤠");
            emojisSection.set(":partying_face", "🥳");
            emojisSection.set(":sunglasses", "😎");
            emojisSection.set(":nerd_face", "🤓");
            emojisSection.set(":monocle_face", "🧐");
            emojisSection.set(":confused_face", "😕");
            emojisSection.set(":worried_face", "😟");
            emojisSection.set(":slightly_frowning_face", "🙁");
            emojisSection.set(":open_mouth", "😮");
            emojisSection.set(":hushed_face", "😯");
            emojisSection.set(":astonished_face", "😲");
            emojisSection.set(":flushed_face", "😳");
            emojisSection.set(":pleading_face", "🥺");
            emojisSection.set(":frowning_face", "😦");
            emojisSection.set(":anguished_face", "😧");
            emojisSection.set(":fearful_face", "😨");
            emojisSection.set(":anxious_face", "😰");
            emojisSection.set(":sad_face", "😥");
            emojisSection.set(":crying_face", "😢");
            emojisSection.set(":loudly_crying_face", "😭");
            emojisSection.set(":screaming_face", "😱");
            emojisSection.set(":confounded_face", "😖");
            emojisSection.set(":persevering_face", "😣");
            emojisSection.set(":disappointed_face", "😞");
            emojisSection.set(":worried_face", "😓");
            emojisSection.set(":weary_face", "😩");
            emojisSection.set(":tired_face", "😫");
            emojisSection.set(":angry_face", "😤");
            emojisSection.set(":pouting_face", "😡");
            emojisSection.set(":angry_face", "😠");
            emojisSection.set(":face_with_symbols_over_mouth", "🤬");
            emojisSection.set(":smiling_face_with_horns", "😈");
            emojisSection.set(":angry_face_with_horns", "👿");
            emojisSection.set(":skull", "💀");
            emojisSection.set(":pile_of_poo", "💩");
            emojisSection.set(":clown_face", "🤡");
            emojisSection.set(":ogre", "👹");
            emojisSection.set(":goblin", "👺");
            emojisSection.set(":ghost", "👻");
            emojisSection.set(":alien", "👽");
            emojisSection.set(":alien_monster", "👾");
            emojisSection.set(":robot_face", "🤖");
            emojisSection.set(":cat_face", "😺");
            emojisSection.set(":grinning_cat_face", "😸");
            emojisSection.set(":cat_with_tears_of_joy", "😹");
            emojisSection.set(":smiling_cat_face_heart_eyes", "😻");
            emojisSection.set(":cat_with_wry_smile", "😼");
            emojisSection.set(":kissing_cat_face", "😽");
            emojisSection.set(":weary_cat_face", "🙀");
            emojisSection.set(":crying_cat_face", "😿");
            emojisSection.set(":pouting_cat_face", "😾");
            emojisSection.set(":smile", "😀");
            emojisSection.set(":grinning_face_with_big_eyes", "😃");
            emojisSection.set(":grinning_face_with_smiling_eyes", "😄");
            emojisSection.set(":smiling_face_with_open_mouth", "😁");
            emojisSection.set(":smiling_face_with_squinting_eyes", "😆");
            emojisSection.set(":smiling_face_with_tears_of_joy", "😅");
            emojisSection.set(":face_with_tears_of_joy", "😂");
            emojisSection.set(":smiling_face_with_halo", "😇");
            emojisSection.set(":winking_face", "😉");
            emojisSection.set(":smirk", "😏");
            emojisSection.set(":relieved_face", "😌");
            emojisSection.set(":smiling_face_with_heart_eyes", "😍");
            emojisSection.set(":smiling_face_with_smiling_eyes", "🥰");
            emojisSection.set(":kissing_face_with_closed_eyes", "😚");
            emojisSection.set(":face_savoring_food", "😋");
            emojisSection.set(":face_with_tongue", "😛");
            emojisSection.set(":wacky_face", "😜");
            emojisSection.set(":squinting_face_with_tongue", "😝");
            emojisSection.set(":money_mouth_face", "🤑");
            emojisSection.set(":hugging_face", "🤗");
            emojisSection.set(":face_with_hand_over_mouth", "🤭");
            emojisSection.set(":thinking_face", "🤔");
            emojisSection.set(":zipper_mouth_face", "🤐");
            emojisSection.set(":raised_eyebrow", "🤨");
            emojisSection.set(":neutral_face", "😐");
            emojisSection.set(":expressionless_face", "😑");
            emojisSection.set(":face_without_mouth", "😶");
            emojisSection.set(":smirking_face", "😏");
            emojisSection.set(":unamused_face", "😒");
            emojisSection.set(":face_with_rolling_eyes", "🙄");
            emojisSection.set(":grimacing_face", "😬");
            emojisSection.set(":lying_face", "🤥");
            emojisSection.set(":relieved_face", "😌");
            emojisSection.set(":pensive_face", "😔");
            emojisSection.set(":sleepy_face", "😪");
            emojisSection.set(":drooling_face", "🤤");
            emojisSection.set(":sleeping_face", "😴");
            emojisSection.set(":face_with_medical_mask", "😷");
            emojisSection.set(":face_with_thermometer", "🤒");
            emojisSection.set(":face_with_head_bandage", "🤕");
            emojisSection.set(":nauseated_face", "🤢");
            emojisSection.set(":face_vomiting", "🤮");
            emojisSection.set(":sneezing_face", "🤧");
            emojisSection.set(":hot_face", "🥵");
            emojisSection.set(":sparkles", "✨");
            emojisSection.set(":dizzy", "💫");
            emojisSection.set(":crescent_moon", "🌙");
            emojisSection.set(":sun", "🌞");
            emojisSection.set(":wind_blowing_face", "💨");
            emojisSection.set(":rainbow", "🌈");
            emojisSection.set(":droplet", "💧");
            emojisSection.set(":splashing_sweat", "💦");
            emojisSection.set(":water_wave", "🌊");
            emojisSection.set(":green_apple", "🍏");
            emojisSection.set(":red_apple", "🍎");
            emojisSection.set(":pear", "🍐");
            emojisSection.set(":tangerine", "🍊");
            emojisSection.set(":lemon", "🍋");
            emojisSection.set(":banana", "🍌");
            emojisSection.set(":watermelon", "🍉");
            emojisSection.set(":grapes", "🍇");
            emojisSection.set(":strawberry", "🍓");
            emojisSection.set(":melon", "🍈");
            emojisSection.set(":cherries", "🍒");
            emojisSection.set(":peach", "🍑");
            emojisSection.set(":pineapple", "🍍");
            emojisSection.set(":tomato", "🍅");
            emojisSection.set(":eggplant", "🍆");
            emojisSection.set(":avocado", "🥑");
            emojisSection.set(":broccoli", "🥦");
            emojisSection.set(":corn", "🌽");
            emojisSection.set(":carrot", "🥕");
            emojisSection.set(":potato", "🥔");
            emojisSection.set(":sweet_potato", "🍠");
            emojisSection.set(":onion", "🧅");
            emojisSection.set(":garlic", "🧄");
            emojisSection.set(":cucumber", "🥒");
            emojisSection.set(":leafy_green", "🥬");
            emojisSection.set(":mushroom", "🍄");
            emojisSection.set(":peanuts", "🥜");
            emojisSection.set(":chestnut", "🌰");
            emojisSection.set(":bread", "🍞");
            emojisSection.set(":croissant", "🥐");
            emojisSection.set(":baguette_bread", "🥖");
            emojisSection.set(":bagel", "🥯");
            emojisSection.set(":pancakes", "🥞");
            emojisSection.set(":waffle", "🧇");
            emojisSection.set(":cheese_wedge", "🧀");
            emojisSection.set(":meat_on_bone", "🍖");
            emojisSection.set(":poultry_leg", "🍗");
            emojisSection.set(":cut_of_meat", "🥩");
            emojisSection.set(":hamburger", "🍔");
            emojisSection.set(":french_fries", "🍟");
            emojisSection.set(":pizza", "🍕");
            emojisSection.set(":hot_dog", "🌭");
            emojisSection.set(":sandwich", "🥪");
            emojisSection.set(":taco", "🌮");
            emojisSection.set(":burrito", "🌯");
            emojisSection.set(":stuffed_pita", "🥙");
            emojisSection.set(":egg", "🥚");
            emojisSection.set(":cooking", "🥘");
            emojisSection.set(":pot_of_food", "🍲");
            emojisSection.set(":bowl_with_spoon", "🥣");
            emojisSection.set(":green_salad", "🥗");
            emojisSection.set(":basket_of_bread", "🧺");
            emojisSection.set(":cupcake", "🧁");
            emojisSection.set(":pie", "🥧");
            emojisSection.set(":chopsticks", "🥢");
            emojisSection.set(":soccer_ball", "⚽");
            emojisSection.set(":basketball", "🏀");
            emojisSection.set(":football", "🏈");
            emojisSection.set(":baseball", "⚾");
            emojisSection.set(":softball", "🥎");
            emojisSection.set(":tennis", "🎾");
            emojisSection.set(":volleyball", "🏐");
            emojisSection.set(":rugby_football", "🏉");
            emojisSection.set(":billiards", "🎱");
            emojisSection.set(":ping_pong", "🏓");
            emojisSection.set(":badminton", "🏸");
            emojisSection.set(":ice_hockey", "🏒");
            emojisSection.set(":field_hockey", "🏑");
            emojisSection.set(":lacrosse", "🥍");
            emojisSection.set(":cricket", "🏏");
            emojisSection.set(":goal_net", "🥅");
            emojisSection.set(":golf", "⛳");
            emojisSection.set(":kite", "🪁");
            emojisSection.set(":bow_and_arrow", "🏹");
            emojisSection.set(":fishing_pole_and_fish", "🎣");
            emojisSection.set(":diving_mask", "🤿");
            emojisSection.set(":boxing_glove", "🥊");
            emojisSection.set(":martial_arts_uniform", "🥋");
            emojisSection.set(":running_shirt", "🎽");
            emojisSection.set(":curling_stone", "🥌");
            emojisSection.set(":skateboard", "🛹");
            emojisSection.set(":ski", "🎿");
            emojisSection.set(":sled", "🛷");
            emojisSection.set(":ice_skate", "⛸");
            emojisSection.set(":snowboard", "🏂");
            emojisSection.set(":trophy", "🏆");
            emojisSection.set(":first_place_medal", "🥇");
            emojisSection.set(":second_place_medal", "🥈");
            emojisSection.set(":third_place_medal", "🥉");
            emojisSection.set(":sports_medal", "🏅");
            emojisSection.set(":ticket", "🎫");
            emojisSection.set(":circus_tent", "🎪");
            emojisSection.set(":performing_arts", "🎭");
            emojisSection.set(":ballet_shoes", "🩰");
            emojisSection.set(":artist_palette", "🎨");
            emojisSection.set(":film_frames", "🎬");
            emojisSection.set(":microphone", "🎤");
            emojisSection.set(":headphone", "🎧");
            emojisSection.set(":musical_note", "🎼");
            emojisSection.set(":musical_keyboard", "🎹");
            emojisSection.set(":drum", "🥁");
            emojisSection.set(":saxophone", "🎷");
            emojisSection.set(":train", "🚂");
            emojisSection.set(":railway_car", "🚃");
            emojisSection.set(":high_speed_train", "🚄");
            emojisSection.set(":bullet_train", "🚅");
            emojisSection.set(":light_rail", "🚈");
            emojisSection.set(":metro", "🚇");
            emojisSection.set(":station", "🚉");
            emojisSection.set(":tram", "🚊");
            emojisSection.set(":monorail", "🚝");
            emojisSection.set(":tram_car", "🚞");
            emojisSection.set(":bus", "🚌");
            emojisSection.set(":oncoming_bus", "🚍");
            emojisSection.set(":trolleybus", "🚎");
            emojisSection.set(":minibus", "🚐");
            emojisSection.set(":ambulance", "🚑");
            emojisSection.set(":fire_engine", "🚒");
            emojisSection.set(":police_car", "🚓");
            emojisSection.set(":oncoming_police_car", "🚔");
            emojisSection.set(":taxi", "🚕");
            emojisSection.set(":oncoming_taxi", "🚖");
            emojisSection.set(":automobile", "🚗");
            emojisSection.set(":oncoming_automobile", "🚘");
            emojisSection.set(":sport_utility_vehicle", "🚙");
            emojisSection.set(":delivery_truck", "🚚");
            emojisSection.set(":articulated_lorry", "🚛");
            emojisSection.set(":tractor", "🚜");
            emojisSection.set(":motor_scooter", "🛵");
            emojisSection.set(":manual_wheelchair", "🦽");
            emojisSection.set(":motorized_wheelchair", "🦼");
            emojisSection.set(":kick_scooter", "🛴");
            emojisSection.set(":skateboard", "🛹");
            emojisSection.set(":ski", "🎿");
            emojisSection.set(":sled", "🛷");
            emojisSection.set(":ice_skate", "⛸");
            emojisSection.set(":snowboard", "🏂");
            emojisSection.set(":bus_stop", "🚏");
            emojisSection.set(":fuel_pump", "⛽");
            emojisSection.set(":police_car_light", "🚨");
            emojisSection.set(":horizontal_traffic_light", "🚥");
            emojisSection.set(":vertical_traffic_light", "🚦");
            emojisSection.set(":stop_sign", "🛑");
            emojisSection.set(":anchor", "⚓");
            emojisSection.set(":sailboat", "⛵");
            emojisSection.set(":canoe", "🛶");
            emojisSection.set(":speedboat", "🚤");
            emojisSection.set(":parachute", "🪂");
            emojisSection.set(":seat", "💺");
            emojisSection.set(":helicopter", "🚁");
            emojisSection.set(":suspension_railway", "🚟");
            emojisSection.set(":mountain_cableway", "🚠");
            emojisSection.set(":aerial_tramway", "🚡");
            emojisSection.set(":rocket", "🚀");
            emojisSection.set(":flying_saucer", "🛸");
            emojisSection.set(":globe_showing_Europe-Africa", "🌍");
            emojisSection.set(":globe_showing_Americas", "🌎");
            emojisSection.set(":globe_showing_Asia-Australia", "🌏");
            emojisSection.set(":globe_with_meridians", "🌐");
            emojisSection.set(":volcano", "🌋");
            emojisSection.set(":seaweed", "🗻");
            emojisSection.set(":brick", "🧱");
            emojisSection.set(":house", "🏠");
            emojisSection.set(":house_with_garden", "🏡");
            emojisSection.set(":office_building", "🏢");
            emojisSection.set(":Japanese_post_office", "🏣");
            emojisSection.set(":hospital", "🏥");
            emojisSection.set(":bank", "🏦");
            emojisSection.set(":hotel", "🏨");
            emojisSection.set(":love_hotel", "🏩");
            emojisSection.set(":convenience_store", "🏪");
            emojisSection.set(":school", "🏫");
            emojisSection.set(":department_store", "🏬");
            emojisSection.set(":factory", "🏭");
            emojisSection.set(":Japanese_castle", "🏯");
            emojisSection.set(":castle", "🏰");
            emojisSection.set(":wedding", "💒");
            emojisSection.set(":Tokyo_tower", "🗼");
            emojisSection.set(":Statue_of_Liberty", "🗽");
            emojisSection.set(":church", "⛪");
            emojisSection.set(":mosque", "🕌");
            emojisSection.set(":synagogue", "🕍");
            emojisSection.set(":Kaaba", "🕋");
            emojisSection.set(":fountain", "⛲");
            emojisSection.set(":tent", "⛺");
            emojisSection.set(":foggy", "🌁");
            emojisSection.set(":cityscape_at_dusk", "🌆");
            emojisSection.set(":sunrise_over_mountains", "🌄");
            emojisSection.set(":sunrise", "🌅");
            emojisSection.set(":cityscape_at_sunset", "🌇");
            emojisSection.set(":bridge_at_night", "🌉");
            emojisSection.set(":arrowleft", "←");
            emojisSection.set(":arrowup", "↑");
            emojisSection.set(":arrowright", "→");
            emojisSection.set(":arrowdown", "↓");
            try {
                config.save(configFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Map<String, String> createDefaultEmojiMap() {
        Map<String, String> defaultMap = new HashMap<>();
        defaultMap.put(":wave", "👋");
        defaultMap.put(":raised_hand", "🤚");
        defaultMap.put(":raised_fist", "✋");
        defaultMap.put(":vulcan_salute", "🖖");
        defaultMap.put(":ok_hand", "👌");
        defaultMap.put(":crossed_fingers", "🤞");
        defaultMap.put(":love_you_gesture", "🤟");
        defaultMap.put(":rock_on", "🤘");
        defaultMap.put(":call_me", "🤙");
        defaultMap.put(":point_left", "👈");
        defaultMap.put(":point_right", "👉");
        defaultMap.put(":point_up", "👆");
        defaultMap.put(":middle_finger", "🖕");
        defaultMap.put(":point_down", "👇");
        defaultMap.put(":selfie", "🤳");
        defaultMap.put(":nail_polish", "💅");
        defaultMap.put(":muscle", "💪");
        defaultMap.put(":leg", "🦵");
        defaultMap.put(":foot", "🦶");
        defaultMap.put(":ear", "👂");
        defaultMap.put(":nose", "👃");
        defaultMap.put(":footprints", "👣");
        defaultMap.put(":eyes", "👀");
        defaultMap.put(":tongue", "👅");
        defaultMap.put(":mouth", "👄");
        defaultMap.put(":lips", "💋");
        defaultMap.put(":glasses", "👓");
        defaultMap.put(":necktie", "👔");
        defaultMap.put(":shirt", "👕");
        defaultMap.put(":jeans", "👖");
        defaultMap.put(":scarf", "🧣");
        defaultMap.put(":gloves", "🧤");
        defaultMap.put(":coat", "🧥");
        defaultMap.put(":socks", "🧦");
        defaultMap.put(":dress", "👗");
        defaultMap.put(":kimono", "👘");
        defaultMap.put(":bikini", "👙");
        defaultMap.put(":blouse", "👚");
        defaultMap.put(":purse", "👛");
        defaultMap.put(":handbag", "👜");
        defaultMap.put(":clutch_bag", "👝");
        defaultMap.put(":backpack", "🎒");
        defaultMap.put(":man_shoe", "👞");
        defaultMap.put(":woman_shoe", "👟");
        defaultMap.put(":high_heeled_shoe", "👠");
        defaultMap.put(":woman_sandal", "👡");
        defaultMap.put(":woman_boot", "👢");
        defaultMap.put(":crown", "👑");
        defaultMap.put(":top_hat", "🎩");
        defaultMap.put(":graduation_cap", "🎓");
        defaultMap.put(":billed_cap", "🧢");
        defaultMap.put(":lipstick", "💄");
        defaultMap.put(":ring", "💍");
        defaultMap.put(":briefcase", "💼");
        defaultMap.put(":cold_face", "🥶");
        defaultMap.put(":woozy_face", "🥴");
        defaultMap.put(":dizzy_face", "😵");
        defaultMap.put(":exploding_head", "🤯");
        defaultMap.put(":cowboy_hat", "🤠");
        defaultMap.put(":partying_face", "🥳");
        defaultMap.put(":sunglasses", "😎");
        defaultMap.put(":nerd_face", "🤓");
        defaultMap.put(":monocle_face", "🧐");
        defaultMap.put(":confused_face", "😕");
        defaultMap.put(":slightly_frowning_face", "🙁");
        defaultMap.put(":open_mouth", "😮");
        defaultMap.put(":hushed_face", "😯");
        defaultMap.put(":astonished_face", "😲");
        defaultMap.put(":flushed_face", "😳");
        defaultMap.put(":pleading_face", "🥺");
        defaultMap.put(":frowning_face", "😦");
        defaultMap.put(":anguished_face", "😧");
        defaultMap.put(":fearful_face", "😨");
        defaultMap.put(":anxious_face", "😰");
        defaultMap.put(":sad_face", "😥");
        defaultMap.put(":crying_face", "😢");
        defaultMap.put(":loudly_crying_face", "😭");
        defaultMap.put(":screaming_face", "😱");
        defaultMap.put(":confounded_face", "😖");
        defaultMap.put(":persevering_face", "😣");
        defaultMap.put(":disappointed_face", "😞");
        defaultMap.put(":worried_face", "😓");
        defaultMap.put(":weary_face", "😩");
        defaultMap.put(":tired_face", "😫");
        defaultMap.put(":pouting_face", "😡");
        defaultMap.put(":angry_face", "😠");
        defaultMap.put(":face_with_symbols_over_mouth", "🤬");
        defaultMap.put(":smiling_face_with_horns", "😈");
        defaultMap.put(":angry_face_with_horns", "👿");
        defaultMap.put(":skull", "💀");
        defaultMap.put(":pile_of_poo", "💩");
        defaultMap.put(":clown_face", "🤡");
        defaultMap.put(":ogre", "👹");
        defaultMap.put(":goblin", "👺");
        defaultMap.put(":ghost", "👻");
        defaultMap.put(":alien", "👽");
        defaultMap.put(":alien_monster", "👾");
        defaultMap.put(":robot_face", "🤖");
        defaultMap.put(":cat_face", "😺");
        defaultMap.put(":grinning_cat_face", "😸");
        defaultMap.put(":cat_with_tears_of_joy", "😹");
        defaultMap.put(":smiling_cat_face_heart_eyes", "😻");
        defaultMap.put(":cat_with_wry_smile", "😼");
        defaultMap.put(":kissing_cat_face", "😽");
        defaultMap.put(":weary_cat_face", "🙀");
        defaultMap.put(":crying_cat_face", "😿");
        defaultMap.put(":pouting_cat_face", "😾");
        defaultMap.put(":smile", "😀");
        defaultMap.put(":grinning_face_with_big_eyes", "😃");
        defaultMap.put(":grinning_face_with_smiling_eyes", "😄");
        defaultMap.put(":smiling_face_with_open_mouth", "😁");
        defaultMap.put(":smiling_face_with_squinting_eyes", "😆");
        defaultMap.put(":smiling_face_with_tears_of_joy", "😅");
        defaultMap.put(":face_with_tears_of_joy", "😂");
        defaultMap.put(":smiling_face_with_halo", "😇");
        defaultMap.put(":winking_face", "😉");
        defaultMap.put(":smirk", "😏");
        defaultMap.put(":smiling_face_with_heart_eyes", "😍");
        defaultMap.put(":smiling_face_with_smiling_eyes", "🥰");
        defaultMap.put(":kissing_face_with_closed_eyes", "😚");
        defaultMap.put(":face_savoring_food", "😋");
        defaultMap.put(":face_with_tongue", "😛");
        defaultMap.put(":wacky_face", "😜");
        defaultMap.put(":squinting_face_with_tongue", "😝");
        defaultMap.put(":money_mouth_face", "🤑");
        defaultMap.put(":hugging_face", "🤗");
        defaultMap.put(":face_with_hand_over_mouth", "🤭");
        defaultMap.put(":thinking_face", "🤔");
        defaultMap.put(":zipper_mouth_face", "🤐");
        defaultMap.put(":raised_eyebrow", "🤨");
        defaultMap.put(":neutral_face", "😐");
        defaultMap.put(":expressionless_face", "😑");
        defaultMap.put(":face_without_mouth", "😶");
        defaultMap.put(":smirking_face", "😏");
        defaultMap.put(":unamused_face", "😒");
        defaultMap.put(":face_with_rolling_eyes", "🙄");
        defaultMap.put(":grimacing_face", "😬");
        defaultMap.put(":lying_face", "🤥");
        defaultMap.put(":relieved_face", "😌");
        defaultMap.put(":pensive_face", "😔");
        defaultMap.put(":sleepy_face", "😪");
        defaultMap.put(":drooling_face", "🤤");
        defaultMap.put(":sleeping_face", "😴");
        defaultMap.put(":face_with_medical_mask", "😷");
        defaultMap.put(":face_with_thermometer", "🤒");
        defaultMap.put(":face_with_head_bandage", "🤕");
        defaultMap.put(":nauseated_face", "🤢");
        defaultMap.put(":face_vomiting", "🤮");
        defaultMap.put(":sneezing_face", "🤧");
        defaultMap.put(":hot_face", "🥵");
        defaultMap.put(":sparkles", "✨");
        defaultMap.put(":dizzy", "💫");
        defaultMap.put(":crescent_moon", "🌙");
        defaultMap.put(":sun", "🌞");
        defaultMap.put(":wind_blowing_face", "💨");
        defaultMap.put(":rainbow", "🌈");
        defaultMap.put(":droplet", "💧");
        defaultMap.put(":splashing_sweat", "💦");
        defaultMap.put(":water_wave", "🌊");
        defaultMap.put(":green_apple", "🍏");
        defaultMap.put(":red_apple", "🍎");
        defaultMap.put(":pear", "🍐");
        defaultMap.put(":tangerine", "🍊");
        defaultMap.put(":lemon", "🍋");
        defaultMap.put(":banana", "🍌");
        defaultMap.put(":watermelon", "🍉");
        defaultMap.put(":grapes", "🍇");
        defaultMap.put(":strawberry", "🍓");
        defaultMap.put(":melon", "🍈");
        defaultMap.put(":cherries", "🍒");
        defaultMap.put(":peach", "🍑");
        defaultMap.put(":pineapple", "🍍");
        defaultMap.put(":tomato", "🍅");
        defaultMap.put(":eggplant", "🍆");
        defaultMap.put(":avocado", "🥑");
        defaultMap.put(":broccoli", "🥦");
        defaultMap.put(":corn", "🌽");
        defaultMap.put(":carrot", "🥕");
        defaultMap.put(":potato", "🥔");
        defaultMap.put(":sweet_potato", "🍠");
        defaultMap.put(":onion", "🧅");
        defaultMap.put(":garlic", "🧄");
        defaultMap.put(":cucumber", "🥒");
        defaultMap.put(":leafy_green", "🥬");
        defaultMap.put(":mushroom", "🍄");
        defaultMap.put(":peanuts", "🥜");
        defaultMap.put(":chestnut", "🌰");
        defaultMap.put(":bread", "🍞");
        defaultMap.put(":croissant", "🥐");
        defaultMap.put(":baguette_bread", "🥖");
        defaultMap.put(":bagel", "🥯");
        defaultMap.put(":pancakes", "🥞");
        defaultMap.put(":waffle", "🧇");
        defaultMap.put(":cheese_wedge", "🧀");
        defaultMap.put(":meat_on_bone", "🍖");
        defaultMap.put(":poultry_leg", "🍗");
        defaultMap.put(":cut_of_meat", "🥩");
        defaultMap.put(":hamburger", "🍔");
        defaultMap.put(":french_fries", "🍟");
        defaultMap.put(":pizza", "🍕");
        defaultMap.put(":hot_dog", "🌭");
        defaultMap.put(":sandwich", "🥪");
        defaultMap.put(":taco", "🌮");
        defaultMap.put(":burrito", "🌯");
        defaultMap.put(":stuffed_pita", "🥙");
        defaultMap.put(":egg", "🥚");
        defaultMap.put(":cooking", "🥘");
        defaultMap.put(":pot_of_food", "🍲");
        defaultMap.put(":bowl_with_spoon", "🥣");
        defaultMap.put(":green_salad", "🥗");
        defaultMap.put(":basket_of_bread", "🧺");
        defaultMap.put(":cupcake", "🧁");
        defaultMap.put(":pie", "🥧");
        defaultMap.put(":chopsticks", "🥢");
        defaultMap.put(":soccer_ball", "⚽");
        defaultMap.put(":basketball", "🏀");
        defaultMap.put(":football", "🏈");
        defaultMap.put(":baseball", "⚾");
        defaultMap.put(":softball", "🥎");
        defaultMap.put(":tennis", "🎾");
        defaultMap.put(":volleyball", "🏐");
        defaultMap.put(":rugby_football", "🏉");
        defaultMap.put(":billiards", "🎱");
        defaultMap.put(":ping_pong", "🏓");
        defaultMap.put(":badminton", "🏸");
        defaultMap.put(":ice_hockey", "🏒");
        defaultMap.put(":field_hockey", "🏑");
        defaultMap.put(":lacrosse", "🥍");
        defaultMap.put(":cricket", "🏏");
        defaultMap.put(":goal_net", "🥅");
        defaultMap.put(":golf", "⛳");
        defaultMap.put(":kite", "🪁");
        defaultMap.put(":bow_and_arrow", "🏹");
        defaultMap.put(":fishing_pole_and_fish", "🎣");
        defaultMap.put(":diving_mask", "🤿");
        defaultMap.put(":boxing_glove", "🥊");
        defaultMap.put(":martial_arts_uniform", "🥋");
        defaultMap.put(":running_shirt", "🎽");
        defaultMap.put(":curling_stone", "🥌");
        defaultMap.put(":skateboard", "🛹");
        defaultMap.put(":ski", "🎿");
        defaultMap.put(":sled", "🛷");
        defaultMap.put(":ice_skate", "⛸");
        defaultMap.put(":snowboard", "🏂");
        defaultMap.put(":trophy", "🏆");
        defaultMap.put(":first_place_medal", "🥇");
        defaultMap.put(":second_place_medal", "🥈");
        defaultMap.put(":third_place_medal", "🥉");
        defaultMap.put(":sports_medal", "🏅");
        defaultMap.put(":ticket", "🎫");
        defaultMap.put(":circus_tent", "🎪");
        defaultMap.put(":performing_arts", "🎭");
        defaultMap.put(":ballet_shoes", "🩰");
        defaultMap.put(":artist_palette", "🎨");
        defaultMap.put(":film_frames", "🎬");
        defaultMap.put(":microphone", "🎤");
        defaultMap.put(":headphone", "🎧");
        defaultMap.put(":musical_note", "🎼");
        defaultMap.put(":musical_keyboard", "🎹");
        defaultMap.put(":drum", "🥁");
        defaultMap.put(":saxophone", "🎷");
        defaultMap.put(":train", "🚂");
        defaultMap.put(":railway_car", "🚃");
        defaultMap.put(":high_speed_train", "🚄");
        defaultMap.put(":bullet_train", "🚅");
        defaultMap.put(":light_rail", "🚈");
        defaultMap.put(":metro", "🚇");
        defaultMap.put(":station", "🚉");
        defaultMap.put(":tram", "🚊");
        defaultMap.put(":monorail", "🚝");
        defaultMap.put(":tram_car", "🚞");
        defaultMap.put(":bus", "🚌");
        defaultMap.put(":oncoming_bus", "🚍");
        defaultMap.put(":trolleybus", "🚎");
        defaultMap.put(":minibus", "🚐");
        defaultMap.put(":ambulance", "🚑");
        defaultMap.put(":fire_engine", "🚒");
        defaultMap.put(":police_car", "🚓");
        defaultMap.put(":oncoming_police_car", "🚔");
        defaultMap.put(":taxi", "🚕");
        defaultMap.put(":oncoming_taxi", "🚖");
        defaultMap.put(":automobile", "🚗");
        defaultMap.put(":oncoming_automobile", "🚘");
        defaultMap.put(":sport_utility_vehicle", "🚙");
        defaultMap.put(":delivery_truck", "🚚");
        defaultMap.put(":articulated_lorry", "🚛");
        defaultMap.put(":tractor", "🚜");
        defaultMap.put(":motor_scooter", "🛵");
        defaultMap.put(":manual_wheelchair", "🦽");
        defaultMap.put(":motorized_wheelchair", "🦼");
        defaultMap.put(":kick_scooter", "🛴");
        defaultMap.put(":skateboard", "🛹");
        defaultMap.put(":ski", "🎿");
        defaultMap.put(":sled", "🛷");
        defaultMap.put(":ice_skate", "⛸");
        defaultMap.put(":snowboard", "🏂");
        defaultMap.put(":bus_stop", "🚏");
        defaultMap.put(":fuel_pump", "⛽");
        defaultMap.put(":police_car_light", "🚨");
        defaultMap.put(":horizontal_traffic_light", "🚥");
        defaultMap.put(":vertical_traffic_light", "🚦");
        defaultMap.put(":stop_sign", "🛑");
        defaultMap.put(":anchor", "⚓");
        defaultMap.put(":sailboat", "⛵");
        defaultMap.put(":canoe", "🛶");
        defaultMap.put(":speedboat", "🚤");
        defaultMap.put(":parachute", "🪂");
        defaultMap.put(":seat", "💺");
        defaultMap.put(":helicopter", "🚁");
        defaultMap.put(":suspension_railway", "🚟");
        defaultMap.put(":mountain_cableway", "🚠");
        defaultMap.put(":aerial_tramway", "🚡");
        defaultMap.put(":rocket", "🚀");
        defaultMap.put(":flying_saucer", "🛸");
        defaultMap.put(":globe_showing_Europe-Africa", "🌍");
        defaultMap.put(":globe_showing_Americas", "🌎");
        defaultMap.put(":globe_showing_Asia-Australia", "🌏");
        defaultMap.put(":globe_with_meridians", "🌐");
        defaultMap.put(":volcano", "🌋");
        defaultMap.put(":seaweed", "🗻");
        defaultMap.put(":brick", "🧱");
        defaultMap.put(":house", "🏠");
        defaultMap.put(":house_with_garden", "🏡");
        defaultMap.put(":office_building", "🏢");
        defaultMap.put(":Japanese_post_office", "🏣");
        defaultMap.put(":hospital", "🏥");
        defaultMap.put(":bank", "🏦");
        defaultMap.put(":hotel", "🏨");
        defaultMap.put(":love_hotel", "🏩");
        defaultMap.put(":convenience_store", "🏪");
        defaultMap.put(":school", "🏫");
        defaultMap.put(":department_store", "🏬");
        defaultMap.put(":factory", "🏭");
        defaultMap.put(":Japanese_castle", "🏯");
        defaultMap.put(":castle", "🏰");
        defaultMap.put(":wedding", "💒");
        defaultMap.put(":Tokyo_tower", "🗼");
        defaultMap.put(":Statue_of_Liberty", "🗽");
        defaultMap.put(":church", "⛪");
        defaultMap.put(":mosque", "🕌");
        defaultMap.put(":synagogue", "🕍");
        defaultMap.put(":Kaaba", "🕋");
        defaultMap.put(":fountain", "⛲");
        defaultMap.put(":tent", "⛺");
        defaultMap.put(":foggy", "🌁");
        defaultMap.put(":cityscape_at_dusk", "🌆");
        defaultMap.put(":sunrise_over_mountains", "🌄");
        defaultMap.put(":sunrise", "🌅");
        defaultMap.put(":cityscape_at_sunset", "🌇");
        defaultMap.put(":bridge_at_night", "🌉");
        defaultMap.put(":arrowleft", "←");
        defaultMap.put(":arrowup", "↑");
        defaultMap.put(":arrowright", "→");
        defaultMap.put(":arrowdown", "↓");
        return defaultMap;
    }

    @Override
    public void onDisable() {
        String PluginPrefix = ChatColor.WHITE + "[" + ChatColor.GREEN + "EmojiChat" + ChatColor.WHITE + "]";
        sendMessage(PluginPrefix + " &cHas been disabled!");

        ConfigurationSection emojisSection = getConfig().getConfigurationSection("Emojis");
        if (emojisSection == null) {
            emojisSection = getConfig().createSection("Emojis");
        }

        for (Map.Entry<String, String> entry : emojiMap.entrySet()) {
            emojisSection.set(entry.getKey(), entry.getValue());
        }

        emojiMap.clear();
    }

    //EventHandler to allow emoji usage in chat
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("emojichat.use.chat")) {
            return;
        }
        String message = event.getMessage();

            for (String emoji : emojiMap.keySet()) {
                if (message.contains(emoji)) {
                    message = message.replace(emoji, emojiMap.get(emoji));
                }
            }

            event.setMessage(message);
        }

    // This event handler is triggered when a player changes a sign.
    // If the player has the necessary permission, it replaces any emoji strings on the sign with their corresponding emojis.
    @EventHandler
    public void onSignChange(SignChangeEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("emojichat.use.signs")) {
            return;
        }

        String[] lines = event.getLines();
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            for (String emoji : emojiMap.keySet()) {
                if (line.contains(emoji)) {
                    line = line.replace(emoji, emojiMap.get(emoji));
                }
            }
            event.setLine(i, line);
        }
    }

    // This method replaces all emoji strings in the text with their corresponding emojis.
    private String replaceEmojis(String text) {
        for (String emoji : emojiMap.keySet()) {
            if (text.contains(emoji)) {
                text = text.replace(emoji, emojiMap.get(emoji));
            }
        }
        return text;
    }

    // This event handler is triggered when a player edits a book.
    // If the player has the necessary permission, it replaces any emoji strings in the book with their corresponding emojis.
    @EventHandler
    public void onPlayerEditBook(PlayerEditBookEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("emojichat.use.books")) {
            return;
        }
        BookMeta bookMeta = event.getNewBookMeta();
        List<String> pages = new ArrayList<>(bookMeta.getPages()); // Create a mutable copy of the pages

        for (int i = 0; i < pages.size(); i++) {
            String page = pages.get(i);
            page = replaceEmojis(page); // Use the replaceEmojis method from the previous code snippet
            pages.set(i, page);
        }

        bookMeta.setPages(pages);
        event.setNewBookMeta(bookMeta);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("emojilist")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("emojichat.use.list")) {
                    int pageNumber = 1; // Default page number

                    if (args.length > 0) {
                        try {
                            pageNumber = Integer.parseInt(args[0]);
                        } catch (NumberFormatException e) {
                            player.sendMessage(ChatColor.RED + "Invalid page number.");
                            return true;
                        }
                    }

                    int startIndex = (pageNumber - 1) * emojisPerPage;
                    int endIndex = startIndex + emojisPerPage;

                    String AvailableEmojisMessage = getConfig().getConfigurationSection("Messages").getString("AvailableEmojisMessage");
                    AvailableEmojisMessage = AvailableEmojisMessage.replace("&", "§");
                    player.sendMessage(AvailableEmojisMessage + pageNumber + ":");

                    int count = 0;
                    for (Map.Entry<String, String> entry : emojiMap.entrySet()) {
                        if (count >= startIndex && count < endIndex) {
                            String emoji = entry.getKey();
                            String emojiText = entry.getValue();

                            String HoverMessage = getConfig().getConfigurationSection("Messages").getString("HoverMessage");
                            HoverMessage = HoverMessage.replace("&", "§");
                            TextComponent emojiComponent = new TextComponent(ChatColor.YELLOW + emoji + " - " + ChatColor.WHITE + emojiText);
                            emojiComponent.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, emoji));
                            emojiComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(HoverMessage).create()));
                            player.spigot().sendMessage(emojiComponent);
                        }
                        count++;
                    }

                    int totalPages = (int) Math.ceil((double) emojiMap.size() / emojisPerPage);
                    if (totalPages > 1) {
                        TextComponent pageNavigation = new TextComponent();
                        if (pageNumber > 1) {
                            String PreviousPageMessage = getConfig().getConfigurationSection("Messages").getString("PreviousPageMessage");
                            PreviousPageMessage = PreviousPageMessage.replace("&", "§");
                            TextComponent previousPage = new TextComponent(PreviousPageMessage);
                            previousPage.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/emojilist " + (pageNumber - 1)));
                            pageNavigation.addExtra(previousPage);
                        }

                        String PageOfMessage = getConfig().getConfigurationSection("Messages").getString("PageOfMessage");
                        PageOfMessage = PageOfMessage.replace("&", "§");
                        PageOfMessage = PageOfMessage.replace("{PAGENUMBER}", String.valueOf(pageNumber));
                        PageOfMessage = PageOfMessage.replace("{TOTALPAGENUMBER}", String.valueOf(totalPages));
                        pageNavigation.addExtra(PageOfMessage);

                        if (pageNumber < totalPages) {
                            String NextPageMessage = getConfig().getConfigurationSection("Messages").getString("NextPageMessage");
                            NextPageMessage = NextPageMessage.replace("&", "§");
                            TextComponent nextPage = new TextComponent(NextPageMessage);
                            nextPage.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/emojilist " + (pageNumber + 1)));
                            pageNavigation.addExtra(nextPage);
                        }
                        player.spigot().sendMessage(pageNavigation);
                    }

                    return true;
                } else {
                    String NoPermMessage = getConfig().getConfigurationSection("Messages").getString("NoPermMessage");
                    NoPermMessage = NoPermMessage.replace("&", "§");
                    player.sendMessage(NoPermMessage);
                    return true;
                }
            } else {
                String CommandSenderFailMessage = getConfig().getConfigurationSection("Messages").getString("CommandSenderFailMessage");
                CommandSenderFailMessage = CommandSenderFailMessage.replace("&", "§");
                sender.sendMessage(CommandSenderFailMessage);
                return true;
            }
        }

        if (command.getName().equalsIgnoreCase("emojisave")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("emojichat.use.saveconfig")) {
                    reloadConfig();
                    saveConfig();
                    // Retrieve the updated emoji mappings from the configuration
                    ConfigurationSection emojisSection = getConfig().getConfigurationSection("Emojis");
                    if (emojisSection != null) {
                        emojiMap.clear(); // Clear the existing emoji mappings

                        for (String key : emojisSection.getKeys(false)) {
                            String tag = emojisSection.getString(key);
                            emojiMap.put(key, tag); // Add the updated emoji mappings
                        }
                    }

                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1, 1);
                    String ConfigSavedMessage = getConfig().getConfigurationSection("Messages").getString("ConfigSavedMessage");
                    ConfigSavedMessage = ConfigSavedMessage.replace("&", "§");
                    String PluginChatPrefix = getConfig().getConfigurationSection("Prefix").getString("Prefix");
                    PluginChatPrefix = PluginChatPrefix.replace("&", "§");
                    player.sendMessage(PluginChatPrefix + ConfigSavedMessage);
                } else {
                    String NoPermMessage = getConfig().getConfigurationSection("Messages").getString("NoPermMessage");
                    NoPermMessage = NoPermMessage.replace("&", "§");
                    player.sendMessage(NoPermMessage);
                }

                return true;
            } else {
                reloadConfig();
                saveConfig();

                // Retrieve the updated emoji mappings from the configuration
                ConfigurationSection emojisSection = getConfig().getConfigurationSection("Emojis");
                if (emojisSection != null) {
                    emojiMap.clear(); // Clear the existing emoji mappings

                    for (String key : emojisSection.getKeys(false)) {
                        String tag = emojisSection.getString(key);
                        emojiMap.put(key, tag);
                    }
                }

                String PluginPrefix = ChatColor.WHITE + "[" + ChatColor.GREEN + "EmojiChat" + ChatColor.WHITE + "]";
                sendMessage(PluginPrefix + " &cSave Failed! Please use this command in-game!");

                return true;
            }
        }

        return false;
    }
}