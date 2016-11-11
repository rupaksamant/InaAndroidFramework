package blueprint.dynamic.framework.utils;

/**
 * Created by Techjini on 10/3/2016.
 */
public class Constants {

    public static class ComponentType {
        public static final String EDIT_TEXT = "edit_text";
        public static final String TEXT_VIEW = "text_view";
        public static final String BUTTON_VIEW = "button";
        public static final String IMAGE_VIEW = "image_view";
        public static final String SPINNER = "spinner";
//        public static final String VERTICAL_LABEL_SPINNER = "vertical_label_spinner";
        public static final String HORIZONTAL_LABEL_LABEL = "horizontal_label_label";
        public static final String HORIZONTAL_LABEL_ICON = "horizontal_label_icon";
        public static final String HORIZONTAL_ICON_LABEL = "horizontal_icon_label";
        public static final String VERTICAL_LABEL_LABEL = "vertical_label_label";
        public static final String VERTICAL_LABEL_EDIT_TEXT = "vertical_label_edit_text";
        public static final String VERTICAL_LABEL_SPINNER = "vertical_label_spinner";
    }

    public static class ScreenType {
        public static final String NAVIGATION_DRAWER = "navigation_drawer";
        public static final String RIGHT_MENU  = "right_menu";
        public static final String POPUP = "popup";
        public static final String GENERAL_SCREEN  = "general_screen";
    }

    /*public static class ComponentType {
        public static final String COMPOSITE = "composite";
        public static final String NORMAL = "normal";
    }*/

    public static class ContainerType {
        public static final String HORIZONTAL_SCROLL_LAYOUT = "horizontal_scroll_layout";
        public static final String VERTICAL_SCROLL_LAYOUT = "vertical_scroll_layout";
        public static final String LINEAR_LAYOUT = "linear_layout";
        public static final String RELATIVE_LAYOUT = "relative_layout";
        public static final String LIST_LAYOUT = "list_layout";
        public static final String ADAPTER_ITEM_LAYOUT = "adapter_item_layout";
    }

    public static class Orientation {
        public static final String VERTICAL = "vertical";
        public static final String HORIZONTAL = "horizontal";
    }

    public static class DefaultValue {

        public static final int PADDING = 5;
        public static final int MARGIN = 5;

        public static final int BUTTUON_HEIGHT = 80;
        public static final int BUTTUON_WIDTH = 120;
        public static final int BUTTUON_VIEW_MARGIN = 2;
        public static final int BUTTUON_VIEW_PADDING = 2;

        public static final int LABEL_HEIGHT = 45;
        public static final int LABEL_WIDTH = 80;

        public static final int EDITTEXT_HEIGHT = 45;
        public static final int EDITTEXT_WIDTH = 150;
        public static final int EDITTEXT_MARGIN = 2;
        public static final int EDITTEXT_PADDING = 2;
        public static final int EDITTEXT_FONT_SIZE = 14;

        public static final int SPINNER_HEIGHT = 45;
        public static final int SPINNER_WIDTH = 100;
        public static final int SPINNER_MARGIN = 2;
        public static final int SPINNER_PADDING = 2;

        public static final int VERTICAL_SCROLL_ITEM_HEIGHT = 45;
        public static final int VERTICAL_SCROLL_ITEM_WIDTH = 80;

        public static final int TEXT_VIEW_HEIGHT = 45;
        public static final int TEXT_VIEW_WIDTH = 80;
        public static final int TEXT_VIEW_FONT_SIZE = 14;
        public static final int TEXT_VIEW_MARGIN = 2;
        public static final int TEXT_VIEW_PADDING = 2;

        public static final int IAMGE_VIEW_HEIGHT = 100;
        public static final int IAMGE_VIEW_WIDTH = 100;
        public static final int IAMGE_VIEW_MARGIN = 1;
        public static final int IAMGE_VIEW_PADDING = 1;
    }

    public static class ContainerName {
        public static final String TOOLBAR = "toolbar";
        public static final String TOOLBAR_LEFT = "left_toolbar";
        public static final String TOOLBAR_CENTER = "center_toolbar";
        public static final String TOOLBAR_RIGHT = "right_toolbar";

        public static final String CONTAINER_CONTENT = "content_container";

        public static final String CONTAINER_TOP = "top_container";
        public static final String CONTAINER_MIDDLE = "middle_container";
        public static final String CONTAINER_BOTTOM = "bottom_container";
        public static final String CONTAINER_LEFT = "left_container";
        public static final String CONTAINER_RIGHT = "right_container";
    }

    public static class FontStyle {
        public static final String FONT_STYLE_NORMAL = "font_normal";
        public static final String FONT_STYLE_BOLD = "font_bold";
        public static final String FONT_STYLE_ITALIC = "font_italic";
        public static final String FONT_STYLE_BOLD_ITALIC = "font_bold_italic";
    }

    public static class FontTypeFace {
        public static final String FONT_TYPEFACE_SERIF = "font_type_serif";
        public static final String FONT_TYPEFACE_DEFAULT = "font_type_default";
        public static final String FONT_TYPEFACE_DEFAULT_BOLD = "font_type_default_bold";
        public static final String FONT_TYPEFACE_MONOSPACE = "font_type_monospace";
        public static final String FONT_TYPEFACE_SANS_SERIF = "font_type_sans_serif";
    }
}
