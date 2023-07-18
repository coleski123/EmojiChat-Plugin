package org.coleski123.emojichat;

import net.md_5.bungee.api.chat.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class EmojiChat extends JavaPlugin implements Listener, CommandExecutor {
    private Map<String, String> emojiMap;

    @Override
    public void onEnable() {
        emojiMap = new HashMap<>();
        emojiMap.put(":wave", ChatColor.YELLOW + "👋" + ChatColor.WHITE);
        emojiMap.put(":raised_hand", ChatColor.YELLOW + "🤚" + ChatColor.WHITE);
        emojiMap.put(":raised_fist", ChatColor.YELLOW + "✋" + ChatColor.WHITE);
        emojiMap.put(":vulcan_salute", ChatColor.YELLOW + "🖖" + ChatColor.WHITE);
        emojiMap.put(":ok_hand", ChatColor.YELLOW + "👌" + ChatColor.WHITE);
        emojiMap.put(":crossed_fingers", ChatColor.YELLOW + "🤞" + ChatColor.WHITE);
        emojiMap.put(":love_you_gesture", ChatColor.YELLOW + "🤟" + ChatColor.WHITE);
        emojiMap.put(":rock_on", ChatColor.YELLOW + "🤘" + ChatColor.WHITE);
        emojiMap.put(":call_me", ChatColor.YELLOW + "🤙" + ChatColor.WHITE);
        emojiMap.put(":point_left", ChatColor.YELLOW + "👈" + ChatColor.WHITE);
        emojiMap.put(":point_right", ChatColor.YELLOW + "👉" + ChatColor.WHITE);
        emojiMap.put(":point_up", ChatColor.YELLOW + "👆" + ChatColor.WHITE);
        emojiMap.put(":middle_finger", ChatColor.YELLOW + "🖕" + ChatColor.WHITE);
        emojiMap.put(":point_down", ChatColor.YELLOW + "👇" + ChatColor.WHITE);
        emojiMap.put(":selfie", ChatColor.YELLOW + "🤳" + ChatColor.WHITE);
        emojiMap.put(":nail_polish", ChatColor.YELLOW + "💅" + ChatColor.WHITE);
        emojiMap.put(":muscle", ChatColor.YELLOW + "💪" + ChatColor.WHITE);
        emojiMap.put(":leg", ChatColor.YELLOW + "🦵" + ChatColor.WHITE);
        emojiMap.put(":foot", ChatColor.YELLOW + "🦶" + ChatColor.WHITE);
        emojiMap.put(":ear", ChatColor.YELLOW + "👂" + ChatColor.WHITE);
        emojiMap.put(":nose", ChatColor.YELLOW + "👃" + ChatColor.WHITE);
        emojiMap.put(":footprints", ChatColor.YELLOW + "👣" + ChatColor.WHITE);
        emojiMap.put(":eyes", ChatColor.YELLOW + "👀" + ChatColor.WHITE);
        emojiMap.put(":tongue", ChatColor.YELLOW + "👅" + ChatColor.WHITE);
        emojiMap.put(":mouth", ChatColor.YELLOW + "👄" + ChatColor.WHITE);
        emojiMap.put(":lips", ChatColor.YELLOW + "💋" + ChatColor.WHITE);
        emojiMap.put(":glasses", ChatColor.YELLOW + "👓" + ChatColor.WHITE);
        emojiMap.put(":necktie", ChatColor.YELLOW + "👔" + ChatColor.WHITE);
        emojiMap.put(":shirt", ChatColor.YELLOW + "👕" + ChatColor.WHITE);
        emojiMap.put(":jeans", ChatColor.YELLOW + "👖" + ChatColor.WHITE);
        emojiMap.put(":scarf", ChatColor.YELLOW + "🧣" + ChatColor.WHITE);
        emojiMap.put(":gloves", ChatColor.YELLOW + "🧤" + ChatColor.WHITE);
        emojiMap.put(":coat", ChatColor.YELLOW + "🧥" + ChatColor.WHITE);
        emojiMap.put(":socks", ChatColor.YELLOW + "🧦" + ChatColor.WHITE);
        emojiMap.put(":dress", ChatColor.YELLOW + "👗" + ChatColor.WHITE);
        emojiMap.put(":kimono", ChatColor.YELLOW + "👘" + ChatColor.WHITE);
        emojiMap.put(":bikini", ChatColor.YELLOW + "👙" + ChatColor.WHITE);
        emojiMap.put(":blouse", ChatColor.YELLOW + "👚" + ChatColor.WHITE);
        emojiMap.put(":purse", ChatColor.YELLOW + "👛" + ChatColor.WHITE);
        emojiMap.put(":handbag", ChatColor.YELLOW + "👜" + ChatColor.WHITE);
        emojiMap.put(":clutch_bag", ChatColor.YELLOW + "👝" + ChatColor.WHITE);
        emojiMap.put(":backpack", ChatColor.YELLOW + "🎒" + ChatColor.WHITE);
        emojiMap.put(":man_shoe", ChatColor.YELLOW + "👞" + ChatColor.WHITE);
        emojiMap.put(":woman_shoe", ChatColor.YELLOW + "👟" + ChatColor.WHITE);
        emojiMap.put(":high_heeled_shoe", ChatColor.YELLOW + "👠" + ChatColor.WHITE);
        emojiMap.put(":woman_sandal", ChatColor.YELLOW + "👡" + ChatColor.WHITE);
        emojiMap.put(":woman_boot", ChatColor.YELLOW + "👢" + ChatColor.WHITE);
        emojiMap.put(":crown", ChatColor.YELLOW + "👑" + ChatColor.WHITE);
        emojiMap.put(":top_hat", ChatColor.YELLOW + "🎩" + ChatColor.WHITE);
        emojiMap.put(":graduation_cap", ChatColor.YELLOW + "🎓" + ChatColor.WHITE);
        emojiMap.put(":billed_cap", ChatColor.YELLOW + "🧢" + ChatColor.WHITE);
        emojiMap.put(":lipstick", ChatColor.YELLOW + "💄" + ChatColor.WHITE);
        emojiMap.put(":ring", ChatColor.YELLOW + "💍" + ChatColor.WHITE);
        emojiMap.put(":briefcase", ChatColor.YELLOW + "💼" + ChatColor.WHITE);
        emojiMap.put(":cold_face", ChatColor.YELLOW + "🥶" + ChatColor.WHITE);
        emojiMap.put(":woozy_face", ChatColor.YELLOW + "🥴" + ChatColor.WHITE);
        emojiMap.put(":dizzy_face", ChatColor.YELLOW + "😵" + ChatColor.WHITE);
        emojiMap.put(":exploding_head", ChatColor.YELLOW + "🤯" + ChatColor.WHITE);
        emojiMap.put(":cowboy_hat", ChatColor.YELLOW + "🤠" + ChatColor.WHITE);
        emojiMap.put(":partying_face", ChatColor.YELLOW + "🥳" + ChatColor.WHITE);
        emojiMap.put(":sunglasses", ChatColor.YELLOW + "😎" + ChatColor.WHITE);
        emojiMap.put(":nerd_face", ChatColor.YELLOW + "🤓" + ChatColor.WHITE);
        emojiMap.put(":monocle_face", ChatColor.YELLOW + "🧐" + ChatColor.WHITE);
        emojiMap.put(":confused_face", ChatColor.YELLOW + "😕" + ChatColor.WHITE);
        emojiMap.put(":worried_face", ChatColor.YELLOW + "😟" + ChatColor.WHITE);
        emojiMap.put(":slightly_frowning_face", ChatColor.YELLOW + "🙁" + ChatColor.WHITE);
        emojiMap.put(":open_mouth", ChatColor.YELLOW + "😮" + ChatColor.WHITE);
        emojiMap.put(":hushed_face", ChatColor.YELLOW + "😯" + ChatColor.WHITE);
        emojiMap.put(":astonished_face", ChatColor.YELLOW + "😲" + ChatColor.WHITE);
        emojiMap.put(":flushed_face", ChatColor.YELLOW + "😳" + ChatColor.WHITE);
        emojiMap.put(":pleading_face", ChatColor.YELLOW + "🥺" + ChatColor.WHITE);
        emojiMap.put(":frowning_face", ChatColor.YELLOW + "😦" + ChatColor.WHITE);
        emojiMap.put(":anguished_face", ChatColor.YELLOW + "😧" + ChatColor.WHITE);
        emojiMap.put(":fearful_face", ChatColor.YELLOW + "😨" + ChatColor.WHITE);
        emojiMap.put(":anxious_face", ChatColor.YELLOW + "😰" + ChatColor.WHITE);
        emojiMap.put(":sad_face", ChatColor.YELLOW + "😥" + ChatColor.WHITE);
        emojiMap.put(":crying_face", ChatColor.YELLOW + "😢" + ChatColor.WHITE);
        emojiMap.put(":loudly_crying_face", ChatColor.YELLOW + "😭" + ChatColor.WHITE);
        emojiMap.put(":screaming_face", ChatColor.YELLOW + "😱" + ChatColor.WHITE);
        emojiMap.put(":confounded_face", ChatColor.YELLOW + "😖" + ChatColor.WHITE);
        emojiMap.put(":persevering_face", ChatColor.YELLOW + "😣" + ChatColor.WHITE);
        emojiMap.put(":disappointed_face", ChatColor.YELLOW + "😞" + ChatColor.WHITE);
        emojiMap.put(":worried_face", ChatColor.YELLOW + "😓" + ChatColor.WHITE);
        emojiMap.put(":weary_face", ChatColor.YELLOW + "😩" + ChatColor.WHITE);
        emojiMap.put(":tired_face", ChatColor.YELLOW + "😫" + ChatColor.WHITE);
        emojiMap.put(":angry_face", ChatColor.YELLOW + "😤" + ChatColor.WHITE);
        emojiMap.put(":pouting_face", ChatColor.YELLOW + "😡" + ChatColor.WHITE);
        emojiMap.put(":angry_face", ChatColor.YELLOW + "😠" + ChatColor.WHITE);
        emojiMap.put(":face_with_symbols_over_mouth", ChatColor.YELLOW + "🤬" + ChatColor.WHITE);
        emojiMap.put(":smiling_face_with_horns", ChatColor.YELLOW + "😈" + ChatColor.WHITE);
        emojiMap.put(":angry_face_with_horns", ChatColor.YELLOW + "👿" + ChatColor.WHITE);
        emojiMap.put(":skull", ChatColor.YELLOW + "💀" + ChatColor.WHITE);
        emojiMap.put(":pile_of_poo", ChatColor.YELLOW + "💩" + ChatColor.WHITE);
        emojiMap.put(":clown_face", ChatColor.YELLOW + "🤡" + ChatColor.WHITE);
        emojiMap.put(":ogre", ChatColor.YELLOW + "👹" + ChatColor.WHITE);
        emojiMap.put(":goblin", ChatColor.YELLOW + "👺" + ChatColor.WHITE);
        emojiMap.put(":ghost", ChatColor.YELLOW + "👻" + ChatColor.WHITE);
        emojiMap.put(":alien", ChatColor.YELLOW + "👽" + ChatColor.WHITE);
        emojiMap.put(":alien_monster", ChatColor.YELLOW + "👾" + ChatColor.WHITE);
        emojiMap.put(":robot_face", ChatColor.YELLOW + "🤖" + ChatColor.WHITE);
        emojiMap.put(":cat_face", ChatColor.YELLOW + "😺" + ChatColor.WHITE);
        emojiMap.put(":grinning_cat_face", ChatColor.YELLOW + "😸" + ChatColor.WHITE);
        emojiMap.put(":cat_with_tears_of_joy", ChatColor.YELLOW + "😹" + ChatColor.WHITE);
        emojiMap.put(":smiling_cat_face_heart_eyes", ChatColor.YELLOW + "😻" + ChatColor.WHITE);
        emojiMap.put(":cat_with_wry_smile", ChatColor.YELLOW + "😼" + ChatColor.WHITE);
        emojiMap.put(":kissing_cat_face", ChatColor.YELLOW + "😽" + ChatColor.WHITE);
        emojiMap.put(":weary_cat_face", ChatColor.YELLOW + "🙀" + ChatColor.WHITE);
        emojiMap.put(":crying_cat_face", ChatColor.YELLOW + "😿" + ChatColor.WHITE);
        emojiMap.put(":pouting_cat_face", ChatColor.YELLOW + "😾" + ChatColor.WHITE);
        emojiMap.put(":smile", ChatColor.YELLOW + "😀" + ChatColor.WHITE);
        emojiMap.put(":grinning_face_with_big_eyes", ChatColor.YELLOW + "😃" + ChatColor.WHITE);
        emojiMap.put(":grinning_face_with_smiling_eyes", ChatColor.YELLOW + "😄" + ChatColor.WHITE);
        emojiMap.put(":smiling_face_with_open_mouth", ChatColor.YELLOW + "😁" + ChatColor.WHITE);
        emojiMap.put(":smiling_face_with_squinting_eyes", ChatColor.YELLOW + "😆" + ChatColor.WHITE);
        emojiMap.put(":smiling_face_with_tears_of_joy", ChatColor.YELLOW + "😅" + ChatColor.WHITE);
        emojiMap.put(":face_with_tears_of_joy", ChatColor.YELLOW + "😂" + ChatColor.WHITE);
        emojiMap.put(":smiling_face_with_halo", ChatColor.YELLOW + "😇" + ChatColor.WHITE);
        emojiMap.put(":winking_face", ChatColor.YELLOW + "😉" + ChatColor.WHITE);
        emojiMap.put(":smirk", ChatColor.YELLOW + "😏" + ChatColor.WHITE);
        emojiMap.put(":relieved_face", ChatColor.YELLOW + "😌" + ChatColor.WHITE);
        emojiMap.put(":smiling_face_with_heart_eyes", ChatColor.YELLOW + "😍" + ChatColor.WHITE);
        emojiMap.put(":smiling_face_with_smiling_eyes", ChatColor.YELLOW + "🥰" + ChatColor.WHITE);
        emojiMap.put(":kissing_face_with_closed_eyes", ChatColor.YELLOW + "😚" + ChatColor.WHITE);
        emojiMap.put(":face_savoring_food", ChatColor.YELLOW + "😋" + ChatColor.WHITE);
        emojiMap.put(":face_with_tongue", ChatColor.YELLOW + "😛" + ChatColor.WHITE);
        emojiMap.put(":wacky_face", ChatColor.YELLOW + "😜" + ChatColor.WHITE);
        emojiMap.put(":squinting_face_with_tongue", ChatColor.YELLOW + "😝" + ChatColor.WHITE);
        emojiMap.put(":money_mouth_face", ChatColor.YELLOW + "🤑" + ChatColor.WHITE);
        emojiMap.put(":hugging_face", ChatColor.YELLOW + "🤗" + ChatColor.WHITE);
        emojiMap.put(":face_with_hand_over_mouth", ChatColor.YELLOW + "🤭" + ChatColor.WHITE);
        emojiMap.put(":thinking_face", ChatColor.YELLOW + "🤔" + ChatColor.WHITE);
        emojiMap.put(":zipper_mouth_face", ChatColor.YELLOW + "🤐" + ChatColor.WHITE);
        emojiMap.put(":raised_eyebrow", ChatColor.YELLOW + "🤨" + ChatColor.WHITE);
        emojiMap.put(":neutral_face", ChatColor.YELLOW + "😐" + ChatColor.WHITE);
        emojiMap.put(":expressionless_face", ChatColor.YELLOW + "😑" + ChatColor.WHITE);
        emojiMap.put(":face_without_mouth", ChatColor.YELLOW + "😶" + ChatColor.WHITE);
        emojiMap.put(":smirking_face", ChatColor.YELLOW + "😏" + ChatColor.WHITE);
        emojiMap.put(":unamused_face", ChatColor.YELLOW + "😒" + ChatColor.WHITE);
        emojiMap.put(":face_with_rolling_eyes", ChatColor.YELLOW + "🙄" + ChatColor.WHITE);
        emojiMap.put(":grimacing_face", ChatColor.YELLOW + "😬" + ChatColor.WHITE);
        emojiMap.put(":lying_face", ChatColor.YELLOW + "🤥" + ChatColor.WHITE);
        emojiMap.put(":relieved_face", ChatColor.YELLOW + "😌" + ChatColor.WHITE);
        emojiMap.put(":pensive_face", ChatColor.YELLOW + "😔" + ChatColor.WHITE);
        emojiMap.put(":sleepy_face", ChatColor.YELLOW + "😪" + ChatColor.WHITE);
        emojiMap.put(":drooling_face", ChatColor.YELLOW + "🤤" + ChatColor.WHITE);
        emojiMap.put(":sleeping_face", ChatColor.YELLOW + "😴" + ChatColor.WHITE);
        emojiMap.put(":face_with_medical_mask", ChatColor.YELLOW + "😷" + ChatColor.WHITE);
        emojiMap.put(":face_with_thermometer", ChatColor.YELLOW + "🤒" + ChatColor.WHITE);
        emojiMap.put(":face_with_head_bandage", ChatColor.YELLOW + "🤕" + ChatColor.WHITE);
        emojiMap.put(":nauseated_face", ChatColor.YELLOW + "🤢" + ChatColor.WHITE);
        emojiMap.put(":face_vomiting", ChatColor.YELLOW + "🤮" + ChatColor.WHITE);
        emojiMap.put(":sneezing_face", ChatColor.YELLOW + "🤧" + ChatColor.WHITE);
        emojiMap.put(":hot_face", ChatColor.YELLOW + "🥵" + ChatColor.WHITE);
        emojiMap.put(":sparkles", ChatColor.YELLOW + "✨" + ChatColor.WHITE);
        emojiMap.put(":dizzy", ChatColor.YELLOW + "💫" + ChatColor.WHITE);
        emojiMap.put(":crescent_moon", ChatColor.YELLOW + "🌙" + ChatColor.WHITE);
        emojiMap.put(":sun", ChatColor.YELLOW + "🌞" + ChatColor.WHITE);
        emojiMap.put(":wind_blowing_face", ChatColor.YELLOW + "💨" + ChatColor.WHITE);
        emojiMap.put(":rainbow", ChatColor.YELLOW + "🌈" + ChatColor.WHITE);
        emojiMap.put(":droplet", ChatColor.YELLOW + "💧" + ChatColor.WHITE);
        emojiMap.put(":splashing_sweat", ChatColor.YELLOW + "💦" + ChatColor.WHITE);
        emojiMap.put(":water_wave", ChatColor.YELLOW + "🌊" + ChatColor.WHITE);
        emojiMap.put(":green_apple", ChatColor.YELLOW + "🍏" + ChatColor.WHITE);
        emojiMap.put(":red_apple", ChatColor.YELLOW + "🍎" + ChatColor.WHITE);
        emojiMap.put(":pear", ChatColor.YELLOW + "🍐" + ChatColor.WHITE);
        emojiMap.put(":tangerine", ChatColor.YELLOW + "🍊" + ChatColor.WHITE);
        emojiMap.put(":lemon", ChatColor.YELLOW + "🍋" + ChatColor.WHITE);
        emojiMap.put(":banana", ChatColor.YELLOW + "🍌" + ChatColor.WHITE);
        emojiMap.put(":watermelon", ChatColor.YELLOW + "🍉" + ChatColor.WHITE);
        emojiMap.put(":grapes", ChatColor.YELLOW + "🍇" + ChatColor.WHITE);
        emojiMap.put(":strawberry", ChatColor.YELLOW + "🍓" + ChatColor.WHITE);
        emojiMap.put(":melon", ChatColor.YELLOW + "🍈" + ChatColor.WHITE);
        emojiMap.put(":cherries", ChatColor.YELLOW + "🍒" + ChatColor.WHITE);
        emojiMap.put(":peach", ChatColor.YELLOW + "🍑" + ChatColor.WHITE);
        emojiMap.put(":pineapple", ChatColor.YELLOW + "🍍" + ChatColor.WHITE);
        emojiMap.put(":tomato", ChatColor.YELLOW + "🍅" + ChatColor.WHITE);
        emojiMap.put(":eggplant", ChatColor.YELLOW + "🍆" + ChatColor.WHITE);
        emojiMap.put(":avocado", ChatColor.YELLOW + "🥑" + ChatColor.WHITE);
        emojiMap.put(":broccoli", ChatColor.YELLOW + "🥦" + ChatColor.WHITE);
        emojiMap.put(":corn", ChatColor.YELLOW + "🌽" + ChatColor.WHITE);
        emojiMap.put(":carrot", ChatColor.YELLOW + "🥕" + ChatColor.WHITE);
        emojiMap.put(":potato", ChatColor.YELLOW + "🥔" + ChatColor.WHITE);
        emojiMap.put(":sweet_potato", ChatColor.YELLOW + "🍠" + ChatColor.WHITE);
        emojiMap.put(":onion", ChatColor.YELLOW + "🧅" + ChatColor.WHITE);
        emojiMap.put(":garlic", ChatColor.YELLOW + "🧄" + ChatColor.WHITE);
        emojiMap.put(":cucumber", ChatColor.YELLOW + "🥒" + ChatColor.WHITE);
        emojiMap.put(":leafy_green", ChatColor.YELLOW + "🥬" + ChatColor.WHITE);
        emojiMap.put(":mushroom", ChatColor.YELLOW + "🍄" + ChatColor.WHITE);
        emojiMap.put(":peanuts", ChatColor.YELLOW + "🥜" + ChatColor.WHITE);
        emojiMap.put(":chestnut", ChatColor.YELLOW + "🌰" + ChatColor.WHITE);
        emojiMap.put(":bread", ChatColor.YELLOW + "🍞" + ChatColor.WHITE);
        emojiMap.put(":croissant", ChatColor.YELLOW + "🥐" + ChatColor.WHITE);
        emojiMap.put(":baguette_bread", ChatColor.YELLOW + "🥖" + ChatColor.WHITE);
        emojiMap.put(":bagel", ChatColor.YELLOW + "🥯" + ChatColor.WHITE);
        emojiMap.put(":pancakes", ChatColor.YELLOW + "🥞" + ChatColor.WHITE);
        emojiMap.put(":waffle", ChatColor.YELLOW + "🧇" + ChatColor.WHITE);
        emojiMap.put(":cheese_wedge", ChatColor.YELLOW + "🧀" + ChatColor.WHITE);
        emojiMap.put(":meat_on_bone", ChatColor.YELLOW + "🍖" + ChatColor.WHITE);
        emojiMap.put(":poultry_leg", ChatColor.YELLOW + "🍗" + ChatColor.WHITE);
        emojiMap.put(":cut_of_meat", ChatColor.YELLOW + "🥩" + ChatColor.WHITE);
        emojiMap.put(":hamburger", ChatColor.YELLOW + "🍔" + ChatColor.WHITE);
        emojiMap.put(":french_fries", ChatColor.YELLOW + "🍟" + ChatColor.WHITE);
        emojiMap.put(":pizza", ChatColor.YELLOW + "🍕" + ChatColor.WHITE);
        emojiMap.put(":hot_dog", ChatColor.YELLOW + "🌭" + ChatColor.WHITE);
        emojiMap.put(":sandwich", ChatColor.YELLOW + "🥪" + ChatColor.WHITE);
        emojiMap.put(":taco", ChatColor.YELLOW + "🌮" + ChatColor.WHITE);
        emojiMap.put(":burrito", ChatColor.YELLOW + "🌯" + ChatColor.WHITE);
        emojiMap.put(":stuffed_pita", ChatColor.YELLOW + "🥙" + ChatColor.WHITE);
        emojiMap.put(":egg", ChatColor.YELLOW + "🥚" + ChatColor.WHITE);
        emojiMap.put(":cooking", ChatColor.YELLOW + "🥘" + ChatColor.WHITE);
        emojiMap.put(":pot_of_food", ChatColor.YELLOW + "🍲" + ChatColor.WHITE);
        emojiMap.put(":bowl_with_spoon", ChatColor.YELLOW + "🥣" + ChatColor.WHITE);
        emojiMap.put(":green_salad", ChatColor.YELLOW + "🥗" + ChatColor.WHITE);
        emojiMap.put(":basket_of_bread", ChatColor.YELLOW + "🧺" + ChatColor.WHITE);
        emojiMap.put(":cupcake", ChatColor.YELLOW + "🧁" + ChatColor.WHITE);
        emojiMap.put(":pie", ChatColor.YELLOW + "🥧" + ChatColor.WHITE);
        emojiMap.put(":chopsticks", ChatColor.YELLOW + "🥢" + ChatColor.WHITE);
        emojiMap.put(":soccer_ball", ChatColor.YELLOW + "⚽" + ChatColor.WHITE);
        emojiMap.put(":basketball", ChatColor.YELLOW + "🏀" + ChatColor.WHITE);
        emojiMap.put(":football", ChatColor.YELLOW + "🏈" + ChatColor.WHITE);
        emojiMap.put(":baseball", ChatColor.YELLOW + "⚾" + ChatColor.WHITE);
        emojiMap.put(":softball", ChatColor.YELLOW + "🥎" + ChatColor.WHITE);
        emojiMap.put(":tennis", ChatColor.YELLOW + "🎾" + ChatColor.WHITE);
        emojiMap.put(":volleyball", ChatColor.YELLOW + "🏐" + ChatColor.WHITE);
        emojiMap.put(":rugby_football", ChatColor.YELLOW + "🏉" + ChatColor.WHITE);
        emojiMap.put(":billiards", ChatColor.YELLOW + "🎱" + ChatColor.WHITE);
        emojiMap.put(":ping_pong", ChatColor.YELLOW + "🏓" + ChatColor.WHITE);
        emojiMap.put(":badminton", ChatColor.YELLOW + "🏸" + ChatColor.WHITE);
        emojiMap.put(":ice_hockey", ChatColor.YELLOW + "🏒" + ChatColor.WHITE);
        emojiMap.put(":field_hockey", ChatColor.YELLOW + "🏑" + ChatColor.WHITE);
        emojiMap.put(":lacrosse", ChatColor.YELLOW + "🥍" + ChatColor.WHITE);
        emojiMap.put(":cricket", ChatColor.YELLOW + "🏏" + ChatColor.WHITE);
        emojiMap.put(":goal_net", ChatColor.YELLOW + "🥅" + ChatColor.WHITE);
        emojiMap.put(":golf", ChatColor.YELLOW + "⛳" + ChatColor.WHITE);
        emojiMap.put(":kite", ChatColor.YELLOW + "🪁" + ChatColor.WHITE);
        emojiMap.put(":bow_and_arrow", ChatColor.YELLOW + "🏹" + ChatColor.WHITE);
        emojiMap.put(":fishing_pole_and_fish", ChatColor.YELLOW + "🎣" + ChatColor.WHITE);
        emojiMap.put(":diving_mask", ChatColor.YELLOW + "🤿" + ChatColor.WHITE);
        emojiMap.put(":boxing_glove", ChatColor.YELLOW + "🥊" + ChatColor.WHITE);
        emojiMap.put(":martial_arts_uniform", ChatColor.YELLOW + "🥋" + ChatColor.WHITE);
        emojiMap.put(":running_shirt", ChatColor.YELLOW + "🎽" + ChatColor.WHITE);
        emojiMap.put(":curling_stone", ChatColor.YELLOW + "🥌" + ChatColor.WHITE);
        emojiMap.put(":skateboard", ChatColor.YELLOW + "🛹" + ChatColor.WHITE);
        emojiMap.put(":ski", ChatColor.YELLOW + "🎿" + ChatColor.WHITE);
        emojiMap.put(":sled", ChatColor.YELLOW + "🛷" + ChatColor.WHITE);
        emojiMap.put(":ice_skate", ChatColor.YELLOW + "⛸" + ChatColor.WHITE);
        emojiMap.put(":snowboard", ChatColor.YELLOW + "🏂" + ChatColor.WHITE);
        emojiMap.put(":trophy", ChatColor.YELLOW + "🏆" + ChatColor.WHITE);
        emojiMap.put(":first_place_medal", ChatColor.YELLOW + "🥇" + ChatColor.WHITE);
        emojiMap.put(":second_place_medal", ChatColor.YELLOW + "🥈" + ChatColor.WHITE);
        emojiMap.put(":third_place_medal", ChatColor.YELLOW + "🥉" + ChatColor.WHITE);
        emojiMap.put(":sports_medal", ChatColor.YELLOW + "🏅" + ChatColor.WHITE);
        emojiMap.put(":ticket", ChatColor.YELLOW + "🎫" + ChatColor.WHITE);
        emojiMap.put(":circus_tent", ChatColor.YELLOW + "🎪" + ChatColor.WHITE);
        emojiMap.put(":performing_arts", ChatColor.YELLOW + "🎭" + ChatColor.WHITE);
        emojiMap.put(":ballet_shoes", ChatColor.YELLOW + "🩰" + ChatColor.WHITE);
        emojiMap.put(":artist_palette", ChatColor.YELLOW + "🎨" + ChatColor.WHITE);
        emojiMap.put(":film_frames", ChatColor.YELLOW + "🎬" + ChatColor.WHITE);
        emojiMap.put(":microphone", ChatColor.YELLOW + "🎤" + ChatColor.WHITE);
        emojiMap.put(":headphone", ChatColor.YELLOW + "🎧" + ChatColor.WHITE);
        emojiMap.put(":musical_note", ChatColor.YELLOW + "🎼" + ChatColor.WHITE);
        emojiMap.put(":musical_keyboard", ChatColor.YELLOW + "🎹" + ChatColor.WHITE);
        emojiMap.put(":drum", ChatColor.YELLOW + "🥁" + ChatColor.WHITE);
        emojiMap.put(":saxophone", ChatColor.YELLOW + "🎷" + ChatColor.WHITE);
        emojiMap.put(":train", ChatColor.YELLOW + "🚂" + ChatColor.WHITE);
        emojiMap.put(":railway_car", ChatColor.YELLOW + "🚃" + ChatColor.WHITE);
        emojiMap.put(":high_speed_train", ChatColor.YELLOW + "🚄" + ChatColor.WHITE);
        emojiMap.put(":bullet_train", ChatColor.YELLOW + "🚅" + ChatColor.WHITE);
        emojiMap.put(":light_rail", ChatColor.YELLOW + "🚈" + ChatColor.WHITE);
        emojiMap.put(":metro", ChatColor.YELLOW + "🚇" + ChatColor.WHITE);
        emojiMap.put(":station", ChatColor.YELLOW + "🚉" + ChatColor.WHITE);
        emojiMap.put(":tram", ChatColor.YELLOW + "🚊" + ChatColor.WHITE);
        emojiMap.put(":monorail", ChatColor.YELLOW + "🚝" + ChatColor.WHITE);
        emojiMap.put(":tram_car", ChatColor.YELLOW + "🚞" + ChatColor.WHITE);
        emojiMap.put(":bus", ChatColor.YELLOW + "🚌" + ChatColor.WHITE);
        emojiMap.put(":oncoming_bus", ChatColor.YELLOW + "🚍" + ChatColor.WHITE);
        emojiMap.put(":trolleybus", ChatColor.YELLOW + "🚎" + ChatColor.WHITE);
        emojiMap.put(":minibus", ChatColor.YELLOW + "🚐" + ChatColor.WHITE);
        emojiMap.put(":ambulance", ChatColor.YELLOW + "🚑" + ChatColor.WHITE);
        emojiMap.put(":fire_engine", ChatColor.YELLOW + "🚒" + ChatColor.WHITE);
        emojiMap.put(":police_car", ChatColor.YELLOW + "🚓" + ChatColor.WHITE);
        emojiMap.put(":oncoming_police_car", ChatColor.YELLOW + "🚔" + ChatColor.WHITE);
        emojiMap.put(":taxi", ChatColor.YELLOW + "🚕" + ChatColor.WHITE);
        emojiMap.put(":oncoming_taxi", ChatColor.YELLOW + "🚖" + ChatColor.WHITE);
        emojiMap.put(":automobile", ChatColor.YELLOW + "🚗" + ChatColor.WHITE);
        emojiMap.put(":oncoming_automobile", ChatColor.YELLOW + "🚘" + ChatColor.WHITE);
        emojiMap.put(":sport_utility_vehicle", ChatColor.YELLOW + "🚙" + ChatColor.WHITE);
        emojiMap.put(":delivery_truck", ChatColor.YELLOW + "🚚" + ChatColor.WHITE);
        emojiMap.put(":articulated_lorry", ChatColor.YELLOW + "🚛" + ChatColor.WHITE);
        emojiMap.put(":tractor", ChatColor.YELLOW + "🚜" + ChatColor.WHITE);
        emojiMap.put(":motor_scooter", ChatColor.YELLOW + "🛵" + ChatColor.WHITE);
        emojiMap.put(":manual_wheelchair", ChatColor.YELLOW + "🦽" + ChatColor.WHITE);
        emojiMap.put(":motorized_wheelchair", ChatColor.YELLOW + "🦼" + ChatColor.WHITE);
        emojiMap.put(":kick_scooter", ChatColor.YELLOW + "🛴" + ChatColor.WHITE);
        emojiMap.put(":skateboard", ChatColor.YELLOW + "🛹" + ChatColor.WHITE);
        emojiMap.put(":ski", ChatColor.YELLOW + "🎿" + ChatColor.WHITE);
        emojiMap.put(":sled", ChatColor.YELLOW + "🛷" + ChatColor.WHITE);
        emojiMap.put(":ice_skate", ChatColor.YELLOW + "⛸" + ChatColor.WHITE);
        emojiMap.put(":snowboard", ChatColor.YELLOW + "🏂" + ChatColor.WHITE);
        emojiMap.put(":bus_stop", ChatColor.YELLOW + "🚏" + ChatColor.WHITE);
        emojiMap.put(":fuel_pump", ChatColor.YELLOW + "⛽" + ChatColor.WHITE);
        emojiMap.put(":police_car_light", ChatColor.YELLOW + "🚨" + ChatColor.WHITE);
        emojiMap.put(":horizontal_traffic_light", ChatColor.YELLOW + "🚥" + ChatColor.WHITE);
        emojiMap.put(":vertical_traffic_light", ChatColor.YELLOW + "🚦" + ChatColor.WHITE);
        emojiMap.put(":stop_sign", ChatColor.YELLOW + "🛑" + ChatColor.WHITE);
        emojiMap.put(":anchor", ChatColor.YELLOW + "⚓" + ChatColor.WHITE);
        emojiMap.put(":sailboat", ChatColor.YELLOW + "⛵" + ChatColor.WHITE);
        emojiMap.put(":canoe", ChatColor.YELLOW + "🛶" + ChatColor.WHITE);
        emojiMap.put(":speedboat", ChatColor.YELLOW + "🚤" + ChatColor.WHITE);
        emojiMap.put(":parachute", ChatColor.YELLOW + "🪂" + ChatColor.WHITE);
        emojiMap.put(":seat", ChatColor.YELLOW + "💺" + ChatColor.WHITE);
        emojiMap.put(":helicopter", ChatColor.YELLOW + "🚁" + ChatColor.WHITE);
        emojiMap.put(":suspension_railway", ChatColor.YELLOW + "🚟" + ChatColor.WHITE);
        emojiMap.put(":mountain_cableway", ChatColor.YELLOW + "🚠" + ChatColor.WHITE);
        emojiMap.put(":aerial_tramway", ChatColor.YELLOW + "🚡" + ChatColor.WHITE);
        emojiMap.put(":rocket", ChatColor.YELLOW + "🚀" + ChatColor.WHITE);
        emojiMap.put(":flying_saucer", ChatColor.YELLOW + "🛸" + ChatColor.WHITE);
        emojiMap.put(":globe_showing_Europe-Africa", ChatColor.YELLOW + "🌍" + ChatColor.WHITE);
        emojiMap.put(":globe_showing_Americas", ChatColor.YELLOW + "🌎" + ChatColor.WHITE);
        emojiMap.put(":globe_showing_Asia-Australia", ChatColor.YELLOW + "🌏" + ChatColor.WHITE);
        emojiMap.put(":globe_with_meridians", ChatColor.YELLOW + "🌐" + ChatColor.WHITE);
        emojiMap.put(":volcano", ChatColor.YELLOW + "🌋" + ChatColor.WHITE);
        emojiMap.put(":seaweed", ChatColor.YELLOW + "🗻" + ChatColor.WHITE);
        emojiMap.put(":brick", ChatColor.YELLOW + "🧱" + ChatColor.WHITE);
        emojiMap.put(":house", ChatColor.YELLOW + "🏠" + ChatColor.WHITE);
        emojiMap.put(":house_with_garden", ChatColor.YELLOW + "🏡" + ChatColor.WHITE);
        emojiMap.put(":office_building", ChatColor.YELLOW + "🏢" + ChatColor.WHITE);
        emojiMap.put(":Japanese_post_office", ChatColor.YELLOW + "🏣" + ChatColor.WHITE);
        emojiMap.put(":hospital", ChatColor.YELLOW + "🏥" + ChatColor.WHITE);
        emojiMap.put(":bank", ChatColor.YELLOW + "🏦" + ChatColor.WHITE);
        emojiMap.put(":hotel", ChatColor.YELLOW + "🏨" + ChatColor.WHITE);
        emojiMap.put(":love_hotel", ChatColor.YELLOW + "🏩" + ChatColor.WHITE);
        emojiMap.put(":convenience_store", ChatColor.YELLOW + "🏪" + ChatColor.WHITE);
        emojiMap.put(":school", ChatColor.YELLOW + "🏫" + ChatColor.WHITE);
        emojiMap.put(":department_store", ChatColor.YELLOW + "🏬" + ChatColor.WHITE);
        emojiMap.put(":factory", ChatColor.YELLOW + "🏭" + ChatColor.WHITE);
        emojiMap.put(":Japanese_castle", ChatColor.YELLOW + "🏯" + ChatColor.WHITE);
        emojiMap.put(":castle", ChatColor.YELLOW + "🏰" + ChatColor.WHITE);
        emojiMap.put(":wedding", ChatColor.YELLOW + "💒" + ChatColor.WHITE);
        emojiMap.put(":Tokyo_tower", ChatColor.YELLOW + "🗼" + ChatColor.WHITE);
        emojiMap.put(":Statue_of_Liberty", ChatColor.YELLOW + "🗽" + ChatColor.WHITE);
        emojiMap.put(":church", ChatColor.YELLOW + "⛪" + ChatColor.WHITE);
        emojiMap.put(":mosque", ChatColor.YELLOW + "🕌" + ChatColor.WHITE);
        emojiMap.put(":synagogue", ChatColor.YELLOW + "🕍" + ChatColor.WHITE);
        emojiMap.put(":Kaaba", ChatColor.YELLOW + "🕋" + ChatColor.WHITE);
        emojiMap.put(":fountain", ChatColor.YELLOW + "⛲" + ChatColor.WHITE);
        emojiMap.put(":tent", ChatColor.YELLOW + "⛺" + ChatColor.WHITE);
        emojiMap.put(":foggy", ChatColor.YELLOW + "🌁" + ChatColor.WHITE);
        emojiMap.put(":cityscape_at_dusk", ChatColor.YELLOW + "🌆" + ChatColor.WHITE);
        emojiMap.put(":sunrise_over_mountains", ChatColor.YELLOW + "🌄" + ChatColor.WHITE);
        emojiMap.put(":sunrise", ChatColor.YELLOW + "🌅" + ChatColor.WHITE);
        emojiMap.put(":cityscape_at_sunset", ChatColor.YELLOW + "🌇" + ChatColor.WHITE);
        emojiMap.put(":bridge_at_night", ChatColor.YELLOW + "🌉" + ChatColor.WHITE);

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
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("emoji") && args.length > 0 && args[0].equalsIgnoreCase("list")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("emojichat.use")) {
                    int emojisPerPage = 10; // Number of emojis to display per page
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

                            TextComponent emojiComponent = new TextComponent(ChatColor.YELLOW + emoji + " - " + emojiText);
                            emojiComponent.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, emoji));
                            emojiComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to copy!").create()));
                            player.spigot().sendMessage(emojiComponent);
                        }
                        count++;
                    }

                    int totalPages = (int) Math.ceil((double) emojiMap.size() / emojisPerPage);
                    if (totalPages > 1) {
                        player.sendMessage(ChatColor.GREEN + "Page " + pageNumber + " of " + totalPages);
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
