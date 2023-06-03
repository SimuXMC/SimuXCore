package com.github.simux.simuxcore.chat;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public class ComponentUtils {

    private static final LegacyComponentSerializer legacyComponentSerializer = LegacyComponentSerializer.legacyAmpersand();
    private static final MiniMessage miniMessage = MiniMessage.miniMessage();

    public static String componentToString(Component component) {
        return legacyComponentSerializer.serialize(component);
    }

    public static Component componentFromString(String input) {
        return miniMessage.deserialize(input);
    }

}
