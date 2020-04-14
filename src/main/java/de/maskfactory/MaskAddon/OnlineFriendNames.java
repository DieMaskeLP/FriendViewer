package de.maskfactory.MaskAddon;

import net.labymod.ingamegui.moduletypes.*;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class OnlineFriendNames extends SimpleTextModule {


    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.EMERALD_BLOCK);
    }

    @Override
    public void loadSettings() {

    }

    @Override
    public String getSettingName() {
        return "Friend Names";
    }

    @Override
    public String getControlName() {
        return "Online Friends";
    }

    @Override
    public String getDescription() {
        return "Shows the names of currently online friends.";
    }

    @Override
    public int getSortingId() {
        return 0;
    }

    @Override
    public String[] getValues() {
        String[] values = new String[Math.min(Main.maxFriends, Main.friendList.size())];
       //consider this: String[] values = Main.friendList.toArray(new String[0]);
        setKeyVisible(true);
        if (Main.friendNamesChat){
            if (Main.getInstance().getApi().isMinecraftChatOpen()){
                for (int i = 0; i < Main.friendList.size(); i++){
                    if (i < Main.maxFriends){
                        values[i] = Main.friendList.get(i);
                    }
                }
                return values;
            } else {
                setKeyVisible(false);
                return new String[0];
            }
        } else {
            setKeyVisible(true);
            for (int i = 0; i < Main.friendList.size(); i++){
                if (i < Main.maxFriends){
                    values[i] = Main.friendList.get(i);
                }
            }
            return values;
        }
    }

    @Override
    public String[] getDefaultValues() {
        return new String[0];
    }

    @Override
    public String[] getKeys() {
        String[] values = new String[Math.min(Main.maxFriends, Main.friendList.size())];
        setKeyVisible(true);
        if (Main.friendNamesChat){
            if (Main.getInstance().getApi().isMinecraftChatOpen()){
                for (int i = 0; i < Main.friendList.size(); i++){
                    if (i < Main.maxFriends)
                        values[i] = "F";
                }
                return values;
            } else {
                setKeyVisible(false);
                return new String[0];
            }
        } else {
            setKeyVisible(true);
            for (int i = 0; i < Main.friendList.size(); i++){
                if (i < Main.maxFriends)
                    values[i] = "F";
            }
            return values;
        }
    }

    @Override
    public String[] getDefaultKeys() {
        return new String[0];
    }
}
