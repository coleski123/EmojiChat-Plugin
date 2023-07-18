package org.coleski123.emojichat;

import net.md_5.bungee.api.chat.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class EmojiChat extends JavaPlugin implements Listener, CommandExecutor {
    private Map<String, String> emojiMap;
    private int emojisPerPage = 10; // Number of emojis to display per page

    @Override
    public void onEnable() {
        emojiMap = new HashMap<>();
        emojiMap.put(":wave", "👋");
        emojiMap.put(":raised_hand", "🤚");
        emojiMap.put(":raised_fist", "✋");
        emojiMap.put(":vulcan_salute", "🖖");
        emojiMap.put(":ok_hand", "👌");
        emojiMap.put(":crossed_fingers", "🤞");
        emojiMap.put(":love_you_gesture", "🤟");
        emojiMap.put(":rock_on", "🤘");
        emojiMap.put(":call_me", "🤙");
        emojiMap.put(":point_left", "👈");
        emojiMap.put(":point_right", "👉");
        emojiMap.put(":point_up", "👆");
        emojiMap.put(":middle_finger", "🖕");
        emojiMap.put(":point_down", "👇");
        emojiMap.put(":selfie", "🤳");
        emojiMap.put(":nail_polish", "💅");
        emojiMap.put(":muscle", "💪");
        emojiMap.put(":leg", "🦵");
        emojiMap.put(":foot", "🦶");
        emojiMap.put(":ear", "👂");
        emojiMap.put(":nose", "👃");
        emojiMap.put(":footprints", "👣");
        emojiMap.put(":eyes", "👀");
        emojiMap.put(":tongue", "👅");
        emojiMap.put(":mouth", "👄");
        emojiMap.put(":lips", "💋");
        emojiMap.put(":glasses", "👓");
        emojiMap.put(":necktie", "👔");
        emojiMap.put(":shirt", "👕");
        emojiMap.put(":jeans", "👖");
        emojiMap.put(":scarf", "🧣");
        emojiMap.put(":gloves", "🧤");
        emojiMap.put(":coat", "🧥");
        emojiMap.put(":socks", "🧦");
        emojiMap.put(":dress", "👗");
        emojiMap.put(":kimono", "👘");
        emojiMap.put(":bikini", "👙");
        emojiMap.put(":blouse", "👚");
        emojiMap.put(":purse", "👛");
        emojiMap.put(":handbag", "👜");
        emojiMap.put(":clutch_bag", "👝");
        emojiMap.put(":backpack", "🎒");
        emojiMap.put(":man_shoe", "👞");
        emojiMap.put(":woman_shoe", "👟");
        emojiMap.put(":high_heeled_shoe", "👠");
        emojiMap.put(":woman_sandal", "👡");
        emojiMap.put(":woman_boot", "👢");
        emojiMap.put(":crown", "👑");
        emojiMap.put(":top_hat", "🎩");
        emojiMap.put(":graduation_cap", "🎓");
        emojiMap.put(":billed_cap", "🧢");
        emojiMap.put(":lipstick", "💄");
        emojiMap.put(":ring", "💍");
        emojiMap.put(":briefcase", "💼");
        emojiMap.put(":cold_face", "🥶");
        emojiMap.put(":woozy_face", "🥴");
        emojiMap.put(":dizzy_face", "😵");
        emojiMap.put(":exploding_head", "🤯");
        emojiMap.put(":cowboy_hat", "🤠");
        emojiMap.put(":partying_face", "🥳");
        emojiMap.put(":sunglasses", "😎");
        emojiMap.put(":nerd_face", "🤓");
        emojiMap.put(":monocle_face", "🧐");
        emojiMap.put(":confused_face", "😕");
        emojiMap.put(":worried_face", "😟");
        emojiMap.put(":slightly_frowning_face", "🙁");
        emojiMap.put(":open_mouth", "😮");
        emojiMap.put(":hushed_face", "😯");
        emojiMap.put(":astonished_face", "😲");
        emojiMap.put(":flushed_face", "😳");
        emojiMap.put(":pleading_face", "🥺");
        emojiMap.put(":frowning_face", "😦");
        emojiMap.put(":anguished_face", "😧");
        emojiMap.put(":fearful_face", "😨");
        emojiMap.put(":anxious_face", "😰");
        emojiMap.put(":sad_face", "😥");
        emojiMap.put(":crying_face", "😢");
        emojiMap.put(":loudly_crying_face", "😭");
        emojiMap.put(":screaming_face", "😱");
        emojiMap.put(":confounded_face", "😖");
        emojiMap.put(":persevering_face", "😣");
        emojiMap.put(":disappointed_face", "😞");
        emojiMap.put(":worried_face", "😓");
        emojiMap.put(":weary_face", "😩");
        emojiMap.put(":tired_face", "😫");
        emojiMap.put(":angry_face", "😤");
        emojiMap.put(":pouting_face", "😡");
        emojiMap.put(":angry_face", "😠");
        emojiMap.put(":face_with_symbols_over_mouth", "🤬");
        emojiMap.put(":smiling_face_with_horns", "😈");
        emojiMap.put(":angry_face_with_horns", "👿");
        emojiMap.put(":skull", "💀");
        emojiMap.put(":pile_of_poo", "💩");
        emojiMap.put(":clown_face", "🤡");
        emojiMap.put(":ogre", "👹");
        emojiMap.put(":goblin", "👺");
        emojiMap.put(":ghost", "👻");
        emojiMap.put(":alien", "👽");
        emojiMap.put(":alien_monster", "👾");
        emojiMap.put(":robot_face", "🤖");
        emojiMap.put(":cat_face", "😺");
        emojiMap.put(":grinning_cat_face", "😸");
        emojiMap.put(":cat_with_tears_of_joy", "😹");
        emojiMap.put(":smiling_cat_face_heart_eyes", "😻");
        emojiMap.put(":cat_with_wry_smile", "😼");
        emojiMap.put(":kissing_cat_face", "😽");
        emojiMap.put(":weary_cat_face", "🙀");
        emojiMap.put(":crying_cat_face", "😿");
        emojiMap.put(":pouting_cat_face", "😾");
        emojiMap.put(":smile", "😀");
        emojiMap.put(":grinning_face_with_big_eyes", "😃");
        emojiMap.put(":grinning_face_with_smiling_eyes", "😄");
        emojiMap.put(":smiling_face_with_open_mouth", "😁");
        emojiMap.put(":smiling_face_with_squinting_eyes", "😆");
        emojiMap.put(":smiling_face_with_tears_of_joy", "😅");
        emojiMap.put(":face_with_tears_of_joy", "😂");
        emojiMap.put(":smiling_face_with_halo", "😇");
        emojiMap.put(":winking_face", "😉");
        emojiMap.put(":smirk", "😏");
        emojiMap.put(":relieved_face", "😌");
        emojiMap.put(":smiling_face_with_heart_eyes", "😍");
        emojiMap.put(":smiling_face_with_smiling_eyes", "🥰");
        emojiMap.put(":kissing_face_with_closed_eyes", "😚");
        emojiMap.put(":face_savoring_food", "😋");
        emojiMap.put(":face_with_tongue", "😛");
        emojiMap.put(":wacky_face", "😜");
        emojiMap.put(":squinting_face_with_tongue", "😝");
        emojiMap.put(":money_mouth_face", "🤑");
        emojiMap.put(":hugging_face", "🤗");
        emojiMap.put(":face_with_hand_over_mouth", "🤭");
        emojiMap.put(":thinking_face", "🤔");
        emojiMap.put(":zipper_mouth_face", "🤐");
        emojiMap.put(":raised_eyebrow", "🤨");
        emojiMap.put(":neutral_face", "😐");
        emojiMap.put(":expressionless_face", "😑");
        emojiMap.put(":face_without_mouth", "😶");
        emojiMap.put(":smirking_face", "😏");
        emojiMap.put(":unamused_face", "😒");
        emojiMap.put(":face_with_rolling_eyes", "🙄");
        emojiMap.put(":grimacing_face", "😬");
        emojiMap.put(":lying_face", "🤥");
        emojiMap.put(":relieved_face", "😌");
        emojiMap.put(":pensive_face", "😔");
        emojiMap.put(":sleepy_face", "😪");
        emojiMap.put(":drooling_face", "🤤");
        emojiMap.put(":sleeping_face", "😴");
        emojiMap.put(":face_with_medical_mask", "😷");
        emojiMap.put(":face_with_thermometer", "🤒");
        emojiMap.put(":face_with_head_bandage", "🤕");
        emojiMap.put(":nauseated_face", "🤢");
        emojiMap.put(":face_vomiting", "🤮");
        emojiMap.put(":sneezing_face", "🤧");
        emojiMap.put(":hot_face", "🥵");
        emojiMap.put(":sparkles", "✨");
        emojiMap.put(":dizzy", "💫");
        emojiMap.put(":crescent_moon", "🌙");
        emojiMap.put(":sun", "🌞");
        emojiMap.put(":wind_blowing_face", "💨");
        emojiMap.put(":rainbow", "🌈");
        emojiMap.put(":droplet", "💧");
        emojiMap.put(":splashing_sweat", "💦");
        emojiMap.put(":water_wave", "🌊");
        emojiMap.put(":green_apple", "🍏");
        emojiMap.put(":red_apple", "🍎");
        emojiMap.put(":pear", "🍐");
        emojiMap.put(":tangerine", "🍊");
        emojiMap.put(":lemon", "🍋");
        emojiMap.put(":banana", "🍌");
        emojiMap.put(":watermelon", "🍉");
        emojiMap.put(":grapes", "🍇");
        emojiMap.put(":strawberry", "🍓");
        emojiMap.put(":melon", "🍈");
        emojiMap.put(":cherries", "🍒");
        emojiMap.put(":peach", "🍑");
        emojiMap.put(":pineapple", "🍍");
        emojiMap.put(":tomato", "🍅");
        emojiMap.put(":eggplant", "🍆");
        emojiMap.put(":avocado", "🥑");
        emojiMap.put(":broccoli", "🥦");
        emojiMap.put(":corn", "🌽");
        emojiMap.put(":carrot", "🥕");
        emojiMap.put(":potato", "🥔");
        emojiMap.put(":sweet_potato", "🍠");
        emojiMap.put(":onion", "🧅");
        emojiMap.put(":garlic", "🧄");
        emojiMap.put(":cucumber", "🥒");
        emojiMap.put(":leafy_green", "🥬");
        emojiMap.put(":mushroom", "🍄");
        emojiMap.put(":peanuts", "🥜");
        emojiMap.put(":chestnut", "🌰");
        emojiMap.put(":bread", "🍞");
        emojiMap.put(":croissant", "🥐");
        emojiMap.put(":baguette_bread", "🥖");
        emojiMap.put(":bagel", "🥯");
        emojiMap.put(":pancakes", "🥞");
        emojiMap.put(":waffle", "🧇");
        emojiMap.put(":cheese_wedge", "🧀");
        emojiMap.put(":meat_on_bone", "🍖");
        emojiMap.put(":poultry_leg", "🍗");
        emojiMap.put(":cut_of_meat", "🥩");
        emojiMap.put(":hamburger", "🍔");
        emojiMap.put(":french_fries", "🍟");
        emojiMap.put(":pizza", "🍕");
        emojiMap.put(":hot_dog", "🌭");
        emojiMap.put(":sandwich", "🥪");
        emojiMap.put(":taco", "🌮");
        emojiMap.put(":burrito", "🌯");
        emojiMap.put(":stuffed_pita", "🥙");
        emojiMap.put(":egg", "🥚");
        emojiMap.put(":cooking", "🥘");
        emojiMap.put(":pot_of_food", "🍲");
        emojiMap.put(":bowl_with_spoon", "🥣");
        emojiMap.put(":green_salad", "🥗");
        emojiMap.put(":basket_of_bread", "🧺");
        emojiMap.put(":cupcake", "🧁");
        emojiMap.put(":pie", "🥧");
        emojiMap.put(":chopsticks", "🥢");
        emojiMap.put(":soccer_ball", "⚽");
        emojiMap.put(":basketball", "🏀");
        emojiMap.put(":football", "🏈");
        emojiMap.put(":baseball", "⚾");
        emojiMap.put(":softball", "🥎");
        emojiMap.put(":tennis", "🎾");
        emojiMap.put(":volleyball", "🏐");
        emojiMap.put(":rugby_football", "🏉");
        emojiMap.put(":billiards", "🎱");
        emojiMap.put(":ping_pong", "🏓");
        emojiMap.put(":badminton", "🏸");
        emojiMap.put(":ice_hockey", "🏒");
        emojiMap.put(":field_hockey", "🏑");
        emojiMap.put(":lacrosse", "🥍");
        emojiMap.put(":cricket", "🏏");
        emojiMap.put(":goal_net", "🥅");
        emojiMap.put(":golf", "⛳");
        emojiMap.put(":kite", "🪁");
        emojiMap.put(":bow_and_arrow", "🏹");
        emojiMap.put(":fishing_pole_and_fish", "🎣");
        emojiMap.put(":diving_mask", "🤿");
        emojiMap.put(":boxing_glove", "🥊");
        emojiMap.put(":martial_arts_uniform", "🥋");
        emojiMap.put(":running_shirt", "🎽");
        emojiMap.put(":curling_stone", "🥌");
        emojiMap.put(":skateboard", "🛹");
        emojiMap.put(":ski", "🎿");
        emojiMap.put(":sled", "🛷");
        emojiMap.put(":ice_skate", "⛸");
        emojiMap.put(":snowboard", "🏂");
        emojiMap.put(":trophy", "🏆");
        emojiMap.put(":first_place_medal", "🥇");
        emojiMap.put(":second_place_medal", "🥈");
        emojiMap.put(":third_place_medal", "🥉");
        emojiMap.put(":sports_medal", "🏅");
        emojiMap.put(":ticket", "🎫");
        emojiMap.put(":circus_tent", "🎪");
        emojiMap.put(":performing_arts", "🎭");
        emojiMap.put(":ballet_shoes", "🩰");
        emojiMap.put(":artist_palette", "🎨");
        emojiMap.put(":film_frames", "🎬");
        emojiMap.put(":microphone", "🎤");
        emojiMap.put(":headphone", "🎧");
        emojiMap.put(":musical_note", "🎼");
        emojiMap.put(":musical_keyboard", "🎹");
        emojiMap.put(":drum", "🥁");
        emojiMap.put(":saxophone", "🎷");
        emojiMap.put(":train", "🚂");
        emojiMap.put(":railway_car", "🚃");
        emojiMap.put(":high_speed_train", "🚄");
        emojiMap.put(":bullet_train", "🚅");
        emojiMap.put(":light_rail", "🚈");
        emojiMap.put(":metro", "🚇");
        emojiMap.put(":station", "🚉");
        emojiMap.put(":tram", "🚊");
        emojiMap.put(":monorail", "🚝");
        emojiMap.put(":tram_car", "🚞");
        emojiMap.put(":bus", "🚌");
        emojiMap.put(":oncoming_bus", "🚍");
        emojiMap.put(":trolleybus", "🚎");
        emojiMap.put(":minibus", "🚐");
        emojiMap.put(":ambulance", "🚑");
        emojiMap.put(":fire_engine", "🚒");
        emojiMap.put(":police_car", "🚓");
        emojiMap.put(":oncoming_police_car", "🚔");
        emojiMap.put(":taxi", "🚕");
        emojiMap.put(":oncoming_taxi", "🚖");
        emojiMap.put(":automobile", "🚗");
        emojiMap.put(":oncoming_automobile", "🚘");
        emojiMap.put(":sport_utility_vehicle", "🚙");
        emojiMap.put(":delivery_truck", "🚚");
        emojiMap.put(":articulated_lorry", "🚛");
        emojiMap.put(":tractor", "🚜");
        emojiMap.put(":motor_scooter", "🛵");
        emojiMap.put(":manual_wheelchair", "🦽");
        emojiMap.put(":motorized_wheelchair", "🦼");
        emojiMap.put(":kick_scooter", "🛴");
        emojiMap.put(":skateboard", "🛹");
        emojiMap.put(":ski", "🎿");
        emojiMap.put(":sled", "🛷");
        emojiMap.put(":ice_skate", "⛸");
        emojiMap.put(":snowboard", "🏂");
        emojiMap.put(":bus_stop", "🚏");
        emojiMap.put(":fuel_pump", "⛽");
        emojiMap.put(":police_car_light", "🚨");
        emojiMap.put(":horizontal_traffic_light", "🚥");
        emojiMap.put(":vertical_traffic_light", "🚦");
        emojiMap.put(":stop_sign", "🛑");
        emojiMap.put(":anchor", "⚓");
        emojiMap.put(":sailboat", "⛵");
        emojiMap.put(":canoe", "🛶");
        emojiMap.put(":speedboat", "🚤");
        emojiMap.put(":parachute", "🪂");
        emojiMap.put(":seat", "💺");
        emojiMap.put(":helicopter", "🚁");
        emojiMap.put(":suspension_railway", "🚟");
        emojiMap.put(":mountain_cableway", "🚠");
        emojiMap.put(":aerial_tramway", "🚡");
        emojiMap.put(":rocket", "🚀");
        emojiMap.put(":flying_saucer", "🛸");
        emojiMap.put(":globe_showing_Europe-Africa", "🌍");
        emojiMap.put(":globe_showing_Americas", "🌎");
        emojiMap.put(":globe_showing_Asia-Australia", "🌏");
        emojiMap.put(":globe_with_meridians", "🌐");
        emojiMap.put(":volcano", "🌋");
        emojiMap.put(":seaweed", "🗻");
        emojiMap.put(":brick", "🧱");
        emojiMap.put(":house", "🏠");
        emojiMap.put(":house_with_garden", "🏡");
        emojiMap.put(":office_building", "🏢");
        emojiMap.put(":Japanese_post_office", "🏣");
        emojiMap.put(":hospital", "🏥");
        emojiMap.put(":bank", "🏦");
        emojiMap.put(":hotel", "🏨");
        emojiMap.put(":love_hotel", "🏩");
        emojiMap.put(":convenience_store", "🏪");
        emojiMap.put(":school", "🏫");
        emojiMap.put(":department_store", "🏬");
        emojiMap.put(":factory", "🏭");
        emojiMap.put(":Japanese_castle", "🏯");
        emojiMap.put(":castle", "🏰");
        emojiMap.put(":wedding", "💒");
        emojiMap.put(":Tokyo_tower", "🗼");
        emojiMap.put(":Statue_of_Liberty", "🗽");
        emojiMap.put(":church", "⛪");
        emojiMap.put(":mosque", "🕌");
        emojiMap.put(":synagogue", "🕍");
        emojiMap.put(":Kaaba", "🕋");
        emojiMap.put(":fountain", "⛲");
        emojiMap.put(":tent", "⛺");
        emojiMap.put(":foggy", "🌁");
        emojiMap.put(":cityscape_at_dusk", "🌆");
        emojiMap.put(":sunrise_over_mountains", "🌄");
        emojiMap.put(":sunrise", "🌅");
        emojiMap.put(":cityscape_at_sunset", "🌇");
        emojiMap.put(":bridge_at_night", "🌉");
        emojiMap.put(":arrowleft", "←");
        emojiMap.put(":arrowup", "↑");
        emojiMap.put(":arrowright", "→");
        emojiMap.put(":arrowdown", "↓");

        getServer().getPluginManager().registerEvents(this, this);
        getCommand("emoji").setExecutor(this);
    }

    @Override
    public void onDisable() {
        emojiMap.clear();
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();

        for (String emoji : emojiMap.keySet()) {
            if (message.contains(emoji)) {
                message = message.replace(emoji, emojiMap.get(emoji));
            }
        }

        event.setMessage(message);
    }

    @EventHandler
    public void onSignChange(SignChangeEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("emojichat.use")) {
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

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("emoji") && args.length > 0 && args[0].equalsIgnoreCase("list")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("emojichat.use")) {
                    int pageNumber = 1; // Default page number

                    if (args.length > 1) {
                        try {
                            pageNumber = Integer.parseInt(args[1]);
                        } catch (NumberFormatException e) {
                            player.sendMessage(ChatColor.RED + "Invalid page number.");
                            return true;
                        }
                    }

                    int startIndex = (pageNumber - 1) * emojisPerPage;
                    int endIndex = startIndex + emojisPerPage;

                    player.sendMessage(ChatColor.GREEN + "Available Emojis - Page " + pageNumber + ":");

                    int count = 0;
                    for (Map.Entry<String, String> entry : emojiMap.entrySet()) {
                        if (count >= startIndex && count < endIndex) {
                            String emoji = entry.getKey();
                            String emojiText = entry.getValue();

                            TextComponent emojiComponent = new TextComponent(ChatColor.YELLOW + emoji + " - " + ChatColor.WHITE + emojiText);
                            emojiComponent.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, emoji));
                            emojiComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to copy!").create()));
                            player.spigot().sendMessage(emojiComponent);
                        }
                        count++;
                    }

                    int totalPages = (int) Math.ceil((double) emojiMap.size() / emojisPerPage);
                    if (totalPages > 1) {
                        TextComponent pageNavigation = new TextComponent();
                        if (pageNumber > 1) {
                            TextComponent previousPage = new TextComponent("◀ Previous ");
                            previousPage.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/emoji list " + (pageNumber - 1)));
                            pageNavigation.addExtra(previousPage);
                        }
                        pageNavigation.addExtra("Page " + pageNumber + " of " + totalPages);
                        if (pageNumber < totalPages) {
                            TextComponent nextPage = new TextComponent(" Next ▶");
                            nextPage.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/emoji list " + (pageNumber + 1)));
                            pageNavigation.addExtra(nextPage);
                        }
                        player.spigot().sendMessage(pageNavigation);
                    }

                    return true;
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                    return true;
                }
            } else {
                sender.sendMessage("This command can only be used by players.");
                return true;
            }
        }
        return false;
    }
}
