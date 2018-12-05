package xyz.xbeeegsone.outdatedprotocol.listeners;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.event.server.DataPacketSendEvent;
import cn.nukkit.network.protocol.*;
import xyz.xbeeegsone.outdatedprotocol.event.OutdatedPlayerLoginEvent;
import xyz.xbeeegsone.outdatedprotocol.network.ExtraLoginPacket;

public class PacketHandler implements Listener {

    @EventHandler
    public void onReceive(DataPacketReceiveEvent event) {
        DataPacket dataPacket = event.getPacket();
        Player player = event.getPlayer();
        switch (dataPacket.pid()) {
            case ExtraLoginPacket.NETWORK_ID:
                ExtraLoginPacket extraLoginPacket = (ExtraLoginPacket) dataPacket;
                if(extraLoginPacket.protocol < ProtocolInfo.CURRENT_PROTOCOL) {
                    Server.getInstance().getLogger().warning("debug");
                    Server.getInstance().getPluginManager().callEvent(new OutdatedPlayerLoginEvent(player));
                }
        }
    }

    @EventHandler
    public void onSend(DataPacketSendEvent event) {
        DataPacket dataPacket = event.getPacket();
        Player player = event.getPlayer();
        switch (dataPacket.pid()) {
            case  ProtocolInfo.UPDATE_BLOCK_PACKET:

                break;

            case  ProtocolInfo.LEVEL_SOUND_EVENT_PACKET:

                break;

            case  ProtocolInfo.LEVEL_EVENT_PACKET:

                break;

            case  ProtocolInfo.SET_ENTITY_DATA_PACKET:

                break;

            case  ProtocolInfo.FULL_CHUNK_DATA_PACKET:

                break;
        }
    }

}