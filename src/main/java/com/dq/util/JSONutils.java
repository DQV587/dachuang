package com.dq.util;
import com.google.gson.Gson;

/**
 * created by HuangHuang
 * on 2021/1/28
 * Explanation :websocket发送的json数据格式模板；
 */
public class JSONutils {
    public static String JsonData;

    public static String Into_Control(String topic) {
        JsonData = "{\"op\":\"advertise\",\"topic\":\"" + topic + "\",\"type\":\"hiwonder_servo_msgs/CommandDuration\"}";
        return JsonData;
    }

    public static String Into_Control_parameter(String topic, String angel) {
        JsonData = "{\"op\":\"publish\",\"topic\":\"" + topic + "\",\"msg\":{\"data\":" + angel + ",\"duration\":25}}";
        return JsonData;
    }


    public static String Into_Control_parameter_back(String topic, String angel) {
        JsonData = "{\"op\":\"publish\",\"topic\":\"" + topic + "\",\"msg\":{\"data\":" + angel + ",\"duration\":2000}}";
        return JsonData;
    }

    public static String jetmax_control_car_move(String topic, String velocity, String direction, String angular_rate) {
        JsonData = "{\"op\":\"publish\",\"topic\":\"" + topic + "\",\"msg\":{\"velocity\":" + velocity + ",\"direction\":" + direction + ",\"angular_rate\":" + angular_rate + "}}";
        return JsonData;
    }

    /**
     * 玩法进入/退出
     * 例：enter / exit
     * {
     * "op": "call_service",
     * "service": "object_tracking/enter"
     * }
     */
    public static String send(String op, String service) {
        RequstBundle bundle = new RequstBundle();
        bundle.op = op;
        bundle.service = service;
        RequstBundle.RequstContent content = new RequstBundle.RequstContent();
        return new Gson().toJson(bundle);
    }


    /**
     * 玩法开启/关闭/发送指令
     * 例：true / false   或参数值
     * {
     * "op": "call_service",
     * "service": "object_tracking/set_running",    物品追踪
     * "args":{data:true}
     * }
     */
    public static String send_data(String op, String service, String data) {
        JsonData = "{\"op\":\"" + op + "\",\"service\":\"/" + service + "\",\"args\":{\"data\":" + data + "}}";
        return JsonData;
    }

    public static String send_data_no_arg(String op, String service) {
        JsonData = "{\"op\":\"" + op + "\",\"service\":\"/" + service + "\",\"args\":{}}";
        return JsonData;
    }

    public static String Heartbeat_data(String op, String service, String data) {
        JsonData = "{\"op\":\"" + op + "\",\"service\":\"/" + service + "\",\"args\":{\"data\":" + data + "}}";
        return JsonData;
    }

    public static String object_tracking_data(String op, String service, String data) {
        JsonData = "{\"op\":\"" + op + "\",\"service\":\"/" + service + "\",\"args\":{\"data\":\"" + data + "\"}}";
        return JsonData;
    }

    public static String absorb_data(String topic, String data) {
        JsonData = "{\"op\":\"publish\",\"topic\":\"" + topic + "\",\"msg\":{\"data\":" + data + "}}";
        return JsonData;
    }

    public static String pwm_data(String topic, int angle, double duration) {
        JsonData = "{\"op\":\"publish\",\"topic\":\"" + topic + "\",\"msg\":{\"data\":" + angle + ",\"duration\":" + duration +"}}";
        return JsonData;
    }

    public static String arm_move_data(String topic, int x, int y, int z, double duration) {
        JsonData = "{\"op\":\"publish\",\"topic\":\"" + topic + "\",\"msg\":{\"x\":" + x + ",\"y\":" + y + ",\"z\":" + z + ",\"duration\":" + duration +"}}";
        return JsonData;
    }

    public static String send_red_color_sort(String op, String service, boolean sort) {
        String sortStr = "false";
        if(sort)
            sortStr = "true";
        JsonData = "{\"op\":\"" + op + "\",\"service\":\"/" + service + "\",\"args\":{\"color_name\":\"red\"," + "\"is_enable\":" + sortStr + "}}";
        return JsonData;
    }

    public static String send_green_color_sort(String op, String service, boolean sort) {
        String sortStr = "false";
        if(sort)
            sortStr = "true";
        JsonData = "{\"op\":\"" + op + "\",\"service\":\"/" + service + "\",\"args\":{\"color_name\":\"green\"," + "\"is_enable\":" + sortStr + "}}";
        return JsonData;
    }

    public static String send_blue_color_sort(String op, String service, boolean sort) {
        String sortStr = "false";
        if(sort)
            sortStr = "true";
        JsonData = "{\"op\":\"" + op + "\",\"service\":\"/" + service + "\",\"args\":{\"color_name\":\"blue\"," + "\"is_enable\":" + sortStr + "}}";
        return JsonData;
    }

