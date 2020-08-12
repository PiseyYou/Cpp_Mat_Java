package test.json;

import java.util.HashMap;
import java.util.Map;

/**
 * {
 *         "Input_Source":"rtsp://192.168.1.110/live4",
 *         "Input_Scale":{
 *             "width":"1920",
 *             "height":"1080",
 *             "bitrate":"4096",
 *             "iframe":"50",
 *             "framerate":"25"
 *         }
 *     },
 */
public class Rtsp {
    private String Input_Source;
    private Scale scale;

    Map<String, String> input = new HashMap<>();

}
