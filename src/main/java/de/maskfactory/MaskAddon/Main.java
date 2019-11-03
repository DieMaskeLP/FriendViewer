package de.maskfactory.MaskAddon;

import net.labymod.api.LabyModAddon;
import net.labymod.api.events.MessageModifyChatEvent;
import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.api.events.MessageSendEvent;
import net.labymod.labyconnect.user.ChatUser;
import net.labymod.settings.elements.*;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;
import net.labymod.utils.ServerData;

import java.util.ArrayList;
import java.util.List;

public class Main extends LabyModAddon {

    public static int onlineFriends = 0;
    public static List<String> friendList = new ArrayList<String>();
    public static boolean friendNamesChat = false, friendAmountChat = false;
    public static int maxFriends = 10;

    public static LabyModAddon getInstance() {
        return instance;
    }

    private static LabyModAddon instance;



    @Override
    public void onEnable() {
        getApi().registerModule(new OnlineFriendNames());
        getApi().registerModule(new OnlineFriendCount());
        instance = this;
        getApi().registerForgeListener(new EventsListener());
    }

    @Override
    public void loadConfig() {
        friendAmountChat = getConfig().has("friendAmountChat") && getConfig().get("friendAmountChat").getAsBoolean();
        friendNamesChat = getConfig().has("friendNamesChat") && getConfig().get("friendNamesChat").getAsBoolean();
        maxFriends = getConfig().has("maxFriends") ? getConfig().get("maxFriends").getAsInt() : 10;
    }


    @Override
    protected void fillSettings(List<SettingsElement> list) {
        list.add( new BooleanElement( "Show Friends only when the Chat is open", this, new ControlElement.IconData( Material.EMERALD_BLOCK ), "friendNamesChat", friendNamesChat ) );
        list.add( new BooleanElement( "Online Friends Amount only when the Chat is open", this, new ControlElement.IconData( Material.EMERALD ), "friendAmountChat", friendAmountChat));
        list.add( new SliderElement( "Max. Friends to show", this, new ControlElement.IconData( Material.ITEM_FRAME ), "maxFriends", maxFriends).setRange(1, 30));
    }
}
