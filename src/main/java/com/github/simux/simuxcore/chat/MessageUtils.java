package com.github.simux.simuxcore.chat;

import org.bukkit.command.CommandSender;

public class MessageUtils {

    public enum Color {
        PREFIX_COLOR("<#00C678>"),
        ACCENT_COLOR("<#9FFFD9>"),
        CONTENT_COLOR("<#CDEBDF>"),
        ERROR_MAIN("<#FF0036>"),
        ERROR_CONTENT("<#FFDAE2>");

        private final String color;

        Color(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return color;
        }

    }

    private MessageUtils() {
        throw new IllegalStateException("A utility class should not be instantiated.");
    }

    /**
     * Utility method used to make sending message feedback to players a tad less painful <br>
     * All parameters will be serialized by minimessage, so strip tags beforehand accordingly.
     *
     * @param sender The person who the message will be sent to
     * @param prefix The prefix that will be colored with {@link Color#PREFIX_COLOR} and bolded
     * @param content The content that will be after the prefix, not bolded, colored with {@link Color#CONTENT_COLOR}
     */
    public static void sendFeedback(CommandSender sender, String prefix, String content) {
        sendFeedback(sender, Color.PREFIX_COLOR.color, Color.CONTENT_COLOR.color, prefix, content);
    }

    /**
     * Utility method used to make sending message feedback to players a tad less painful <br>
     * Has more parameters to allow for customization of the feedback, while keeping it relatively streamlined <br>
     * All parameters will be serialized by minimessage, so strip tags beforehand accordingly.
     *
     * @param sender The person who the message will be sent to
     * @param prefixColor The color that the prefix will be
     * @param contentColor The color that the content of the message will be at first
     * @param prefix The prefix to be colored and bolded with the prefixColor
     * @param content The content what will be after the prefix, not bolded, colored with contentColor
     */
    public static void sendFeedback(CommandSender sender, String prefixColor, String contentColor, String prefix, String content) {
        sender.sendMessage(ComponentUtils.componentFromString(
                prefixColor +  "<b>" + prefix + "</b> "+ contentColor + content));
    }

    /**
     * Utility method used to make sending message feedback to players a tad less painful <br>
     * Has more parameters to allow for customization of the feedback, while keeping it relatively streamlined <br>
     * Allows the method caller to input a {@link Color} value that automatically is converted to a usable string <br>
     * All parameters will be serialized by minimessage, so strip tags beforehand accordingly.
     *
     * @param sender The person who the message will be sent to
     * @param prefixColor The color that the prefix will be
     * @param contentColor The color that the content of the message will be at first
     * @param prefix The prefix to be colored and bolded with the prefixColor
     * @param content The content what will be after the prefix, not bolded, colored with contentColor
     */
    public static void sendFeedback(CommandSender sender, Color prefixColor, Color contentColor, String prefix, String content) {
        sendFeedback(sender, prefixColor.color, contentColor.color, prefix, content);
    }

}
