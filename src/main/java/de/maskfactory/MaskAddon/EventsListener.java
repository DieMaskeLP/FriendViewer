package de.maskfactory.MaskAddon;

import net.labymod.core.ForgeAdapter;
import net.labymod.labyconnect.user.ChatRequest;
import net.labymod.labyconnect.user.ChatUser;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import java.util.ArrayList;
import java.util.List;
public class EventsListener {
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent e){
        //Add the online friends to a list and the amount of online friends to a integer
        List<String> friendList = new ArrayList<String>();
        int onlineFriends = 0;
        for (ChatUser f : Main.getInstance().getApi().getLabyModChatClient().getFriends()){
            if (f.isOnline()){
                onlineFriends++;
                friendList.add(f.getGameProfile().getName());
            }
        }
        Main.friendList = friendList;
        Main.onlineFriends = onlineFriends;
    }
}

