package moe.plushie.armourers_workshop.common.library.global.permission;

import java.util.EnumSet;

public final class PermissionSystem {

    public final PermissionGroup groupNoLogin;
    public final PermissionGroup groupUser;
    public final PermissionGroup groupMod;
    public final PermissionGroup groupAdmin;

    public PermissionSystem() {
        EnumSet<PlushieAction> actions = EnumSet.noneOf(PlushieAction.class);

        actions.add(PlushieAction.SKIN_DOWNLOAD);
        groupNoLogin = new PermissionGroup("no login", actions.clone());

        actions.add(PlushieAction.SKIN_UPLOAD);
        actions.add(PlushieAction.SKIN_RATE);
        actions.add(PlushieAction.SKIN_FLAG);
        actions.add(PlushieAction.SKIN_OWNER_DELETE);
        actions.add(PlushieAction.SKIN_OWNER_EDIT);
        actions.add(PlushieAction.SKIN_COMMENT_CREATE);
        actions.add(PlushieAction.SKIN_COMMENT_OWNER_DELETE);
        actions.add(PlushieAction.SKIN_COMMENT_OWNER_EDIT);
        groupUser = new PermissionGroup("user", actions.clone());

        actions.add(PlushieAction.SKIN_MOD_EDIT);
        actions.add(PlushieAction.SKIN_MOD_DELETE);
        actions.add(PlushieAction.SKIN_COMMENT_MOD_DELETE);
        actions.add(PlushieAction.SKIN_COMMENT_MOD_EDIT);
        actions.add(PlushieAction.FLAG_GET_LIST);
        actions.add(PlushieAction.FLAG_DELETE);
        actions.add(PlushieAction.USER_BAN_TEMP);
        actions.add(PlushieAction.USER_BAN_PERM);
        groupMod = new PermissionGroup("mod", actions.clone());

        groupAdmin = new PermissionGroup("admin", EnumSet.allOf(PlushieAction.class));
    }

    public static enum PlushieAction {
        /** Download skins. */
        SKIN_DOWNLOAD,

        /** Upload skins */
        SKIN_UPLOAD,

        /** Leave a skin rating. */
        SKIN_RATE,

        /** Report a skin. */
        SKIN_FLAG,

        /** Delete their own skin. */
        SKIN_OWNER_DELETE,

        /** Delete other users skins. */
        SKIN_MOD_DELETE,

        /** Edit their own skins. */
        SKIN_OWNER_EDIT,

        /** Edit other users skins. */
        SKIN_MOD_EDIT,

        /** Comment on skins. */
        SKIN_COMMENT_CREATE,

        /** Delete their own comments. */
        SKIN_COMMENT_OWNER_DELETE,
        /** Delete other users comments. */
        SKIN_COMMENT_MOD_DELETE,
        /** Edit their own comments. */
        SKIN_COMMENT_OWNER_EDIT,
        /** Edit other users comments. */
        SKIN_COMMENT_MOD_EDIT,

        /** Get the permission flag list. */
        FLAG_GET_LIST,
        /**  */
        FLAG_DELETE,

        /** Ban a user temporarily. */
        USER_BAN_TEMP,
        /** Ban a user permanently. */
        USER_BAN_PERM,
        /** Change users permission group. */
        USER_GROUP_CHANGE,
        /** View server status. */
        SERVER_VIEW_STATS
    }

    public static class PermissionGroup {

        private final String name;
        private final EnumSet<PlushieAction> actions;

        public PermissionGroup(String name, EnumSet<PlushieAction> actions) {
            this.name = name;
            this.actions = EnumSet.noneOf(PlushieAction.class);
            this.actions.addAll(actions);
        }

        public String getName() {
            return name;
        }

        public boolean havePermission(PlushieAction action) {
            // PermissionAPI.hasPermission(profile, node, context)
            return actions.contains(action);
        }
    }
}