    public static String send_color_track(String op, String service, String color) {
        JsonData = "{\"op\":\"" + op + "\",\"service\":\"/" + service + "\",\"args\":{\"color_name\":\"" + color + "\"}}";
        return JsonData;
    }
    /**
     * 颜色阈值设置
     * 	"op": "call_service",
     * 	"service": "/lab_config_manager/enter",
     * 	"args": {}
     */
    public static String enter_color_threshold() {
        JsonData = "{\"op\":\"call_service\",\"service\": \"/lab_config_manager/enter\",\"args\":{}}";
        return JsonData;
    }

    public static String get_color_threshold_suport() {
        JsonData = "{\"op\":\"call_service\",\"service\": \"/lab_config_manager/lab_adjust\",\"args\":{}}";
        return JsonData;
    }

    /**
     * 获取颜色阈值
     * 	"op": "call_service",
     * 	"service": "/lab_config_manager/get_range",
     * 	"args": {}
     */
    public static String get_color_threshold_data(String color) {
        JsonData = "{\"op\":\"call_service\",\"service\": \"/lab_config_manager/get_range\",\"args\":{\"color_name\":\"" + color + "\"}}";
        return JsonData;
    }
    /**
     * 获取颜色列表
     * 	"op": "call_service",
     * 	"service": "/lab_config_manager/get_all_color_name",
     * 	"args": {}
     */
    public static String get_color_list_data() {
        JsonData = "{\"op\":\"call_service\",\"service\": \"/lab_config_manager/get_all_color_name\",\"args\":{}}";
        return JsonData;
    }
    /**
     * 保存数据1
     * 	"op": "call_service",
     * 	"service": "/lab_config_manager/stash_range",
     * 	"args": {}
     */
    public static String save1_color_threshold_data(String color) {
        JsonData = "{\"op\":\"call_service\",\"service\": \"/lab_config_manager/stash_range\",\"args\":{\"color_name\":\"" + color + "\"}}";
        return JsonData;
    }
    /**
     * 保存数据2
     * 	"op": "call_service",
     * 	"service": "/lab_config_manager/save_to_disk",
     * 	"args": {}
     */
    public static String save2_color_threshold_data() {
        JsonData = "{\"op\":\"call_service\",\"service\": \"/lab_config_manager/save_to_disk\",\"args\":{}}";
        return JsonData;
    }
    /**
     * 调节颜色值设置
     * 	"op": "call_service",
     * 	"service": "/lab_config_manager/change_range",
     * 	"args": {}
     */
    public static String change_color_value(int L_min, int L_max, int A_min, int A_max, int B_min, int B_max) {
        JsonData = "{\"op\":\"call_service\",\"service\": \"/lab_config_manager/change_range\",\"args\":{\"min\":[" + L_min + "," + A_min + "," + B_min + "],\"max\":[" + L_max + "," + A_max + "," + B_max + "]}}";
        return JsonData;
    }
    /**
     * 物品分拣玩法发送指令
     * {
     * "op": "call_service",
     * "service": "/object_sorting/set_target",
     * "args":{
     * "color":["blue", "red"],
     * "tag":["tag1", "tag2"]
     * }
     * }
     */
    public static String object_sorting_data(String color_data, String tag_data) {
        JsonData = "{\"op\":\"call_service\",\"service\": \"/object_sorting/set_target\",\"args\":{\"color\":[" + color_data + "],\"tag\":[" + tag_data + "]}}";
        return JsonData;
    }

    /**
     * 入库指令
     * {
     * "op": "call_service",
     * "service": "/in/set_target",
     * "args":{
     * "goods":["red", "tag2", "tag1"],
     * "position":["L1", "R1", "R2"]
     * }
     * }
     */
    public static String Smatr_Storage_data(String goods, String position) {
        JsonData = "{\"op\":\"call_service\",\"service\": \"/in/set_target\",\"args\":{\"goods\":[" + goods + "],\"position\":[" + position + "]}}";
        return JsonData;
    }

    /**
     * 出库指令
     * {
     * "op": "call_service",
     * "service": "/exchange/set_target",
     * "args": {
     * "position": ["L1", "R1"]
     * }
     * }
     */
    public static String Smatr_Warehouse_data(String position) {
        JsonData = "{\"op\":\"call_service\",\"service\": \"/out/set_target\",\"args\":{\"position\":[" + position + "]}}";
        return JsonData;
    }

    /**
     * 转仓指令
     * {
     * "op": "call_service",
     * "service": "/out/set_target",
     * "args": {
     * "position": ["L1"]
     * }
     * }
     */
    public static String Smatr_Transfer_data(String position) {
        JsonData = "{\"op\":\"call_service\",\"service\": \"/exchange/set_target\",\"args\":{\"position\":[" + position + "]}}";
        return JsonData;
    }

    public static class RequstBundle {
        private String op;
        private String service;
        private RequstContent args;

        public String getOp() {
            return op;
        }

        public void setOp(String op) {
            this.op = op;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public RequstContent getArgs() {
            return args;
        }

        public void setArgs(RequstContent args) {
            this.args = args;
        }

        public static class RequstContent {
            public String data;

            public String getData() {
                return data;
            }

            public void setData(String data) {
                this.data = data;
            }
        }
    }
}

