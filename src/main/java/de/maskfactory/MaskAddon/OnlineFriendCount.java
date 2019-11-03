package de.maskfactory.MaskAddon;

import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

public class OnlineFriendCount extends SimpleModule {
    @Override
    public String getDisplayName() {
        if (Main.friendAmountChat){
            setKeyVisible(true);
            if (Main.getInstance().getApi().isMinecraftChatOpen()){
                return "Friends Online";
            } else setKeyVisible(false);
        } else {
            return "Friends Online";
        }
        return null;
    }

    @Override
    public String getDisplayValue() {
        if (Main.friendAmountChat) {
            if (Main.getInstance().getApi().isMinecraftChatOpen()) {
                return Main.onlineFriends + "/" + Main.getInstance().getApi().getLabyModChatClient().getFriends().size();
            }
        } else return Main.onlineFriends + "/" + Main.getInstance().getApi().getLabyModChatClient().getFriends().size();
        return null;
    }

    @Override
    public String getDefaultValue() {
        if (Main.friendAmountChat){
            if (Main.getInstance().getApi().isMinecraftChatOpen()){
                return "0";
            }
        } else return "0";
        return null;
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.EMERALD);
    }



    @Override
    public void loadSettings() {

    }

    @Override
    public String getSettingName() {
        return "Online Friends";
    }

    @Override
    public String getDescription() {
        return "Shows you the amount of the friend, wich are online.";
    }

    @Override
    public int getSortingId() {
        return 0;
    }
}
